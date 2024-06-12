package lt.viko.eif.siroochenko.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity class representing a Dish.
 */
@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    /**
     * Default constructor.
     */
    public Dish() {
    }

    /**
     * Constructs a new Dish with the specified name and price.
     *
     * @param name the name of the dish
     * @param price the price of the dish
     */
    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the ID of the dish.
     *
     * @return the ID of the dish
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the dish.
     *
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the dish.
     *
     * @return the name of the dish
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the dish.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the dish.
     *
     * @return the price of the dish
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the dish.
     *
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
