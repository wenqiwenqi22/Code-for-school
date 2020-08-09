public class ImpactEstimationException extends Exception{

    /**
     * Throws exception when the estimated impact is invalid.
     * @param message - specify the details of the exception
     */
    public ImpactEstimationException(String message) {
        super(message);
    }
}
