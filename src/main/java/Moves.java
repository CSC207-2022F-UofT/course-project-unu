import package.cards;

interface Moves {
    List<Card> getPossibleMoves();
    void drawCard();
    void makeMove();
}

interface ComputerMoves extends Moves {
    void makeBestMove();
    void makeRandomMove();
}
