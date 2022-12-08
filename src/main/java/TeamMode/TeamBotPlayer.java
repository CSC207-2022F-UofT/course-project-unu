package TeamMode;

import entities.BotPlayer;

public class TeamBotPlayer extends BotPlayer  implements TeamPlayer{
    private final Team teamOfPlayer;
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
     * returns team
     * @return the team
     */
    public Team getTeam(){
        return this.teamOfPlayer;
    }
}
