package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * An abstract super class of all the UI component classes
 * defines methods share by all UI components like createMainField() and generateScreen()
 */
public abstract class UIComponent {

    Controller c;

    /**
     * Constructor of a UIComponent
     * @param c The controller of this game that each UI component interacts with, takes the input from UI
     */
    public UIComponent(Controller c) {
        this.c = c;
    }

    /**
     * constructor for UI components that do not take any user input (no controller)
     */
    public UIComponent(){}

    /**
     * the method that every UI component should implement
     */
    public abstract void generateScreen();

    /**
     * create the main window of this page
     * @param screenName the page name displayed at the top of the window
     * @param width window width
     * @param height window height
     * @return the initialized main window
     */
    public JFrame createMainField(String screenName, int width, int height) {
        JFrame window = new JFrame();
        window.setSize(width, height);
        window.setTitle(screenName);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the windows properly
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        return window;
    }

    /**
     * set the background given the window
     * @param window main window
     * @param width background width
     * @param height background height
     * @return background label
     */
    public JLabel setBackground(JFrame window, int width, int height) {
        JPanel pagePanel = new JPanel();
        pagePanel.setBounds(0, 0, width, height);
        pagePanel.setLayout(null);
        window.add(pagePanel);
        JLabel pageLabel = new JLabel();
        pageLabel.setBounds(0, 0, width, height);
        pageLabel.setIcon(adjustedImage("/bg.jpg", width, height));
        pagePanel.add(pageLabel);
        return pageLabel;
    }

    /**
     * adjust an image's size, so it fits the required scale
     * @param address the image file address
     * @param width icon width
     * @param height icon height
     * @return an ImageIcon that can be set to a label
     */
    public ImageIcon adjustedImage(String address, int width, int height) {
        ImageIcon startBG = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(address)));
        Image bg = startBG.getImage();
        Image adjustedBg = bg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(adjustedBg);
    }

    /**
     * get the text that will be displayed on the card label
     * @param cardStr the string representation of a card
     * @return card text
     */
    public String getCardText(String cardStr) {
        String cardText;
        if (cardStr.equals("+4") || cardStr.equals("W")) {
            cardText = cardStr;
        } else {
            String[] splitCard = cardStr.split("-");
            cardText = splitCard[0];
        }
        return cardText;
    }

    /**
     * get the colour that will be displayed on the card label
     * @param cardStr the string representation of a card
     * @return card colour
     */
    public Color getCardColor(String cardStr) {
        Color cardColor = Color.white;
        if (cardStr.equals("+4") || cardStr.equals("W")) {
            cardColor = Color.black;
        } else {
            String[] splitCard = cardStr.split("-");
            String colour = splitCard[1];
            switch (colour) {
                case "red":
                    cardColor = Color.red;
                    break;
                case "yellow":
                    cardColor = Color.yellow;
                    break;
                case "green":
                    cardColor = Color.green;
                    break;
                case "blue":
                    cardColor = Color.blue;
                    break;
            }
        }
        return cardColor;
    }

}
