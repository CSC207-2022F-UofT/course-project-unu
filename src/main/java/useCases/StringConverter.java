package useCases;

import cards.Card;
import java.util.List;
import entities.CardFactory;
import entities.GameState;
import entities.Player;

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
    public static int getIndexOfCard(String card, GameState gameState) {
        List<Player> players = gameState.getPlayers();

        String cardType;
        if (card.contains("W")) {
            cardType = "wild";
        } else if (card.contains("+4")) {
            cardType = "plusFour";
        } else if (card.contains("+2")) {
            cardType = "plusTwo";
        } else if (card.contains("R")) {
            cardType = "reverse";
        } else if (card.contains("S")) {
            cardType = "skip";
        } else {
            cardType = card.substring(0, 1);
        }

        String cardColour = "";
        if (card.contains("red")) {
            cardColour = "red";
        } else if (card.contains("blue")) {
            cardColour = "blue";
        } else if (card.contains("yellow")) {
            cardColour = "yellow";
        } else if (card.contains("green")){
            cardColour = "green";
        }

        int i = 0;
        for (Card handCard: players.get(0).getHand()) {
            String type = handCard.getCardType();
            String colour = handCard.getColour();

            if (cardType.equals(type)) {
                if (cardType.equals("wild") || cardType.equals("plusFour")) {
                    return i;
                } else if (cardColour.equals(colour)) {
                    return i;
                }
            }

            i++;
        }

        return -1; // this should not happen lol
    }
    }

