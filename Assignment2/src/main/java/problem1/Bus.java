package problem1;

/**
 * Bus is a object extends from Class Vehicle that has a color, make and model, license plate, speed, maximum speed, upper bound of accelerate factor
 * lower bound of accelerate factor, upper bound of decelerate factor, lower bound of decelerate factor and helper factor(which help us to calculate the speed
 * after changing).
 * it inherit all methods from its parent Vehicle class.
 */
public class Bus extends Vehicle {
    public static final int DEFAULT_MAX_SPEED = 60;

    /**
     * Constructor that creates a new bus object with a specific color, make and model, license plate, maximum speed.
     * @param color -  the color of the bus.
     * @param makeAndModel- the make and model of the bus.
     * @param licensePlate- the license plate of the bus.
     * @param maximumSpeed- the maximum speed of the bus.
     * @throws IllegalArgumentException throws an illegal argument when the maximum speed is wrong.
     */
    public Bus(String color, String makeAndModel, String licensePlate, int maximumSpeed) throws IllegalArgumentException {
        super(color, makeAndModel, licensePlate, maximumSpeed);
    }

    /**
     * This method override the abstract class Vehicle.
     * Returns the default maximum speed of the bus.
     * @return the default maximum speed of the bus.
     */
    @Override
    public int getDefaultMaximumSpeed() {
        return DEFAULT_MAX_SPEED;
    }
}
