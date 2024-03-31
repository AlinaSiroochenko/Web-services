package lt.viko.eif.asiroochenko.restaurantapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;
import java.util.ArrayList;

/**
 * The Customer class represents a customer entity in the restaurant application.
 * Each customer has an identifier, first name, last name, associated dishes, table, chef, and order.
 * This class is annotated as an Entity to be mapped to the database table "customers".
 * It also specifies the XML type for JAXB marshalling purposes.
 */
@XmlRootElement
@XmlType(propOrder = {"id", "firstName", "lastName", "dishes", "tables", "chef", "order" })
@Entity
@Table(name = "customers")
public class Customer {
    /**
     * The unique identifier for the customer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * The first name of the customer.
     */
    private String firstName;

    /**
     * The last name of the customer.
     */
    private String lastName;

    /**
     * The chef associated with the customer.
     */
    @OneToOne(targetEntity = Chef.class, cascade = CascadeType.ALL)
    private Chef chef;

    /**
     * The order associated with the customer.
     */
    @OneToOne(targetEntity = Order.class, cascade = CascadeType.ALL)
    private Order order;

    /**
     * The table associated with the customer.
     */
    @OneToOne(targetEntity = Tables.class, cascade = CascadeType.ALL)
    private Tables tables;

    /**
     * The list of dishes ordered by the customer.
     */
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Customer_Dish",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "dish_id")})
    private List<Dish> dishes = new ArrayList<>();

    /**
     * Constructs an empty Customer object. Needed for JPA.
     */
    public Customer() {
    }

    /**
     * Constructs a Customer object with the specified first name, last name, and identifier.
     *
     * @param firstName The first name of the customer.
     * @param lastName  The last name of the customer.
     * @param id        The identifier of the customer.
     */
    public Customer(String firstName, String lastName, int id) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns a string representation of the Customer object.
     *
     * @return A string representation of the Customer object including first name, last name, dishes, table, chef, and order.
     */
    @Override
    public String toString() {
        return String.format("Customer: \n" +
                        "\tFirst Name: %s\n" +
                        "\tLast Name: %s\n" +
                        "\tDishes: %s \n" +
                        "\tTable: %s \n" +
                        "\tChef: %s \n" +
                        "\tOrder: %s", this.firstName, this.lastName,
                constructDishList(), this.tables, this.chef, this.order);
    }

    /**
     * Constructs a string representation of the list of dishes ordered by the customer.
     *
     * @return A string representation of the list of dishes ordered by the customer.
     */
    private String constructDishList() {
        String result = "";
        for (Dish dish : dishes) {
            result += dish;
        }
        return result;
    }

    /**
     * Retrieves the identifier of the customer.
     *
     * @return The identifier of the customer.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the identifier of the customer.
     *
     * @param id The identifier of the customer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the first name of the customer.
     *
     * @return The first name of the customer.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the customer.
     *
     * @param firstName The first name of the customer.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the last name of the customer.
     *
     * @return The last name of the customer.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the customer.
     *
     * @param lastName The last name of the customer.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the chef associated with the customer.
     *
     * @return The chef associated with the customer.
     */
    public Chef getChef() {
        return chef;
    }

    /**
     * Sets the chef associated with the customer.
     *
     * @param chef The chef associated with the customer.
     */
    public void setChef(Chef chef) {
        this.chef = chef;
    }

    /**
     * Retrieves the order associated with the customer.
     *
     * @return The order associated with the customer.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the order associated with the customer.
     *
     * @param order The order associated with the customer.
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Retrieves the table associated with the customer.
     *
     * @return The table associated with the customer.
     */
    public Tables getTables() {
        return tables;
    }

    /**
     * Sets the table associated with the customer.
     *
     * @param tables The table associated with the customer.
     */
    public void setTables(Tables tables) {
        this.tables = tables;
    }

    /**
     * Retrieves the list of dishes ordered by the customer.
     *
     * @return The list of dishes ordered by the customer.
     */
    public List<Dish> getDishes() {
        return dishes;
    }

    /**
     * Sets the list of dishes ordered by the customer.
     *
     * @param dishes The list of dishes ordered by the customer.
     */
    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
