package cards;

import game.Game;

public abstract class Card {

    /**
     * The type of card this object is. Can be numbers ranging from 0 to 9, or the names of special cards.
     */
    private final String cardType;

    /**
     * The colour this card is. Can be Red, BLue, Green, or Yellow.
     */
    private String colour;

    public String getCardType() {
        return cardType;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * Constructs this card with a cardType and colour.
     *
     * @param cardType  the String representing the card's type
     * @param colour    the String representing the card's colour
     */
    public Card(String cardType, String colour) {
        this.cardType = cardType;
        this.colour = colour;
    }

    /**
     * Constructs this card with a cardType. The colour takes on the value of cardType.
     *
     * @param cardType  the String representing the card's type
     */
    public Card(String cardType) {
        this.cardType = this.colour = cardType;
    }

    /**
     * Causes an effect after being played.
     *
     * @param game the Game object this card is affecting
     */
    public abstract void playedEffect(Game game);
}
