abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }
    public abstract double calculateInterest();
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getHolderName() {
        return holderName;
    }
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    public double calculateInterest() {
        return getBalance() * 0.04;
    }
}
class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    public double calculateInterest() {
        return getBalance() * 0.02;
    }
}
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}
class LoanAccount implements Loanable {
    private double loanAmount;
    private boolean eligibleForLoan;
    public void applyForLoan(double amount) {
        loanAmount = amount;
        eligibleForLoan = calculateLoanEligibility();
    }
    public boolean calculateLoanEligibility() {
        return loanAmount <= 50000;
    }
    public double getLoanAmount() {
        return loanAmount;
    }
    public boolean isEligibleForLoan() {
        return eligibleForLoan;
    }
}
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("A123", "Khushi", 1000);
        BankAccount acc2 = new CurrentAccount("A124", "Piyush", 2000);
        System.out.println("Interest for Savings Account: " + acc1.calculateInterest());
        System.out.println("Interest for Current Account: " + acc2.calculateInterest());
        LoanAccount loanAccount = new LoanAccount();
        loanAccount.applyForLoan(40000);
        System.out.println("Loan eligibility: " + loanAccount.isEligibleForLoan());
    }
}
