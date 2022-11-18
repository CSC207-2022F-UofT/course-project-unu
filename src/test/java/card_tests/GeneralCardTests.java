package card_tests;

import cards.Card;
import cards.NumberCard;
import cards.WildCard;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GeneralCardTests {

    Card card1;
    Card card2;
    Card card3;

    @Before
    public void setup() {
         card1 = new NumberCard("0", "Red");
         card2 = new NumberCard("1", "Red");
         card3 = new NumberCard("1", "Blue");
    }

    @After
    public void teardown() {

    }

    /**
     * Checks if a card's type and colour is correct.
     */
    @Test
    public void testCardCreation() {
        String type = "0";
        String colour = "Red";
        Card card = new NumberCard(type, colour);

        Assert.assertEquals(card.getCardType(), type);
        Assert.assertEquals(card.getColour(), colour);

        Card wild = new WildCard(type);

        Assert.assertEquals(wild.getCardType(), type);
        Assert.assertEquals(wild.getColour(), type);

    }

    /**
     * Tests if cards' type match correctly.
     */
    @Test
    public void testMatchingType() {

        Assert.assertNotEquals(card1.getCardType(), card2.getCardType());

        Assert.assertEquals(card2.getCardType(), card3.getCardType());
    }

    /**
     * Tests if cards' colour match correctly.
     */
    @Test
    public void testMatchingColour() {

        Assert.assertEquals(card1.getColour(), card2.getColour());

        Assert.assertNotEquals(card2.getColour(), card3.getColour());
    }

    /**
     * Checks if a card successfully changes colour.
     */
    @Test
    public void testSetNewColour() {
        String oldColour = "Wild";
        String newColour = "Red";

        Card wild = new WildCard(oldColour);

        Assert.assertEquals(wild.getColour(), oldColour);

        wild.setColour(newColour);

        Assert.assertEquals(wild.getColour(), newColour);
    }
}
