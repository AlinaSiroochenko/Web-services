package lt.viko.eif.siroochenko.restaurant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Represents a dish entity with name and price.
 * This class is annotated for persistence in a relational database using JPA.
 * It extends the {@link BaseEntity} class, inheriting its ID field.
 */
@Entity
@Table(name = "dish")
public class Dish extends BaseEntity {
    private String name;
    private double price;

    /**
     * Default constructor.
     */
    public Dish() {
    }

    /**
     * Constructs a new Dish with specified name and price.
     *
     * @param name The name of the dish.
     * @param price The price of the dish.
     */
    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Returns a string representation of the dish, including name and price.
     *
     * @return A formatted string representing the dish.
     */
    @Override
    public String toString() {
        return String.format("\tDish: \n" +
                "\t\tName: %s \n" +
                "\t\tPrice: %.2f \n", this.name, this.price);
    }

    /**
     * Gets the name of the dish.
     *
     * @return The name of the dish.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the dish.
     *
     * @param name The new name of the dish.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the dish.
     *
     * @return The price of the dish.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the dish.
     *
     * @param price The new price of the dish.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
