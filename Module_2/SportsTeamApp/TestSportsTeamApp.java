/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/
package Module_2.SportsTeamApp;

import java.util.Scanner;

public class TestSportsTeamApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Continue loop until user decides to exit
        while (true) {
            System.out.print("Enter the team name: ");
            String teamName = scanner.nextLine();
            
            Team team = new Team(teamName);
            
            System.out.print("Enter player names separated by commas (without spaces): ");
            String playerNamesInput = scanner.nextLine();
            
            String[] playerNames = playerNamesInput.split(",");
            for (String playerName : playerNames) {
                team.addPlayer(playerName);
            }
            
            System.out.println("Number of players in team " + team.getTeamName() + ": " + team.getPlayerCount());
            System.out.print("Players on team: ");
            String[] players = team.getPlayers();
            for (int i = 0; i < team.getPlayerCount(); i++) {
                System.out.print(players[i]);
                if (i < team.getPlayerCount() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            
            System.out.print("Do you want to continue? (yes/no): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                break; // Exit the loop
            }
        }
        
        scanner.close();
    }
}
