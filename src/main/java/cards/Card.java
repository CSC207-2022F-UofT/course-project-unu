package cards;

import Game.Game;

public abstract class Card {
    private final String cardType;

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

    public Card(String cardType, String colour) {
        this.cardType = cardType;
        this.colour = colour;
    }

    public Card(String cardType) {
        this.cardType = this.colour = cardType;
    }

    //Requires a game object to interact with
    public abstract void playedEffect(Game game);
}
