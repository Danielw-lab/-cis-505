/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/
public class Ball extends Product {
    private String color;

    public Ball() {
        super();
        this.color = "";
    }
    public Ball(String code, String description, double price, String color) {
        super(code, description, price);
        this.color = color;
    }

    // Accessor and mutator methods for color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Override toString() method
    @Override
    public String toString() {
        return super.toString() + "\nColor: " + color;
    }
}