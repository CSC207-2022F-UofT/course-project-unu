package UserProfilePage;
import java.util.ArrayList;
import java.util.List;
import entities.Player;

public class RecordGame {
    public List<Player> PlayerList;
    public List<Player> Winners;

    public void RecordGame(List<Player> PlayerList, List<Player> Winners){
        this.PlayerList = PlayerList;
        this.Winners = Winners;

        // for (Player player: PlayerList){
        //     if (this.Winners.contains(player)){
        //         player(true);
        //     }
        //     else {
        //         player(false);
        //     }
        // }
    }
}
