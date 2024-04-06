import java.util.Scanner;

public class TestBowlingShopApp {
    public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
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
    }
    public static void displayMenu() {
        System.out.println("MENU OPTIONS:");
        System.out.println("   1. <b> - Get bowling balls");
        System.out.println("   2. <s> - Get bowling shoes");
        System.out.println("   3. <a> - Get bowling bags");
        System.out.println("   4. <x> - To Exit\n");

        System.out.print("Please choose an option: ");
        // Code to read user input and process it
    }
}