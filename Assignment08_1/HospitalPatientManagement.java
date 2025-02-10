abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
    public abstract double calculateBill();
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
class InPatient extends Patient {
    public InPatient(String patientId, String name, int age) {
        super(patientId, name, age);
    }
    public double calculateBill() {
        return 2000 + 500 * 5; 
    }
}
class OutPatient extends Patient {
    public OutPatient(String patientId, String name, int age) {
        super(patientId, name, age);
    }
    public double calculateBill() {
        return 500 + 200 * 2; 
    }
}
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}
class PatientRecord implements MedicalRecord {
    private String records = "";
    public void addRecord(String record) {
        records += record + "\n";
    }
    public void viewRecords() {
        System.out.println("Medical Records: \n" + records);
    }
}
public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient patient1 = new InPatient("P1", "Piyush", 22);
        Patient patient2 = new OutPatient("P2", "Khushi", 21);
        MedicalRecord record1 = new PatientRecord();
        record1.addRecord("Diagnosed with flu");
        record1.addRecord("Admitted for 5 days");
        MedicalRecord record2 = new PatientRecord();
        record2.addRecord("Consulted for headache");
        record2.addRecord("Tests recommended");
        Patient[] patients = { patient1, patient2 };
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill: " + patient.calculateBill());
            if (patient instanceof InPatient) {
                record1.viewRecords();
            } else if (patient instanceof OutPatient) {
                record2.viewRecords();
            }
            System.out.println();
        }
    }
}
