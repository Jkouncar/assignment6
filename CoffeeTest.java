import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CoffeeTest {

    @Test
    public void testConstructorAndCalcPrice() {
        Coffee coffee = new Coffee("Latte", Type.COFFEE, Size.MEDIUM, true, false);
        assertEquals("Latte", coffee.getName());
        assertEquals(Type.COFFEE, coffee.getType());
        assertEquals(Size.MEDIUM, coffee.getSize());
        assertTrue(coffee.extraShot);
        assertFalse(coffee.extraSyrup);
        assertEquals(3.5, coffee.calcPrice(), 0.01); // Price calculation test
    }

    @Test
    public void testEquals() {
        Coffee coffee1 = new Coffee("Latte", Type.COFFEE, Size.MEDIUM, true, false);
        Coffee coffee2 = new Coffee("Latte", Type.COFFEE, Size.MEDIUM, true, false);
        Coffee coffee3 = new Coffee("Cappuccino", Type.COFFEE, Size.SMALL, true, false);

        assertTrue(coffee1.equals("Latte", Type.COFFEE, Size.MEDIUM, true, false));
        assertTrue(coffee1.equals(coffee2));
        assertFalse(coffee1.equals(coffee3));
    }

    @Test
    public void testToString() {
        Coffee coffee = new Coffee("Mocha", Type.COFFEE, Size.LARGE, false, true);
        String expected = "Name: Mocha\nSize: LARGE\nExtra Shot: false\nExtra Syrup: true\nPrice: $4.5";
        assertEquals(expected, coffee.toString());
    }
}
