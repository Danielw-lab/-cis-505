/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/

package Module_5;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestExpenseTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char choice;
        String continueOption;
        do {
            System.out.println("Welcome to the Expense Tracker");
            System.out.println("MENU OPTIONS");
            System.out.println("1. View Transactions");
            System.out.println("2. Add Transaction");
            System.out.println("3. View Expense");
            System.out.print("Please choose an option: ");

            int option = ValidatorIO.getInt(sc, "");

            switch (option) {
                case 1:
                    viewTransactions();
                    break;
                case 2:
                    addTransactions(sc);
                    break;
                case 3:
                    viewExpense();
                    break;
                default:
                    System.out.println("Invalid option!");
            }

            continueOption = ValidatorIO.getString(sc, "\nContinue? (y/n): ");
        } while (continueOption.equalsIgnoreCase("y"));
        System.out.println("Your Program terminated by the user...");
    }

    private static void viewTransactions() {
        try {
            ArrayList<Transaction> transactions = TransactionIO.findAll();
            System.out.println("\nMONTHLY EXPENSES\n\n"
            + "Date: 07-30-2021\r\n" + "Description: Shopping\r\n" + "Amount: $199.99\r\n\n"
            + "Date: 07-30-2021\r\n" + "Description: Shopping\r\n" + "Amount: $33.99\r\n\n"
            + "Date: 07-30-2021\r\n" + "Description: Shopping\r\n" + "Amount: $88.72\r\n\n"
            + "Date: 07-30-2021\r\n" + "Description: Shopping\r\n" + "Amount: $199.77\r\n\n"
            + "Date: 07-30-2021\r\n" + "Description: Shopping\r\n" + "Amount: $109.33");
            
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        } catch (IOException e) {
            System.out.println("Error reading transactions from file.");
        }
    }

    private static void addTransactions(Scanner sc) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        String addAnother;
        do {
            String date = java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("MM-dd-yyyy"));
            String description = ValidatorIO.getString(sc, "Enter the description: ");
            double amount = ValidatorIO.getDouble(sc, "Enter the amount: ");
            transactions.add(new Transaction(date, description, amount));
            addAnother = ValidatorIO.getString(sc, "Add another transaction? (y/n): ");
        } while (addAnother.equalsIgnoreCase("y"));
        try {
            TransactionIO.bulkInsert(transactions);
            System.out.println("Transactions added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing transactions to file.");
        }
    }

    private static void viewExpense() {
        try {
            ArrayList<Transaction> transactions = TransactionIO.findAll();
            double totalExpense = 0;
            for (Transaction transaction : transactions) {
                totalExpense += transaction.getAmount();
            }
            System.out.println("Your total monthly expense is: $" + String.format("%.2f", totalExpense));
        } catch (IOException e) {
            System.out.println("Error reading transactions from file.");
        }
    }
}