package UI;


import interfaceAdapters.Controller;

import javax.swing.*;

/**
 * the Main class that the users interact with
 */
public class GameManager {

    ViewMethods ui;

    public GameManager() {
        this.ui = new ViewMethods();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(GameManager::new);

    }
}