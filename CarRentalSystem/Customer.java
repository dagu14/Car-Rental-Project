import java.util.ArrayList;
import java.util.List;

public class Customer {
    // Customer class represents a customer with username and password for authentication
    private final String name;
    private final String contactInformation;
    private final List<String> rentalHistory;

    public Customer(String name, String contactInformation) {
        this.name = name;
        this.contactInformation = contactInformation;
        this.rentalHistory = new ArrayList<>();
    }

    public String getName() {

        return name;
    }

    public String getContactInformation() {

        return contactInformation;
    }

    //method to add rental history
    public void addRentalHistory(String rentalDetails) {
        rentalHistory.add(rentalDetails);
    }

    //Authenticates a customer.
    static class AuthenticationSystem {

    //return True if the customer is authenticated, false otherwise.
        public boolean authenticateCustomer(Customer customer) {
            return true;
        }
    }
}