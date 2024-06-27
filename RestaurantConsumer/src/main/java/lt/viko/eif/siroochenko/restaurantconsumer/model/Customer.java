package lt.viko.eif.siroochenko.restaurantconsumer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Represents a customer entity with name and email.
 * This class is annotated for persistence in a relational database using JPA.
 * It extends the {@link BaseEntity} class, inheriting its ID field.
 */
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {
    private String name;
    private String email;

    /**
     * Default constructor.
     */
    public Customer() {
    }

    /**
     * Constructs a new Customer with specified name and email.
     *
     * @param name The name of the customer.
     * @param email The email of the customer.
     */
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Returns a string representation of the customer, including name and email.
     *
     * @return A formatted string representing the customer.
     */
    @Override
    public String toString() {
        return String.format("\tCustomer: \n" +
                "\t\tName: %s \n" +
                "\t\tEmail: %s \n", this.name, this.email);
    }

    /**
     * Gets the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name The new name of the customer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email of the customer.
     *
     * @return The email of the customer.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the customer.
     *
     * @param email The new email of the customer.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
