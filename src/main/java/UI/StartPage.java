package UI;

import interfaceAdapters.Controller;

import javax.swing.*;

/**
 * A UI component
 * generating the starting window of the game
 * the user can choose regular mode or team mode
 */
public class StartPage extends UIComponent {

    JFrame window;
    JLabel startLabel;
    JButton regularButton;
    JButton teamButton;

    /**
     * Constructor of StartPage
     * @param c the controller of this game, passes the user input to the use cases layer
     */
    public StartPage(Controller c){
        super(c);
        generateScreen();
    }

    /**
     * generate all the buttons
     * @param bg the background label where the buttons will be added
     */
    public void createStartPageButtons(JLabel bg) {
        regularButton = new JButton("Regular Mode");
        regularButton.setBounds(340, 430, 120, 70);
        regularButton.addActionListener(e -> {
            new RegularModeSetup(c);
            window.setVisible(false);
        });
        teamButton = new JButton("Team Mode");
        teamButton.setBounds(540, 430, 120, 70);
        teamButton.addActionListener(e -> {
            new TeamModeSetup(c);
            window.setVisible(false);
        });
        bg.add(regularButton);
        bg.add(teamButton);

    }

    /**
     * create the main screen setup
     */
    public void generateScreen() {

        window = super.createMainField("Start Page", 1000, 700);

        //set background
        startLabel = super.setBackground(window, 1000, 700);

        //add buttons
        createStartPageButtons(startLabel);

        //add logo
        JLabel logo = new JLabel();
        logo.setBounds(350, 130, 300, 200);
        logo.setIcon(super.adjustedImage("/UNO_logo.jpg", 300, 200));
        startLabel.add(logo);
    }
}