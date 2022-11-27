package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage {

    JFrame window;
    JPanel startPanel;
    JLabel startLabel;
    JButton regularButton;
    JButton teamButton;
    Controller c;

    public StartPage(Controller c){
        this.c = c;
        generateScreen();

    }

    public void createStartPageButtons(JLabel bg) {
        regularButton = new JButton("Regular Mode");
        regularButton.setBounds(340, 430, 120, 70);
        regularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegularModeSetup(c);
                window.setVisible(false);
            }
        });
        teamButton = new JButton("Team Mode");
        teamButton.setBounds(540, 430, 120, 70);
        teamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TeamModeSetup(c);
                window.setVisible(false);
            }
        });
        bg.add(regularButton);
        bg.add(teamButton);

    }

    public void generateScreen() {
        //create a main field
        window = new JFrame();
        window.setSize(1000, 700);
        window.setTitle("Start Page");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the windows properly
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        //set background
        startPanel = new JPanel();
        startPanel.setBounds(0, 0, 1000, 700);
        startPanel.setLayout(null);
        window.add(startPanel);
        startLabel = new JLabel();
        startLabel.setBounds(0, 0, 1000, 700);
        ImageIcon startBG = new ImageIcon(this.getClass().getResource("/bg.jpg"));
        Image bg = startBG.getImage();
        Image adjustedBg = bg.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
        startBG = new ImageIcon(adjustedBg);
        startLabel.setIcon(startBG);
        startPanel.add(startLabel);
        createStartPageButtons(startLabel);

        JLabel logo = new JLabel();
        ImageIcon unoLogo = new ImageIcon(this.getClass().getResource("/UNO_logo.jpg"));
        Image logoImg = unoLogo.getImage();
        Image adjustedLogo = logoImg.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        logo.setBounds(350, 130, 300, 200);
        unoLogo = new ImageIcon(adjustedLogo);
        logo.setIcon(unoLogo);
        startLabel.add(logo);


    }
}