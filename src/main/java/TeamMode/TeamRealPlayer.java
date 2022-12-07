package TeamMode;

import entities.RealPlayer;

public class TeamRealPlayer extends RealPlayer implements TeamPlayer{

    private Team teamOfPlayer;

    /**
     * creates a team player
     *
     * @param name name
     * @param team team
     */
    public TeamRealPlayer(String name, Team team) {
        super(name);
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
     * @return team
     */
    public Team getTeam() {
        return this.teamOfPlayer;
    }
}
