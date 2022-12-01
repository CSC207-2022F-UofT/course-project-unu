package useCases;

import entities.GameState;

public class CheckWin {
    public boolean checkGameOver(GameState gameState) {
        return gameState.getPlayers().get(gameState.getToMove()).getHand().isEmpty();
    }
}
