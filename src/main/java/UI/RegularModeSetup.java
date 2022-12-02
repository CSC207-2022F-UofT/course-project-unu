package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * class RegularModeSetUp
 * UI component, inherits the abstract class UIComponent
 * collects all the user inputs that are necessary for setting up a regular game
 * the user can set the level of the bot players and assign a name for each player
 * the user can start the game after clicking on the start game button
 */
public class RegularModeSetup extends UIComponent{

    JFrame window;
    JLabel regularSetupLabel;

    /**
     * constructor, creates a RegulaModeSetup object and generates its screen
     * @param c the controller of the game, takes all the user inputs and pass that to the main game mechanism
     */
    public RegularModeSetup(Controller c){
        super(c);
        generateScreen();
        this.c.setTeamMode(false);//may delete this if useless
    }

    /**
     * set up all the buttons on the regular mode setup page
     * @param bg the background JLabel that the new buttons will be added to
     */
    public void createRegularButtons(JLabel bg) {
        //Player 1 input takers
        TextField player1 = new TextField("Player 1: your name");
        player1.setBounds(100, 100, 150, 50);
        player1.addActionListener(e -> c.addPlayerName(player1.getText()));
        bg.add(player1);

        //Player 2 input takers
        addBotPlayerButtons(bg, 200, 2);

        //Player 3 input takers
        addBotPlayerButtons(bg, 300, 3);

        //Player 4 inputs takers
        addBotPlayerButtons(bg, 400, 4);

        //Start Game button
        Button startGame = new Button("Start Game");
        startGame.setBounds(670, 250, 100, 100);
        startGame.addActionListener(e -> {
            c.startGame();
            window.setVisible(false);
        });
        bg.add(startGame);
    }

    /**
     * a helper method that adds all the input takers of the bot players to the background label
     * @param bg background label
     * @param buttonY y value of the input takers
     * @param player which bot player is it handling
     */
    public void addBotPlayerButtons(JLabel bg, int buttonY, int player){
        TextField playerName = new TextField("Player " + player + ": Bot " + (player-1) + " name");
        playerName.setBounds(100, buttonY, 150, 50);
        playerName.addActionListener(e -> c.addPlayerName(playerName.getText()));
        bg.add(playerName);
        Button easy = new Button("Easy");
        easy.setBounds(300, buttonY, 50, 50);
        easy.addActionListener(e -> c.addBotLevel("easy"));
        bg.add(easy);
        Button medium = new Button("Medium");
        medium.setBounds(400, buttonY, 100, 50);
        medium.addActionListener(e -> c.addBotLevel("medium"));
        bg.add(medium);
        Button hard = new Button("Hard");
        hard.setBounds(550, buttonY, 50, 50);
        hard.addActionListener(e -> c.addBotLevel("hard"));
        bg.add(hard);
    }

    /**
     * create the screen of the regular mode setup page
     */
    public void generateScreen() {
        //create a main field
        window = super.createMainField("Regular Mode Setup", 1000, 700);

        //set background
        regularSetupLabel = super.setBackground(window, 1000, 700);

        //add input takers
        createRegularButtons(regularSetupLabel);
    }
}
