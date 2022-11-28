package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegularModeSetup {

    Controller c;
    JFrame window;
    JPanel regularSetupPanel;
    JLabel regularSetupLabel;
    ViewMethods ui;

    public RegularModeSetup(Controller c){

        generateScreen();
        this.c = c;
       // c.setTeamMode(false);//may delete this if useless

    }

    public void createRegularButtons(JLabel bg) {
        TextField player1 = new TextField("Player 1: your name");
        player1.setBounds(100, 100, 150, 50);
        player1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addPlayerName(player1.getText());
            }
        });
        bg.add(player1);
        TextField player2 = new TextField("Player 2: Bot 1 name");
        player2.setBounds(100, 200, 150, 50);
        player2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addPlayerName(player2.getText());
            }
        });
        bg.add(player2);
        Button easy2 = new Button("Easy");
        easy2.setBounds(300, 200, 50, 50);
        easy2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("easy");
            }
        });
        bg.add(easy2);
        Button medium2 = new Button("Medium");
        medium2.setBounds(400, 200, 100, 50);
        medium2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("medium");
            }
        });
        bg.add(medium2);
        Button hard2 = new Button("Hard");
        hard2.setBounds(550, 200, 50, 50);
        hard2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("hard");
            }
        });
        bg.add(hard2);

        TextField player3 = new TextField("Player 3: Bot 2 name");
        player3.setBounds(100, 300, 150, 50);
        player3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addPlayerName(player3.getText());
            }
        });
        bg.add(player3);

        Button easy3 = new Button("Easy");
        easy3.setBounds(300, 300, 50, 50);
        easy3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("easy");
            }
        });
        bg.add(easy3);
        Button medium3 = new Button("Medium");
        medium3.setBounds(400, 300, 100, 50);
        medium3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("medium");
            }
        });
        bg.add(medium3);
        Button hard3 = new Button("Hard");
        hard3.setBounds(550, 300, 50, 50);
        hard3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("hard");
            }
        });
        bg.add(hard3);
        TextField player4 = new TextField("Player 4: Bot 3 name");
        player4.setBounds(100, 400, 150, 50);
        player4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addPlayerName(player4.getText());
            }
        });
        bg.add(player4);
        Button easy4 = new Button("Easy");
        easy4.setBounds(300, 400, 50, 50);
        easy4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("easy");
            }
        });
        bg.add(easy4);
        Button medium4 = new Button("Medium");
        medium4.setBounds(400, 400, 100, 50);
        medium4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("medium");
            }
        });
        bg.add(medium4);
        Button hard4 = new Button("Hard");
        hard4.setBounds(550, 400, 50, 50);
        hard4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("hard");
            }
        });
        bg.add(hard4);


        Button startGame = new Button("Start Game");
        startGame.setBounds(670, 250, 100, 100);
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.startGame(ui);
            }
        });
        bg.add(startGame);
    }



    public void generateScreen() {
        //create a main field
        window = new JFrame();
        window.setSize(1000, 700);
        window.setTitle("Regular Mode Setup");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the windows properly
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        //set background
        regularSetupPanel = new JPanel();
        regularSetupPanel.setBounds(0, 0, 1000, 700);
        regularSetupPanel.setLayout(null);
        window.add(regularSetupPanel);
        regularSetupLabel = new JLabel();
        regularSetupLabel.setBounds(0, 0, 1000, 700);
        ImageIcon regularBG = new ImageIcon(this.getClass().getResource("/bg.jpg"));
        Image bg = regularBG.getImage();
        Image adjustedBg = bg.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
        regularBG = new ImageIcon(adjustedBg);

        regularSetupLabel.setIcon(regularBG);
        regularSetupPanel.add(regularSetupLabel);

        createRegularButtons(regularSetupLabel);
    }
}
