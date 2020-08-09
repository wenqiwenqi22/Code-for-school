package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipientTest {
    public Recipient recipient1 = new Recipient("james", "bond","jb@123.com");
    public Recipient recipient2 = new Recipient("james", "bond","jb@123.com");

    @Test
    public void testEquals() {
        assertEquals(recipient1, recipient2);
    }

    @Test
    public void testHashCode() {
        assertTrue(recipient1.hashCode() == recipient2.hashCode());
    }
}