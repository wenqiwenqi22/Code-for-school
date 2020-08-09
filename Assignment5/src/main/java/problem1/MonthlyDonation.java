package problem1;

import java.time.LocalDate;

/**
 * MonthlyDonation is an object that extends from class donation, it is one type
 * of donation which will donate specific amount in the same date in every month
 * until the cancel date.
 */
public class MonthlyDonation extends Donation {
    private LocalDate cancellationDate = null;

    /**
     * Constructs a monthly donation object which has a name, an amount and a create date of the donation
     * @param name - the name of a specific monthly donation
     * @param amount -  the donate amount of a specific monthly donation
     * @param createDate -  the donation created date of a specific monthly donation
     * @throws Exception  when the monthly donation created date is not the current date, or the donate amount is a negative number.
     */
    public MonthlyDonation(String name, int amount, LocalDate createDate) throws Exception{
        super(name, amount, createDate);

    }

    /**
     * Constructs a monthly donation object which has a name, an amount  of the donation, the created date is current date if not provided
     * @param name -  the name of a specific monthly donation
     * @param amount -  the donate amount of a specific monthly donation
     * @throws Exception when the monthly donation the donate amount is a negative number.
     */
    public MonthlyDonation(String name, int amount) throws Exception{
        super(name, amount);
    }


    /**
     * Sets the cancellation date for a monthly donation.
     * @param date - the date wanted to set as the cancellation date
     * @throws InvalidDateException  when the cancellation date is in the past.
     */
    public void setCancellationDate(LocalDate date) throws InvalidDateException{
        if (date.isBefore(LocalDate.now())){
            throw new InvalidDateException("The cancellation date provided is invalid.");
        }else{
            this.cancellationDate = date;
        }
    }

    /**
     * Returns the  cancellation date for a monthly donation
     * @return the  cancellation date for a monthly donation
     */
    public LocalDate getCancellationDate(){
        return this.cancellationDate;
    }


    @Override
    public String toString() {
        return "MonthlyDonation{" +
                "cancellationDate=" + cancellationDate +
                '}';
    }
}
