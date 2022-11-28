/*
package card_tests;

import cards.*;
import entities.Player;
import entities.RealPlayer;
import game.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class CardEffectTests {

    Game game;

    @BeforeEach
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

    @AfterEach
    public void teardown() {

    }

    */
/*
    TODO: Test for the following things
    - All cardEffects
    - Their effects on Game data
     *//*


    */
/**
     * Test ReverseCard effect.
     *//*

    @Test
    public void testReverse() {
        Card card = new ReverseCard("Reverse", "Red");

        Assertions.assertEquals(game.getNextPlayer(), 1);

        card.playedEffect(game);

        Assertions.assertEquals(game.getNextPlayer(), 3);
    }

    */
/**
     * Test SkipCard effect.
     *//*

    @Test
    public void testSkip() {
        Card card = new SkipCard("Skip", "Red");

        Assertions.assertEquals(game.getNextPlayer(), 1);

        card.playedEffect(game);

        Assertions.assertEquals(game.getNextPlayer(), 2);

    }

    */
/**
     * Test Plus2Card effect.
     *//*

    @Test
    public void testPlus2() {

        int size = game.getPlayers().get(game.getNextPlayer()).getHand().size();

        Card card = new PlusTwoCard("Plus2", "Red");
        card.playedEffect(game);

        Assertions.assertEquals(game.getPlayers().get(game.getNextPlayer() - 1).getHand().size(), size + 2);

    }

    */
/**
     * Test WildCard effect.
     *//*

    @Test
    public void testWild() {
        Card card = new PlusTwoCard("Plus2", "Red");
        card.playedEffect(game);

    }

    */
/**
     * Test Plus4Card effect.
     *//*

    @Test
    public void testPlus4() {
        int size = game.getPlayers().get(game.getNextPlayer()).getHand().size();

        Card card = new PlusTwoCard("Plus2", "Red");
        card.playedEffect(game);

        Assertions.assertEquals(game.getPlayers().get(game.getNextPlayer() - 1).getHand().size(), size + 4);
    }

}
*/
