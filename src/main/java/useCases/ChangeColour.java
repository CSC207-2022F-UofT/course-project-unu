package useCases;

import entities.GameState;

public class ChangeColour {

    //lastPlayed must be a Wild Card
    public void setColour(GameState gameState, String colour) {
        gameState.getLastPlayed().setColour(colour);
    }
}