package TeamMode;

import entities.Player;

import java.util.List;

public class Team {
    private List<Player> teamPlayers;
    private String name;
    public Team(){
    }
    public Team(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Player> getTeamPlayers(){
        return teamPlayers;
    }
    public boolean addTeamPlayer(TeamPlayer player){
        if(teamPlayers.contains(player)){
            return false;
        }
        teamPlayers.add(player);
        return true;
    }
}
