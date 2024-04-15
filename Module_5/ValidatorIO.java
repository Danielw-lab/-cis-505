/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/

package Module_5;

import java.util.Scanner;

class ValidatorIO {
    public static int getInt(Scanner sc, String prompt) {
        int input = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid integer value.");
                sc.nextLine();
            }
        }
        return input;
    }

    public static double getDouble(Scanner sc, String prompt) {
        double input = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                input = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Error! Invalid double value.");
                sc.nextLine();
            }
        }
        return input;
    }

    public static String getString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.next();
    }
}