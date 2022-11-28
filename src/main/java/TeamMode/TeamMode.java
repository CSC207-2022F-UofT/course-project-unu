package TeamMode;

import cards.Card;
import entities.Player;
import game.Game;
import interfaceAdapters.Presenter_Interface;

import java.util.List;

public class TeamMode extends Game {
    List<Team> teams;

    /**
     * creates a TeamMode object
     * @param players - players of the game
     * @param isClockwise - direction
     * @param presenter - a presenter needed to start the gamme
     */
    public TeamMode(List<Player> players, boolean isClockwise, Presenter_Interface presenter) {
        super(players, isClockwise,presenter);
    }

    /**
     * returns the list of players of the same team
     * @param wonPlayer - player whose team will be returned
     * @return
     */
    public List<Player> getTeamOfWinners(TeamPlayer wonPlayer){
        return wonPlayer.getTeam().getTeamPlayers();

    }
}