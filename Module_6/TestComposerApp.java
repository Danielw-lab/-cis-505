/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/
import java.util.Scanner;

public class TestComposerApp {
    public static void main(String[] args) {
        MemComposerDao composerDao = new MemComposerDao();
        Scanner input = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nWelcome to the Composer App\n");
            System.out.println("MENU OPTIONS");
            System.out.println("1. View Composers");
            System.out.println("2. Find Composers");
            System.out.println("3. Add Composers");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\n---DISPLAYING COMPOSERS---");
                    for (Composer composer : composerDao.findAll()) {
                        System.out.println(composer);
                    }
                    break;
                case 2:
                    System.out.println("\n---DISPLAYING COMPOSERS---");
                    System.out.print("Enter an id: ");
                    int id = input.nextInt();
                    Composer foundComposer = composerDao.findBy(id);
                    if (foundComposer != null) {
                        System.out.println(foundComposer);
                    } else {
                        System.out.println("Composer with id " + id + " not found.");
                    }
                    break;
                case 3:
                    System.out.print("\nEnter an id: ");
                    int newId = input.nextInt();
                    input.nextLine(); // Consume newline character
                    System.out.print("Enter a name: ");
                    String newName = input.nextLine();
                    System.out.print("Enter a genre: ");
                    String newGenre = input.nextLine();
                    composerDao.insert(new Composer(newId, newName, newGenre));
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        } while (option != 4);

        input.close();
    }
}