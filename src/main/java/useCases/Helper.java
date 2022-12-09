package useCases;

import entities.BotPlayer;
import entities.Player;
import entities.RealPlayer;
import useCases.teammode.Team;
import useCases.teammode.TeamBotPlayer;
import useCases.teammode.TeamRealPlayer;

import java.util.ArrayList;
import java.util.List;
//class crated to avoid dependency between entities and controller
public class Helper {
    //list of player names
    private final List<String> playerNames;
    //list of team names
    private final List<String> teamNames;
    //list of levels of bots
    private final List<String> botLevels;
    private final boolean teamMode;
    public Helper(List<String> playerNames,List<String> teamNames,List<String> botLevels, boolean teamMode){
        this.playerNames=playerNames;
        this.botLevels=botLevels;
        this.teamNames=teamNames;
        this.teamMode = teamMode;
    }

    /**
     * returns the list of players depending on the teammode
     * @return
     */
    public List<Player> getListOfPlayers(){
       if(teamMode){
           return teamPlayerList();
       }
       return regularPlayerList();
    }
    /**
     * returns the list of players that can be used to initialize the game
     * @return the list of players
     */
    private List<Player> regularPlayerList() {
        List<Player> playerList = new ArrayList<>();
        Player player = new RealPlayer(playerNames.get(0));
        playerList.add(player);

        for(int k=1, i = 0;k<playerNames.size();k++, i++){
            player = new BotPlayer(playerNames.get(k), botLevels.get(i));
            playerList.add(player);
        }
        return playerList;
    }
    /**
     * return the list of team players that can be used to initialize the game
     * @return list of team players
     */
    private List<Player> teamPlayerList() {
        List<Player> teamPlayers = new ArrayList<>();
        Team team1 = new Team(teamNames.get(0));
        Player player1 = new TeamRealPlayer(playerNames.get(0),team1);
        Player player2 = new TeamBotPlayer(playerNames.get(1),botLevels.get(0),team1);
        teamPlayers.add(player1);
        teamPlayers.add(player2);
        Team team2 = new Team(teamNames.get(1));
        //k - bot levels name
        for(int i=2, k=1; i<playerNames.size();i++,k++){
            Player player = new TeamBotPlayer(playerNames.get(i),botLevels.get(k),team2);
            teamPlayers.add(player);
        }
        return teamPlayers;
    }
}
