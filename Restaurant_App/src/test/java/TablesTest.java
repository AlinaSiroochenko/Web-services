import lt.viko.eif.asiroochenko.restaurantapp.model.Tables;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class TablesTest {
    @Test
    public void testTablesInitialization() {
        int number = 1;
        int capacity = 4;
        Tables table = new Tables(number, capacity);

        assertNotNull(table);
        assertEquals(number, table.getNumber());
        assertEquals(capacity, table.getCapacity());
    }
}
