package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeChoosingPage {
    public static JFrame window;
    ViewMethods vm;
    Controller c;

    public JPanel gamePanel[];
    public JLabel gameLabel[];

    public ModeChoosingPage(){
        c = new Controller();
        generateScreen();
    }

    public void createModeChoosingButtons() {
        JButton team = new JButton();
        team.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.setTeamMode(true);
                createTeamSetUp();
            }
        });
        JButton regular = new JButton();
        regular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.setTeamMode(false);
                createRegularSetUp();
            }
        });
    }


    public void createTeamSetUp() {
        //textfields record player name
        TextField player1 = new TextField();
        player1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addPlayerName(player1.getText());
            }
        });
        TextField player2 = new TextField();
        player2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addPlayerName(player2.getText());
            }
        });
        TextField player3 = new TextField();
        player3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addPlayerName(player3.getText());
            }
        });
        TextField player4 = new TextField();
        player4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addPlayerName(player4.getText());
            }
        });
        TextField team1 = new TextField();
        team1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addTeamName(team1.getText());
            }
        });
        TextField team2 = new TextField();
        team2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addTeamName(team2.getText());
            }
        });
        Button startGame = new Button();
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.startGame();
            }
        });

    }

    public void createRegularSetUp() {
        TextField player1 = new TextField();
        player1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addPlayerName(player1.getText());
            }
        });
        TextField player2 = new TextField();
        player2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addPlayerName(player2.getText());
            }
        });
        Button easy2 = new Button();
        easy2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("easy");
            }
        });
        Button medium2 = new Button();
        medium2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("medium");
            }
        });
        Button hard2 = new Button();
        hard2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("hard");
            }
        });

        TextField player3 = new TextField();
        player3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addPlayerName(player3.getText());
            }
        });
        Button easy3 = new Button();
        easy3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("easy");
            }
        });
        Button medium3 = new Button();
        medium3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("medium");
            }
        });
        Button hard3 = new Button();
        hard3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("hard");
            }
        });
        TextField player4 = new TextField();
        player4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addPlayerName(player4.getText());
            }
        });
        Button easy4 = new Button();
        easy4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("easy");
            }
        });
        Button medium4 = new Button();
        medium4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("medium");
            }
        });
        Button hard4 = new Button();
        hard4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.addBotLevel("hard");
            }
        });

        Button startGame = new Button();
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.startGame();
            }
        });
    }



    public void generateScreen() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setTitle("ModeChoosing");
        //window.setLocationRelativeTo(GameBoard.window);
        window.setLayout(null);
        window.setVisible(true);
        vm.createBackground(1,"/bg.jpg", window);
        createModeChoosingButtons();
    }


}
