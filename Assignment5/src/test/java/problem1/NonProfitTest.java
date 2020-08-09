package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NonProfitTest {
    private NonProfit nonProfit;
    private String nameOfOrganization;
    private List<Donation> donationsList;
    private Donation donation1;
    private MonthlyDonation donation2;
    private Pledge donation3;

    @Before
    public void setUp() throws Exception {
        donation1 = new OneTimeDonation("Wendy", 500);
        donation2 = new MonthlyDonation("Amy", 100);
        donation3 = new Pledge("Annie", 100);
        donationsList = new ArrayList<>();
        donationsList.add(donation1);
        nameOfOrganization = "Love";
        nonProfit = new NonProfit(nameOfOrganization, donationsList);
    }

    @Test
    public void getNameOfOrganization() {
        assertEquals(nonProfit.getNameOfOrganization(), nameOfOrganization);
    }

    @Test
    public void getDonationsList() {
        assertEquals(nonProfit.getDonationsList(), donationsList);
    }

    @Test
    public void getTotalDonationsForYear() {
        donationsList.add(donation2);
        assertEquals(nonProfit.getTotalDonationsForYear(2020), 600);
    }

    @Test
    public void makeADonation() {
        // when the donation list is not empty
        nonProfit.makeADonation(donation2);
        assertEquals(nonProfit.getTotalDonationsForYear(2020), 600);
        //when the donation list is null or empty
        NonProfit nonProfit1 = new NonProfit(nameOfOrganization, new ArrayList<Donation>());
        nonProfit1.makeADonation(donation2);
        assertEquals(nonProfit1.getTotalDonationsForYear(2020), 100);
    }

    @Test
    public void getOneTimeDonationAmount() {
        //happy path
        assertEquals(nonProfit.getOneTimeDonationAmount(2020, donation1), 500);
        //the year is not the year of the donation
        assertEquals(nonProfit.getOneTimeDonationAmount(2000, donation1), 0);
    }

    @Test
    public void getMonthlyDonationAmount() {
        //happy path
        nonProfit.makeADonation(donation2);
        assertEquals(nonProfit.getOneTimeDonationAmount(2020, donation2), 100);
        // the year is not the year of the donation
        assertEquals(nonProfit.getOneTimeDonationAmount(2000, donation2), 0);
    }

    @Test
    // the start date is before or equals the beginning of the year
    // the end date has not been set or after current date
    public void getMonthlyDonationAmount1() throws InvalidDateException {
        //a monthly donation without a cancel date
        assertEquals(nonProfit.getMonthlyDonationAmount(2020, donation2), 100);
        //a monthly donation with a cancel date
        donation2.setCancellationDate(LocalDate.of(2020, 12, 20));
        assertEquals(nonProfit.getMonthlyDonationAmount(2020, donation2), 100);
        //checking year is in the future
        assertEquals(nonProfit.getMonthlyDonationAmount(2022, donation2), 0);

    }

    @Test
    public void getPledgeAmount() throws InvalidDateException {
        // have not set the donate date for a pledge
        assertEquals(nonProfit.getPledgeAmount(2020, donation3), 0);
        // set the donate date for a pledge
        donation3.setDonateDate(LocalDate.now());
        nonProfit.makeADonation(donation3);
        assertEquals(nonProfit.getPledgeAmount(2020, donation3), 100);
        //checking year is in the future
        assertEquals(nonProfit.getPledgeAmount(2022, donation3), 0);
    }

    @Test
    public void toStringTest() {
        String s = "NonProfit{nameOfOrganization='Love', donationsList=[Donation{name='Wendy', amount=500, createDate=" + LocalDate.now() + "}], sum=0, now="+ LocalDate.now() +", currentYear=2020}";
        assertEquals(nonProfit.toString(), s);
    }

    @Test
    public void equalsTest() throws Exception {
        assertEquals(nonProfit, new NonProfit(nameOfOrganization, donationsList));
    }

    @Test
    public void hashCodeTest() throws Exception {
        assertEquals(nonProfit.hashCode(), new NonProfit(nameOfOrganization, donationsList).hashCode());
    }
}