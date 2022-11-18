package card_tests;

import cards.*;
import entities.Player;
import entities.RealPlayer;
import game.Game;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class CardEffectTests {

    Game game;

    @Before
    public void setup() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new RealPlayer("Player 1"));
        players.add(new RealPlayer("Player 2"));
        players.add(new RealPlayer("Player 3"));
        players.add(new RealPlayer("Player 4"));

        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new NumberCard("0","Red"));
        cards.add(new NumberCard("0","Red"));
        cards.add(new NumberCard("1","Red"));
        cards.add(new NumberCard("1","Red"));
        cards.add(new NumberCard("2","Red"));

        game = new Game(players, cards, true);
    }

    @After
    public void teardown() {

    }

    /*
    TODO: Test for the following things
    - All cardEffects
    - Their effects on Game data
     */

    /**
     * Test ReverseCard effect.
     */
    @Test
    public void testReverse() {
        Card card = new ReverseCard("Reverse", "Red");

        Assert.assertEquals(game.getNextPlayer(), 1);

        card.playedEffect(game);

        Assert.assertEquals(game.getNextPlayer(), 3);
    }

    /**
     * Test SkipCard effect.
     */
    @Test
    public void testSkip() {
        Card card = new SkipCard("Skip", "Red");

        Assert.assertEquals(game.getNextPlayer(), 1);

        card.playedEffect(game);

        Assert.assertEquals(game.getNextPlayer(), 2);

    }

    /**
     * Test Plus2Card effect.
     */
    @Test
    public void testPlus2() {
        Card card = new PlusTwoCard("Plus2", "Red");

        Assert.assertEquals(game.getNextPlayer(), 1);

        card.playedEffect(game);

        Assert.assertEquals(game.getNextPlayer(), 2);

    }

    /**
     * Test WildCard effect.
     */
    @Test
    public void testWild() {

    }

    /**
     * Test Plus4Card effect.
     */
    @Test
    public void testPlus4() {

    }

}
