package problem1;

import java.time.LocalDate;

/**
 * One time donation is an object that extends from donation class with all the methods from donations.
 * One time donation only happens once.
 */
public class OneTimeDonation extends Donation {

    /**
     * Constructs a one-time donation object which has a name, an amount and a create date of the donation
     * @param name - the name of a specific one-time donation
     * @param amount -  the donate amount of a specific one-time donation
     * @param createDate -  the donation created date of a specific one-time donation
     * @throws Exception  when the one-time donation created date is not the current date, or the donate amount is a negative number.
     */
    public OneTimeDonation(String name, int amount, LocalDate createDate) throws Exception{
        super(name, amount, createDate);
    }

    /**
     *  Constructs a one-time donation object which has a name, an amount  of the donation, the created date is current date if not provided
     * @param name -  the name of a specific one-time donation
     * @param amount -  the donate amount of a specific one-time donation
     * @throws Exception when the one-time donation the donate amount is a negative number.
     */
    public OneTimeDonation(String name, int amount) throws Exception{
        super(name, amount);
    }
}
