import lt.viko.eif.asiroochenko.restaurantapp.model.Customer;
import lt.viko.eif.asiroochenko.restaurantapp.model.Dish;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerTest {

    @Test
    public void testCustomerInitialization() {

        String firstName = "John";
        String lastName = "Smith";
        int id = 1;
        Customer customer = new Customer(firstName, lastName, id);

        assertNotNull(customer);
        assertEquals(firstName, customer.getFirstName());
        assertEquals(lastName, customer.getLastName());
        assertEquals(id, customer.getId());
    }

    @Test
    public void testAddDish() {

        Customer customer = new Customer();
        Dish dish = new Dish("Pasta Carbonara", 10);

        customer.getDishes().add(dish);

        assertEquals(1, customer.getDishes().size());
        assertEquals(dish, customer.getDishes().get(0));
    }
}
