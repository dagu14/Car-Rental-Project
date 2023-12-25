import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RentalSystemTest {
    private RentalSystem rentalSystem;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        rentalSystem = new RentalSystem();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testAddVehicle() {
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", "Blue", 2015, 200.0);
        rentalSystem.addVehicle(vehicle);
        assertTrue(rentalSystem.availableVehicles.contains(vehicle));
    }

    @Test
    public void testRentVehicle() {
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", "Blue", 2015, 200.0);
        Customer customer = new Customer("John Doe", "1234567890");

        rentalSystem.addVehicle(vehicle);
        rentalSystem.rentVehicle(vehicle, customer, 7);

        assertTrue(rentalSystem.rentedVehicles.contains(vehicle));
        assertEquals(customer.getName(), vehicle.getRentedBy());
        assertEquals("Vehicle: Toyota Corolla, Rental Duration: 7 days", customer.getRentalHistory().get(0));
    }

}
