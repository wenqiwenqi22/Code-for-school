package problem1;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * NonProfit is a class with a name of the organization, a list of donations. It also has a function to calculate the sum of
 * all donations for a specific year and other functions like calculate different type of donations.
 */

public class NonProfit {
    /**
     * {@value #NUMBER_OF_MONTHS} NUMBER_OF_MONTHS in a year, which is 12.
     */
    public static final int NUMBER_OF_MONTHS = 12;
    private String nameOfOrganization;
    private List<Donation> donationsList;
    private int sum;
    private LocalDate now = LocalDate.now();
    private Integer currentYear = now.getYear();

    /**
     * Constructs a NonProfit object with a specific name of the organization and a list of donations
     * @param nameOfOrganization- the name of the organization
     * @param donationsList- the list of donations
     */

    public NonProfit(String nameOfOrganization, List<Donation> donationsList) {
        this.nameOfOrganization = nameOfOrganization;
        this.donationsList = donationsList;
    }

    /**
     * Returns the name of the organization
     * @return the name of the organization
     */
    public String getNameOfOrganization() {
        return this.nameOfOrganization;
    }

    /**
     * Return the list of donations
     * @return the list of donations
     */
    public List<Donation> getDonationsList() {
        return this.donationsList;
    }

    /**
     * Returns the total donations amount for a specific year(provided by the argument) by adding different types of donations
     * @param year - the year you wanted to check the total donation amount
     * @return the total donations amount for a specific year(provided by the argument) by adding different types of donations
     */
    public int getTotalDonationsForYear(Integer year) {
        sum = 0;
        // loop all the donations in the donations list
        for (int i = 0; i < this.donationsList.size(); i++){
            Donation donation = this.donationsList.get(i);
            LocalDate donationDate = donation.getCreateDate();
            if (donation instanceof OneTimeDonation) {
                sum += getOneTimeDonationAmount(year, donation);
            }else if(donation instanceof MonthlyDonation){
                MonthlyDonation monthlyDonation = (MonthlyDonation)donation;
                sum += getMonthlyDonationAmount(year, monthlyDonation);
            }else if (donation instanceof Pledge){
                sum += getPledgeAmount(year, donation);
            }
        }

        return sum;
    }

    /**
     * adds a new donation to the non-profit object, returns a new list of donation
     * @param donation-the new donation you wanted to add in the non-profit object
     * @return a new list of donation after adding a new donation
     */
    public List<Donation> makeADonation(Donation donation){
        if (this.donationsList == null || this.donationsList.isEmpty()){
            this.donationsList = new ArrayList<>();
        }
        this.donationsList.add(donation);
        return this.donationsList;
    }


    /**
     * Returns the donation amount of an one-time donation happened in a specific year.
     * @param year- a specific year wanted to check the donation amount
     * @param donation - an one-time donation happened in a specific year
     * @return the donation amount of an one-time donation happened in a specific year
     */
    public int getOneTimeDonationAmount(Integer year, Donation donation) {
        if (donation.getCreateDate().getYear() == year){
            return donation.getAmount();
        }
        return 0;
    }

    /**
     * Calculates and returns the total donation amount for a monthly donation which happens in specific year by using
     * number of months times donation amount per month
     * @param year - a specific year wanted to check the donation amount
     * @param donation - a monthly donation happened in a specific year
     * @return the total donation amount for a monthly donation which happens in specific year
     */
    public int getMonthlyDonationAmount(Integer year, MonthlyDonation donation) {
        // if the year is the year of the donation object
        if (donation.getCreateDate().getYear() == year) {
            LocalDate startDate = donation.getCreateDate();
            LocalDate endDate = donation.getCancellationDate();
            LocalDate beginOfYear = LocalDate.of(year, 1, 1);
            LocalDate endOfYear = LocalDate.of(year, 12, 31);
            //starDateOfThisYear means the date of the first donation in this year
            // endDateOfThisYear means the date of the last payment in the year if it is not over
            //for example, if a monthly donation was created on 2018.4.5, no end date,
            // and now we are checking for year 2019, starDateOfThisYear is 2019.1.5
            LocalDate starDateOfThisYear = LocalDate.of(year, 1, startDate.getDayOfMonth());
            LocalDate endDateOfThisYear = LocalDate.of(year, 12, startDate.getDayOfMonth());
            Period period = null;
            // when the year is a previous year
            if (year < currentYear) {
                // the start date is before or equals the beginning of the year
                // the end date is after the end of the year or the end date has not been set
                if ((startDate.isBefore(beginOfYear) || startDate.equals(beginOfYear))
                        && ( endDate == null || endDate.isAfter(endOfYear))) {

                    return NUMBER_OF_MONTHS * donation.getAmount();
                } else {

                    // the start date is before or equals the beginning of the year
                    //the end date is before the end of the year
                    if (startDate.isBefore(beginOfYear)|| startDate.equals(beginOfYear)
                        && endDate != null) {
                        period = Period.between(starDateOfThisYear, endDate);

                        //the start date is after the beginning of the year
                        // the end date is after the end of the year or the end date has not been set
                    } else if (endDate == null || endDate.isAfter(endOfYear)) {

                        period = Period.between(startDate, endDateOfThisYear);

                        //the start date is after the beginning of the year
                        //the end date is before the end of the year
                    } else {
                        period = Period.between(startDate, endDate);
                    }

                    if (period == null){
                        return 0;
                    }
                    //if the period is less than 1 month, then we count the amount once
                    if (period.getMonths() == 0){
                        return donation.getAmount();
                    }
                    return period.getMonths() * donation.getAmount();
                }
            } else if ((int)year == currentYear){
                //if the start date is before or equal to the begin of the year, we should count from the 1st amount in January
                //if the end date is after or equal to the end of the year, we should count till the the last amount in December
                if((startDate.isBefore(beginOfYear) || startDate.equals(beginOfYear))
                        && (endDate == null || endDate.isAfter(now) || endDate.equals(now))){
                    period = Period.between(starDateOfThisYear, now);

                    // if the start date is after the begin of the year, we should count from the actual start date
                    // if the end date is before the current date or has not been set yet, we should count till the actual end date
                }else if (startDate.isAfter(beginOfYear)
                        && (endDate == null || endDate.isBefore(now))) {
                    if (endDate == null){
                        period = Period.between(startDate, now);
                    }else {
                        period = Period.between(startDate, endDate);
                    }

                    // if the start date is before or equal the begin of the year, we should count from the 1st amount in January
                    // if the end date is before the current date, we should count till the actual end date
                } else if ((startDate.isBefore(beginOfYear)|| startDate.equals(beginOfYear))
                        && (endDate == null ||endDate.isBefore(now))){
                    if (endDate == null){
                        period = Period.between(starDateOfThisYear, now);
                    }else {
                        period = Period.between(starDateOfThisYear, endDate);
                    }

                    //if the start date is after the begin of the year, we should count from the actual start date
                    //if the end date is after or equals now, we should count till now.
                } else if (startDate.isAfter(beginOfYear)
                        && (endDate.isAfter(now) || endDate.equals(now))){
                    period = Period.between(startDate, now);
                }
                if(period == null){
                    return 0;
                }
                //if the period is less than 1 month, then we count the amount once
                if (period.getMonths() == 0){
                    return donation.getAmount();
                }
                return period.getMonths() * donation.getAmount();
            }

        }
        return 0;
    }

    /**
     * Calculates and returns the donation amount for a pledge if the actual donate time is in a specific year.
     * @param year - a specific year wanted to check the donation amount
     * @param donation - a pledge happened in a specific year
     * @return the donation amount for a pledge if the actual donate time is in a specific year.
     */
    public int getPledgeAmount(Integer year, Donation donation){
        //when there is no donate date for pledge, we don't count it.
        Pledge pledge = (Pledge)donation;
        if (pledge.getActualDonateDate() == null){
            return 0;
        }else{
            // when there is a donate date
            LocalDate donateDate = pledge.getActualDonateDate();
            if(year == donateDate.getYear()){
                // when the year is previous year, return the amount
                //when the year is this year, check if the donation date is before or equals the current date
                if (year < currentYear || ((int)year == currentYear && (donateDate.isBefore(now) || donateDate.equals(now)))){
                    return donation.getAmount();
                }
            }
        }
        return 0;
    }

    /**
     * Returns true if two non-profit objects are equal
     * @param o the object that wanted to compare
     * @return true if two non-profit objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NonProfit nonProfit = (NonProfit) o;
        return sum == nonProfit.sum &&
                Objects.equals(nameOfOrganization, nonProfit.nameOfOrganization) &&
                Objects.equals(donationsList, nonProfit.donationsList) &&
                Objects.equals(now, nonProfit.now) &&
                Objects.equals(currentYear, nonProfit.currentYear);
    }

    /**
     * Returns the hashcode of the object
     * @return the hashcode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(nameOfOrganization, donationsList, sum, now, currentYear);
    }

    /**
     * Returns the String format of the object
     * @return the String format of the object
     */
    @Override
    public String toString() {
        return "NonProfit{" +
                "nameOfOrganization='" + nameOfOrganization + '\'' +
                ", donationsList=" + donationsList +
                ", sum=" + sum +
                ", now=" + now +
                ", currentYear=" + currentYear +
                '}';
    }
}
