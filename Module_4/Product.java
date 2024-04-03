public class Product {
    private String code;
    private String description;
    private double price;

    public Product() {
        this.code = "";
        this.description = "";
        this.price = 0.0;
    }

    // Accessors and mutators for all data fields

    @Override
    public String toString() {
        return "Code: " + code + "\nDescription: " + description + "\nPrice: $" + String.format("%,6.2f", price);
    }
}
