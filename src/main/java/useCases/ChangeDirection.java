package useCases;

import entities.GameState;

public class ChangeDirection {

    public void changeDirection(GameState gameState) {
        gameState.changeDirection();
    }
}
