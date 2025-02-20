import java.util.*;
class Patient implements Comparable<Patient> {
    String name;
    int severity;
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }
}
public class HospitalTriage {
    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>();
        queue.add(new Patient("Piyush", 3));
        queue.add(new Patient("Khushi", 5));
        queue.add(new Patient("Aditya", 2));
        while (!queue.isEmpty()) {
            System.out.println(queue.poll().name);
        }
    }
}
