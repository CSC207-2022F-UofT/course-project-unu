package UserProfilePage;

public class UserProfile{
    public String name;
    public int GamesPlayed;
    public int GamesWon;
    public float WinRate;


    public void UserProfile(String name){
        //Creates a new player
        this.name = name;
        this.GamesPlayed = 0;
        this.GamesWon = 0;
    }

    public void UserProfile(boolean outcome){
        //takes an input of win/loss and records a game
        this.GamesPlayed ++;
        if (outcome){
            this.GamesWon ++;
        }
        this.WinRate = this.GamesWon / this.GamesPlayed;
    }
}
