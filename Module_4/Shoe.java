/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/
public class Shoe extends Product {
    private double size;

    public Shoe() {
        super();
        this.size = 0.0;
    }
    public Shoe(String code, String description, double price, double size) {
        super(code, description, price);
        this.size = size;
    }
    // Accessor and mutator methods for size
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    // Override toString() method
    @Override
    public String toString() {
        return super.toString() + "\nSize: " + size;
    }
}