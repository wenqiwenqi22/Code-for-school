package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PhotographerTest {

    private Photographer photographer;
    private String firstName;
    private String lastName;

    @Before
    public void setUp() throws Exception {
        firstName = "Junqi";
        lastName = "Ma";
        photographer = new Photographer(firstName, lastName);
    }

    @Test
    public void getFirstName() {
        assertEquals(photographer.getFirstName(), firstName);
    }

    @Test
    public void getLastName() {
        assertEquals(photographer.getLastName(), lastName);
    }

    @Test
    public void testEquals() {
        assertEquals(photographer, new Photographer(firstName, lastName));
    }

    @Test
    public void testHashCode() {
        assertEquals(photographer.hashCode(), new Photographer(firstName, lastName).hashCode());
    }

    @Test
    public void testToString() {
        String s = "Artist{firstName='Junqi', lastName='Ma'}";
        assertEquals(photographer.toString(), s);
    }
}