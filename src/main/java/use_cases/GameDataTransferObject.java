package use_cases;

import entities.Player;
import cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameDataTransferObject {
    private final List<Player> players;

    private List<Card> deck;

    private Card lastPlayed;

    private int toMove;

    private boolean isClockwise;

    private List<Card> discardPile = new ArrayList<>();

    public GameDataTransferObject(List<Player> players, List<Card> deck, Card lastPlayed, int toMove, boolean isClockwise, List<Card> discardPile) {
        this.players = players;
        this.deck = deck;
        this.lastPlayed = lastPlayed;
        this.toMove = toMove;
        this.isClockwise = isClockwise;
        this.discardPile = discardPile;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public List<Card> getDeck() {
        return this.deck;
    }

    public Card getLastPlayed() {
        return this.lastPlayed;
    }

    public int getToMove() {
        return this.toMove;
    }

    public boolean getIsClockwise() {
        return this.isClockwise;
    }

    public List<Card> getDiscardPile() {
        return this.discardPile;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public void setLastPlayed(Card card) {
        this.lastPlayed = card;
    }

    public void setToMove(int toMove) {
        this.toMove = toMove;
    }

    public void changeDirection() {
        isClockwise = !isClockwise;
    }

    public void setDiscardPile(List<Card> discardPile) {
        this.discardPile = discardPile;
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    // If the deck is empty, shuffle the discard pile into the deck
    public void reshuffle() {
        deck = new ArrayList<>(discardPile);
        deck.remove(lastPlayed);

        discardPile.clear();
        discardPile.add(lastPlayed);

        shuffleDeck();
    }
}