package UI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ScoreBoard extends UIComponent{

    JFrame window;
    JLabel scoreBoardLabel;
    String rankType;
    List<String> players;

    public ScoreBoard(String rankType, List<String> players) {
        super();
        this.rankType = rankType;
        this.players = players;
        generateScreen();
    }

    public void generateScreen() {
        //create a main field
        window = super.createMainField("Player Ranking by " + rankType, 500, 500);

        //set up background
        scoreBoardLabel = super.setBackground(window, 500, 500);

        JLabel columns = new JLabel("Rank   Player");
        columns.setBounds(100, 50, 300, 50);
        columns.setForeground(Color.white);
        columns.setFont(new Font("Monospace", Font.PLAIN, 40));
        scoreBoardLabel.add(columns);

        for (int i=0; i< players.size(); i++) {
            addPlayer(scoreBoardLabel, i+1, players.get(i));
        }

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(400, 400, 50, 50);
        exitButton.addActionListener(e -> window.setVisible(false));
        scoreBoardLabel.add(exitButton);
    }

    public void addPlayer(JLabel bg, int rank, String player) {
        JLabel playerRank = new JLabel(rank + "         " + player);
        playerRank.setBounds(135, 70+rank*70, 300, 50);
        playerRank.setForeground(Color.white);
        playerRank.setFont(new Font("Monospace", Font.PLAIN, 35));
        bg.add(playerRank);
    }

}
