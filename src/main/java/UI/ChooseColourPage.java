package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * UI component, extends the abstract class UIComponent
 * creates a colour-choosing page that allows the user to choose a colour after a
 * wild card is played
 * the chosen colour will be the new colour theme of the game
 */
public class ChooseColourPage extends UIComponent {

    JFrame window;
    JPanel colourPanel;
    public ChooseColourPage(Controller c) {
        super(c);
        generateScreen();
    }

    /**
     * generate the colour choosing page screen
     */
    public void generateScreen() {

        //create a main field
        window = super.createMainField("Choose Cards", 250, 200);

        //set background
        colourPanel = new JPanel();
        colourPanel.setBounds(0, 0, 250, 200);
        colourPanel.setLayout(null);
        window.add(colourPanel);

        //set up the colour buttons so each button can pass the new chosen colour to the controller
        String[] colourStr = {"red", "yellow", "green", "blue"};
        Color[] colours = {Color.red, Color.yellow, Color.green, Color.blue};
        for (int i=0; i<4; i++) {
            JButton colorButton = new JButton(colourStr[i]);
            colorButton.setBounds(55+70*(i/2), 15+70*(i%2), 70, 70);
            colorButton.setBackground(colours[i]);
            colorButton.setOpaque(true);
            int finalI = i;
            colorButton.addActionListener(e -> {
                c.changeColour(colourStr[finalI]);
                window.setVisible(false);
            });
            colourPanel.add(colorButton);
        }
    }
}
