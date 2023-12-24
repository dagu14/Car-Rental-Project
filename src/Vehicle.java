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
    public String getColor() {
        return color;
    }

}

class Motorbike extends Vehicle{

    String bodyType;
    private Motorbike(String make, String model,String color, int year, double rentalRate, String bodyType) {
        super(make, model, color, year, rentalRate);

    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("body type: " + bodyType);

    }

}
 class Car extends Vehicle{

     String bodyType;
    private Car(String make, String model,String color, int year, double rentalRate, String bodyType) {
        super(make, model, color, year, rentalRate);

    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("body type: " + bodyType);
    }

}
class Truck extends Vehicle{
    String bodyType;

    private Truck(String make, String model, String color, int year, double rentalRate, String bodyType ) {
        super(make, model, color, year, rentalRate);
        this.bodyType = "4 door";

    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("body type: " + bodyType);


    }

}
