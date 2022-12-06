package useCases;

import entities.GameState;
import entities.Player;

public class MakeBotMove {

    //Should only be called when toMove is not 0 (so toMove is a bot player).
    public void makeBotPlay(GameState gameState) {
        Player botPlayer = gameState.getPlayers().get(gameState.getToMove());

        //Do logic here to get the card this bot wants to play
        int toPlay = 1; //Delete this later

        if (toPlay == -1) {

        } else {

        }

    }
}
