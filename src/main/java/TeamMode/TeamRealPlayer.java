package TeamMode;

import entities.RealPlayer;

public class TeamRealPlayer extends RealPlayer implements TeamPlayer{

    private final Team teamOfPlayer;

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
     * returns team
     * @return team
     */
    public Team getTeam() {
        return this.teamOfPlayer;
    }
}
