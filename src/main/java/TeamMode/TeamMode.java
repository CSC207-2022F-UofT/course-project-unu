package TeamMode;

import cards.Card;
import entities.Player;
import game.Game;

import java.util.List;

public class TeamMode extends Game {
    List<Team> teams;
    public TeamMode(List<Player> players, List<Card> deck, boolean isClockwise) {
        super(players, deck, isClockwise);

    }
    public List<Player> getTeamOfWinners(TeamPlayer wonPlayer){
        return wonPlayer.getTeam().getTeamPlayers();

    }
}
