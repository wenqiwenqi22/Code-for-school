package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AutomobileTest {
    private Automobile automobile;
    protected String color = "yellow";
    protected String makeAndModel = "AUDI-Q7";
    protected String licensePlate = "ABC-18";
    protected int speed = 10;
    protected int maximumSpeed = 70;

    @Before
    public void setUp() throws Exception {
        automobile = new Automobile(color, makeAndModel, licensePlate, maximumSpeed);
    }

    @Test
    public void accelerate() {
        automobile.setInitialSpeed(speed);
        // case 1: happy path
        try {
            automobile.accelerate(20);
            assertEquals(automobile.getSpeed(), 12);
        } catch (InvalidAccelerationException e) {
            fail("An exception should not have been thrown.");
        }
        // case 2: throw exception when the accelerate factor is wrong
        try {
            automobile.accelerate(80);
            assertEquals(automobile.getSpeed(), 18);
            fail("An exception should have been thrown.");
        } catch (InvalidAccelerationException e) {
        }

        // case 3: throw exception when the maximum speed is violate
        try {
            automobile.setInitialSpeed(50);
            automobile.accelerate(50);
            assertEquals(automobile.getSpeed(), 75);
            fail("An exception should have been thrown.");
        } catch (InvalidAccelerationException e) {
        }
    }

    @Test
    public void decelerate() {
        automobile.setInitialSpeed(50);
        // case 1: happy path
        try {
            automobile.decelerate(20);
            assertEquals(automobile.getSpeed(), 40);
        } catch (InvalidDecelerationException e) {
            fail("An exception should not have been thrown.");
        }
        // case 2: throw exception when the accelerate factor is wrong
        try {
            automobile.decelerate(-10);
            assertEquals(automobile.getSpeed(), 55);
            fail("An exception should have been thrown.");
        } catch (InvalidDecelerationException e) {
        }
    }

    @Test
    public void setInitialSpeed() {
        // case 1: happy path
        try {
            automobile.setInitialSpeed(50);
            assertEquals(automobile.getSpeed(), 50);
        } catch (IllegalArgumentException e) {
            fail("An exception should not have been thrown.");
        }
        // case 2 : invalid initial speed
        try {
            automobile.setInitialSpeed(100);
            assertEquals(automobile.getSpeed(), 50);
            fail("An exception should have been thrown.");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void getSpeed() {
        // case 1: happy path
        try {
            automobile.setInitialSpeed(50);
            assertEquals(automobile.getSpeed(), 50);
        } catch (IllegalArgumentException e) {
            fail("An exception should not have been thrown.");
        }
        // case 2 : invalid initial speed
        try {
            automobile.setInitialSpeed(100);
            assertEquals(automobile.getSpeed(), 50);
            fail("An exception should have been thrown.");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void getDefaultMaximumSpeed() {
        assertEquals(automobile.getDefaultMaximumSpeed(), 70);
    }
}