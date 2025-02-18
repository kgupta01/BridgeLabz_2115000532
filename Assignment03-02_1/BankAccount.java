public class BankAccount {
    static String bankName = "ABC Bank";
    static int totalAccounts = 0;    
    final String accountNumber;
    String accountHolderName;
    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }
    public static void getTotalAccounts() {
        System.out.println("Total accounts: " + totalAccounts);
    }
    public void displayAccountDetails() {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
    }
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("John Doe", "12345");
        BankAccount account2 = new BankAccount("Jane Smith", "67890");
	System.out.println(account1 instanceof BankAccount);
        System.out.println(account2 instanceof BankAccount);   
        account1.displayAccountDetails();
        account2.displayAccountDetails();
        BankAccount.getTotalAccounts();
    }
}
