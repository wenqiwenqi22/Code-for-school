package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PainterTest {
    private Painter painter;
    private String firstName;
    private String lastName;

    @Before
    public void setUp() throws Exception {
        firstName = "Wenqi";
        lastName = "Cao";
        painter = new Painter(firstName, lastName);
    }

    @Test
    public void getFirstName() {
        assertEquals(painter.getFirstName(), firstName);
    }

    @Test
    public void getLastName() {
        assertEquals(painter.getLastName(), lastName);
    }

    @Test
    public void testEquals() {
        assertEquals(painter, new Painter(firstName, lastName));
    }

    @Test
    public void testHashCode() {
        assertEquals(painter.hashCode(), new Painter(firstName, lastName).hashCode());
    }

    @Test
    public void testToString() {
        assertEquals(painter.toString(), new Painter(firstName, lastName).toString());
    }
}