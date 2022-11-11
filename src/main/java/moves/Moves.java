package moves;

import java.util.List;
import cards.Card;

public interface Moves {
    /**
     * Return a list of Card objects from Player's hand that Player can play.
     * If there are no possible moves, return an empty list.
     * @param lastPlayed the last played card in Game
     */
    List<Card> getPossibleMoves(Card lastPlayed);

    void makeMove(Card lastPlayed);
}

