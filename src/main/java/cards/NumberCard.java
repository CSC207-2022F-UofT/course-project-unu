package cards;

import game.Game;

public class NumberCard extends Card {

    public NumberCard(String cardType, String colour) {
        super(cardType, colour);
    }

    @Override
    public void playedEffect(Game game) {}
}
