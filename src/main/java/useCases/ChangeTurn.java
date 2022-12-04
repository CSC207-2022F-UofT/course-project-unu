package useCases;

import entities.GameState;

public class ChangeTurn {

    /**
     * Set the index of toMove in the gameState to the Player whose turn it is next.
     * @param gameState the GameState the program is managing
     */
    public void setNextTurn(GameState gameState) {
        gameState.setToMove(gameState.getNextPlayer());
    }
}
