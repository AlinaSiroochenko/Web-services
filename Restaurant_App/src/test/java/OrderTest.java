import static org.testng.Assert.assertEquals;
import lt.viko.eif.asiroochenko.restaurantapp.model.Order;
import org.testng.annotations.Test;

public class OrderTest {

    @Test
    public void testOrderToString() {

        double totalPrice = 50.0;
        String status = "In process";
        Order order = new Order(totalPrice, status);

        String expectedToString = String.format("\n\t\tTotal Price: %.2f\n" +
                        "\t\tStatus: %s\n",
                totalPrice, status);
        String actualToString = order.toString();

        assertEquals(expectedToString, actualToString);
    }

    @Test
    public void testOrderGettersAndSetters() {

        double totalPrice = 50.0;
        String status = "In process";
        Order order = new Order();

        order.setTotalPrice(totalPrice);
        order.setStatus(status);

        assertEquals(totalPrice, order.getTotalPrice(), 0.01);
        assertEquals(status, order.getStatus());
    }

}
