package entities;

import moves.Moves;

public class RealPlayer extends Player implements Moves{

    private final static String playerType = "real";

    public RealPlayer(String name){
        super(name);
    }

    public String getPlayerType() {
        return playerType;
    }
}
