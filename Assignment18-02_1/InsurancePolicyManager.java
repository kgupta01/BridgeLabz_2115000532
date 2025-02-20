import java.util.*;
import java.time.*;
class Policy implements Comparable<Policy> {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;
    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Policy)) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }
    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}
public class InsurancePolicyManager {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();   
    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }
    public void displayAllPolicies() {
        System.out.println("All Unique Policies:");
        hashSet.forEach(System.out::println);
    }
    public void displayExpiringSoon() {
        System.out.println("Policies Expiring in Next 30 Days:");
        LocalDate today = LocalDate.now();
        treeSet.stream()
                .filter(p -> !p.expiryDate.isBefore(today) && p.expiryDate.isBefore(today.plusDays(30)))
                .forEach(System.out::println);
    }
    public void displayByCoverageType(String coverageType) {
        System.out.println("Policies with Coverage Type: " + coverageType);
        hashSet.stream()
                .filter(p -> p.coverageType.equalsIgnoreCase(coverageType))
                .forEach(System.out::println);
    }
    public void findDuplicatePolicies() {
        System.out.println("Duplicate Policies:");
        Set<String> seen = new HashSet<>();
        hashSet.stream()
                .filter(p -> !seen.add(p.policyNumber))
                .forEach(System.out::println);
    }
    public void comparePerformance() {
        System.out.println("Performance Comparison:");
        int size = 10000;
        List<Policy> samplePolicies = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            samplePolicies.add(new Policy("P" + i, "Holder" + i, LocalDate.now().plusDays(i % 365), "Auto", 500 + i));
        }   
        measureTime("HashSet Add", () -> {
            Set<Policy> set = new HashSet<>();
            set.addAll(samplePolicies);
        });
        measureTime("LinkedHashSet Add", () -> {
            Set<Policy> set = new LinkedHashSet<>();
            set.addAll(samplePolicies);
        });
        measureTime("TreeSet Add", () -> {
            Set<Policy> set = new TreeSet<>();
            set.addAll(samplePolicies);
        });
    }
    private void measureTime(String task, Runnable action) {
        long start = System.nanoTime();
        action.run();
        long end = System.nanoTime();
        System.out.println(task + " Time: " + (end - start) / 1e6 + " ms");
    }
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();
        manager.addPolicy(new Policy("P101", "Khushi", LocalDate.now().plusDays(10), "Health", 1000));
        manager.addPolicy(new Policy("P102", "Aditya", LocalDate.now().plusDays(40), "Auto", 1200));
        manager.addPolicy(new Policy("P103", "Piyush", LocalDate.now().plusDays(20), "Home", 1500));
        manager.addPolicy(new Policy("P101", "Krishna", LocalDate.now().plusDays(10), "Health", 1000));   
        manager.displayAllPolicies();
        manager.displayExpiringSoon();
        manager.displayByCoverageType("Health");
        manager.findDuplicatePolicies();
        manager.comparePerformance();
    }
}
