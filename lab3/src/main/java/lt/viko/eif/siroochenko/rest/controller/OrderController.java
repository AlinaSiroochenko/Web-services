package lt.viko.eif.siroochenko.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lt.viko.eif.siroochenko.rest.model.CustomerOrder;
import lt.viko.eif.siroochenko.rest.repository.CustomerOrderRepository;

/**
 * REST controller for managing customer orders.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    /**
     * Creates a new customer order.
     *
     * @param order the order to create
     * @return the created order and HTTP status 201 Created
     */
    @PostMapping
    public ResponseEntity<CustomerOrder> createOrder(@RequestBody CustomerOrder order) {
        CustomerOrder savedOrder = customerOrderRepository.save(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    /**
     * Retrieves a customer order by ID.
     *
     * @param id the ID of the order to retrieve
     * @return the order and HTTP status 200 OK if found, or HTTP status 404 Not Found if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<CustomerOrder> getOrderById(@PathVariable Long id) {
        return customerOrderRepository.findById(id)
                .map(order -> new ResponseEntity<>(order, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Updates an existing customer order.
     *
     * @param id the ID of the order to update
     * @param orderDetails the order details to update
     * @return the updated order and HTTP status 200 OK if found and updated, or HTTP status 404 Not Found if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<CustomerOrder> updateOrder(@PathVariable Long id, @RequestBody CustomerOrder orderDetails) {
        return customerOrderRepository.findById(id)
                .map(order -> {
                    order.setDate(orderDetails.getDate());
                    order.setStatus(orderDetails.getStatus());
                    CustomerOrder updatedOrder = customerOrderRepository.save(order);
                    return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Deletes a customer order by ID.
     *
     * @param id the ID of the order to delete
     * @return HTTP status 204 No Content if found and deleted, or HTTP status 404 Not Found if not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        return customerOrderRepository.findById(id)
                .map(order -> {
                    customerOrderRepository.delete(order);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
