package game;

import entities.Player;
import entities.RealPlayer;
import entities.CardFactory;
import cards.Card;
import interfaceAdapters.Presenter_Interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final List<Player> players;
    private List<Card> deck;
    private Card lastPlayed;
    private List<Card> discardPile = new ArrayList<>();
    private int toMove;
    private boolean isClockwise;
    private final Presenter_Interface presenter;

    public Game(List<Player> players, boolean isClockwise, Presenter_Interface presenter) {
        this.players = players;
        this.deck = newDeck();
        this.toMove = 3;
        this.isClockwise = isClockwise;
        this.presenter = presenter;
    }

    public int getToMove() {
        return this.toMove;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Presenter_Interface getPresenter() {
        return presenter;
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

    public void setToMove(int toMove) {
        this.toMove = toMove;
    }

    public void changeDirection() {
        isClockwise = !isClockwise;
    }

    public void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
    }

    // If the deck is empty, shuffle the discard pile into the deck
    public void reshuffle() {
        deck = new ArrayList<>(discardPile);
        deck.remove(lastPlayed);

        discardPile.clear();
        discardPile.add(lastPlayed);

        shuffleDeck(deck);
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

        if (players.get(player).getPlayerType().equalsIgnoreCase("real")) {
            String[] hand = convertHand(players.get(player).getHand());
            presenter.updateHand(hand);
        }
        //tell the UI that this player has drawn a card
        String playerName = "player" + (player + 1);
        presenter.updateDraw(playerName);
    }

    /**
     * From current player's hand, remove the card at index n
     * Do card effect
     * Update lastPlayed and discardPile
     * Update View with presenter
     * @param n index of Card to play
     */
    public void play(int n) {

        Card played = players.get(toMove).playCard(n);

        lastPlayed = played;
        discardPile.add(played);

        presenter.updateLastPlayed(convert(played), players.indexOf(toMove));

        if (players.get(toMove).getPlayerType().equalsIgnoreCase("real")) {
            String[] cards = convertHand(players.get(toMove).getHand());
            presenter.updateHand(cards);
        }

        played.playedEffect(this);
    }

    public void play(String card) {
        play(getIndexOf(card));
    }

    //Set colour of the played WildCard
    public void setColour(String colour) {
        lastPlayed.setColour(colour);
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
     * Call a presenter method that displays RealPlayer's card options as list of strings
     */
    public void displayRealPlayerOptions() {
        Player realPlayer = players.get(0);
        List<String> cards = new ArrayList<>();
        List<Card> possibleMoves = realPlayer.getPossibleMoves(lastPlayed);

        for (Card card: possibleMoves) {
            cards.add(convert(card));
        }

        presenter.displayOptions(cards);
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

    /**
     * Game Setup: Each player draws 7 cards.
     * The top card of the deck is flipped over if it isn't a Wild card.
     * Do effect of flipped card as if the player before the first player had just played it
     */
    public void setup() {
        for (int i = 0; i < players.size(); i++) {
            draw(7, i);
        }

        while (deck.get(0).getCardType().equalsIgnoreCase("plusFour") ||
                deck.get(0).getCardType().equalsIgnoreCase("wild")) {
            shuffleDeck(deck);
        }

        lastPlayed = deck.remove(0);
        lastPlayed.playedEffect(this);
        setToMove(getNextPlayer());

    }

    //Return the index of the card with the given string representation.
    private int getIndexOf(String card) {
        String cardType;
        String colour;
        Card check;
        CardFactory cardFactory = new CardFactory();

        if (card.contains("W")) {
            check = cardFactory.getCard("wild");
            return players.get(toMove).getHand().indexOf(check);
        } else if (card.contains("+4")) {
            check = cardFactory.getCard("plusFour");
            return players.get(toMove).getHand().indexOf(check);
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
        return players.get(toMove).getHand().indexOf(check);
    }

    //Return the string representation of the given card.
    private String convert(Card card) {
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

    private String[] convertHand(List<Card> hand) {
        String[] cards = new String[hand.size()];

        for (int i = 0; i < cards.length; i++) {
            cards[i] = convert(hand.get(i));
        }

        return cards;
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