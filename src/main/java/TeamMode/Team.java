package TeamMode;

import entities.Player;

import java.util.List;

public class Team {
    /**
     * list of the team players
     */
    private List<Player> teamPlayers;
    private String name;
    public Team(){
    }

    /**
     * creates a Team object
     * @param name name of the team
     */
    public Team(String name){
        this.name = name;
    }

    /**
     * returns name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * sets new name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * return the all players in the team
     * @return
     */
    public List<Player> getTeamPlayers(){
        return teamPlayers;
    }

    /**
     * adds new team player
     * @param player - new player
     * @return
     */
    public boolean addTeamPlayer(TeamPlayer player){
        if(teamPlayers.contains(player)){
            return false;
        }
        teamPlayers.add(player);
        return true;
    }
}