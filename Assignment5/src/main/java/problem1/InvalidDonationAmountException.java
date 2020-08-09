package problem1;

/***
 * InvalidDonationAmountException is an object that extends from Exception class
 * which will throw an exception and message when the donate amount is not valid(negative)
 */
public class InvalidDonationAmountException extends Exception {
    /**
     * Constructs anInvalidDonationAmountException which will throw an exception and message when the donate amount is not valid(negative)
     * @param message - a specific message for the InvalidDonationAmountException
     */
    public InvalidDonationAmountException(String message) {
        super(message);
    }
}
