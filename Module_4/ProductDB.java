import java.util.LinkedList;

public class ProductDB {
    public static GenericQueue<Product> getProducts(String code) {
        GenericQueue<Product> products = new GenericQueue<>();
        if (code.equals("b")) {
            for (int i = 0; i < 5; i++) {
                Ball ball = new Ball();
                ball.setCode("B" + (i + 1));
                ball.setDescription("Bowling Ball #" + (i + 1));
                ball.setPrice(100.0);
                ball.setColor("Red");
                products.enqueue(ball);
            }
        } else if (code.equals("s")) {
            for (int i = 0; i < 5; i++) {
                Shoe shoe = new Shoe();
                shoe.setCode("S" + (i + 1));
                shoe.setDescription("Bowling Shoe #" + (i + 1));
                shoe.setPrice(50.0);
                shoe.setSize(9.5);
                products.enqueue(shoe);
            }
        } else if (code.equals("a")) {
            for (int i = 0; i < 3; i++) {
                Bag bag = new Bag();
                bag.setCode("A" + (i + 1));
                bag.setDescription("Bowling Bag #" + (i + 1));
                bag.setPrice(80.0);
                bag.setType("Single");
                products.enqueue(bag);
            }
        }
        return products;
    }
}