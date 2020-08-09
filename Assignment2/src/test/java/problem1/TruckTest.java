package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TruckTest {
    private Truck truck;
    protected String color = "blue";
    protected String makeAndModel = "Benz-c7";
    protected String licensePlate = "DEF-21";
    protected int speed = 10;
    protected int maximumSpeed = 60;

    @Before
    public void setUp() throws Exception {
        truck = new Truck(color, makeAndModel, licensePlate, maximumSpeed);
    }

    @Test
    public void accelerate() {
        truck.setInitialSpeed(speed);
        // case 1: happy path
        try {
            truck.accelerate(20);
            assertEquals(truck.getSpeed(), 12);
        } catch (InvalidAccelerationException e) {
            fail("An exception should not have been thrown.");
        }
        // case 2: throw exception when the accelerate factor is wrong
        try {
            truck.accelerate(80);
            assertEquals(truck.getSpeed(), 18);
            fail("An exception should have been thrown.");
        } catch (InvalidAccelerationException e) {
        }

        // case 3: throw exception when the maximum speed is violate
        try {
            truck.setInitialSpeed(50);
            truck.accelerate(50);
            assertEquals(truck.getSpeed(), 75);
            fail("An exception should have been thrown.");
        } catch (InvalidAccelerationException e) {
        }
    }

    @Test
    public void decelerate() {
        truck.setInitialSpeed(50);
        // case 1: happy path
        try {
            truck.decelerate(20);
            assertEquals(truck.getSpeed(), 40);
        } catch (InvalidDecelerationException e) {
            fail("An exception should not have been thrown.");
        }
        // case 2: throw exception when the accelerate factor is wrong
        try {
            truck.decelerate(-10);
            assertEquals(truck.getSpeed(), 55);
            fail("An exception should have been thrown.");
        } catch (InvalidDecelerationException e) {
        }
    }

    @Test
    public void setInitialSpeed() {
        // case 1: happy path
        try {
            truck.setInitialSpeed(50);
            assertEquals(truck.getSpeed(), 50);
        } catch (IllegalArgumentException e) {
            fail("An exception should not have been thrown.");
        }
        // case 2 : invalid initial speed
        try {
            truck.setInitialSpeed(100);
            assertEquals(truck.getSpeed(), 50);
            fail("An exception should have been thrown.");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void getSpeed() {
        // case 1: happy path
        try {
            truck.setInitialSpeed(50);
            assertEquals(truck.getSpeed(), 50);
        } catch (IllegalArgumentException e) {
            fail("An exception should not have been thrown.");
        }
        // case 2 : invalid initial speed
        try {
            truck.setInitialSpeed(100);
            assertEquals(truck.getSpeed(), 50);
            fail("An exception should have been thrown.");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void getDefaultMaximumSpeed() {
        assertEquals(truck.getDefaultMaximumSpeed(), 60);
    }
}