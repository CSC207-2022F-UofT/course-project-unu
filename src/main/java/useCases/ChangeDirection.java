package useCases;

import entities.GameState;

public class ChangeDirection {

    /**
     * Change the direction of the turn order.
     * @param gameState the GameState the program is managing
     */
    public void changeDirection(GameState gameState) {
        gameState.changeDirection();
    }
}
