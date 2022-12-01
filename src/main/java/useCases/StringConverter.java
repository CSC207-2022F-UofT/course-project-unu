package useCases;

import cards.Card;
import java.util.List;

public class StringConverter {

    public static String convert(Card card) {
        String type;

        if (card.getCardType().equalsIgnoreCase("wild")) {
            return "W";
        } else if (card.getCardType().equalsIgnoreCase("plusFour")) {
            return "+4";
        } else if (card.getCardType().equalsIgnoreCase("reverse")) {
            type = "R";
        } else if (card.getCardType().equalsIgnoreCase("plusTwo")) {
            type = "+2";
        } else if (card.getCardType().equalsIgnoreCase("skip")) {
            type = "S";
        } else {
            type = card.getCardType();
        }

        return type + "-" + card.getColour();
    }

    public static String[] convertHand(List<Card> hand) {
        String[] cards = new String[hand.size()];

        for (int i = 0; i < cards.length; i++) {
            cards[i] = convert(hand.get(i));
        }

        return cards;
    }
}
