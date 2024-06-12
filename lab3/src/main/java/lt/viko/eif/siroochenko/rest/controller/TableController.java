package lt.viko.eif.siroochenko.rest.controller;

import lt.viko.eif.siroochenko.rest.model.Tables;
import lt.viko.eif.siroochenko.rest.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing restaurant tables.
 */
@RestController
@RequestMapping("/tables")
public class TableController {

    @Autowired
    private TableRepository tableRepository;

    /**
     * Retrieves all tables.
     *
     * @return a list of all tables
     */
    @GetMapping
    public List<Tables> getAllTables() {
        return tableRepository.findAll();
    }

    /**
     * Creates a new table.
     *
     * @param table the table to create
     * @return the created table and HTTP status 201 Created
     */
    @PostMapping
    public ResponseEntity<Tables> createTable(@RequestBody Tables table) {
        Tables savedTable = tableRepository.save(table);
        return new ResponseEntity<>(savedTable, HttpStatus.CREATED);
    }

    /**
     * Retrieves a table by ID.
     *
     * @param id the ID of the table to retrieve
     * @return the table and HTTP status 200 OK if found, or HTTP status 404 Not Found if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Tables> getTableById(@PathVariable Long id) {
        Optional<Tables> table = tableRepository.findById(id);
        return table.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Updates an existing table.
     *
     * @param id the ID of the table to update
     * @param tableDetails the table details to update
     * @return the updated table and HTTP status 200 OK if found and updated, or HTTP status 404 Not Found if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Tables> updateTable(@PathVariable Long id, @RequestBody Tables tableDetails) {
        Optional<Tables> tableOptional = tableRepository.findById(id);
        if (tableOptional.isPresent()) {
            Tables table = tableOptional.get();
            table.setNumber(tableDetails.getNumber());
            table.setSeats(tableDetails.getSeats());
            Tables updatedTable = tableRepository.save(table);
            return ResponseEntity.ok(updatedTable);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a table by ID.
     *
     * @param id the ID of the table to delete
     * @return HTTP status 204 No Content if found and deleted, or HTTP status 404 Not Found if not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        Optional<Tables> tableOptional = tableRepository.findById(id);
        if (tableOptional.isPresent()) {
            tableRepository.delete(tableOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
