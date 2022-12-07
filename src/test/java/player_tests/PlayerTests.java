package player_tests;

import entities.Player;
import entities.RealPlayer;
import entities.CardFactory;
import cards.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTests {

    Player player;
    CardFactory cardFactory = new CardFactory();

    @BeforeEach
    public void setup() {
        player = new RealPlayer("player1");

        List<Card> cards = new ArrayList<>();
        cards.add(cardFactory.getCard("1", "red"));
        cards.add(cardFactory.getCard("plusFour"));
        cards.add(cardFactory.getCard("skip", "blue"));

        player.drawCards(cards);
    }

    @AfterEach
    public void teardown() {

    }
    /**
     * Test that the player has three cards after setup.
     */
    @Test
    public void testDrawCardsSize() {
        Assertions.assertEquals(3, player.getHand().size());
    }

    /**
     * Test if a card was added to the player's hand.
     */
    @Test
    public void testDrawOne() {
        List<Card> newCards = new ArrayList<>();
        newCards.add(cardFactory.getCard("2", "blue"));
        player.drawCards(newCards);

        Assertions.assertEquals(4, player.getHand().size());
    }

    /**
     * Test that playCard makes the player's hand smaller.
     */
    @Test
    public void testPlayCardSize() {
        player.playCard(0);
        Assertions.assertEquals(2, player.getHand().size());
    }

    /**
     * Test that playCard() returns the correct Card value.
     */
    @Test
    public void testPlayCardReturnValue() {
        Assertions.assertEquals("1", player.playCard(0).getCardType());
    }

}
