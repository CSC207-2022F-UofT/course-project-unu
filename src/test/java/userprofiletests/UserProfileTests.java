package userprofiletests;

import UserProfilePage.UserProfile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserProfileTests {
    UserProfile profile1;
    UserProfile profile2;
    UserProfile profile3;
    UserProfile profile4;


    @Test
    public void testProfileConstructor(){
        String name = "name";
        Integer DefaultGamesPlayed = 0;
        Integer DefaultGamesWon = 0;
        Float DefaultWinRate = 0.0f;

        profile1 = new UserProfile("name");

        Assertions.assertEquals(profile1.name, name);
        Assertions.assertEquals(profile1.GamesPlayed, DefaultGamesPlayed);
        Assertions.assertEquals(profile1.GamesWon, DefaultGamesWon);
        Assertions.assertEquals(profile1.WinRate, DefaultWinRate);
    }

    @Test
    public void testNewGameResult(){
        profile2 = new UserProfile("name");
        profile2.NewGameResult(true);
        Integer GamesPlayed = 1;
        Integer GamesWon = 1;
        Float WinRate = 1.0f;
        Assertions.assertEquals(profile2.GamesPlayed, GamesPlayed);
        Assertions.assertEquals(profile2.GamesWon, GamesWon);
        Assertions.assertEquals(profile2.WinRate, WinRate);
    }

    @Test
    public void testToString(){
        profile3 = new UserProfile("name");
        String str = "name/0/0";
        Assertions.assertEquals(profile3.toString(), str);
    }

    @Test
    public void testStringTo(){
        profile4 = new UserProfile("name");
        String str = "name2/0/0";
        String name2 = "name2";
        profile4.StringTo(str);
        Integer DefaultGamesPlayed = 0;
        Integer DefaultGamesWon = 0;
        Float DefaultWinRate = 0.0f;
        Assertions.assertEquals(profile4.name, name2);
        Assertions.assertEquals(profile4.GamesPlayed, DefaultGamesPlayed);
        Assertions.assertEquals(profile4.GamesWon, DefaultGamesWon);
        Assertions.assertEquals(profile4.WinRate, DefaultWinRate);
    }


}
