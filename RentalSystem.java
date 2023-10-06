
class Vehicle {
    private String make;
    private String model;
    private int year;
    private double baseRentalPrice;

    public Vehicle(String make, String model, int year, double baseRentalPrice) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.baseRentalPrice = baseRentalPrice;
    }

    public double calculateRentalCost(int days) {
        return baseRentalPrice * days;
    }

    // Getters for attributes (make, model, year) if needed
}

class Economy extends Vehicle {
    public Economy(String make, String model, int year) {
        super(make, model, year, 40.0); // Set base rental price for Economy vehicles
    }
}

class Luxury extends Vehicle {
    public Luxury(String make, String model, int year) {
        super(make, model, year, 100.0); // Set base rental price for Luxury vehicles
    }
}

class SUV extends Vehicle {
    public SUV(String make, String model, int year) {
        super(make, model, year, 70.0); // Set base rental price for SUV vehicles
    }
}

public class RentalSystem {
    public static void main(String[] args) {
        // Create instances of each type of vehicle
        Economy economyCar = new Economy("Toyota", "Camry", 2022);
        Luxury luxuryCar = new Luxury("Mercedes-Benz", "S-Class", 2022);
        SUV suvCar = new SUV("Ford", "Explorer", 2022);

        // Specify the number of rental days
        int rentalDays = 5;

        // Calculate and display the rental cost for each vehicle
        System.out.println("Economy Car Rental Cost for " + rentalDays + " days: $" + economyCar.calculateRentalCost(rentalDays));
        System.out.println("Luxury Car Rental Cost for " + rentalDays + " days: $" + luxuryCar.calculateRentalCost(rentalDays));
        System.out.println("SUV Car Rental Cost for " + rentalDays + " days: $" + suvCar.calculateRentalCost(rentalDays));
    }
}