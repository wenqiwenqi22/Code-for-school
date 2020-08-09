package problem1;
/**
 * Automobile is a object extends from Class Vehicle that has a color, make and model, license plate, speed, maximum speed, upper bound of accelerate factor
 * lower bound of accelerate factor, upper bound of decelerate factor, lower bound of decelerate factor and helper factor(which help us to calculate the speed
 * after changing).
 * it inherit all methods from its parent Vehicle class.
 */
public class Automobile extends Vehicle {
    public static final int DEFAULT_MAX_SPEED = 70;

    /**
     * Constructor that creates a new automobile object with a specific color, make and model, license plate, maximum speed.
     * @param color -  the color of the automobile.
     * @param makeAndModel- the make and model of the automobile.
     * @param licensePlate- the license plate of the automobile.
     * @param maximumSpeed- the maximum speed of the automobile.
     * @throws IllegalArgumentException throws an illegal argument when the maximum speed is wrong.
     */
    public Automobile(String color, String makeAndModel, String licensePlate, int maximumSpeed) throws IllegalArgumentException {
        super(color, makeAndModel, licensePlate, maximumSpeed);
    }

    /**
     * This method override the abstract class Vehicle.
     * Returns the default maximum speed of the automobile.
     * @return the default maximum speed of the automobile.
     */
    @Override
    public int getDefaultMaximumSpeed() {
        return DEFAULT_MAX_SPEED;
    }
}
