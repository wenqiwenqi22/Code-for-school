package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PledgeTest {
    private Pledge donation;
    private LocalDate actualDonateDate;
    private String name;
    private int amount;

    @Before
    public void setUp() throws Exception {
        //happy path1
        name = "Suzy";
        amount = 380;
        donation = new Pledge(name, amount);
        //happy path2
        Pledge pledge2 = new Pledge(name, amount, LocalDate.now(), LocalDate.of(2020, 10, 11));

        //happy path3
        Pledge pledge3 = new Pledge(name, amount, LocalDate.now());

        //throw an exception
        try{
            LocalDate previousDate = LocalDate.of(2000, 10, 11);
            Pledge pledge = new Pledge(name, amount, LocalDate.now(),previousDate);
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
        assertEquals(donation.getCreateDate(), LocalDate.now());
    }

    @Test
    public void getActualDonateDate() throws InvalidDateException {
        assertEquals(donation.getActualDonateDate(), null);
        donation.setDonateDate(LocalDate.of(2020, 12,1));
        assertEquals(donation.getActualDonateDate(), LocalDate.of(2020, 12,1));
    }

    @Test
    public void setDonateDate() throws InvalidDateException{
        assertEquals(donation.getActualDonateDate(), null);
        donation.setDonateDate(LocalDate.of(2020, 12,1));
        assertEquals(donation.getActualDonateDate(), LocalDate.of(2020, 12,1));
    }

    @Test(expected = InvalidDateException.class)
    public void setDonateDateFail() throws InvalidDateException{
        LocalDate previousDate = LocalDate.of(2000, 10, 11);
        donation.setDonateDate(previousDate);

    }

    @Test
    public void equalsTest() throws Exception {
        assertEquals(donation, new Pledge(name, amount, LocalDate.now()));
    }

    @Test
    public void hashCodeTest() throws Exception {
        assertEquals(donation.hashCode(), new Pledge(name, amount, LocalDate.now()).hashCode());
    }

    @Test
    public void toStringTest() {
        String s = "Donation{name='Suzy', amount=380, createDate=" + LocalDate.now() + "}";
        assertEquals(donation.toString(), s);
    }

}