/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/

package Module_2.SportsTeamApp;

public class Team {
    private String teamName;
    private String[] players;
    private int playerCount;

    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new String[20];
        this.playerCount = 0;
    }

    public void addPlayer(String playerName) {
        players[playerCount] = playerName;
        playerCount++;
    }

    public String[] getPlayers() {
        return players;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public String getTeamName() {
        return teamName;
    }    
}
