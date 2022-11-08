package TeamMode;


import java.util.List;

public class TeamMode extends Game{
    private TeamPlayer[] players;
    public TeamMode(){

    }
    public TeamMode(TeamPlayer[] players){
        this.players=players;
    }

    public TeamPlayer[] getAllPlayers(){
        return players;
    }
    //override of checkGameOver
    //start
}
