package problem1;

/**
 * InvalidDateException is an object that extended from Exception class,which will throws
 * an exception message when the specific date is invalid
 */
public class InvalidDateException extends Exception {

    /**
     * Constructs an InvalidDateException object when  the specific date is invalid
     * @param message - the specific message for the InvalidDateException
     */
    public InvalidDateException(String message) {
        super(message);
    }
}
