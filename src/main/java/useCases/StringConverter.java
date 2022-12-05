package useCases;

import entities.cards.Card;
import java.util.List;
import entities.cards.CardFactory;
import entities.GameState;

public class StringConverter {

    /**
     * Determine the corresponding string of a Card object and return the string.
     * @param card the Card object being converted to a String object
     */
    public static String convertCardToString(Card card) {
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
            cards[i] = convertCardToString(hand.get(i));
        }

        return cards;
    }
    //Return the index of the card with the given string representation.
    public static int convertCardToInteger(String card, GameState gameState) {
        String cardType;
        String colour;
        Card check;
        CardFactory cardFactory = new CardFactory();

        if (card.contains("W")) {
            check = cardFactory.getCard("wild");
            return gameState.getPlayers().get(gameState.getToMove()).getHand().indexOf(check);
        } else if (card.contains("+4")) {
            check = cardFactory.getCard("plusFour");
            return gameState.getPlayers().get(gameState.getToMove()).getHand().indexOf(check);
        } else if (card.contains("R")) {
            cardType = "reverse";
        } else if (card.contains("+2")) {
            cardType = "plusTwo";
        } else if (card.contains("S")) {
            cardType = "skip";
        } else {
            cardType = card.substring(0, 1);
        }

        if (card.contains("red")) {
            colour = "red";
        } else if (card.contains("yellow")) {
            colour = "yellow";
        } else if (card.contains("blue")) {
            colour = "blue";
        } else {
            colour = "green";
        }

        check = cardFactory.getCard(cardType, colour);
        return gameState.getPlayers().get(gameState.getToMove()).getHand().indexOf(check);
    }
}
