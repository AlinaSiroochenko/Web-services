package lt.viko.eif.siroochenko.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lt.viko.eif.siroochenko.rest.model.Chef;
import lt.viko.eif.siroochenko.rest.repository.ChefRepository;

/**
 * REST controller for managing chefs.
 */
@RestController
@RequestMapping("/chefs")
public class ChefController {

    @Autowired
    private ChefRepository chefRepository;

    /**
     * Creates a new chef.
     *
     * @param chef the chef to create
     * @return the created chef and HTTP status 201 Created
     */
    @PostMapping
    public ResponseEntity<Chef> createChef(@RequestBody Chef chef) {
        Chef savedChef = chefRepository.save(chef);
        return new ResponseEntity<>(savedChef, HttpStatus.CREATED);
    }

    /**
     * Retrieves a chef by ID.
     *
     * @param id the ID of the chef to retrieve
     * @return the chef and HTTP status 200 OK if found, or HTTP status 404 Not Found if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Chef> getChefById(@PathVariable Long id) {
        return chefRepository.findById(id)
                .map(chef -> new ResponseEntity<>(chef, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Updates an existing chef.
     *
     * @param id the ID of the chef to update
     * @param chefDetails the chef details to update
     * @return the updated chef and HTTP status 200 OK if found and updated, or HTTP status 404 Not Found if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Chef> updateChef(@PathVariable Long id, @RequestBody Chef chefDetails) {
        return chefRepository.findById(id)
                .map(chef -> {
                    chef.setName(chefDetails.getName());
                    chef.setExperience(chefDetails.getExperience());
                    Chef updatedChef = chefRepository.save(chef);
                    return new ResponseEntity<>(updatedChef, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Deletes a chef by ID.
     *
     * @param id the ID of the chef to delete
     * @return HTTP status 204 No Content if found and deleted, or HTTP status 404 Not Found if not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChef(@PathVariable Long id) {
        return chefRepository.findById(id)
                .map(chef -> {
                    chefRepository.delete(chef);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
