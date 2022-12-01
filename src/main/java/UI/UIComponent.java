package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * An abstract super class of all the UI component classes
 * defines methods share by all UI components like createMainField() and generateScreen()
 */
public abstract class UIComponent {

    Controller c;

    /**
     *
     * @param c The controller of this game that each UI component interacts with, takes the input from UI
     */
    public UIComponent(Controller c) {
        this.c = c;
    }

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