package TeamMode;

import entities.RealPlayer;

public class TeamRealPlayer extends RealPlayer implements TeamPlayer{

    private Team teamOfPlayer;

    /**
     * creates a team player
     *
     * @param name
     * @param team
     */
    public TeamRealPlayer(String name, Team team) {
        super(name);
        teamOfPlayer = team;
    }

    /**
     * return team name
     *
     * @return
     */
    public String getTeamName() {
        return teamOfPlayer.getName();
    }

    /**
     * sets team name
     *
     * @return
     */
    public void setTeamName(String name) {
        this.teamOfPlayer.setName(name);
    }

    /**
     * sets team
     *
     * @return
     */
    public void setTeamOfPlayer(Team teamOfPlayer) {
        this.teamOfPlayer = teamOfPlayer;
    }

    /**
     * returns team
     *
     * @return
     */
    public Team getTeam() {
        return this.teamOfPlayer;
    }
}
