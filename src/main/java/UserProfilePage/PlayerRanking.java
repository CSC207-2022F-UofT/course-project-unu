package UserProfilePage;
import java.util.ArrayList;
import java.util.List;

public class PlayerRanking {
    public List<UserProfile> Profiles;

    public void PlayerRanking(List<UserProfile> Profiles){
        this.Profiles = Profiles;
    }

    // TOOD
    public static List<String> getRankByGames() {
        return new ArrayList<String>();
    }

    // TODO 
    public static List<String> getRankByWins() {
        return new ArrayList<String>();
    }

    // TODO
    public static List<String> getRankByWinrate() {
        return new ArrayList<String>();
    }
}
