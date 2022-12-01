package entities;

import cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameState {
    private final List<Player> players;
    private List<Card> deck;
    private Card lastPlayed;
    private List<Card> discardPile = new ArrayList<>();
    private int toMove;
    private boolean isClockwise;

    public GameState(List<Player> players){
        this.players = players;
        this.deck = newDeck();
        this.toMove = 3;
        this.isClockwise = isClockwise;
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

    public List<Card> getDiscardPile() {
        return this.discardPile;
    }

    public int getToMove() {
        return this.toMove;
    }

    public int getNextPlayer() {
        int nextPlayer;

        if (isClockwise) {
            nextPlayer = (toMove + 1) % players.size();
        } else {
            nextPlayer = (toMove + players.size() - 1) % players.size();
        }

        return nextPlayer;
    }

    public boolean getIsClockwise() {
        return this.isClockwise;
    }

    public void setLastPlayed(Card lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public void setDiscardPile(List<Card> discardPile) {
        this.discardPile = discardPile;
    }

    public void setToMove(int toMove) {
        this.toMove = toMove;
    }

    public void changeDirection() {
        this.isClockwise = !isClockwise;
    }

    public void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
    }

    public void reshuffle() {
        this.deck = new ArrayList<>(discardPile);
        this.deck.remove(lastPlayed);

        this.discardPile.clear();
        this.discardPile.add(lastPlayed);

        shuffleDeck(this.deck);
    }

    private List<Card> newDeck() {
        CardFactory cardFactory = new CardFactory();

        String[] colours = {"red", "yellow", "blue", "green"};
        String[] cardTypes = {"reverse", "plusTwo", "skip",
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] wildCardTypes = {"wild", "plusFour"};

        List<Card> newDeck = new ArrayList<>();

        for (String colour: colours) {
            for (String cardType : cardTypes) {
                newDeck.add(cardFactory.getCard(cardType, colour));
                newDeck.add(cardFactory.getCard(cardType, colour));
            }

            for (String wildCardType : wildCardTypes) {
                for (int i = 0; i < 4; i++) {
                    newDeck.add(cardFactory.getCard(wildCardType));
                }
            }
        }
        shuffleDeck(newDeck);

        return newDeck;
    }

}
