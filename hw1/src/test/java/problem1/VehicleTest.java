package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {
    private static final String FIRST_NAME = "James";
    private static final String LAST_NAME = "Bond";
    private static final String PHONE_NUMBER = "7654321098";

    private Vehicle vehicle;
    private Owner owner;
    @Before
    public void setUp() throws Exception {
        owner = new Owner(FIRST_NAME , LAST_NAME, PHONE_NUMBER);
        vehicle = new Vehicle(12345, "AB2233", owner);
    }

    @Test
    public void getVIN() {
        assertEquals((Integer) 12345, vehicle.getVIN());
    }

    @Test
    public void getLicensePlate() {
        assertEquals("AB2233", vehicle.getLicensePlate());
    }

    @Test
    public void getVehicleOwner() {
        assertEquals(FIRST_NAME , vehicle.getVehicleOwner().getFirstName());
        assertEquals(LAST_NAME , vehicle.getVehicleOwner().getLastName());
        assertEquals(PHONE_NUMBER , vehicle.getVehicleOwner().getPhoneNumber());
    }

    @Test
    public void setVIN() {
        Integer setValue = 222;
        vehicle.setVIN(setValue);
        Integer getValue = vehicle.getVIN();

        assertEquals(setValue, getValue);
    }

    @Test
    public void setLicensePlate() {
        String setString = "5004Rocks";
        vehicle.setLicensePlate(setString);
        String getString = vehicle.getLicensePlate();

        assertEquals(setString, getString);
    }

    @Test
    public void setVehicleOwner() {
        // before setting
        assertEquals(FIRST_NAME, vehicle.getVehicleOwner().getFirstName());
        assertEquals(LAST_NAME, vehicle.getVehicleOwner().getLastName());
        assertEquals(PHONE_NUMBER, vehicle.getVehicleOwner().getPhoneNumber());

        // after setting
        String newFirstName = "Justin";
        String newLastName = "Bieber";
        String newPhoneNumber = "1234567890";
        Owner newOwner = new Owner(newFirstName, newLastName,newPhoneNumber );
        vehicle.setVehicleOwner(newOwner);
        assertEquals(newFirstName, vehicle.getVehicleOwner().getFirstName());
        assertEquals(newLastName, vehicle.getVehicleOwner().getLastName());
        assertEquals(newPhoneNumber, vehicle.getVehicleOwner().getPhoneNumber());
    }


}