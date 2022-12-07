package TeamMode;

import entities.BotPlayer;

public class TeamBotPlayer extends BotPlayer  implements TeamPlayer{
    private Team teamOfPlayer;
    /**
     * creates a team player
     * @param name name
     * @param team team
     */
    public TeamBotPlayer(String name,String level, Team team){
        super(name,level);
        teamOfPlayer = team;
        team.addTeamPlayer(this);
    }

    /**
     * return team name
     * @return team name
     */
    public String getTeamName() {
        return teamOfPlayer.getName();
    }
    /**
     * sets team name
     */
    public void setTeamName(String name) {
        this.teamOfPlayer.setName(name);
    }

    /**
     * sets team
     */
    public void setTeamOfPlayer(Team teamOfPlayer) {
        this.teamOfPlayer = teamOfPlayer;
    }
    /**
     * returns team
     * @return the team
     */
    public Team getTeam(){
        return this.teamOfPlayer;
    }
}
