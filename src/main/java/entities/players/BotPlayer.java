package entities.players;
import entities.cards.Card;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class BotPlayer extends Player implements ComputerMoves {
  private final static String playerType = "bot";

  public BotPlayer(String name) {
    super(name);
  }

  public String getPlayerType() {
    return playerType;
  }

  /**
   * Return the index of an optimal move from Player's hand.
   * If a move doesn't exist, return -1.
   * @param playedCards the entire list of played cards.
   */
  public int getBestMove(ArrayList<Card> playedCards, ArrayList<Card> nextPlayerHand) {
    int numberOfPlayed = playedCards.size();
    Card lastPlayed = playedCards.get(numberOfPlayed - 1);
    ArrayList<Card> possibleMoves = this.getPossibleMoves(lastPlayed);

    int bestMove = -1;
    int bestMovePriority = 0;

    for (int i = 0; i < possibleMoves.size(); i++) {
      Card card = possibleMoves.get(i);

      int cardPriority = card.getBotPriority();

      // Make sure the next player doesn't win
      if (Arrays.asList("Plus4", "Plus2", "Skip", "Reverse").contains(card.getCardType())) {
        cardPriority += upsetNextPlayerWeight(nextPlayerHand);
      }

      if (cardPriority > bestMovePriority) {
        bestMovePriority = cardPriority;
        bestMove = i;
      }
    }

    return bestMove;
  }

  /**
   * Return the index of the highest botPriority move in the Player's hand.
   * @param lastPlayed the last played card in the Game.
   */
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

  /**
   * Return the index of the from Player's hand of a random Card that Player can play.
   * If a move doesn't exist, return -1
   * @param lastPlayed the last played card in Game
   */
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
  private int upsetNextPlayerWeight(ArrayList<Card> nextPlayerCards) {
    if (nextPlayerCards.size() <= 2) {
      return 10;
    }

    return 0;
  }
}
