package moves;

import java.util.ArrayList;
import cards.Card;

public interface Moves {
    /**
     * Return a list of Card objects from Player's hand that Player can play.
     * If there are no possible moves, return an empty list.
     * @param lastPlayed the last played card in Game
     */
    ArrayList<Card> getPossibleMoves(Card lastPlayed);

    /**
     * Return a list containing a Card object from Player's hand that Player can play.
     * This Card corresponds to the default move the game will play for the Player.
     * An empty list corresponds to drawing a Card from the deck.
     * @param lastPlayed the last played card in Game
     */
    ArrayList<Card> getDefaultMove (Card lastPlayed);
}

