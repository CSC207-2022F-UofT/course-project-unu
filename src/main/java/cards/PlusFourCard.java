package cards;

import useCases.GameFacade;

public class PlusFourCard extends WildCard{

    public PlusFourCard(String cardType, int botPriority) {
        super(cardType, botPriority);
    }

    /**
     * Allows the player to change the colour of this card.
     * Also forces the next player to draw four cards.
     *
     * @param game the Game object this card is affecting
     */
    @Override
    public void playedEffect(GameFacade game) {
        super.playedEffect(game);
        game.draw(4, game.getGameState().getNextPlayer());
        game.setNextTurn();
    }

    /**
     * Convert the Card into a string with the following format:
     * - - plus four card "+4"
     */
    @Override
    public String toString() {
        return "+4";
    }
}
