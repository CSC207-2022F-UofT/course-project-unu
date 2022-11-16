package cards;

import game.Game;

public class ReverseCard extends Card {

    public ReverseCard(String cardType, String colour) {
        super(cardType, colour);
    }


    @Override
    public void playedEffect(Game game) {
        //TODO: Change direction of play in game

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
