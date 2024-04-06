public class ProductDB {
    public static GenericQueue<Product> getProducts(String code) {
        GenericQueue<Product> products = new GenericQueue<>();

        if (code.equalsIgnoreCase("b")) {
            for (int i = 0; i < 5; i++) {
                Ball ball = new Ball();
                ball.setCode("B" + (i + 1) * 100);
                ball.setDescription("Black Window 2.0" + (i + 1));
                ball.setPrice(100 + i * 10);
                ball.setColor("Black and Red " + (i + 1));
                products.enqueue(ball);
            }
        } else if (code.equalsIgnoreCase("s")) {
            for (int i = 0; i < 5; i++) {
                Shoe shoe = new Shoe();
                shoe.setCode("S" + (i + 1) * 100);
                shoe.setDescription("Youth Skull Green/Black " + (i + 1));
                shoe.setPrice(50 + i * 5);
                shoe.setSize(7.5 + i);
                products.enqueue(shoe);
            }
        } else if (code.equalsIgnoreCase("a")) {
            for (int i = 0; i < 3; i++) {
                Bag bag = new Bag();
                bag.setCode("A" + (i + 1) * 100);
                bag.setDescription("Bowling Bag " + (i + 1));
                bag.setPrice(70 + i * 7);
                bag.setType("Single " + (i + 1));
                products.enqueue(bag);
            }
        }

        return products;
    }
}
