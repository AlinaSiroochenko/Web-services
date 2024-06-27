package lt.viko.eif.siroochenko.restaurantconsumer.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an order entity with properties for the customer's name, list of dishes,
 * total amount, and table. This class is annotated for persistence in a
 * relational database using JPA. It extends the {@link BaseEntity} class, inheriting its ID field.
 */
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    private String customerName;

    @ManyToMany(fetch = FetchType.EAGER,
            targetEntity = Dish.class,
            cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_dish",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> dishes = new ArrayList<>();

    private double totalAmount;

    @OneToOne(targetEntity = Tables.class, cascade = CascadeType.ALL)
    private Tables tables;

    /**
     * Default constructor.
     */
    public Order() {
    }

    /**
     * Constructs a new Order with specified customer name, total amount, and table.
     *
     * @param customerName The name of the customer.
     * @param totalAmount  The total amount of the order.
     * @param tables        The tables associated with the order.
     */
    public Order(String customerName, double totalAmount, Tables tables) {
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.tables = tables;
    }

    /**
     * Returns a string representation of the order, including customer name, list of dishes,
     * total amount, and table.
     *
     * @return A formatted string representing the order.
     */
    @Override
    public String toString() {
        return String.format("Order: \n" +
                "\tCustomerName: %s \n" +
                "\tDishes: %s" +
                "\tTotal Amount: %.2f\n" +
                "%s", this.customerName, constructDishesList(), this.totalAmount, this.tables.toString());
    }

    /**
     * Constructs a formatted string of the list of dishes.
     *
     * @return A string representing the list of dishes in the order.
     */
    private String constructDishesList() {
        StringBuilder result = new StringBuilder("\n");
        for (Dish dish : this.dishes) {
            result.append(dish.toString());
        }
        return result.toString();
    }

    /**
     * Gets the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the name of the customer.
     *
     * @param customerName The new name of the customer.
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Adds a dish to the list of dishes.
     *
     * @param dish The dish to add.
     */
    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }

    /**
     * Gets the list of dishes included in the order.
     *
     * @return The list of dishes.
     */
    public List<Dish> getDishes() {
        return dishes;
    }

    /**
     * Sets the list of dishes included in the order.
     *
     * @param dishes The new list of dishes.
     */
    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    /**
     * Gets the total amount of the order.
     *
     * @return The total amount.
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the total amount of the order.
     *
     * @param totalAmount The new total amount.
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Gets the table associated with the order.
     *
     * @return The tables.
     */
    public Tables getTables() {
        return tables;
    }

    /**
     * Sets the table associated with the order.
     *
     * @param tables The new table.
     */
    public void setTables(Tables tables) {
        this.tables = tables;
    }
}
