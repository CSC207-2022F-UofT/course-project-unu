package UI;


import interfaceAdapters.Controller;

import javax.swing.*;

/**
 * the Main class that the users interact with
 */
public class GameManager {


    Controller c;
    ViewMethods ui;

    public GameManager() {
        this.ui = new ViewMethods(this);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(GameManager::new);

    }
}