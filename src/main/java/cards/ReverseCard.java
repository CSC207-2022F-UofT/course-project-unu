package cards;

import Game.Game;

public class ReverseCard extends Card {

    public ReverseCard(String cardType, String colour) {
        super(cardType, colour);
    }

    @Override
    public void playedEffect(Game game) {
        //TODO: Change direction of play in game
    }
}
