package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * UI component, extends the abstract class UIComponent
 * generates a window that show the card buttons of all the possible moves
 * after the user clicks on the play card button
 * the user can play a card after clicking on a card button
 */
public class PlayCardWindow extends UIComponent {

    JFrame window;
    JPanel playPanel;

    /**
     * constructor of PlayCardWindow, generates a screen and creates all the moves
     * @param c the controller that this UI component interacts with
     * @param cards a list of strings that represents all the possible moves
     */
    public PlayCardWindow(Controller c, List<String> cards) {
        super(c);
        generateScreen();
        createPossibleMoves(cards);
    }

    /**
     * creates the window of the play card page
     */
    public void generateScreen() {

        //create a main field
        window = super.createMainField("Choose Cards", 250, 200);

        //set background
        playPanel = new JPanel();
        playPanel.setBounds(0, 0, 250, 200);
        playPanel.setLayout(null);
        window.add(playPanel);
    }

    /**
     * show all the possible moves on the screen
     * @param possibleMoves a list of strings the represents all the possible moves of the real player
     */
    public void createPossibleMoves(List<String> possibleMoves) {
        JButton[] cardButtons = new JButton[possibleMoves.size()];
        for (int i=0; i< cardButtons.length; i++) {
            int cardX = 50*(i / 3);
            int cardY = 50*(i % 3);
            cardButtons[i] = createCardButtons(cardX, cardY, 50, 50, possibleMoves.get(i));
            playPanel.add(cardButtons[i]);
        }
    }

    /**
     * helper method that generates a card button provided with the card string
     * @param cardX x position
     * @param cardY y position
     * @param width card width
     * @param height card height
     * @param cardStr the string representation of a card
     * @return card button
     */
    public JButton createCardButtons(int cardX, int cardY, int width, int height, String cardStr) {

        JButton card = new JButton();
        card.setBounds(cardX, cardY, width, height);

        String cardText = super.getCardText(cardStr);
        Color cardColor = getCardColor(cardStr);
        if (cardColor == Color.yellow) {
            card.setForeground(Color.black);
        } else {
            card.setForeground(Color.white);
        }

        card.setText(cardText);
        card.setBackground(cardColor);
        card.setOpaque(true);
        card.setFont(new Font("Monospace", Font.PLAIN, 30));
        card.setHorizontalAlignment(SwingConstants.CENTER);
        card.setBorder(BorderFactory.createLineBorder(Color.white));
        card.addActionListener(e -> {
            if (cardStr.equals("W") || cardStr.equals("+4")) {
                //if the card is a wild card then create a colour choosing page and play card after select colour
                new ChooseColourPage(c, cardStr);
            } else {
                c.playCard(cardStr);
            }
            window.setVisible(false);
        });

        return card;
    }
}
