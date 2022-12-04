package useCases;

import entities.GameState;
import entities.Player;
import java.util.List;

public class CheckWin {
    public boolean checkGameOver(GameState gameState) {
        List<Player> players = gameState.getPlayers();

        for (Player player: players) {
            if (player.getHand().isEmpty()) {
                return true;
            }
        }

        return false;
    }
}
