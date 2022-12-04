package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * UI component, extends the abstract class UIComponent
 * shows the real player the game result (win or lose)
 * allows the user to view the score board and user profile (text-based)
 * allows the user to start a new game
 */
public class ResultPage extends UIComponent{

    JFrame window;
    JLabel resultLabel;
    String resultMessage;

    /**
     * Constructor of ResultPage
     * @param c the controller that the result page interacts with
     * @param isWin if the user won the game, isWin is true, vice versa
     */
    public ResultPage(Controller c, boolean isWin) {
        super(c);
        if (isWin) {
            this.resultMessage = "WIN";
        } else {
            this.resultMessage = "LOSE";
        }
        generateScreen();
    }

    /**
     * generate the main screen of the result page
     */
    public void generateScreen() {

        //create main field
        window = super.createMainField("Result Page", 700, 500);

        //set background
        resultLabel = super.setBackground(window, 700, 500);

        //add result text
        resultLabel.add(result(resultMessage));
        addResultPageButtons(resultLabel);
    }

    /**
     * generate a label that shows the result message ("YOU WIN" or "YOU LOSE")
     * @param resultMessage "WIN or "LOSE"
     * @return a JLabel that shows the text
     */
    public JLabel result(String resultMessage) {
        JLabel result = new JLabel("YOU " + resultMessage + " !");
        result.setBounds(250, 50, 300, 200);
        result.setForeground(Color.white);
        result.setFont(new Font("Monospace", Font.PLAIN, 40));
        return result;
    }

    /**
     * add all buttons to the background
     * @param bg the background label
     */
    public void addResultPageButtons(JLabel bg) {
        JButton newGame = new JButton("New Game");
        newGame.setBounds(100, 300, 100, 50);
        newGame.addActionListener(e -> {
            window.setVisible(false);
            new ViewMethods();
        });
        JButton scoreBoard = new JButton("Score Board");
        scoreBoard.setBounds(300, 300, 100, 50);
        //TODO: print score board
        JButton userProfile = new JButton("User Profile");
        userProfile.setBounds(500, 300, 100, 50);
        //TODO: print user profile
        bg.add(newGame);
        bg.add(scoreBoard);
        bg.add(userProfile);
    }

}
