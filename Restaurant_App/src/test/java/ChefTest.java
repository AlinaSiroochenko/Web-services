import lt.viko.eif.asiroochenko.restaurantapp.model.Chef;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChefTest {

    @Test
    public void testConstructorAndGetters() {
        Chef chef = new Chef("Alice", "Johnson");
        assertEquals("Alice", chef.getFirstName());
        assertEquals("Johnson", chef.getLastName());
    }

    @Test
    public void testToString() {
        Chef chef = new Chef("Alice", "Johnson");
        String expectedString = "\n\t\tFirst Name: Alice\n" +
                "\t\tLast Name: Johnson\n";
        assertEquals(expectedString, chef.toString());
    }
}
