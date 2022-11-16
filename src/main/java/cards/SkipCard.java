package cards;

import game.Game;

public class SkipCard extends Card {

    public SkipCard(String cardType, String colour) {
        super(cardType, colour);
    }


    @Override
    public void playedEffect(Game game) {
        //TODO: Skip next player in the game

    /**
     * Skips the next player's turn.
     *
     * @param game the Game object this card is affecting
     */
    @Override
    public void playedEffect(Game game) {
        /*
        This sets the current player to the next player.
        Once the turn actually ends, it will be as if the next player had just gone.
         */
        game.setToMove(game.getNextPlayer());

    }
}
