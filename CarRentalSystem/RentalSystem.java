//importing libraries
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalSystem {
    private final List<Vehicle> availableVehicles;
    private final List<Vehicle> rentedVehicles;
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";
    private final Customer.AuthenticationSystem authenticationSystem;
    public RentalSystem() {
        availableVehicles = new ArrayList<>();
        rentedVehicles = new ArrayList<>();
        authenticationSystem = new Customer.AuthenticationSystem();
    }

    public void addVehicle(Vehicle vehicle) { // Add a new vehicle to the list of available vehicles
        availableVehicles.add(vehicle);
    }



    public void rentVehicle(Vehicle vehicle, Customer customer, int rentalDuration) { //Rent a vehicle for a specified duration
        try {
            if (availableVehicles.contains(vehicle)) {
                availableVehicles.remove(vehicle); // Remove the vehicle from the available list
                rentedVehicles.add(vehicle); // Add the vehicle to the rented list
                vehicle.setRentedBy(customer.getName()); // Store the customer name in the Vehicle object
                String rentalDetails = "Vehicle: " + vehicle.getMake() + " " + vehicle.getModel() +
                        ", Rental Duration: " + rentalDuration + " days";
                customer.addRentalHistory(rentalDetails);
            } else {
                throw new Exception("Vehicle is not available for rent.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void returnVehicle(Vehicle vehicle, Customer customer) {
        if (rentedVehicles.contains(vehicle)) {
            rentedVehicles.remove(vehicle);
            availableVehicles.add(vehicle);


            if (!customer.getName().equals(vehicle.getRentedBy())) {
                System.out.println("Access denied. Customer name does not match the name during rental.");
                rentedVehicles.add(vehicle);
                availableVehicles.remove(vehicle);
            }else{
                System.out.println("Car returned successfully");
            }
        }
    }

    public void displayRentalInfo() {
        System.out.println("Available vehicles: ");
        for (Vehicle av : availableVehicles) {
            av.displayInfo();
            System.out.println();
        }

        System.out.println("Rented vehicles: ");
        for (Vehicle rv : rentedVehicles) {
            rv.displayInfo();
            System.out.println();
        }
    }

    public double calculateRentalCost(Vehicle vehicle, int rentalDuration) {
        double rentalRate = vehicle.getRentalRate();
        return rentalRate * rentalDuration;
    }
    public void generateInvoice(Vehicle vehicle, int rentalDuration, double rentalCost, Customer customer) {
        System.out.println("===== Invoice =====");
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Contact Information: " + customer.getContactInformation());
        System.out.println("Vehicle: " + vehicle.getMake() + " " + vehicle.getModel());
        System.out.println("Rental Duration: " + rentalDuration + " days");
        System.out.println("Rental Cost: " + rentalCost);
        System.out.println("===================");
    }

    // Admin can manage car details such as adding, editing, and deleting a car
    public void manageCarDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (username.equals(USERNAME) && password.equals(PASSWORD)) { // Check if the admin credentials are valid
            System.out.println("===== Car Management =====");
            System.out.println("1. Add Car");
            System.out.println("2. Edit Car");
            System.out.println("3. Delete Car");
            System.out.println("4. Back to Main Menu");
            System.out.println();
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    System.out.println("=== Add new Vehicle === ");
                    System.out.print("Enter the vehicle make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter the vehicle model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter the vehicle color: ");
                    String color = scanner.nextLine();
                    System.out.print("Enter the vehicle year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter the vehicle rental rate: ");
                    double rentalRate = scanner.nextDouble();

                    Vehicle newVehicle = new Vehicle(make, model, color, year, rentalRate);
                    addVehicle(newVehicle);
                    System.out.println("Car added successfully!");
                    break;
                }
                case 2: {
                    System.out.println("==== Update Vehicle Rental rate ====");
                    System.out.print("Enter the vehicle make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter the vehicle model: ");
                    String model = scanner.nextLine();

                    Vehicle selectedVehicle = null;
                    for (Vehicle v : availableVehicles) {
                        if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                            selectedVehicle = v;
                            break;
                        }
                    }

                    if (selectedVehicle != null) {
                        System.out.print("Enter the new rental rate: ");
                        double newRentalRate = scanner.nextDouble();

                        selectedVehicle.setRentalRate(newRentalRate);
                        System.out.println("Car details updated successfully!");
                    } else {
                        System.out.println("Car not found!");
                    }
                    break;
                }
                case 3: {
                    System.out.println("==== Delete Vehicle ====");
                    System.out.print("Enter the vehicle make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter the vehicle model: ");
                    String model = scanner.nextLine();

                    Vehicle selectedVehicle = null;
                    for (Vehicle v : availableVehicles) {
                        if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                            selectedVehicle = v;
                            break;
                        }
                    }

                    if (selectedVehicle != null) {
                        availableVehicles.remove(selectedVehicle);
                        System.out.println("Car deleted successfully!");
                    } else {
                        System.out.println("Car not found!");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Returning to the main menu...");
                    break;
                }
                default: {
                    System.out.println("Invalid choice!");
                    break;
                }
            }
        } else {
            System.out.println("Invalid username or password. Access denied.");
        }  }

    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("***** 🚗WELLCOME TO AHADU CAR RENTING PLC 😊😊🚗*****");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Display Rental Information");
            System.out.println("4. Manage Car Details");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println("==== Rent a vehicle ====");
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your contact information: ");
                    String contactInfo = scanner.nextLine();
                    Customer customer = new Customer(name, contactInfo);
                    boolean isAuthenticated = authenticationSystem.authenticateCustomer(customer);

                    if (isAuthenticated) {
                        System.out.println("Authentication successful!😁");
                        System.out.println("Available vehicles: ");
                        for (int i = 0; i < availableVehicles.size(); i++) {
                            System.out.println((i + 1) + ". " + availableVehicles.get(i).getMake() + " " +
                                    availableVehicles.get(i).getModel());
                        }
                        System.out.print("Enter the vehicle number: ");
                        int vehicleNumber = scanner.nextInt();
                        scanner.nextLine();

                        if (vehicleNumber >= 1 && vehicleNumber <= availableVehicles.size()) {
                            Vehicle selectedVehicle = availableVehicles.get(vehicleNumber - 1);
                            System.out.print("Enter the rental duration (in days): ");
                            int rentalDuration = scanner.nextInt();
                            scanner.nextLine();

                            double rentalCost = calculateRentalCost(selectedVehicle, rentalDuration);
                            generateInvoice(selectedVehicle, rentalDuration, rentalCost, customer);
                            rentVehicle(selectedVehicle, customer, rentalDuration);
                            System.out.println("Vehicle rented successfully!😁");
                        } else {
                            System.out.println("Invalid vehicle number!😢");
                        }
                    } else {
                        System.out.println("Authentication failed!");
                    }
                    break;
                }
                case 2: {
                    System.out.println("=== Return a vehicle ===");
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your contact information: ");
                    String contactInfo = scanner.nextLine();


                    Customer customer = new Customer(name, contactInfo);
                    boolean isAuthenticated = authenticationSystem.authenticateCustomer(customer);

                    if (isAuthenticated) {
                        System.out.println("Authentication successful!😁");
                        System.out.println("Rented vehicles: ");
                        for (int i = 0; i < rentedVehicles.size(); i++) {
                            System.out.println((i + 1) + ". " + rentedVehicles.get(i).getMake() + " " +
                                    rentedVehicles.get(i).getModel());
                        }
                        System.out.print("Enter the vehicle number: ");
                        int vehicleNumber = scanner.nextInt();
                        scanner.nextLine();

                        if (vehicleNumber >= 1 && vehicleNumber <= rentedVehicles.size()) {
                            Vehicle selectedVehicle = rentedVehicles.get(vehicleNumber - 1);
                            returnVehicle(selectedVehicle,customer);

                        } else {
                            System.out.println("Invalid vehicle number!😶");
                        }
                    } else {
                        System.out.println("Authentication failed!");
                    }
                    break;
                }
                case 3: {
                    displayRentalInfo();
                    break;
                }
                case 4: {
                    manageCarDetails();
                    break;
                }
                case 5: {
                    System.out.println("Exiting...🙌");
                    return;
                }
                default: {
                    System.out.println("Invalid choice!😫😫");
                    break;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem();
        rentalSystem.addVehicle(new Vehicle("Toyota", "Camry", "Black", 2021, 50.0));
        rentalSystem.addVehicle (new Vehicle("Nissan", "Altima","silver",2018,300));
        rentalSystem.addVehicle( new Vehicle("Ford", "F150", "Red", 2001, 200));
        rentalSystem.addVehicle( new Vehicle("Jeep", "Cherokee","Black",2023,500));
        rentalSystem.addVehicle( new Vehicle("Mercedes-Benz","CLA","Grey",2023,650));
        rentalSystem.addVehicle( new Vehicle("Honda", "Civic","Brown",2020,200));
        rentalSystem.addVehicle( new Vehicle("Audi", "A3","white",2019,150));
        rentalSystem.addVehicle( new Vehicle("Hyundai", "Elantra","Orange",2022,250));
        rentalSystem.addVehicle( new Vehicle("Toyota","Corolla","Blue",2015,200));
        rentalSystem.addVehicle( new Vehicle("Ford", "Fiesta", "Silver",2019,150));
        rentalSystem.mainMenu();
    }
}