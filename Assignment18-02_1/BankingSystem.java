import java.util.*;
public class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>();
    private Map<String, Double> sortedAccounts = new TreeMap<>(Comparator.comparingDouble(accounts::get));
    private Queue<String> withdrawalQueue = new LinkedList<>();
    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(accountNumber, balance);
    }
    public void withdraw(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber) && accounts.get(accountNumber) >= amount) {
            withdrawalQueue.add(accountNumber);
        }
    }
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            double amount = 10; 
            accounts.put(accountNumber, accounts.get(accountNumber) - amount);
            sortedAccounts.put(accountNumber, accounts.get(accountNumber));
        }
    }
    public Map<String, Double> getSortedAccounts() {
        return new TreeMap<>(sortedAccounts);
    }
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount("1001", 500.0);
        bank.addAccount("1002", 1000.0);
        bank.addAccount("1003", 750.0);   
        bank.withdraw("1001", 100.0);
        bank.withdraw("1003", 200.0);
        bank.processWithdrawals();
        System.out.println("Sorted accounts: " + bank.getSortedAccounts());
    }
}
