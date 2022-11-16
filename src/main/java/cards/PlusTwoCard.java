package cards;

import game.Game;

public class PlusTwoCard extends Card {

    public PlusTwoCard(String cardType, String colour) {
        super(cardType, colour);
    }

    @Override
    public void playedEffect(Game game) {
        //TODO: Force next player in game to draw

    /**
     * Forces the next player to draw two cards and skips their turn.
     *
     * @param game the Game object this card is affecting
     */
    @Override
    public void playedEffect(Game game) {
        game.draw(2, game.getNextPlayer());
        game.setToMove(game.getNextPlayer());

    }
}
