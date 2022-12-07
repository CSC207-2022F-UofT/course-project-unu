package UserProfilePage;

public class UserProfile{
    public String name;
    public int GamesPlayed;
    public int GamesWon;
    public float WinRate;


    /**
     * Creates a new player with the given name.
     * @param name is the name of the player, which is a string
     */
    public UserProfile(String name){
        //constructor
        this.name = name;
        this.GamesPlayed = 0;
        this.GamesWon = 0;
        this.WinRate = 0.0f;
    }

    /**
     * Record a new game to the profile of the player.
     * @param outcome is the outcome of a game, true means this player had won, false means he lost
     */
    public void NewGameResult(boolean outcome){
        this.GamesPlayed ++;
        if (outcome){
            this.GamesWon ++;
        }
        this.WinRate = (float)this.GamesWon / this.GamesPlayed;
    }
    @Override
    public String toString(){
        //outputs this userprofile using a string
        return this.name + "/" + this.GamesPlayed + "/" + this.GamesWon;
    }

    public void StringTo(String str){
        //takes a string to setup a userprofile
        String[] parts = str.split("/");
        this.name = parts[0];
        this.GamesPlayed = Integer.parseInt(parts[1]);
        this.GamesWon = Integer.parseInt(parts[2]);
        if (this.GamesPlayed != 0){
            this.WinRate = (float)this.GamesWon / this.GamesPlayed;
        }
        else{
            this.WinRate = 0.0f;
        }

    }
}
