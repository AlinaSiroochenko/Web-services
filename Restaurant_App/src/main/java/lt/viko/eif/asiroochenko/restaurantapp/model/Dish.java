package lt.viko.eif.asiroochenko.restaurantapp.model;

import jakarta.xml.bind.annotation.XmlType;
import javax.persistence.*;

/**
 * The Dish class represents a dish entity in the restaurant application.
 * Each dish has an identifier, name, and price.
 * This class is annotated as an Entity to be mapped to the database table "dishes".
 * It also specifies the XML type for JAXB marshalling purposes.
 */
@Entity
@Table(name = "dishes")
@XmlType(propOrder = {"name", "price"})
public class Dish {
    /**
     * The unique identifier for the dish.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The name of the dish.
     */
    private String name;

    /**
     * The price of the dish.
     */
    private int price;

    /**
     * Constructs an empty Dish object. Needed for JPA.
     */
    public Dish() {
    }

    /**
     * Constructs a Dish object with the specified name and price.
     *
     * @param name  The name of the dish.
     * @param price The price of the dish.
     */
    public Dish(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Returns a string representation of the Dish object.
     *
     * @return A string representation of the Dish object including name and price.
     */
    @Override
    public String toString() {
        return String.format( "\n\t\tDish: \n" +
                "\t\t\tName: %s\n" +
                "\t\t\tPrice: %d\n", this.name, this.price);
    }

    /**
     * Retrieves the identifier of the dish.
     *
     * @return The identifier of the dish.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the identifier of the dish.
     *
     * @param id The identifier of the dish.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the dish.
     *
     * @return The name of the dish.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the dish.
     *
     * @param name The name of the dish.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the price of the dish.
     *
     * @return The price of the dish.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the dish.
     *
     * @param price The price of the dish.
     */
    public void setPrice(int price) {
        this.price = price;
    }
}