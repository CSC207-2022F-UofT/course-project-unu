package UI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * UI component, extends the abstract class UIComponent
 * displays player ranking
 */
public class ScoreBoard extends UIComponent{

    JFrame window;
    JLabel scoreBoardLabel;
    String rankType;
    List<String> players;

    /**
     * Constructor
     * @param rankType rank type
     * @param players sorted list of players
     */
    public ScoreBoard(String rankType, List<String> players) {
        super();
        this.rankType = rankType;
        this.players = players;
        generateScreen();
    }

    /**
     * generate the screen of scoreboard
     */
    public void generateScreen() {
        //create a main field
        window = super.createMainField("Player Ranking by " + rankType, 500, 500);

        //set up background
        scoreBoardLabel = super.setBackground(window, 500, 500);

        //column titles
        JLabel columns = new JLabel("Rank   Player");
        columns.setBounds(100, 50, 300, 50);
        columns.setForeground(Color.white);
        columns.setFont(new Font("Monospace", Font.PLAIN, 40));
        scoreBoardLabel.add(columns);

        //add each player
        for (int i=0; i< players.size(); i++) {
            addPlayer(scoreBoardLabel, i+1, players.get(i));
        }

        //exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(400, 400, 50, 50);
        exitButton.addActionListener(e -> window.setVisible(false));
        scoreBoardLabel.add(exitButton);
    }

    /**
     * helper method, add the player text label to the page
     * @param bg background label
     * @param rank player rank
     * @param player player name
     */
    public void addPlayer(JLabel bg, int rank, String player) {
        JLabel playerRank = new JLabel(rank + "         " + player);
        playerRank.setBounds(135, 70+rank*70, 300, 50);
        playerRank.setForeground(Color.white);
        playerRank.setFont(new Font("Monospace", Font.PLAIN, 35));
        bg.add(playerRank);
    }

}
