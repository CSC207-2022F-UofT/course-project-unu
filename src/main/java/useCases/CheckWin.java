package useCases;

import entities.GameState;
import interfaceAdapters.Presenter_Interface;

public class CheckWin {

    public boolean checkGameOver(GameState gameState) {
        return gameState.getPlayers().get(gameState.getToMove()).getHand().isEmpty();
    }
}
