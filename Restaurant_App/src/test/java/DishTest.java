import lt.viko.eif.asiroochenko.restaurantapp.model.Dish;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class DishTest {
    @Test
    public void testDishInitialization() {
        String name = "Pasta Carbonara";
        int price = 10;
        Dish dish = new Dish(name, price);

        assertNotNull(dish);
        assertEquals(name, dish.getName());
        assertEquals(price, dish.getPrice());
    }
}
