/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/
public class ProductDB {
    public static GenericQueue<Product> getProducts(String code) {
        GenericQueue<Product> products = new GenericQueue<>();

        if (code.equals("b")) {
            products.enqueue(new Ball("B100", "Black Widow 2.0", 144.95, "Black and"));
            products.enqueue(new Ball("B200", "Axiom Peart", 154.95, "Blue and Red"));
            products.enqueue(new Ball("B300", "Proton Physix", 174.95, "Pink and Purple"));
            products.enqueue(new Ball("B400", "Force Unleashed", 139.99, "Red and White")); 
            products.enqueue(new Ball("B500", "Phaze III", 154.99, "Purple and Green")); 
        } else if (code.equals("a")) {
            products.enqueue(new Bag("A300", "Silver/Royal Blue", 74.99, "Triple"));
            products.enqueue(new Bag("A200", "Prime Roller Black/Royal Blue", 54.99, "Double"));
            products.enqueue(new Bag("A100", "Path Pro Deluxe", 34.99, "Single"));
        } else if (code.equals("s")) {
            products.enqueue(new Shoe("S500", "Youth Skull Green/Black", 39.99, 3.0));
            products.enqueue(new Shoe("S400", "Men's Tribal White", 26.99, 8.5));
            products.enqueue(new Shoe("S300", "Women's Path Lite Seamless Mesh", 54.99, 6.0));
            products.enqueue(new Shoe("S200", "Women's Rise Black/Hot Pink", 39.99, 7.0));
            products.enqueue(new Shoe("S100", "Men's Ram Black", 39.99, 10.5));
        }
        return products;
    }
}