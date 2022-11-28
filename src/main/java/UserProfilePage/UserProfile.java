package UserProfilePage;

public class UserProfile{
    public String name;
    public int GamesPlayed;
    public int GamesWon;
    public float WinRate;


    /**
     * Creates a new player with the given name.
     * @param name
     */
    public void UserProfile(String name){
        this.name = name;
        this.GamesPlayed = 0;
        this.GamesWon = 0;
    }

    /**
     * Record a new game to the profile of the player.
     * @param outcome
     */
    public void newGameResult(boolean outcome){
        this.GamesPlayed ++;
        if (outcome){
            this.GamesWon ++;
        }
        this.WinRate = this.GamesWon / this.GamesPlayed;
    }
}
