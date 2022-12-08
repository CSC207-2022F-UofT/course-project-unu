package entities.teammode;

public interface TeamPlayer {
    //to use the polymorphism of the clean architecture I created a teamMode interface which will help cast the player to this type
    //and connect two types of the players in the teamMode
    Team getTeam();
}
