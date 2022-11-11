package entities;

import cards.Card;
import moves.Moves;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Player implements Moves {

    private final String name;
    private List<Card> hand = new ArrayList<>();

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public void drawCards(List<Card> cards) {
        hand.addAll(cards);
    }

    public Card playCard(int n) {
        return hand.remove(n);
    }

    public List<Card> getPossibleMoves(Card lastPlayed) {
        List<Card> possibleMoves = new ArrayList<>();

        for (Card card: this.hand) {
            if (card.getCardType().equals(lastPlayed.getCardType())) {
                possibleMoves.add(card);
            }
            else if (card.getColour().equals(lastPlayed.getColour())) {
                possibleMoves.add(card);
            }
        }

        return possibleMoves;
    }

    public void makeMove(Card lastPlayed) {}
}
