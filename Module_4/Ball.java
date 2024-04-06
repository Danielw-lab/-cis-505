public class Ball extends Product {
    private String color;

    // No-argument constructor
    public Ball() {
        super();
        this.color = "";
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