import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {
    @Test
    public void testdisplayInfo(){
        Vehicle vehicle = new Vehicle("Toyota", "Camry", "Blue", 2020, 50.0);
        assertEquals("Toyota", vehicle.getMake());
        assertEquals("Camry", vehicle.getModel());
        //assertEquals(2020, vehicle.getYear());
        assertEquals(50.0, vehicle.getRentalRate(), 0.001);

        vehicle.displayInfo();
    }
    @Test
    public void testSetRentalRate() {
        Vehicle vehicle = new Vehicle("Ford", "Fusion", "Silver", 2020, 60.0);

        assertEquals(60.0, vehicle.getRentalRate(), 0.01);

        vehicle.setRentalRate(70.0);

        assertEquals(70.0, vehicle.getRentalRate(), 0.01);
    }
    @Test
    public void testRentVehicle() {
        Vehicle vehicle = new Vehicle("Chevrolet", "Malibu", "Black", 2019, 45.0);

        assertNull(vehicle.getRentedBy());

        vehicle.setRentedBy("John Doe");

        assertEquals("John Doe", vehicle.getRentedBy());
    }
    @Test
    public void testGetRentalDuration() {
        Vehicle vehicle = new Vehicle("Tesla", "Model S", "White", 2023, 100.0);

        // Assuming a rental duration method is implemented, initially set to 0
        assertEquals(0, vehicle.getRentalDuration());
    }
}
