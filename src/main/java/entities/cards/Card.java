package entities.cards;

import useCases.GameFacade;

public abstract class Card {

    /**
     * The type of card this object is. Can be numbers (0 to 9) or names (Skip, Plus2, Wild, etc.).
     */
    private final String cardType;


    /**
     * The bot priority of this card. This is used to determine the order in which a bot is to play this card.
     */
    private final int botPriority;

    /**
     * The colour this card is.
     * Can be: Red, Blue, Green, or Yellow.
     * This field defaults to one of these four values, but may also take on cardType as a placeholder value.
     */
    private String colour;

    public String getCardType() {
        return cardType;
    }

    public String getColour() {
        return colour;
    }

    public int getBotPriority() {
        return botPriority;
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
    public Card(String cardType, String colour, int botPriority) {
        this.cardType = cardType;
        this.colour = colour;
        this.botPriority = botPriority;
    }

    /**
     * Constructs this card with a cardType. The colour takes on the value of cardType.
     *
     * @param cardType  the String representing the card's type
     */
    public Card(String cardType, int botPriority) {
        this.cardType = this.colour = cardType;
        this.botPriority = botPriority;
    }

    /**
     * Causes an effect after being played.
     *
     * @param game the Game object this card is affecting
     */
    public abstract void playedEffect(GameFacade game);
}
