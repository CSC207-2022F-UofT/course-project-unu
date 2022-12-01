package useCases;

import entities.GameState;

public class ChangeTurn {
    public void setNextTurn(GameState gameState) {
        gameState.setToMove(gameState.getNextPlayer());
    }
}
