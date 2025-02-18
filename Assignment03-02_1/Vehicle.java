public class Vehicle {
    static double registrationFee = 100.0;
    final String registrationNumber;
    String ownerName;
    String vehicleType;
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    public void displayVehicleDetails() {
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("ABC123", "Alice", "Car");
        Vehicle vehicle2 = new Vehicle("XYZ456", "Bob", "Truck");
        System.out.println(vehicle1 instanceof Vehicle);
	System.out.println(vehicle2 instanceof Vehicle);
	vehicle1.displayVehicleDetails();
	vehicle2.displayVehicleDetails();
	Vehicle.updateRegistrationFee(120.0);
	vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}
