package TeamMode;

import cards.Card;
import entities.Player;
import game.Game;

import java.util.List;

public class TeamMode extends Game {
    List<Team> teams;

    /**
     * creates a TeamMode object
     * @param players - players of the game
     * @param deck - deck of cards
     * @param isClockwise - direction
     */
    public TeamMode(List<Player> players, List<Card> deck, boolean isClockwise) {
        super(players, deck, isClockwise);

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