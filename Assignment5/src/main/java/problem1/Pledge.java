package problem1;

import java.time.LocalDate;

/**
 * Pledge is an object that extends from class donation, it is one type of donation which happened
 * in the future. it track the created date and the actual donate date separately.
 */
public class Pledge extends Donation {
    private LocalDate actualDonateDate;

    /**
     * Constructs a pledge object which has a name, an amount and a create date and an actual donate date of the donation
     * @param name - the name of a specific pledge
     * @param amount -  the donate amount of a specific pledge
     * @param createDate -  the donation created date of a specific pledge
     * @param actualDonateDate - the actual donate date of a specific pledge
     * @throws Exception  pledge created date is not the current date, or the donate amount is a negative number, or the actual donate date is in the past.
     */
    public Pledge(String name, int amount, LocalDate createDate, LocalDate actualDonateDate) throws Exception{
        super(name, amount, createDate);
        if (actualDonateDate.isBefore(LocalDate.now())) {
            throw new InvalidDateException("This date is invalid.");
        }else {
            this.actualDonateDate = actualDonateDate;
        }
    }

    /**
     * Constructs a pledge object which has a name, an amount and a create date of the donation
     * @param name - the name of a specific pledge
     * @param amount -  the donate amount of a specific pledge
     * @param createDate -  the donation created date of a specific pledge
     * @throws Exception  pledge created date is not the current date, or the donate amount is a negative number, or the actual donate date is in the past.
     */
    public Pledge(String name, int amount,  LocalDate createDate) throws Exception{
        super(name, amount, createDate);

    }

    /**
     * Constructs a pledge object which has a name, an amount of the donation, the created date is current date if not provided
     * @param name - the name of a specific pledge
     * @param amount -  the donate amount of a specific pledge
     * @throws Exception  pledge the donate amount is a negative number, or the actual donate date is in the past.
     */
    public Pledge(String name, int amount) throws Exception{
        super(name, amount);
    }

    /**
     * Returns the actual donate date for the pledge, if it has not been set yet, returns null
     * @return the actual donate date for the pledge, if it has not been set yet, returns null
     */
    public LocalDate getActualDonateDate() {
        return this.actualDonateDate;
    }


    /**
     * Sets the actual donate date for a specific pledge
     * @param date - the date wanted to set as the actual donate date
     * @throws InvalidDateException - when donate date is in the previous.
     */
    public void setDonateDate(LocalDate date) throws InvalidDateException{
        if (date.isBefore(LocalDate.now())){
            throw new InvalidDateException("The donation date cannot be the past.");
        }else{
            this.actualDonateDate = date;
        }
    }

}
