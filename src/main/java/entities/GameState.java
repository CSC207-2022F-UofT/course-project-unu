package entities;

import entities.cards.Card;
import entities.cards.CardFactory;
import entities.players.Player;

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
        this.isClockwise = true;
    }

    /**
     * Return the list of Player objects in the game.
     */
    public List<Player> getPlayers() {
        return this.players;
    }

    /**
     * Return a list of Card objects contained in the GameState's hand.
     */
    public List<Card> getDeck() {
        return this.deck;
    }

    /**
     * Return the last played Card.
     */
    public Card getLastPlayed() {
        return this.lastPlayed;
    }

    /**
     * Return a list of Card objects contained in the GameState's discard pile.
     */
    public List<Card> getDiscardPile() {
        return this.discardPile;
    }

    /**
     * Return the index of the player whose turn it is.
     */
    public int getToMove() {
        return this.toMove;
    }

    /**
     * Return the index of the player whose turn it is next.
     */
    public int getNextPlayer() {
        int nextPlayer;

        if (isClockwise) {
            nextPlayer = (toMove + 1) % players.size();
        } else {
            nextPlayer = (toMove + players.size() - 1) % players.size();
        }

        return nextPlayer;
    }

    /**
     * Return whether the game turn order is clockwise.
     * Returns True if clockwise, returns False if not clockwise.
     */
    public boolean getIsClockwise() {
        return this.isClockwise;
    }

    /**
     * Set the GameState's last played Card.
     * @param lastPlayed the last played card in the game
     */
    public void setLastPlayed(Card lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    /**
     * Set the GameState's deck.
     * @param deck the game's deck
     */
    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    /**
     * Set the GameState's discard pile.
     * @param discardPile the game's discard pile
     */
    public void setDiscardPile(List<Card> discardPile) {
        this.discardPile = discardPile;
    }

    /**
     * Set the index of the player whose turn it is.
     * @param toMove the index of the player whose turn it is
     */
    public void setToMove(int toMove) {
        this.toMove = toMove;
    }

    /**
     * Switch the direction of turns.
     * Clockwise becomes counterclockwise and vice versa.
     */
    public void changeDirection() {
        this.isClockwise = !isClockwise;
    }

    /**
     * Shuffle the cards in the deck.
     * @param deck deck of Card objects to be shuffled
     */
    public void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
    }

    /**
     * Add the cards in the GameState's discard pile to its deck and shuffle the new deck.
     */
    public void reshuffle() {
        this.deck = new ArrayList<>(discardPile);
        this.deck.remove(lastPlayed);

        this.discardPile.clear();
        this.discardPile.add(lastPlayed);

        shuffleDeck(this.deck);
    }

    /**
     * Create and return a new deck of Cards.
     */
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
                newDeck.add(cardFactory.getCard(wildCardType));
            }
        }
        shuffleDeck(newDeck);

        return newDeck;
    }

}
