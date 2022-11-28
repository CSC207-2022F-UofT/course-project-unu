package cards;

import game.Game;

public class PlusTwoCard extends Card {

    public PlusTwoCard(String cardType, String colour) {
        super(cardType, colour);
    }

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

    /**
     * Convert the Card into a string with the following format:
     * - plus two card "+2-red"
     */
    @Override
    public String toString() {
        return "+2-" + this.getColour().toLowerCase();
    }
}
