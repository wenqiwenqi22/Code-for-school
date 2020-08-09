package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class OneTimeDonationTest {
    private OneTimeDonation donation;
    private String name;
    private int amount;

    @Before
    public void setUp() throws Exception {
        //constructor 1
        name = "Lulu";
        amount = 200;
        donation = new OneTimeDonation(name, amount);

        //constructor 2
        Donation donation1 = new OneTimeDonation(name, amount, LocalDate.now());

        //throw an exception
        try {
            Donation donation2 = new OneTimeDonation(name, amount, LocalDate.of(2020, 6, 12));
            fail("This is an expected exception.");
        }catch (InvalidDateException e){

        }

    }

    @Test
    public void getName() {
        assertEquals(donation.getName(), name);
    }

    @Test
    public void getAmount() {
        assertEquals(donation.getAmount(), amount);
    }

    @Test
    public void getCreateDate() {
        assertEquals(donation.getCreateDate(), LocalDate.now());
    }
    @Test
    public void equalsTest() throws Exception {
        assertEquals(donation, new OneTimeDonation(name, amount, LocalDate.now()));
    }

    @Test
    public void hashCodeTest() throws Exception {
        assertEquals(donation.hashCode(), new OneTimeDonation(name, amount, LocalDate.now()).hashCode());
    }
    @Test
    public void toStringTest() {
        String s = "Donation{name='Lulu', amount=200, createDate=" + LocalDate.now() + "}";
        assertEquals(donation.toString(), s);
    }
}