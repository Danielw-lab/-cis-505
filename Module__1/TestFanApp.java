/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/ 
public class TestFanApp {
    public static void main(String[] args) {
        // Create two instances of the Fan class
        Fan fan1 = new Fan(); // default constructor
        Fan fan2 = new Fan(Fan.MEDIUM, true, 8.0, "blue"); // argument constructor with constants
        
        // Display the objects by invoking the classes toString() method
        System.out.println("Fan 1: " + fan1);
        System.out.println("Fan 2: " + fan2);
    }
}
