package entities;
import moves.ComputerMoves;
import cards.Card;
import java.util.Random;
import java.util.ArrayList;

public class BotPlayer extends Player implements ComputerMoves {
  private final static String playerType = "bot";

  public BotPlayer(String name) {
    super(name);
  }

  public String getPlayerType() {
    return playerType;
  }


  public int getBestMove(ArrayList<Card> playedCards) {
    int numberOfPlayed = playedCards.size();
    Card lastPlayed = playedCards.get(numberOfPlayed - 1);
    ArrayList<Card> possibleMoves = this.getPossibleMoves(lastPlayed);

    if (possibleMoves.size() == 0) {
      return -1;
    }

    return getRandomMove(lastPlayed);
  }

  public int getMovesFromWeights(Card lastPlayed) {
    ArrayList<Card> possibleMoves = this.getPossibleMoves(lastPlayed);
    int bestMove = -1;
    int bestMovePriority = 0;

    for (int i = 0; i < possibleMoves.size(); i++) {
      Card card = possibleMoves.get(i);

      // pass is next player uno? 
      int cardPriority = card.getBotPriority();

      // As a bot, we generally want to save our wild cards for later.
      // Number (6), Reverse (5), Skip (4), Wild(3), Draw Two (2), Draw Four (1)
      if (cardPriority > bestMovePriority) {
        bestMovePriority = cardPriority;
        bestMove = i;
      }
    }

    return bestMove;
  }

  public int getRandomMove(Card lastPlayed) {
    ArrayList<Card> possibleMoves = this.getPossibleMoves(lastPlayed);
    int numberOfPossibleMoves = possibleMoves.size();

    if (numberOfPossibleMoves == 0) {
      return -1;
    }

    Random rand = new Random();
    int n = rand.nextInt(possibleMoves.size());

    return n;
  }
  
  /**
   * Is the next player about to Uno?
   * @param nextPlayerCards
   */
  private boolean isNextPlayerUno(ArrayList<Card> nextPlayerCards) {
    return nextPlayerCards.size() == 1;
  }
}
