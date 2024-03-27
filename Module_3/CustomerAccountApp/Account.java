/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/
package Module_3.CustomerAccountApp;

public class Account {
    private double balance;

    // Default constructor
    public Account() {
        this.balance = 200.00;
    }

    // Accessor method
    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amt) {
        balance += amt;
    }

    // Method to withdraw money
    public void withdraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
        }
    }

    // Display account menu
    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    // Get transaction date
    public String getTransactionDate() {
        // Simulating date as a placeholder
        return "03-26-2024";
    }
}
