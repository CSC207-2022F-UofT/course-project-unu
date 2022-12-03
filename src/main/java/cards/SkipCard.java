package cards;

import useCases.GameFacade;

public class SkipCard extends Card {

    public SkipCard(String cardType, String colour, int botPriority) {
        super(cardType, colour, botPriority);
    }

    /**
     * Skips the next player's turn.
     *
     * @param game the Game object this card is affecting
     */
    @Override
    public void playedEffect(GameFacade game) {
        /*
        This sets the current player to the next player.
        Once the turn actually ends, it will be as if the next player had just gone.
         */
        game.getGameState().setToMove(game.getGameState().getNextPlayer());
    }
}
