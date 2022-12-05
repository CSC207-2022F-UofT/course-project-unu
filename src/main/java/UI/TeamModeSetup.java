package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * UI component, extends the abstract class UIComponent
 * the user inputs the team name and player's names on this page
 * the user can also start the game after setting up all the inputs needed
 * By Default, Player 1 is the real player and the other three players are all bots
 * Player 1 and Player 2 form Team 1 and Player 3 and Player 4 form Team 2
 */
public class TeamModeSetup extends UIComponent{

    JFrame window;
    JLabel teamSetupLabel;

    /**
     * Constructor, creates a setup page for the game in team mode
     * @param c the controller that this page passes the input to
     */
    public TeamModeSetup(Controller c) {
        super(c);
        generateScreen();
        c.setTeamMode(true);//may delete this if useless
    }

    /**
     * create the buttons that takes the input needed to initialize a new team game
     * @param bg the background label that all the buttons will be added to
     */
    public void createTeamButtons(JLabel bg) {
        //team 1
        TextField team1 = new TextField("Team 1 name");
        team1.setBounds(100, 100, 150, 50);
        team1.addActionListener(e -> c.addTeamName(team1.getText()));
        bg.add(team1);

        TextField player1 = new TextField("Player 1: your name");
        player1.setBounds(100, 200, 150, 50);
        player1.addActionListener(e -> c.addPlayerName(player1.getText()));
        bg.add(player1);
        setBotPlayerButtons(bg, 1, 100, 300);

        //team 2
        TextField team2 = new TextField("Team 2 name");
        team2.setBounds(500, 100, 150, 50);
        team2.addActionListener(e -> c.addTeamName(team2.getText()));
        bg.add(team2);

        setBotPlayerButtons(bg, 2, 500, 200);
        setBotPlayerButtons(bg, 3, 500, 300);

        //Start game button
        Button startGame = new Button("Start Game");
        startGame.setBounds(450, 450, 100, 100);
        startGame.addActionListener(e -> c.startGame());
        bg.add(startGame);

    }

    /**
     * Helper method that creates the buttons needed for each bot player
     * @param bg the background label that all the buttons will be added to
     * @param bot bot number, can only be either 1, 2, 3
     * @param botX x-position of the text field
     * @param botY y-position of the text field
     */
    public void setBotPlayerButtons(JLabel bg, int bot, int botX, int botY) {
        TextField botName = new TextField("Player " + (bot+1) +": Bot " + bot + " name");
        botName.setBounds(botX, botY, 150, 50);
        botName.addActionListener(e -> c.addPlayerName(botName.getText()));
        bg.add(botName);
        Button easy = new Button("Easy");
        easy.setBounds(botX+150, botY, 50, 50);
        easy.addActionListener(e -> c.addBotLevel("easy"));
        bg.add(easy);
        Button medium = new Button("Medium");
        medium.setBounds(botX+200, botY, 100, 50);
        medium.addActionListener(e -> c.addBotLevel("medium"));
        bg.add(medium);
        Button hard = new Button("Hard");
        hard.setBounds(botX+300, botY, 50, 50);
        hard.addActionListener(e -> c.addBotLevel("hard"));
        bg.add(hard);
    }

    /**
     * creates the main screen of the team mode setup page
     */
    public void generateScreen() {
        //create a main field
        window = super.createMainField("Team Mode Setup", 1000, 700);

        //set background
        teamSetupLabel = super.setBackground(window, 1000, 700);

        //add buttons
        createTeamButtons(teamSetupLabel);
    }
}
