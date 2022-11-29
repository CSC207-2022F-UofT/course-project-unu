package UI;

import interfaceAdapters.Controller;

import javax.swing.*;

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
     * the method that every UI component should implement
     */
    public abstract void generateScreen();

}
