package moves;

import cards.Card;

public interface ComputerMoves extends Moves {
    Card getBestMove();

    Card getRandomMove();
}
