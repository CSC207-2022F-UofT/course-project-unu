package useCases.teammode;

import entities.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {
    /**
     * list of the team players
     */
    private final List<Player> teamPlayers;
    private String name;

    /**
     * creates a Team object
     * @param name name of the team
     */
    public Team(String name){
        this.name = name;
        this.teamPlayers = new ArrayList<>();
    }

    /**
     * returns name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets new name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * adds new team player
     * @param player - new player
     * @return whether teamPlayers contains player
     */
    public boolean addTeamPlayer(Player player){
        if(teamPlayers.contains(player)){
            return false;
        }
        teamPlayers.add(player);
        return true;
    }
}