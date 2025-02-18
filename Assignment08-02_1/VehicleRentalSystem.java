abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    public abstract double calculateRentalCost(int days);
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getRentalRate() {
        return rentalRate;
    }
    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }
}
class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    public double calculateInsurance() {
        return getRentalRate() * 0.10;
    }
    public void getInsuranceDetails() {
        System.out.println("Car insurance cost is: " + calculateInsurance());
    }
}
class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    public double calculateInsurance() {
        return getRentalRate() * 0.05;
    }
    public void getInsuranceDetails() {
        System.out.println("Bike insurance cost is: " + calculateInsurance());
    }
}
class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    public double calculateInsurance() {
        return getRentalRate() * 0.15;
    }
    public void getInsuranceDetails() {
        System.out.println("Truck insurance cost is: " + calculateInsurance());
    }
}
interface Insurable {
    double calculateInsurance();
    void getInsuranceDetails();
}
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Car("V123", 50);
        Vehicle v2 = new Bike("V124", 20);
        Vehicle v3 = new Truck("V125", 100);
        Vehicle[] vehicles = { v1, v2, v3 };
        for (Vehicle vehicle : vehicles) {
            double rentalCost = vehicle.calculateRentalCost(5);
            System.out.println("Rental cost for " + vehicle.getType() + " " + vehicle.getVehicleNumber() + " is: " + rentalCost);
            if (vehicle instanceof Insurable) {
                Insurable insurableVehicle = (Insurable) vehicle;
                insurableVehicle.getInsuranceDetails();
            }
        }
    }
}
