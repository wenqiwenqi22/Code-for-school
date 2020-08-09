package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MonthlyDonationTest {
    private MonthlyDonation donation;
    private String name;
    private int amount;
    private LocalDate createDate;

    @Before
    public void setUp() throws Exception {
        //happy path
        name = "Ellie Chen";
        amount = 1000;
        createDate = LocalDate.now();
        donation = new MonthlyDonation(name, amount, createDate);

        //throw exceptions
        try{
            MonthlyDonation donation2 = new MonthlyDonation(name, -10, createDate);
            fail("This is an expected exception.");
        }catch (Exception e){

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
        assertEquals(donation.getCreateDate(), createDate);
    }


    @Test
    public void setCancellationDate() throws InvalidDateException {
        assertEquals(donation.getCancellationDate(), null);
        donation.setCancellationDate(LocalDate.of(2022, 6,15));
        assertEquals(donation.getCancellationDate(), LocalDate.of(2022, 6,15));
    }

    @Test(expected = InvalidDateException.class)
    public void setCancellationDateFail() throws InvalidDateException {
        donation.setCancellationDate(LocalDate.of(2002, 6,15));
    }

    @Test
    public void getCancellationDate() throws InvalidDateException{
        assertEquals(donation.getCancellationDate(), null);
        donation.setCancellationDate(LocalDate.of(2022, 6,15));
        assertEquals(donation.getCancellationDate(), LocalDate.of(2022, 6,15));
    }

    @Test
    public void toStringTest() {
        String s = "MonthlyDonation{cancellationDate=null}";
        assertEquals(donation.toString(), s);
    }

    @Test
    public void equalsTest() throws Exception {
        assertEquals(donation, new MonthlyDonation(name, amount, createDate));
    }

    @Test
    public void hashCodeTest() throws Exception {
        assertEquals(donation.hashCode(), new MonthlyDonation(name, amount, createDate).hashCode());
    }

}