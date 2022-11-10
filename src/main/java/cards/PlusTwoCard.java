package cards;

import game.Game;

public class PlusTwoCard extends Card {

    public PlusTwoCard(String cardType, String colour) {
        super(cardType, colour);
    }

    @Override
    public void playedEffect(Game game) {
        //TODO: Force next player in game to draw
    }
}
