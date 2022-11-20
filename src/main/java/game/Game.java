package game;

import entities.Player;
import entities.CardFactory;
import cards.Card;
import interfaceAdapters.Presenter_Interface;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Game {
    private List<Player> players;
    private List<Card> deck;
    private Card lastPlayed;
    private int toMove;
    private boolean isClockwise;
    private List<Card> discardPile = new ArrayList<>();

    public Game(List<Player> players, boolean isClockwise) {
        this.players = players;
        this.deck = newDeck();
        this.toMove = 0;
        this.isClockwise = isClockwise;
    }

    public Game(List<Player> players, List<Card> deck, boolean isClockwise) {
        this.players = players;
        this.deck = newDeck();
        this.toMove = 0;
        this.isClockwise = isClockwise;
    }

    public Game(List<Player> players, List<Card> deck, Card lastPlayed, int toMove, boolean isClockwise, List<Card> discardPile) {
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

    public int getNextPlayer() {
        int nextPlayer;

        if (isClockwise) {
            nextPlayer = (toMove + 1) % players.size();
        } else {
            nextPlayer = (toMove + players.size() - 1) % players.size();
        }

        return nextPlayer;
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

    /**
     * Remove top drawAmount cards from deck
     * Add removed cards to player's hand
     * @param drawAmount amount of cards to draw
     * @param player player
     */
    public void draw(int drawAmount, int player) {
        List<Card> cards;

        if (drawAmount <= deck.size()) {
            cards = new ArrayList<>(deck.subList(0, drawAmount));
            deck.subList(0, drawAmount).clear();

        } else {
            int leftover = drawAmount - deck.size();
            cards = new ArrayList<>(deck);

            reshuffle();

            cards.addAll(deck.subList(0, leftover));
            deck.subList(0, leftover).clear();
        }

        players.get(player).drawCards(cards);
    }

    /**
     * From current player's hand, remove card at index n
     * Do card effect
     * Update lastPlayed and discardPile accordingly
     * @param n Card to play
     */
    public void play(int n) {
        Card played = players.get(toMove).playCard(n);

        played.playedEffect(this);

        lastPlayed = played;

        discardPile.add(played);
    }

    /**
     * Return the list of cards the player can play from their deck
     * @param player Player
     */
    public List<Card> getPlayerOptions(Player player) {
        return player.getPossibleMoves(lastPlayed);
    }

    /**
     * Return the Player's default move
     * @param player Player
     */
    public List<Card> getPlayerDefault(Player player) {
        return player.getDefaultMove(lastPlayed);
    }

    /**
     * Allow a Player to make a move, based on their input
     * move = -1 refers to drawing a card
     * Any other integer refers to the card they would like to play
     * @param player Player
     * @param move Player's desired move
     */
    public void makeMove(int player, int move) {
        if (move == -1) {
            draw(1, player);
        }
        else {
            play(move);
        }
    }

    public boolean checkGameOver() {
        return players.get(toMove).getHand().isEmpty();
    }

    public List<Card> newDeck() {
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

        return newDeck;
    }
}