package cards;

import game.Game;

public class PlusFourCard extends WildCard{

    public PlusFourCard(String cardType) {
        super(cardType);
    }

    @Override
    public void playedEffect(Game game) {
        super.playedEffect(game);
        //TODO: Force next player to draw four times
    }
}
