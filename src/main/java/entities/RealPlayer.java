package entities;


public class RealPlayer extends Player{

    private final static String playerType = "real";

    public RealPlayer(String name){
        super(name);
    }

    public String getPlayerType() {
        return playerType;
    }
}
