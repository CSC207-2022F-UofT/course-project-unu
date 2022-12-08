package useCases.UserProfilePage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerRanking {
    public List<UserProfile> Profiles;

    public void PlayerRanking(List<UserProfile> Profiles){
        this.Profiles = Profiles;
    }

    public List<String> getRankByGames() {
        ArrayList<String> RankByGames = new ArrayList<String>();
        //An ArrayList to store user's names
        ArrayList<Integer> Games = new ArrayList<Integer>();
        //An ArrayList to store user's Games played
        for(UserProfile Profile: this.Profiles){
            Games.add(Profile.GamesPlayed);
        }
        Collections.sort(Games);
        for(Integer game: Games){
            for(UserProfile Profile: this.Profiles){
                if(Profile.GamesPlayed == game){
                    RankByGames.add(Profile.name);
                }
            }
        }
        return RankByGames;
    }

    public List<String> getRankByWins() {
        ArrayList<String> RankByWins = new ArrayList<String>();
        //An ArrayList to store user's names
        ArrayList<Integer> Wins = new ArrayList<Integer>();
        //An ArrayList to store user's Wins
        for(UserProfile Profile: this.Profiles){
            Wins.add(Profile.GamesWon);
        }
        Collections.sort(Wins);
        for(Integer win: Wins){
            for(UserProfile Profile: this.Profiles){
                if(Profile.GamesWon == win){
                    RankByWins.add(Profile.name);
                }
            }
        }
        return RankByWins;
    }

    public List<String> getRankByWinrate() {
        ArrayList<String> RankByWinrate = new ArrayList<String>();
        //An ArrayList to store user's names
        ArrayList<Float> Winrates = new ArrayList<Float>();
        //An ArrayList to store user's Winrate
        for(UserProfile Profile: this.Profiles){
            Winrates.add(Profile.WinRate);
        }
        Collections.sort(Winrates);
        for(Float winrate: Winrates){
            for(UserProfile Profile: this.Profiles){
                if(Profile.GamesWon == winrate){
                    RankByWinrate.add(Profile.name);
                }
            }
        }
        return RankByWinrate;
    }
}
