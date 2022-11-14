package cards;

import game.Game;

public class PlusFourCard extends WildCard{

    public PlusFourCard(String cardType) {
        super(cardType);
    }

    /**
     * Allows the player to change the colour of this card.
     * Also forces the next player to draw four cards.
     *
     * @param game the Game object this card is affecting
     */
    @Override
    public void playedEffect(Game game) {
        super.playedEffect(game);
        game.draw(4, game.getNextPlayer());
    }
}
