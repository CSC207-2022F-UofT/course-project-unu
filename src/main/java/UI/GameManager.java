package UI;

import javax.swing.*;

/**
 * the Main class that the users interact with
 */
public class GameManager {

    //StartPage ui = new StartPage(this);

    public GameManager() {new StartPage(this);}

    public static void main(String[] args) {

        SwingUtilities.invokeLater(GameManager::new);

        //new GameManager();
    }
    

}
