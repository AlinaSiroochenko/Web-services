package lt.viko.eif.asiroochenko.restaurantapp.model;

import jakarta.xml.bind.annotation.XmlType;
import javax.persistence.*;

/**
 * The Order class represents an order entity in the restaurant application.
 * Each order has an identifier, total price, and status.
 * This class is annotated as an Entity to be mapped to the database table "orders".
 * It also specifies the XML type for JAXB marshalling purposes.
 */
@Entity
@Table(name = "orders")
@XmlType(propOrder = {"totalPrice", "status"})
public class Order {
    /**
     * The unique identifier for the order.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The total price of the order.
     */
    private double totalPrice;

    /**
     * The status of the order.
     */
    private String status;

    /**
     * Constructs an empty Order object. Needed for JPA.
     */
    public Order() {
    }

    /**
     * Constructs an Order object with the specified total price and status.
     *
     * @param totalPrice The total price of the order.
     * @param status     The status of the order.
     */
    public Order(double totalPrice, String status) {
        this.totalPrice = totalPrice;
        this.status = status;
    }

    /**
     * Returns a string representation of the Order object.
     *
     * @return A string representation of the Order object including total price and status.
     */
    @Override
    public String toString() {
        return String.format("\n\t\tTotal Price: %.2f\n" +
                        "\t\tStatus: %s\n",
                this.totalPrice, this.status);
    }

    /**
     * Retrieves the identifier of the order.
     *
     * @return The identifier of the order.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the identifier of the order.
     *
     * @param id The identifier of the order.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the total price of the order.
     *
     * @return The total price of the order.
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the total price of the order.
     *
     * @param totalPrice The total price of the order.
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Retrieves the status of the order.
     *
     * @return The status of the order.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the order.
     *
     * @param status The status of the order.
     */
    public void setStatus(String status) {
        this.status = status;
    }
}