package lt.viko.eif.asiroochenko.restaurantapp.model;

import jakarta.xml.bind.annotation.XmlType;
import javax.persistence.*;

/**
 * The Tables class represents a table entity in the restaurant application.
 * Each table has an identifier, number, and capacity.
 * This class is annotated as an Entity to be mapped to the database table "tables".
 * It also specifies the XML type for JAXB marshalling purposes.
 */
@Entity
@Table(name = "tables")
@XmlType(propOrder = {"number", "capacity"})
public class Tables {
    /**
     * The unique identifier for the table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The number of the table.
     */
    private int number;

    /**
     * The capacity of the table.
     */
    private int capacity;

    /**
     * Constructs an empty Tables object. Needed for JPA.
     */
    public Tables() {
    }

    /**
     * Constructs a Tables object with the specified number and capacity.
     *
     * @param number   The number of the table.
     * @param capacity The capacity of the table.
     */
    public Tables(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
    }

    /**
     * Returns a string representation of the Tables object.
     *
     * @return A string representation of the Tables object including number and capacity.
     */
    @Override
    public String toString() {
        return String.format("\n\t\tNumber: %s\n" +
                "\t\tCapacity: %d\n", this.number, this.capacity);
    }

    /**
     * Retrieves the identifier of the table.
     *
     * @return The identifier of the table.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the identifier of the table.
     *
     * @param id The identifier of the table.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the number of the table.
     *
     * @return The number of the table.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the number of the table.
     *
     * @param number The number of the table.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Retrieves the capacity of the table.
     *
     * @return The capacity of the table.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the capacity of the table.
     *
     * @param capacity The capacity of the table.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}