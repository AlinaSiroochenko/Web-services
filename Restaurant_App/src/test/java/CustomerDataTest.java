import lt.viko.eif.asiroochenko.restaurantapp.db.CustomerData;
import lt.viko.eif.asiroochenko.restaurantapp.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerDataTest {

    private CustomerData customerData;
    private List<Customer> customers;

    @BeforeEach
    void setUp() {
        customerData = new CustomerData();
        customers = new ArrayList<>();
    }

    @Test
    void testGetCustomers() {
        Customer customer1 = new Customer("John", "Smith", 1);
        Customer customer2 = new Customer("Alice", "Smith", 2);

        customers.add(customer1);
        customers.add(customer2);

        customerData.setCustomers(customers);

        assertEquals(customers, customerData.getCustomers(), "Returned list of customers should match the expected list");
    }

    @Test
    void testSetCustomers() {
        List<Customer> newCustomers = new ArrayList<>();
        Customer customer1 = new Customer("Bob", "Ross", 3);
        Customer customer2 = new Customer("Emma", "Watson", 4);

        newCustomers.add(customer1);
        newCustomers.add(customer2);

        customerData.setCustomers(newCustomers);

        assertEquals(newCustomers, customerData.getCustomers(), "Returned list of customers should match the newly set list");
    }
}
