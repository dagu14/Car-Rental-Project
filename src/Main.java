
import java.util.ArrayList;
import java.util.List;

class Customer {
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

    public List<String> getRentalHistory() {
        return rentalHistory;
    }

    public void addRentalHistory(String rentalDetails) {
        rentalHistory.add(rentalDetails);
    }
    static class AuthenticationSystem {

        public boolean authenticateCustomer(Customer customer) {
            return true;
        }
    }
}
