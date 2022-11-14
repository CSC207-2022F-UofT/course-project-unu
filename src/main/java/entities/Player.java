package entities;

import cards.Card;
import java.util.ArrayList;
import java.util.List;

public abstract class Player {

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

    public abstract String getPlayerType();

    public void drawCards(List<Card> cards) {
        hand.addAll(cards);
    }

    public Card playCard(int n) {
        return hand.remove(n);
    }
}
