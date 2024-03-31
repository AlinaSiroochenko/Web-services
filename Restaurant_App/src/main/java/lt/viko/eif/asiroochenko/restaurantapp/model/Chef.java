package lt.viko.eif.asiroochenko.restaurantapp.model;

import jakarta.xml.bind.annotation.XmlType;
import javax.persistence.*;

/**
 * The Chef class represents a chef entity in the restaurant application.
 * Each chef has an identifier, first name, and last name.
 * This class is annotated as an Entity to be mapped to the database table "chefs".
 * It also specifies the XML type for JAXB marshalling purposes.
 */
@Entity
@Table(name = "chefs")
@XmlType(propOrder = {"firstName", "lastName"})
public class Chef {
    /**
     * The unique identifier for the chef.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The first name of the chef.
     */
    private String firstName;

    /**
     * The last name of the chef.
     */
    private String lastName;

    /**
     * Constructs an empty Chef object. Needed for JPA.
     */
    public Chef() {
    }

    /**
     * Constructs a Chef object with the specified first name and last name.
     *
     * @param firstName The first name of the chef.
     * @param lastName  The last name of the chef.
     */
    public Chef(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Retrieves the identifier of the chef.
     *
     * @return The identifier of the chef.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the identifier of the chef.
     *
     * @param id The identifier of the chef.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the first name of the chef.
     *
     * @return The first name of the chef.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the chef.
     *
     * @param firstName The first name of the chef.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the last name of the chef.
     *
     * @return The last name of the chef.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the chef.
     *
     * @param lastName The last name of the chef.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns a string representation of the Chef object.
     *
     * @return A string representation of the Chef object including first name and last name.
     */
    @Override
    public String toString() {
        return String.format("\n\t\tFirst Name: %s\n" +
                        "\t\tLast Name: %s\n", this.firstName,
                this.lastName);
    }
}
