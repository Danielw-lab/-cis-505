import java.util.Scanner;

public class TestBowlingShopApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("x")) {
                GenericQueue<Product> products = ProductDB.getProducts(choice);
                while (products.size() > 0) {
                    System.out.println(products.dequeue());
                    System.out.println("--------------------");
                }
            }
        } while (!choice.equals("x"));
    }

    public static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("b - Get bowling balls");
        System.out.println("s - Get bowling shoes");
        System.out.println("a - Get bowling bags");
        System.out.println("x - Exit");
    }
}