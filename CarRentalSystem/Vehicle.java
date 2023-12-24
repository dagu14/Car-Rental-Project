public class Vehicle {

    protected String make;
    protected String model;
    protected String color;
    protected int year;
    protected double rentalRate;


    public Vehicle(String make, String model,String color, int year, double rentalRate) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.rentalRate = rentalRate;
    }

    public void displayInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model " + model);
        System.out.println("color " + color);
        System.out.println("Year: " + year);
        System.out.println("Rental Rate: " + rentalRate);
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
    public void setRentalRate(double newRentalRate) {
        rentalRate = newRentalRate;
    }

    private String rentedBy;


    public String getRentedBy() {
        return rentedBy;
    }

    public void setRentedBy(String rentedBy) {
        this.rentedBy = rentedBy;
    }
}