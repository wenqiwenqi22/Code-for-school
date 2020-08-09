package problem1;

/**
 * Vehicle is a object that has a color, make and model, license plate, speed, maximum speed, upper bound of accelerate factor
 * lower bound of accelerate factor, upper bound of decelerate factor, lower bound of decelerate factor and helper factor(which help us to calculate the speed
 * after changing).
 */
public abstract class Vehicle {
    protected String color;
    protected String makeAndModel;
    protected String licensePlate;
    protected int speed;
    protected int maximumSpeed;
    private static final int ACCELERATE_FACTOR_UPPER_BOUND = 50;
    private static final int ACCELERATE_FACTOR_LOWER_BOUND = 10;
    private static final int DECELERATE_FACTOR_UPPER_BOUND = 50;
    private static final int DECELERATE_FACTOR_LOWER_BOUND = 20;
    private static final int HELPER_FACTOR = 100;

    /**
     * Constructor that creates a new vehicle object with a specific color, make and model, license plate, maximum speed.
     * @param color -  the color of the vehicle.
     * @param makeAndModel- the make and model of the vehicle.
     * @param licensePlate- the license plate of the vehicle.
     * @param maximumSpeed- the maximum speed of the vehicle.
     * @throws IllegalArgumentException  throws an illegal argument when the maximum speed is wrong.
     */
    public Vehicle(String color, String makeAndModel, String licensePlate, int maximumSpeed) throws IllegalArgumentException {
        this.color = color;
        this.color = color;
        this.makeAndModel = makeAndModel;
        this.licensePlate = licensePlate;
        if (getDefaultMaximumSpeed() == maximumSpeed) {
            this.maximumSpeed = maximumSpeed;
        } else {
            throw new IllegalArgumentException("This is an invalid speed. Please enter a valid speed");
        }
    }

    /**
     * This method will be override for each child class for different default maximum speed.
     * @return  the specific default maximum speed in the children class
     */
    public abstract int getDefaultMaximumSpeed();

    /**
     * This method will calculate a speed after acceleration when the acceleration factor and the speed is valid.
     * @param accelerationFactor-the accelerate factor of acceleration
     * @throws InvalidAccelerationException throws an illegal acceleration exception when the accelerate factor is wrong.
     */
    public void accelerate(int accelerationFactor) throws InvalidAccelerationException{
        if (accelerationFactor >= ACCELERATE_FACTOR_LOWER_BOUND && accelerationFactor <= ACCELERATE_FACTOR_UPPER_BOUND) {
            this.speed = this.speed * (HELPER_FACTOR + accelerationFactor) / HELPER_FACTOR;
            if (this.speed <= maximumSpeed && this.speed > 0){
                return;
            } else {
                throw new InvalidAccelerationException("Speeding warning!");
            }
        } else {
            throw new InvalidAccelerationException("Invalid accelerate factor!");
        }
    }

    /**
     * This method will calculate a speed after deceleration when the deceleration factor and the speed is valid.
     * @param decelerationFactor-the decelerate factor of deceleration
     * @throws InvalidDecelerationException throws an illegal deceleration exception when the decelerate factor is wrong.
     */
    public void decelerate(int decelerationFactor) throws InvalidDecelerationException{
        if (decelerationFactor >= DECELERATE_FACTOR_LOWER_BOUND && decelerationFactor <= DECELERATE_FACTOR_UPPER_BOUND) {
            this.speed = this.speed * (HELPER_FACTOR - decelerationFactor) / HELPER_FACTOR;
            if (this.speed <= maximumSpeed && this.speed > 0){
                return;
            } else {
                throw new InvalidDecelerationException("Speeding warning!");
            }
        } else {
            throw new InvalidDecelerationException("Invalid decelerate factor!");
        }
    }

    /**
     * This method is used to set the initial speed of the vehicle before acceleration or deceleration.
     * @param speed- the initial speed of the vehicle.
     * @throws IllegalArgumentException throws an illegal argument exception when the initial speed is invalid.
     */
    public void setInitialSpeed(int speed) throws IllegalArgumentException{
        if (speed > 0 && speed <= getDefaultMaximumSpeed()) {
            this.speed = speed;
        } else {
            throw new IllegalArgumentException("Invalid initial speed!");
        }
    }

    /**
     * Returns the current speed of the vehicle.
     * @return the current speed of the vehicle.
     */
    public int getSpeed() {
        return this.speed;
    }
}
