package entities.cards;

import useCases.GameFacade;

public class NumberCard extends Card {

    public NumberCard(String cardType, String colour, int botPriority) {
        super(cardType, colour, botPriority);
    }

    /**
     * Has no effect on the game.
     *
     * @param game the Game object this card is affecting
     */
    @Override
    public void playedEffect(GameFacade game) {}
}
