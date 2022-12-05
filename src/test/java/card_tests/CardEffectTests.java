/*
package card_tests;

import cards.*;
import entities.players.Player;
import entities.players.RealPlayer;
import game.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import interfaceAdapters.Presenter;
import UI.*;

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
        cards.add(new NumberCard("0","Red", 1));
        cards.add(new NumberCard("0","Red", 1));
        cards.add(new NumberCard("1","Red", 1));
        cards.add(new NumberCard("1","Red", 1));
        cards.add(new NumberCard("2","Red", 1));


        View view = new ViewMethods(new GameManager());
        game = new Game(players, true, new Presenter(view));
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
        Card card = new ReverseCard("Reverse", "Red", 1);

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
        Card card = new SkipCard("Skip", "Red", 1);

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

        Card card = new PlusTwoCard("Plus2", "Red", 1);
        card.playedEffect(game);

        Assertions.assertEquals(game.getPlayers().get(game.getNextPlayer() - 1).getHand().size(), size + 2);

    }

    */
/**
     * Test WildCard effect.
     *//*

    @Test
    public void testWild() {
        Card card = new PlusTwoCard("Plus2", "Red", 1);
        card.playedEffect(game);
    }

    */
/**
     * Test Plus4Card effect.
     *//*

    @Test
    public void testPlus4() {
        int size = game.getPlayers().get(game.getNextPlayer()).getHand().size();

        Card card = new PlusTwoCard("Plus2", "Red", 1);
        card.playedEffect(game);

        Assertions.assertEquals(game.getPlayers().get(game.getNextPlayer() - 1).getHand().size(), size + 4);
    }
}
*/
