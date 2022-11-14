package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage {

    JFrame window;
    ViewMethods vm;

    public JPanel gamePanel[];
    public JLabel gameLabel[];



    public StartPage(ViewMethods vm, JFrame window, JPanel gamePanel[], JLabel gameLabel[]){

        this.vm = vm;
        this.window = window;
        this.gamePanel = gamePanel;
        this.gameLabel = gameLabel;

        generateScreen();

    }

    public void createStartPageButtons() {
        //panelNum = 1 by default
        JButton startGameButton;
        JButton exitButton;
        JButton instruction;
        startGameButton = new JButton("Start");
        startGameButton.setBounds(120, 300, 100, 50);
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });
        //startGameButton.a
        instruction = new JButton("Instruction");
        instruction.setBounds(120, 365, 100, 50);
        exitButton = new JButton("Exit");
        exitButton.setBounds(120, 430, 100, 50);
        gameLabel[0].add(startGameButton);
        gameLabel[0].add(exitButton);
        gameLabel[0].add(instruction);

    }

    public void generateScreen() {
        vm.createBackground(0,"/bg.jpg");
        createStartPageButtons();
    }

}
