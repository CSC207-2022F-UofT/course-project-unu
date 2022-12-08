
package team_mode_tests;
import TeamMode.Team;
import TeamMode.TeamBotPlayer;
import TeamMode.TeamPlayer;
import TeamMode.TeamRealPlayer;
import entities.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class TeamTest {
        Team teamTest = new Team("TeamTest");
        Player player1 = new TeamRealPlayer("TeamPlayer1",teamTest);

    /**
     * test of adding new player
     */
    @Test
    public void addPlayerTest() {
        Assertions.assertTrue(!teamTest.addTeamPlayer(player1));
    }

    /**
     * checks whether the TeamName is right
     */
    @Test
    public void checkTeam(){
        Assertions.assertEquals(teamTest,((TeamPlayer)player1).getTeam());
    }

    /**
     * checks whether polymorphism is inherited
     * also checks if adding the bot player is correct
     */
    @Test
    public void checkBotPlayer(){
        Player botPlayer = new TeamBotPlayer("BotPlayer","medium",teamTest);
        Assertions.assertTrue(!teamTest.addTeamPlayer(botPlayer));
        Assertions.assertEquals("bot",botPlayer.getPlayerType().toLowerCase());
    }



}
