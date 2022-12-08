package use_case_tests;
import entities.cards.WildCard;
import entities.BotPlayer;
import entities.Player;
import entities.RealPlayer;
import useCases.Presenter_Interface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import useCases.GameFacade;

import java.util.Arrays;
import java.util.List;


public class GameFacadeTests {
    Presenter_Interface presenter;
    Player p1 = new RealPlayer("p1");
    Player p2 = new BotPlayer("p2", "easy");
    List<Player> players = Arrays.asList(p1, p2);
    GameFacade gameFacade = new GameFacade(players, presenter, false);

    /**
     * setColour() in ChangeColour should change the colour of the last card played.
     */
    @Test
    public void setColourTest() {
        WildCard wild = new WildCard("w", 1);
        gameFacade.getGameState().setLastPlayed(wild);

        gameFacade.setColour("r");
        String colour = gameFacade.getGameState().getLastPlayed().getColour();
        Assertions.assertEquals("r", colour);

        gameFacade.setColour("b");
        String colour2 = gameFacade.getGameState().getLastPlayed().getColour();
        Assertions.assertEquals("b", colour2);
    }

    /**
     * changeDirection() should change the turn order of the game.
     */
    @Test
    public void changeDirectionTest() {
        boolean direction1 = gameFacade.getGameState().getIsClockwise();

        gameFacade.changeDirection();

        boolean direction2 = gameFacade.getGameState().getIsClockwise();

        Assertions.assertEquals(!direction1, direction2);
    }

    /**
     * setNextTurn() should change toMove.
     */
    @Test
    public void changeTurnTest() {
        int toMove1 = gameFacade.getGameState().getToMove();

        gameFacade.setNextTurn();

        int toMove2 = gameFacade.getGameState().getToMove();

        Assertions.assertNotEquals(toMove1, toMove2);
    }
}
