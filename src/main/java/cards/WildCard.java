package cards;

import useCases.GameFacade;

public class WildCard extends Card {

    public WildCard(String cardType, int botPriority) {
        super(cardType, botPriority);
    }

    /**
     * Allows the player to change the colour of this card.
     *
     * @param game the Game object this card is affecting
     */
    @Override
    public void playedEffect(GameFacade game) {
        game.getPresenter().requestNewColour();

    }
}
