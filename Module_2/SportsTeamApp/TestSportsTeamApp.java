/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/ 
public class TestSportsTeamApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continueProgram = true;
        while (continueProgram) {
            System.out.print("Enter team name: ");
            String teamName = scanner.nextLine();

            Team team = new Team(teamName);

            System.out.print("Enter player names (comma-separated, no spaces): ");
            String playerNames = scanner.nextLine();

            String[] players = playerNames.split(",");

            for (String playerName : players) {
                team.addPlayer(playerName);
            }

            System.out.println("Number of players in team " + team.getPlayerCount());
            System.out.print("Players on team: ");
            for (int i = 0; i < team.getPlayerCount(); i++) {
                System.out.print(team.getPlayers()[i]);
                if (i < team.getPlayerCount() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();

            System.out.print("Do you want to continue? (yes/no): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                continueProgram = false;
            }
        }

        scanner.close();
    }
}
