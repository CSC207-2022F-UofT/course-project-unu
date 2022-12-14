package entities;

import entities.cards.Card;

import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class BotPlayer extends Player {
	private final static String playerType = "bot";
	private final String difficulty;

	public BotPlayer(String name, String difficulty) {
		super(name);
		this.difficulty = difficulty;
	}

	public String getPlayerType() {
		return playerType;
	}

	/**
	 * get the best move fpr the bot player
	 * @param lastPlayed last played card
	 * @param nextPlayerHand next player's hand
	 * @return the index of the best move card
	 */
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

	/**
	 * get the best move
	 * @param lastPlayed last played card by the previous player
	 * @return the index of the best move card
	 */
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

	/**
	 * generate a random possible move
	 * @param lastPlayed last played card in the game
	 * @return the index of the move
	 */
	public int getRandomMove(Card lastPlayed) {
		List<Card> possibleMoves = this.getPossibleMoves(lastPlayed);
		int numberOfPossibleMoves = possibleMoves.size();

		if (numberOfPossibleMoves == 0) {
			return -1;
		}

		Random rand = new Random();

		return rand.nextInt(possibleMoves.size());
	}

	/**
	 * Is the next player about to Uno?
	 * 
	 * @param nextPlayerCards the next player's hand
	 */
	private int upsetNextPlayerWeight(List<Card> nextPlayerCards) {
		if (nextPlayerCards.size() <= 2) {
			return 10;
		}

		return 0;
	}

	/**
	 * Return the index of the Card the bot wants to play.
	 * Return -1 if the bot wants to draw a card.
	 * @param lastPlayed the last played card in the game
	 * @param nextPlayerHand the hand of the next player
	 */
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
