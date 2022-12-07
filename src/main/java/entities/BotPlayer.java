package entities;

import moves.ComputerMoves;
import cards.Card;
import java.util.Random;
import java.util.List;
import java.util.Arrays;

public class BotPlayer extends Player implements ComputerMoves {
	private final static String playerType = "bot";
	private String difficulty;

	public BotPlayer(String name, String difficulty) {
		super(name);
		this.difficulty = difficulty;
	}

	public String getPlayerType() {
		return playerType;
	}

	public int getBestMove(Card lastPlayed, List<Card> nextPlayerHand) {
		List<Card> possibleMoves = this.getPossibleMoves(lastPlayed);

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

	public int getMovesFromWeights(Card lastPlayed) {
		List<Card> possibleMoves = this.getPossibleMoves(lastPlayed);
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
		List<Card> possibleMoves = this.getPossibleMoves(lastPlayed);
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
	 * 
	 * @param nextPlayerCards
	 */
	private int upsetNextPlayerWeight(List<Card> nextPlayerCards) {
		if (nextPlayerCards.size() <= 2) {
			return 10;
		}

		return 0;
	}

	/**
	 * Return the card of the move to make based on the difficulty.
	 * 
	 * @param nextPlayerCards
	 */
	public Card makeMove(Card lastPlayed, List<Card> nextPlayerHand) {
		int toPlay = -1;

		if (this.difficulty.equals("easy")) {
			toPlay = getRandomMove(lastPlayed);
		}

		else if (this.difficulty.equals("medium")) {
			toPlay = getMovesFromWeights(lastPlayed);
		}

		else if (this.difficulty.equals("hard")) {
			toPlay = getBestMove(lastPlayed, nextPlayerHand);
		}

		if (toPlay == -1) {
			return this.playCard(toPlay);

		}

		return null;
	}

	public int getBotToPlay(Card lastPlayed, List<Card> nextPlayerHand) {
		int toPlay;

		if (this.difficulty.equals("easy")) {
			toPlay = getRandomMove(lastPlayed);
		}

		else if (this.difficulty.equals("medium")) {
			toPlay = getMovesFromWeights(lastPlayed);
		}

		else {
			toPlay = getBestMove(lastPlayed, nextPlayerHand);
		}

		return toPlay;
	}
}
