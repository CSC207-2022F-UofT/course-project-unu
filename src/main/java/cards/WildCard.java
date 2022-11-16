package cards;

import game.Game;

public class WildCard extends Card {

    public WildCard(String cardType) {
        super(cardType);
    }


    @Override
    public void playedEffect(Game game) {
        // super.setColour( /* User input */ );

    /**
     * Allows the player to change the colour of this card.
     *
     * @param game the Game object this card is affecting
     */
    @Override
    public void playedEffect(Game game) {
        // TODO: Implement with User Inputs - super.setColour( /* User input */ );

    }
}
