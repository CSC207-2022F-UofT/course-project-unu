package TeamMode;

import entities.players.BotPlayer;

public class TeamBotPlayer extends BotPlayer  implements TeamPlayer{
    private Team teamOfPlayer;
    /**
     * creates a team player
     * @param name
     * @param team
     */
    public TeamBotPlayer(String name,String level, Team team){
        super(name,level);
        teamOfPlayer = team;
        team.addTeamPlayer(this);
    }

    /**
     * return team name
     * @return
     */
    public String getTeamName() {
        return teamOfPlayer.getName();
    }
    /**
     * sets team name
     * @return
     */
    public void setTeamName(String name) {
        this.teamOfPlayer.setName(name);
    }

    /**
     * sets team
     * @return
     */
    public void setTeamOfPlayer(Team teamOfPlayer) {
        this.teamOfPlayer = teamOfPlayer;
    }
    /**
     * returns team
     * @return
     */
    public Team getTeam(){
        return this.teamOfPlayer;
    }
}
