package entities.players;

import entities.cards.Card;

import java.util.ArrayList;

public class RealPlayer extends Player implements Moves{

    private final static String playerType = "real";

    public RealPlayer(String name){
        super(name);
    }

    public String getPlayerType() {
        return playerType;
    }

    /**
     * Return whether a user can play a desired move.
     * @param playerChoice the index of the selected card in the player's hand
     * @param lastPlayed the last played card in Game
     */
    public boolean isAllowedMove(int playerChoice, Card lastPlayed) {
        ArrayList<Card> allowedMoves = this.getPossibleMoves(lastPlayed);

        return allowedMoves.contains(this.getHand().get(playerChoice));
    }
}
