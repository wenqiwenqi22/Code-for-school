package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BusTest {
    private Bus bus;
    protected String color = "blue";
    protected String makeAndModel = "Benz-c7";
    protected String licensePlate = "DEF-21";
    protected int speed = 10;
    protected int maximumSpeed = 60;

    @Before
    public void setUp() throws Exception {
        bus = new Bus(color, makeAndModel, licensePlate, maximumSpeed);
    }

    @Test
    public void accelerate() {
        bus.setInitialSpeed(speed);
        // case 1: happy path
        try {
            bus.accelerate(20);
            assertEquals(bus.getSpeed(), 12);
        } catch (InvalidAccelerationException e) {
            fail("An exception should not have been thrown.");
        }
        // case 2: throw exception when the accelerate factor is wrong
        try {
            bus.accelerate(80);
            assertEquals(bus.getSpeed(), 18);
            fail("An exception should have been thrown.");
        } catch (InvalidAccelerationException e) {
        }

        // case 3: throw exception when the maximum speed is violate
        try {
            bus.setInitialSpeed(50);
            bus.accelerate(50);
            assertEquals(bus.getSpeed(), 75);
            fail("An exception should have been thrown.");
        } catch (InvalidAccelerationException e) {
        }
    }

    @Test
    public void decelerate() {
        bus.setInitialSpeed(50);
        // case 1: happy path
        try {
            bus.decelerate(20);
            assertEquals(bus.getSpeed(), 40);
        } catch (InvalidDecelerationException e) {
            fail("An exception should not have been thrown.");
        }
        // case 2: throw exception when the accelerate factor is wrong
        try {
            bus.decelerate(-10);
            assertEquals(bus.getSpeed(), 55);
            fail("An exception should have been thrown.");
        } catch (InvalidDecelerationException e) {
        }
    }

    @Test
    public void setInitialSpeed() {
        // case 1: happy path
        try {
            bus.setInitialSpeed(50);
            assertEquals(bus.getSpeed(), 50);
        } catch (IllegalArgumentException e) {
            fail("An exception should not have been thrown.");
        }
        // case 2 : invalid initial speed
        try {
            bus.setInitialSpeed(100);
            assertEquals(bus.getSpeed(), 50);
            fail("An exception should have been thrown.");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void getSpeed() {
        // case 1: happy path
        try {
            bus.setInitialSpeed(50);
            assertEquals(bus.getSpeed(), 50);
        } catch (IllegalArgumentException e) {
            fail("An exception should not have been thrown.");
        }
        // case 2 : invalid initial speed
        try {
            bus.setInitialSpeed(100);
            assertEquals(bus.getSpeed(), 50);
            fail("An exception should have been thrown.");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void getDefaultMaximumSpeed() {
        assertEquals(bus.getDefaultMaximumSpeed(), 60);
    }

}