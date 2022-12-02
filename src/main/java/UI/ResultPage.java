package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * UI component, extends the abstract class UIComponent
 * shows the real player the game result (win or lose)
 * allows the user to view the score board and user profile (textbased)
 * allows the user to start a new game
 */
public class ResultPage extends UIComponent{

    JFrame window;
    JLabel resultLabel;
    String resultMessage;

    public ResultPage(Controller c, boolean isWin) {
        super(c);
        if (isWin) {
            this.resultMessage = "WIN";
        } else {
            this.resultMessage = "LOSE";
        }
        generateScreen();
    }

    public void generateScreen() {

        //create main field
        window = super.createMainField("Result Page", 700, 500);

        //set background
        resultLabel = super.setBackground(window, 700, 500);

        //add result text
        resultLabel.add(result(resultMessage));
        addResultPageButtons(resultLabel);
    }

    public JLabel result(String resultMessage) {
        JLabel result = new JLabel("YOU " + resultMessage + " !");
        result.setBounds(250, 50, 300, 200);
        result.setForeground(Color.white);
        result.setFont(new Font("Monospace", Font.PLAIN, 40));
        return result;
    }
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
