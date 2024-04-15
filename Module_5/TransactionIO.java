/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/
package Module_5;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class TransactionIO {
    private static final String FILE_NAME = "expenses.txt"; // "expenses.txt" please put the right file directory 
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        PrintWriter output = null;
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                output = new PrintWriter(new FileOutputStream(file, true));
            } else {
                output = new PrintWriter(FILE_NAME);
            }
            for (Transaction transaction : transactions) {
                output.println(transaction);
            }
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    public static ArrayList<Transaction> findAll() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try (Scanner input = new Scanner(new File(FILE_NAME))) {
            while (input.hasNext()) {
                String date = input.nextLine().substring(6);
                String description = input.nextLine().substring(13);
                double amount = Double.parseDouble(input.nextLine().substring(8));
                transactions.add(new Transaction(date, description, amount));
            }
        }
        return transactions;
    }
}