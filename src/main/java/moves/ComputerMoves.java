package moves;
import cards.Card;
import java.util.ArrayList;

public interface ComputerMoves extends Moves {
    /**
     * Return the index of an optimal move from Player's hand.
     * If a move doesn't exist, return -1.
     * @param playedCards the entire list of played cards. 
     */
    int getBestMove(ArrayList<Card> playedCards, ArrayList<Card> nextPlayerHand);

    /**
     * Return the index of the from Player's hand of a random Card that Player can play.
     * If a move doesn't exist, return -1 
     * @param lastPlayed the last played card in Game
     */
    int getRandomMove(Card lastPlayed);
    
    /**
     * Return the index of the highest botPriority move in the Player's hand.
     * @param lastPlayed the last played card in the Game.
     */
    int getMovesFromWeights(Card lastPlayed);
}
