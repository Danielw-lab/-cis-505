/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/
package Module_3.CustomerAccountApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestCustomerAccountApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();

        System.out.print("Enter a customer number between 1007 and 1009: ");
        int customerId = scanner.nextInt();
        Customer customer = CustomerDB.getCustomer(customerId);

        account.displayMenu();
        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmt = scanner.nextDouble();
                    account.deposit(depositAmt);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmt = scanner.nextDouble();
                    account.withdraw(withdrawAmt);
                    break;
                case 3:
                    System.out.printf("Current Balance: $%,6.2f%n", account.getBalance());
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Error: Invalid Option.");
            }
        } while (choice != 4);
        // Get today's date
        LocalDate today = LocalDate.now();

        // Format the date as desired
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String formattedDate = today.format(formatter);

        System.out.println("\n----Customer Details----");
        System.out.println(customer);
       // System.out.println("Today's date is: " + formattedDate);
       // System.out.printf("Account Balance : $%,6.2f%n", account.getBalance());
       // System.out.printf("Today's date is: %s%n", formattedDate);
       // System.out.printf("Account Balance: $%,6.2f%n", account.getBalance());
        System.out.printf("Balance as of %s, is: $%,6.2f%n", formattedDate, account.getBalance());

        scanner.close();
    }
}
