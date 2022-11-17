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

  /**
   * Return the index of an optimal move from Player's hand.
   * If a move doesn't exist, return -1.
   * @param playedCards the entire list of played cards. 
   */
  public int getBestMove(ArrayList<Card> playedCards) {
    // TODO - Sean: Weight the probs of each card based on how many are played
    // TODO - Sean: Option to give the bot 'super vision' so it knows what cards 
    // are in each players hand and in the deck

    return -1;
  }

  /**
   * Return the index of the highest botPriority move in the Player's hand.
   * @param lastPlayed the last played card in the Game.
   */
  public int getMoveFromGenericWeights(Card lastPlayed) {
    ArrayList<Card> possibleMoves = this.getPossibleMoves(lastPlayed);
    int bestMove = -1;
    int bestMoveScore = 0;
    int currentMoveScore = 0;

    // As a bot, we generally want to save our wild cards for later.

    for (int i = 0; i < possibleMoves.size(); i++) {
      Card card = possibleMoves.get(i);
      String cardType = card.getCardType();

      // TODO - Sean: To write clean code (open/closed), each card should implement (botPriority)
      currentMoveScore = card.botPriority();

      // if (cardType.equals("Number")) {
      //   currentMoveScore = 5;
      // } else if (cardType.equals("Reverse")) {
      //   currentMoveScore = 4;
      // } else if (cardType.equals("Skip")) {
      //   currentMoveScore = 3;
      // } else if (cardType.equals("Draw Two")) {
      //   currentMoveScore = 2;
      // } else if (cardType.equals("Draw Four")) {
      //   currentMoveScore = 1;
      // } else if (cardType.equals("Draw Four")) {
      //   currentMoveScore = 1;
      // }

      if (currentMoveScore > bestMoveScore) {
        bestMoveScore = currentMoveScore;
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
}
