package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnerTest {
    private Owner owner;

    @Before
    public void setUp() throws Exception {
        owner = new Owner("Wenqi", "Cao", "1234567890");

    }

    @Test
    public void getFirstName() {
        assertEquals("Wenqi", owner.getFirstName());
    }

    @Test
    public void setFirstName() {
        // before setting
        assertEquals("Wenqi", owner.getFirstName());
        // after setting
        String firstName = "Ellie";
        owner.setFirstName(firstName);
        assertEquals(firstName, owner.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Cao", owner.getLastName());
    }

    @Test
    public void setLastName() {
        // before setting
        assertEquals("Cao", owner.getLastName());
        // after setting
        String lastName = "James";
        owner.setLastName(lastName);
        assertEquals(lastName, owner.getLastName());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals("1234567890", owner.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber() {
        // before setting
        String oldPhoneNumber = "1234567890";
        assertEquals(oldPhoneNumber, owner.getPhoneNumber());
        // after setting
        // checking the phone number has less than 10 characters
        String newPhoneNumber2 = "123";
        owner.setPhoneNumber(newPhoneNumber2);
        assertEquals(oldPhoneNumber, owner.getPhoneNumber());

        // checking if the phone number is 10 characters only
        String newPhoneNumber1 = "0987654321";

        owner.setPhoneNumber(newPhoneNumber1);
        assertEquals(newPhoneNumber1, owner.getPhoneNumber());


    }
}