package UI;

import interfaceAdapters.Controller;
import interfaceAdapters.gateway.CSVGateway;
import interfaceAdapters.gateway.DBGateway;

import javax.swing.*;
import java.awt.*;

/**
 * UI component, extends the abstract class UIComponent
 * shows the real player the game result (win or lose)
 * allows the user to view the score board and user profile (text-based)
 * allows the user to start a new game
 */
public class ResultPage extends UIComponent {

    JFrame window;
    JLabel resultLabel;
    String resultMessage;
    String winTeam;
    DBGateway dbGateway;

    /**
     * Constructor of ResultPage for regular mode
     * 
     * @param c     the controller that the result page interacts with
     * @param isWin isWin is true if the user won the game, vice versa
     */
    public ResultPage(Controller c, boolean isWin) {
        super(c);

        this.dbGateway = new CSVGateway("db/stats.csv");
        this.dbGateway.recordNewGame(isWin);

        if (isWin) {
            this.resultMessage = "WIN";
        } else {
            this.resultMessage = "LOSE";
        }

        this.generateScreen();
    }

    /**
     * Constructor of ResultPage for team mode
     * 
     * @param c       the controller that the result page interacts with
     * @param isWin   isWin is true if the user won the game, vice versa
     * @param winTeam the winner team name
     */
    public ResultPage(Controller c, boolean isWin, String winTeam) {
        super(c);

        this.dbGateway = new CSVGateway("db/stats.csv");
        this.dbGateway.recordNewGame(isWin);

        if (isWin) {
            this.resultMessage = "WIN";
        } else {
            this.resultMessage = "LOSE";
        }
        this.winTeam = winTeam;
        generateScreen();
    }

    /**
     * generate the main screen of the result page
     */
    public void generateScreen() {

        // create main field
        window = super.createMainField("Result Page", 700, 500);

        // set background
        resultLabel = super.setBackground(window, 700, 500);

        // add result text
        if (winTeam != null) {
            resultLabel.add(result(resultMessage, 250, 50));
            resultLabel.add(winTeamMessage(winTeam));
        } else {
            resultLabel.add(result(resultMessage, 250, 100));
        }

        addResultPageButtons(resultLabel);

        // display the wins and losses
        JLabel totalGames = new JLabel("Total Games: " + this.dbGateway.getTotalGames());
        JLabel totalWins = new JLabel("Total Wins: " + this.dbGateway.getTotalWins());

        totalGames.setFont(new Font("Arial", Font.BOLD, 20));
        totalGames.setBounds(250, 200, 200, 50);

        totalWins.setFont(new Font("Arial", Font.BOLD, 20));
        totalWins.setBounds(250, 220, 200, 50);

        resultLabel.add(totalGames);
        resultLabel.add(totalWins);
    }

    /**
     * generate a label that shows the result message ("YOU WIN" or "YOU LOSE")
     * 
     * @param resultMessage "WIN or "LOSE"
     * @return a JLabel that shows the text
     */
    public JLabel result(String resultMessage, int xPos, int yPos) {
        JLabel result = new JLabel("YOU " + resultMessage + " !");
        result.setBounds(xPos, yPos, 300, 100);
        result.setForeground(Color.white);
        result.setFont(new Font("Monospace", Font.PLAIN, 40));

        return result;
    }

    /**
     * generate a label that shows the winner team
     * 
     * @param winTeam the name of the winner team
     * @return the label that shows the text
     */
    public JLabel winTeamMessage(String winTeam) {
        JLabel team = new JLabel("WINNER TEAM: " + winTeam + " !");
        team.setBounds(150, 120, 400, 100);
        team.setForeground(Color.white);
        team.setFont(new Font("Monospace", Font.PLAIN, 32));

        return team;
    }

    /**
     * add all buttons to the background
     * 
     * @param bg the background label
     */
    public void addResultPageButtons(JLabel bg) {
        // New Game Button
        JButton newGame = new JButton("New Game");
        newGame.setBounds(200, 300, 100, 50);
        newGame.addActionListener(e -> {
            window.setVisible(false);
            new ViewMethods();
        });
        bg.add(newGame);

        // Player Ranking Buttons
        JLabel message = new JLabel("Player Rankings:");
        message.setBounds(420, 200, 200, 50);
        message.setForeground(Color.white);
        message.setFont(new Font("Monospace", Font.PLAIN, 20));
        JButton games = new JButton("By Games");
        games.setBounds(420, 250, 75, 50);
        games.addActionListener(e -> c.getPlayerRank("Games"));
        JButton wins = new JButton("By Wins");
        wins.setBounds(420, 300, 75, 50);
        wins.addActionListener(e -> c.getPlayerRank("Wins"));
        JButton winRate = new JButton("By Win Rate");
        winRate.setBounds(420, 350, 100, 50);
        winRate.addActionListener(e -> c.getPlayerRank("Win Rate"));

        bg.add(message);
        bg.add(games);
        bg.add(wins);
        bg.add(winRate);

    }

}
