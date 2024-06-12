package lt.viko.eif.siroochenko.rest.controller;

import lt.viko.eif.siroochenko.rest.model.Dish;
import lt.viko.eif.siroochenko.rest.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * REST controller for managing dishes.
 */
@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishRepository dishRepository;

    /**
     * Retrieves a dish by ID.
     *
     * @param id the ID of the dish to retrieve
     * @return the dish and HTTP status 200 OK if found, or HTTP status 404 Not Found if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable Long id) {
        Optional<Dish> dish = dishRepository.findById(id);
        return dish.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creates a new dish.
     *
     * @param dish the dish to create
     * @return the created dish and HTTP status 201 Created
     */
    @PostMapping
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish) {
        Dish savedDish = dishRepository.save(dish);
        return ResponseEntity.status(201).body(savedDish);
    }

    /**
     * Updates an existing dish.
     *
     * @param id the ID of the dish to update
     * @param dish the dish details to update
     * @return the updated dish and HTTP status 200 OK if found and updated, or HTTP status 404 Not Found if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long id, @RequestBody Dish dish) {
        if (!dishRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        dish.setId(id);
        Dish updatedDish = dishRepository.save(dish);
        return ResponseEntity.ok(updatedDish);
    }

    /**
     * Deletes a dish by ID.
     *
     * @param id the ID of the dish to delete
     * @return HTTP status 204 No Content if found and deleted, or HTTP status 404 Not Found if not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long id) {
        if (!dishRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        dishRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
