package entities.cards;

import useCases.GameFacade;

public class WildCard extends Card {

    public WildCard(String cardType, int botPriority) {
        super(cardType, botPriority);
    }

    /**
     * Makes no changes to the game in the current build of the game.
     *
     * @param game the Game object this card is affecting
     */
    @Override
    public void playedEffect(GameFacade game) {}
}
