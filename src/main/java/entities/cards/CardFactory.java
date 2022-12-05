package entities.cards;

import entities.cards.Card;
import entities.cards.NumberCard;
import entities.cards.ReverseCard;
import entities.cards.PlusTwoCard;
import entities.cards.PlusFourCard;
import entities.cards.SkipCard;
import entities.cards.WildCard;

public class CardFactory {

    /**
     * Return a card object of the given cardType and with the given colour.
     * @param cardType the type of Card
     * @param colour the colour of Card
     */
    public Card getCard(String cardType, String colour) {
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

    /**
     * Return a card object of the given cardType where the card does not have a colour.
     * This applies to Wild Cards and +4 Cards.
     * @param cardType the type of Card
     */
    public Card getCard(String cardType) {
        if (cardType.equalsIgnoreCase("wild")) {
            return new WildCard(cardType, 2);
        } else {
            return new PlusFourCard(cardType, 1);
        }
    }
}
