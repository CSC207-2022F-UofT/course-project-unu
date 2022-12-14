package card_tests;

import entities.cards.Card;
import entities.cards.NumberCard;
import entities.cards.WildCard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GeneralCardTests {

    Card card1;
    Card card2;
    Card card3;

    @BeforeEach
    public void setup() {
         card1 = new NumberCard("0", "Red", 1);
         card2 = new NumberCard("1", "Red", 1);
         card3 = new NumberCard("1", "Blue", 1);
    }

    @AfterEach
    public void teardown() {

    }

    /**
     * Checks if a card's type and colour is correct.
     */
    @Test
    public void testCardCreation() {
        String type = "0";
        String colour = "Red";
        Card card = new NumberCard(type, colour, 1);

        Assertions.assertEquals(card.getCardType(), type);
        Assertions.assertEquals(card.getColour(), colour);

        Card wild = new WildCard(type, 1);

        Assertions.assertEquals(wild.getCardType(), type);
        Assertions.assertEquals(wild.getColour(), type);

    }

    /**
     * Tests if cards' type match correctly.
     */
    @Test
    public void testMatchingType() {

        Assertions.assertNotEquals(card1.getCardType(),
                card2.getCardType());

        Assertions.assertEquals(card2.getCardType(), card3.getCardType());
    }

    /**
     * Tests if cards' colour match correctly.
     */
    @Test
    public void testMatchingColour() {

        Assertions.assertEquals(card1.getColour(),
                card2.getColour());

        Assertions.assertNotEquals(card2.getColour(), card3.getColour());
    }

    /**
     * Checks if a card successfully changes colour.
     */
    @Test
    public void testSetNewColour() {
        String oldColour = "Wild";
        String newColour = "Red";

        Card wild = new WildCard(oldColour, 1);

        Assertions.assertEquals(wild.getColour(), oldColour);

        wild.setColour(newColour);

        Assertions.assertEquals(wild.getColour(), newColour);
    }
}
