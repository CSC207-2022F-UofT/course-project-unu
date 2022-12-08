package entities.cards;

import useCases.GameFacade;

public class ReverseCard extends Card {

    public ReverseCard(String cardType, String colour, int botPriority) {
        super(cardType, colour, botPriority);
    }

    /**
     * Reverses the direction of play.
     *
     * @param game the Game object this card is affecting
     */
    @Override
    public void playedEffect(GameFacade game) {
        game.changeDirection();
    }

    /**
     * Convert the Card into a string with the following format:
     * - reverse card "R-red"
     */
    @Override
    public String toString() {
        return "R-" + this.getColour().toLowerCase();
    }
}
