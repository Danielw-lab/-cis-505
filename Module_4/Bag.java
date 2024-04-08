/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/

public class Bag extends Product {
    private String type;

    public Bag() {
        super();
        this.type = "";
    }
    public Bag(String code, String description, double price, String type) {
        super(code, description, price);
        this.type = type;
    }
    // Accessor and mutator methods for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Override toString() method
    @Override
    public String toString() {
        return super.toString() + "\nType: " + type;
    }
}