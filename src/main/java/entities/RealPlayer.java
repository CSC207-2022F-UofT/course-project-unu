package entities;

import cards.Card;
import moves.Moves;

import java.util.ArrayList;
import java.util.List;

public class RealPlayer extends Player implements Moves{

    private final static String playerType = "real";

    public RealPlayer(String name){
        super(name);
    }

    public String getPlayerType() {
        return playerType;
    }

    public void makeMove(Card lastPlayed) {
        List<Card> possibleMoves = getPossibleMoves(lastPlayed);

        // Implementation depends on how player input is retrieved from UI
        }
    }
}
