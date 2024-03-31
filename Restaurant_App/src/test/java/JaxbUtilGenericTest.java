import lt.viko.eif.asiroochenko.restaurantapp.Util.JaxbUtilGeneric;
import lt.viko.eif.asiroochenko.restaurantapp.model.Customer;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class JaxbUtilGenericTest {

    @Test
    void testConvertToXML() {

        Customer customer = new Customer("John", "john@example.com", 1);

        JaxbUtilGeneric.convertToXML(customer);

        File file = new File("generated.xml");
        assertTrue(file.exists());
    }
}
