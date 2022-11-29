package move_tests;

import cards.*;
import entities.Player;
import entities.RealPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleMovesTests {
    Card card1 = new NumberCard("1", "Blue");
    Card card2 = new ReverseCard("Reverse", "Red");
    Card card3 = new PlusTwoCard("Plus2", "Yellow");
    List<Card> cards = Arrays.asList(card1, card2, card3);
    Player testPlayer = new RealPlayer("Test");

    @BeforeEach
    public void setup() {
        testPlayer.drawCards(cards);
    }

    /**
     * getPossibleMoves() should return an empty list when there are no possible moves.
     */
    @Test
    public void noPossibleMoves() {
        Card middle = new NumberCard("5", "Green");
        List<Card> possibleMoves = testPlayer.getPossibleMoves(middle);

        Assertions.assertEquals(0, possibleMoves.size());
    }

    /**
     * Wild cards in Player deck should always be a possible move.
     */
    @Test
    public void wildCard() {
        Card wildCard = new WildCard("Wild");
        List<Card> wild = new ArrayList<>();
        wild.add(wildCard);
        testPlayer.drawCards(wild);

        Card middle = new NumberCard("5", "Green");
        List<Card> possibleMoves = testPlayer.getPossibleMoves(middle);

        Assertions.assertEquals(1, possibleMoves.size());
        Assertions.assertEquals("Wild", possibleMoves.get(0).getCardType());
    }

    /**
     * Cards with a matching type should be in the list returned by getPossibleMoves().
     */
    @Test
    public void typeCard() {
        Card middle = new ReverseCard("Reverse", "Green");
        List<Card> possibleMoves = testPlayer.getPossibleMoves(middle);

        Assertions.assertEquals(1, possibleMoves.size());
        Assertions.assertEquals(card2.getCardType(), possibleMoves.get(0).getCardType());
    }

    /**
     * Cards with a matching colour should be in the list returned by getPossibleMoves().
     */
    @Test
    public void colourCard() {
        Card middle = new NumberCard("8", "Red");
        List<Card> possibleMoves = testPlayer.getPossibleMoves(middle);

        Assertions.assertEquals(1, possibleMoves.size());
        Assertions.assertEquals(card2.getColour(), possibleMoves.get(0).getColour());
    }
}
