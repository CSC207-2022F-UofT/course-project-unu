package TeamMode;

import cards.Card;
import entities.Player;
import interfaceAdapters.Presenter;
import useCases.GameFacade;

import java.util.List;

public class TeamMode extends GameFacade {
    /**
     * creates a TeamMode object
     * @param players - players of the game
     * @param presenter - presenter
     */
    public TeamMode(List<Player> players, Presenter presenter) {
        super(players,presenter);
    }
    /*
    * returns the list of players of the same team
    * @param wonPlayer - player whose team will be returned * @return
    */
   public List<Player> getTeamOfWinners(Player wonPlayer){
       return ((TeamPlayer)wonPlayer).getTeam().getTeamPlayers();
   }
}