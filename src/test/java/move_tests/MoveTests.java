package move_tests;

import cards.Card;
import cards.NumberCard;
import cards.PlusTwoCard;
import cards.ReverseCard;
import entities.Player;
import entities.RealPlayer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveTests {
    @Test
    public void noPossibleMoves1() {
        Card card1 = new NumberCard("1", "Blue");
        Card card2 = new ReverseCard("3", "Red");
        Card card3 = new PlusTwoCard("Plus2", "Yellow");
        Card middle = new NumberCard("5", "Green");
        List<Card> cards = new ArrayList<>(Arrays.asList(card1, card2, card3));

        Player testPlayer = new RealPlayer("Test");
        testPlayer.drawCards(cards);
        List<Card> possibleMoves = testPlayer.getPossibleMoves(middle);

        Assertions.assertEquals(0, possibleMoves.size());
    }
}
