package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnerTest {
    private Owner owner;
    private String firstName;
    private String lastName;

    @Before
    public void setUp() throws Exception {
        firstName = "Mina";
        lastName = "Zhou";
        owner = new Owner(firstName, lastName);
    }

    @Test
    public void getFirstName() {
        assertEquals(firstName, owner.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals(lastName, owner.getLastName());
    }
}