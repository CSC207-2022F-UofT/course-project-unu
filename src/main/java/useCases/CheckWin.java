package useCases;

import entities.GameState;
import entities.Player;

import java.util.List;

public class CheckWin {

    /**
     * Return whether any Player has entered a win state.
     * A Player has won when their hand is empty.
     * @param gameState the GameState the program is managing
     */
    public boolean checkGameOver(GameState gameState) {
        List<Player> players = gameState.getPlayers();
        for (Player player : players){
            if(player.getHand().isEmpty()){
                return true;
            }
        }
        return false;
    }
}
