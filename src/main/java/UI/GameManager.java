package UI;

import javax.swing.*;

/**
 * the main class that starts the program
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