package cards;

import game.Game;

public class NumberCard extends Card {

    public NumberCard(String cardType, String colour) {
        super(cardType, colour);
    }

    /**
     * Has no effect on the game.
     *
     * @param game the Game object this card is affecting
     */

    @Override
    public void playedEffect(Game game) {}
}
