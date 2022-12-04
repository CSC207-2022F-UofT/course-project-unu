package useCases;

import entities.GameState;
import entities.Player;
import entities.BotPlayer;
import java.util.List;

public class MakeBotMove {
    // Should only be called when toMove is not 0 (so toMove is a bot player).
    public void makeBotPlay(GameState gameState) {
        Player player = gameState.getPlayers().get(gameState.getToMove());

        if (player instanceof BotPlayer) {
            BotPlayer botPlayer = (BotPlayer) player;

            List<Player> players = gameState.getPlayers();
            Player nextPlayer = players.get(gameState.getNextPlayer());

            botPlayer.makeMove(gameState.getLastPlayed(), nextPlayer.getHand());
        }
    }
}
