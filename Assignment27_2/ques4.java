public class ques4 {
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }
    public static void main(String[] args) {
        double km = 10;
        double miles = convertKmToMiles(km);
        System.out.println(km + " kilometers is equal to " + miles + " miles.");
        double milesValue = 5;
        double kmValue = convertMilesToKm(milesValue);
        System.out.println(milesValue + " miles is equal to " + kmValue + " kilometers.");
        double meters = 100;
        double feet = convertMetersToFeet(meters);
        System.out.println(meters + " meters is equal to " + feet + " feet.");
        double feetValue = 50;
        double metersValue = convertFeetToMeters(feetValue);
        System.out.println(feetValue + " feet is equal to " + metersValue + " meters.");
    }
}
