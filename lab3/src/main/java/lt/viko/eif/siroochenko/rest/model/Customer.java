package lt.viko.eif.siroochenko.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity class representing a Customer.
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    /**
     * Default constructor.
     */
    public Customer() {
    }

    /**
     * Constructs a new Customer with the specified name and email.
     *
     * @param name the name of the customer
     * @param email the email of the customer
     */
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Gets the ID of the customer.
     *
     * @return the ID of the customer
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the customer.
     *
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the customer.
     *
     * @return the name of the customer
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email of the customer.
     *
     * @return the email of the customer
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the customer.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
