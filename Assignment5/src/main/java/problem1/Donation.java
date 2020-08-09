package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Donation is an abstract class with the name, the amount and the create date of the donation.
 */
public abstract class Donation {
    private String name;
    private int amount;
    private LocalDate createDate;

    /**
     * Constructs a donation object which has a name, an amount and a create date of the donation
     * @param name -  the name of a specific donation
     * @param amount -  the donate amount of a specific donation
     * @param createDate -  the donation created date of a specific donation
     * @throws Exception  when the donation created date is not the current date, or the donate amount is a negative number.
     */
    public Donation(String name, int amount, LocalDate createDate) throws Exception{
        if (amount <= 0){
            throw new InvalidDonationAmountException("The amount of the donation is invalid.");
        }else{
            this.amount = amount;
        }

        if (!createDate.equals(LocalDate.now())){
            throw new InvalidDateException("The donate date is invalid.");
        }else{
            this.createDate = createDate;
        }
        this.name = name;
    }

    /**
     * Constructs a donation object which has a name, an amount  of the donation, the created date is current date if not provided
     * @param name -  the name of a specific donation
     * @param amount -  the donate amount of a specific donation
     * @throws Exception  when the donation created date is not the current date, or the donate amount is a negative number.
     */
    public Donation(String name, int amount) throws Exception {
        this(name, amount, LocalDate.now());
    }


    /**
     * Returns the name of the specific donation
     * @return the name of the specific donation
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the donate amount of the specific donation
     * @return the donate amount of the specific donation
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * Returns the create date of the donation
     * @return the create date of the donation
     */
    public LocalDate getCreateDate() {
        return this.createDate;
    }

    /**
     * Returns true if two donation objects are equal
     * @param o the object that wanted to compare
     * @return true if two donation objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donation donation = (Donation) o;
        return amount == donation.amount &&
                Objects.equals(name, donation.name) &&
                Objects.equals(createDate, donation.createDate);
    }

    /**
     * Returns the hashcode of the object
     * @return the hashcode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, amount, createDate);
    }

    /**
     * Returns the String format of the object
     * @return the String format of the object
     */
    @Override
    public String toString() {
        return "Donation{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", createDate=" + createDate +
                '}';
    }
}
