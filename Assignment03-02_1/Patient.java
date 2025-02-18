public class Patient {
	static String hospitalName = "Singhal Nursing Home";
	final int patientID;
	String name;
	int age;
	String ailment;
	static int totalPatients = 0;
	public Patient(int patientID, String name, int age, String ailment) {
		this.patientID = patientID;
		this.name = name;
		this.age = age;
		this.ailment = ailment;
		totalPatients++;
	}
	public static void getTotalPatients() {
		System.out.println("Total No. of Patients: " + totalPatients);
	}
	public void displayPatientsDetails() {
		System.out.println("Patient's ID: " + patientID);
		System.out.println("Patient's Name:" + name);
		System.out.println("Patient's Age:" + age);
		System.out.println("Patient's Ailment" + ailment);
	}
	public static void main(String[] args) {
		Patient p1 = new Patient(1, "Khushi", 21, "Diabetes");
		Patient p2 = new Patient(2, "Piyush", 22, "AIDs");
		System.out.println(p1 instanceof Patient);
		System.out.println(p2 instanceof Patient);
		p1.displayPatientsDetails();
		p2.displayPatientsDetails();
		Patient.getTotalPatients();
	}
}
