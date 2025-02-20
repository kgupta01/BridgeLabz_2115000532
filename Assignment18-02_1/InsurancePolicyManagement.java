import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
class Policy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    Policy(String policyNumber, String policyholderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
    }
    @Override
    public String toString() {
        return policyNumber + " - " + policyholderName + " - " + expiryDate;
    }
}
public class InsurancePolicyManagement {
    private Map<String, Policy> policyMap = new HashMap<>();
    private Map<String, Policy> orderedPolicyMap = new LinkedHashMap<>();
    private Map<LocalDate, Policy> sortedPolicyMap = new TreeMap<>();
    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicyMap.put(policy.policyNumber, policy);
        sortedPolicyMap.put(policy.expiryDate, policy);
    }
    public Policy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }
    public List<Policy> getExpiringPolicies(int days) {
        LocalDate now = LocalDate.now();
        return sortedPolicyMap.entrySet().stream()
                .filter(entry -> entry.getKey().isBefore(now.plusDays(days)))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
    public List<Policy> getPoliciesByHolder(String name) {
        return policyMap.values().stream()
                .filter(policy -> policy.policyholderName.equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
    public void removeExpiredPolicies() {
        LocalDate now = LocalDate.now();
        sortedPolicyMap.entrySet().removeIf(entry -> entry.getKey().isBefore(now));
    }
    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();
        system.addPolicy(new Policy("P1", "Khushi", LocalDate.now().plusDays(10)));
        system.addPolicy(new Policy("P2", "Piyush", LocalDate.now().plusDays(5)));
        system.addPolicy(new Policy("P3", "Khushi", LocalDate.now().plusDays(40)));   
        System.out.println("Expiring Policies: " + system.getExpiringPolicies(30));
        System.out.println("Khushi's Policies: " + system.getPoliciesByHolder("Khushi"));
        system.removeExpiredPolicies();
    }
}
