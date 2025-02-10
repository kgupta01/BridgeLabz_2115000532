abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    public abstract double calculateFare(double distance);
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
    }
    public String getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    public String getDriverName() {
        return driverName;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public double getRatePerKm() {
        return ratePerKm;
    }
    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }
}
class Car extends Vehicle {
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}
class Bike extends Vehicle {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}
class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}
interface GPS {
    void getCurrentLocation();
    void updateLocation(String newLocation);
}
class VehicleGPS implements GPS {
    private String currentLocation;
    public void getCurrentLocation() {
        System.out.println("Current Location: " + currentLocation);
    }
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
        System.out.println("Location updated to: " + currentLocation);
    }
}
public class RideHailingApplication {
    public static void main(String[] args) {
        Vehicle car = new Car("V1", "Khushi", 15);
        Vehicle bike = new Bike("V2", "Piyush", 8);
        Vehicle auto = new Auto("V3", "Pihu", 12);
        Vehicle[] vehicles = { car, bike, auto };
        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            double fare = vehicle.calculateFare(10); 
            System.out.println("Fare for 10 km: " + fare);
            System.out.println();
        }
        VehicleGPS gps = new VehicleGPS();
        gps.updateLocation("Downtown");
        gps.getCurrentLocation();
    }
}
