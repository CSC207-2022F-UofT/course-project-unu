package moves;
// import cards.Card;

public interface ComputerMoves extends Moves {
    int getBestMove();

    int getRandomMove();
    
    int getMovesFromWeights();
}
