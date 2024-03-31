package lt.viko.eif.asiroochenko.restaurantapp.db;

import lt.viko.eif.asiroochenko.restaurantapp.model.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 * The CustomerData class represents a database abstraction for managing customer data.
 * It provides methods to retrieve and set a list of Customer objects.
 */
public class CustomerData {

    private List<Customer> customers = new ArrayList<>();

    /**
     * Retrieves the list of customers.
     *
     * @return The list of customers.
     */
    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * Sets the list of customers.
     *
     * @param customers The list of customers to set.
     */
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
