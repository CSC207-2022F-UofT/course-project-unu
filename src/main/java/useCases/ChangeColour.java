package useCases;

import entities.GameState;

public class ChangeColour {

    /**
     * Set the colour of the last played card in GameState.
     * The last played card must be a Wild Card.
     * @param gameState the GameState the program is managing
     * @param colour the colour we are setting the Wild Card to
     */
    public void setColour(GameState gameState, String colour) {
        gameState.getLastPlayed().setColour(colour);
    }
}