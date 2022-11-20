package entities;

import cards.Card;
import cards.NumberCard;
import cards.ReverseCard;
import cards.PlusTwoCard;
import cards.PlusFourCard;
import cards.SkipCard;
import cards.WildCard;

public class CardFactory {

    /**
     * Return a card object of the given cardType and with the given colour.
     * @param cardType the type of Card
     * @param colour the colour of Card
     */
    public Card getCard(String cardType, String colour, int botPriority) {
        if (cardType.equalsIgnoreCase("REVERSE")) {
            return new ReverseCard(cardType, colour, 5);
        } else if (cardType.equalsIgnoreCase("PLUSTWOCARD")) {
            return new PlusTwoCard(cardType, colour, 3);
        } else if (cardType.equalsIgnoreCase("SKIPCARD")) {
            return new SkipCard(cardType, colour, 4);
        } else {
            return new NumberCard(cardType, colour, 6);
        }
    }

    public Card getCard(String cardType) {
        if (cardType.equalsIgnoreCase("wild")) {
            return new WildCard(cardType, 2);
        } else {
            return new PlusFourCard(cardType, 1);
        }
    }
}
