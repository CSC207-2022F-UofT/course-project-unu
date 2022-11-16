package UI;


import javax.swing.*;


/**
 * the Main class that the users interact with
 */
public class GameManager {


    StartPage ui = new StartPage(this);

    public static void main(String[] args) {

        new GameManager();
    }
    
    public GameManager() {

    }

    ActionHandler aHandler;
    ViewMethods ui;

    public GameManager() {
        this.ui = new ViewMethods(this);
        this.aHandler = new ActionHandler(this);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(GameManager::new);

    }
    

}
