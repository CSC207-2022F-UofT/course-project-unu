package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * UI component, extends abstract UIComponent
 * takes all the input needed to start a game in team mode
 * the user can start the game by clicking on the start game button
 */
public class TeamModeSetup extends UIComponent{

    JFrame window;
    JLabel teamSetupLabel;

    /**
     * Constructor
     * @param c the controller that this page passes input to
     */
    public TeamModeSetup(Controller c) {
        super(c);
        generateScreen();
        c.setTeamMode(true);
    }

    /**
     * add all the input takers to the background label
     * @param bg background label
     */
    public void createTeamButtons(JLabel bg) {
        //team 1 input takers
        TextField team1 = new TextField("Team 1 name");
        team1.setBounds(100, 100, 150, 50);
        team1.addActionListener(e -> c.addTeamName(team1.getText()));
        bg.add(team1);

        TextField player1 = new TextField("Player 1: your name");
        player1.setBounds(100, 200, 150, 50);
        player1.addActionListener(e -> c.addPlayerName(player1.getText()));
        bg.add(player1);
        addBotPlayerButtons(bg, 1, 100, 300);

        //team 2 input takers
        TextField team2 = new TextField("Team 2 name");
        team2.setBounds(500, 100, 150, 50);
        team2.addActionListener(e -> c.addTeamName(team2.getText()));
        bg.add(team2);
        addBotPlayerButtons(bg, 2, 500, 200);
        addBotPlayerButtons(bg, 3, 500, 300);

        Button startGame = new Button("Start Game");
        startGame.setBounds(450, 450, 100, 100);
        startGame.addActionListener(e -> {
            c.startGame();
            window.setVisible(false);
        });
        bg.add(startGame);

    }

    /**
     * helper method that creates the buttons of each bot player
     * @param bg background label
     * @param bot bot number
     * @param botX x-position of text field
     * @param botY y-position of text field
     */
    public void addBotPlayerButtons(JLabel bg, int bot, int botX, int botY) {
        //player name
        TextField botName = new TextField("Player " + (bot+1) + ": Bot " + bot + "'s name");
        botName.setBounds(botX, botY, 150, 50);
        botName.addActionListener(e -> c.addPlayerName(botName.getText()));
        bg.add(botName);
        //easy button
        Button easy = new Button("Easy");
        easy.setBounds(botX+150, botY, 50, 50);
        easy.addActionListener(e -> c.addBotLevel("easy"));
        bg.add(easy);
        //medium button
        Button medium = new Button("Medium");
        medium.setBounds(botX+200, botY, 100, 50);
        medium.addActionListener(e -> c.addBotLevel("medium"));
        bg.add(medium);
        //hard button
        Button hard = new Button("Hard");
        hard.setBounds(botX+300, botY, 50, 50);
        hard.addActionListener(e -> c.addBotLevel("hard"));
        bg.add(hard);
    }

    /**
     * generate the team mode set up page screen
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
