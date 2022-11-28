package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * A UI component
 * generating the starting window of the game
 * the user can choose regular mode or team mode
 */
public class StartPage extends UIComponent {

    JFrame window;
    JPanel startPanel;
    JLabel startLabel;
    JButton regularButton;
    JButton teamButton;
    Controller c;

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
        startPanel = new JPanel();
        startPanel.setBounds(0, 0, 1000, 700);
        startPanel.setLayout(null);
        this.window.add(startPanel);
        startLabel = new JLabel();
        startLabel.setBounds(0, 0, 1000, 700);
        //ImageIcon startBG = new ImageIcon(this.getClass().getResource("/bg.jpg"));
        ImageIcon startBG = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/bg.jpg")));
        Image bg = startBG.getImage();
        Image adjustedBg = bg.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
        startBG = new ImageIcon(adjustedBg);
        startLabel.setIcon(startBG);
        startPanel.add(startLabel);
        createStartPageButtons(startLabel);

        JLabel logo = new JLabel();
        ImageIcon unoLogo = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/UNO_logo.jpg")));
        Image logoImg = unoLogo.getImage();
        Image adjustedLogo = logoImg.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        logo.setBounds(350, 130, 300, 200);
        unoLogo = new ImageIcon(adjustedLogo);
        logo.setIcon(unoLogo);
        startLabel.add(logo);
    }
}