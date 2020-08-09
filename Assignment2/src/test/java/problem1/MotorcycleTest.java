package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MotorcycleTest {
    private Motorcycle motorcycle;
    protected String color = "red";
    protected String makeAndModel = "YAMAHA-A7";
    protected String licensePlate = "ABC-12";
    protected int speed = 10;
    protected int maximumSpeed = 65;

    @Before
    public void setUp() throws IllegalArgumentException {
        //case 1: happy path
        try {
            motorcycle = new Motorcycle(color, makeAndModel, licensePlate, maximumSpeed);
            assertEquals(motorcycle.maximumSpeed, maximumSpeed);
        } catch (IllegalArgumentException e) {
            fail("An exception should not have been thrown.");
        }
        //case 2: invalid object
        try {
            Motorcycle motorcycle2 = new Motorcycle(color, makeAndModel, licensePlate, 100);
            assertEquals(motorcycle.maximumSpeed, maximumSpeed);
            fail("An exception should have been thrown.");
        } catch (IllegalArgumentException e) {
        }

    }

    @Test
    public void accelerate(){
        motorcycle.setInitialSpeed(speed);
        // case 1: happy path
        try {
            motorcycle.accelerate(20);
            assertEquals(motorcycle.getSpeed(), 12);
        } catch (InvalidAccelerationException e) {
            fail("An exception should not have been thrown.");
        }
        // case 2: throw exception when the accelerate factor is wrong
        try {
            motorcycle.accelerate(80);
            assertEquals(motorcycle.getSpeed(), 18);
            fail("An exception should have been thrown.");
        } catch (InvalidAccelerationException e) {
        }

        // case 3: throw exception when the maximum speed is violate
        try {
            motorcycle.setInitialSpeed(50);
            motorcycle.accelerate(50);
            assertEquals(motorcycle.getSpeed(), 75);
            fail("An exception should have been thrown.");
        } catch (InvalidAccelerationException e) {
        }
    }

    @Test
    public void decelerate() {
        motorcycle.setInitialSpeed(50);
        // case 1: happy path
        try {
            motorcycle.decelerate(20);
            assertEquals(motorcycle.getSpeed(), 40);
        } catch (InvalidDecelerationException e) {
            fail("An exception should not have been thrown.");
        }
        // case 2: throw exception when the accelerate factor is wrong
        try {
            motorcycle.decelerate(-10);
            assertEquals(motorcycle.getSpeed(), 55);
            fail("An exception should have been thrown.");
        } catch (InvalidDecelerationException e) {
        }

    }

    @Test
    public void setInitialSpeed() {
        // case 1: happy path
        try {
            motorcycle.setInitialSpeed(50);
            assertEquals(motorcycle.getSpeed(), 50);
        } catch (IllegalArgumentException e) {
            fail("An exception should not have been thrown.");
        }
        // case 2 : invalid initial speed
        try {
            motorcycle.setInitialSpeed(100);
            assertEquals(motorcycle.getSpeed(), 50);
            fail("An exception should have been thrown.");
        } catch (IllegalArgumentException e) {
        }

    }

    @Test
    public void getDefaultMaximumSpeed() {
        assertEquals(motorcycle.getDefaultMaximumSpeed(), 65);
    }
}