package useCases;

import entities.GameState;
import entities.Player;
import entities.BotPlayer;
import java.util.List;

public class MakeBotMove {
    // Should only be called when toMove is not 0 (so toMove is a bot player).
    public void makeBotPlay(GameState gameState, Presenter_Interface presenter) {
        Play play = new Play();
        Draw draw = new Draw();

        BotPlayer botPlayer = (BotPlayer) gameState.getPlayers().get(gameState.getToMove());

        List<Player> players = gameState.getPlayers();
        Player nextPlayer = players.get(gameState.getNextPlayer());

        int toPlay = botPlayer.getBotToPlay(gameState.getLastPlayed(), nextPlayer.getHand());

        if (toPlay < 0) {
            draw.draw(gameState, 1, gameState.getToMove(), presenter);
        } else {
            play.playCard(gameState, toPlay, presenter);
        }
    }
}
