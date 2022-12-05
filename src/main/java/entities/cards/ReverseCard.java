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
}
