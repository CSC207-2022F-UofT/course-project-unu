package entities;

import entities.cards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Player {

    private final String name;
    private final List<Card> hand = new ArrayList<>();

    public Player(String name){
        this.name = name;
    }

    /**
     * Return the player's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return a list of Card objects contained in the player's hand.
     */
    public List<Card> getHand() {
        return this.hand;
    }

    /**
     * Return whether the player is a RealPlayer or a BotPlayer.
     */
    public abstract String getPlayerType();

    /**
     * Add a list of Card objects to the player's hand.
     */
    public void drawCards(List<Card> cards) {
        hand.addAll(cards);
    }

    /**
     * Return the Card at index n in the player's hand and removes it from the hand.
     * @param n index of card in player's hand
     */
    public Card playCard(int n) {
        return hand.remove(n);
    }

    /**
     * Return a list of Card objects from Player's hand that Player can play.
     * If there are no possible moves, return an empty list.
     * @param lastPlayed the last played card in Game
     */
    public ArrayList<Card> getPossibleMoves(Card lastPlayed) {
        ArrayList<Card> possibleMoves = new ArrayList<>();

        for (Card card: this.hand) {
            String cardType = card.getCardType();

            if (cardType.equals(lastPlayed.getCardType())) {
                possibleMoves.add(card);
            }
            else if (card.getColour().equals(lastPlayed.getColour())) {
                possibleMoves.add(card);
            }
            else if (cardType.equals("wild") || cardType.equals("plusFour")) {
                possibleMoves.add(card);
            }
        }

        return possibleMoves;
    }

    /**
     * Return a list containing a Card object from Player's hand that Player can play.
     * This Card corresponds to the default move the game will play for the Player.
     * An empty list corresponds to drawing a Card from the deck.
     * @param lastPlayed the last played card in Game
     */
    public ArrayList<Card> getDefaultMove(Card lastPlayed) {
        ArrayList<Card> possibleMoves = getPossibleMoves(lastPlayed);
        ArrayList<String> specialCards = new ArrayList<>(Arrays.asList("Plus2", "Plus4", "Skip", "Reverse", "Wild"));

        ArrayList<Card> defaultMove = new ArrayList<>();

        // Select order: special cards -> number cards -> nothing/draw
        for (Card card: possibleMoves) {
            String cardType = card.getCardType();

            if (specialCards.contains(cardType)) {
                defaultMove.add(card);
                return defaultMove;
            }
        }

        if (possibleMoves.size() > 0) {
            defaultMove.add(possibleMoves.get(0));
        }

        return defaultMove;
    }
}
