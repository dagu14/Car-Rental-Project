import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CustomerTest {

    @Test
    public void testGetName() {
        Customer customer = new Customer("John Doe", "john@example.com");
        String name = customer.getName();
        Assertions.assertEquals("John Doe", name);
    }

    @Test
    public void testGetContactInformation() {
        Customer customer = new Customer("John Doe", "john@example.com");
        String contactInformation = customer.getContactInformation();
        Assertions.assertEquals("john@example.com", contactInformation);
    }

    @Test
    public void testGetRentalHistory() {
        Customer customer = new Customer("John Doe", "john@example.com");
        List<String> rentalHistory = customer.getRentalHistory();
        Assertions.assertNotNull(rentalHistory);
        Assertions.assertEquals(0, rentalHistory.size());
    }

    @Test
    public void testAddRentalHistory() {
        Customer customer = new Customer("John Doe", "john@example.com");
        customer.addRentalHistory("Rental details 1");
        customer.addRentalHistory("Rental details 2");
        List<String> rentalHistory = customer.getRentalHistory();
        Assertions.assertEquals(2, rentalHistory.size());
        Assertions.assertEquals("Rental details 1", rentalHistory.get(0));
        Assertions.assertEquals("Rental details 2", rentalHistory.get(1));
    }

    @Test
    public void testAuthenticateCustomer() {
        Customer.AuthenticationSystem authSystem = new Customer.AuthenticationSystem();

        Customer customer = new Customer("John Doe", "john@example.com");
        boolean isAuthenticated = authSystem.authenticateCustomer(customer);

        Assertions.assertTrue(isAuthenticated);
    }
}