package cards;

import game.Game;

public class ReverseCard extends Card {

    public ReverseCard(String cardType, String colour) {
        super(cardType, colour);
    }

    /**
     * Reverses the direction of play.
     *
     * @param game the Game object this card is affecting
     */
    @Override
    public void playedEffect(Game game) {
        game.changeDirection();
    }
}
