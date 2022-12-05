package useCases;

import entities.GameState;
import entities.players.Player;

public class MakeBotMove {

    /**
     * Make a BotPlayer play a move.
     * The method should only be called when toMove is not 0 (so when toMove refers to a BotPlayer.)
     * @param gameState the GameState the program is managing
     */
    public void makeBotPlay(GameState gameState) {
        Player botPlayer = gameState.getPlayers().get(gameState.getToMove());

        //Do logic here to get the card this bot wants to play
        int toPlay = 1; //Delete this later

        if (toPlay == -1) {

        } else {

        }

    }
}
