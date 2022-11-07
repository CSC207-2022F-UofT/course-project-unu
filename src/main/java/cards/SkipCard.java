package cards;

import Game.Game;

public class SkipCard extends Card {

    public SkipCard(String cardType, String colour) {
        super(cardType, colour);
    }

    @Override
    public void playedEffect(Game game) {
        //TODO: Skip next player in the game
    }
}
