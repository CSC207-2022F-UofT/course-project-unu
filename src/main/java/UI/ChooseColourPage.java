package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseColourPage {

    Controller c;
    JFrame window;
    JPanel colourPanel;
    public ChooseColourPage(Controller c) {

        this.c = c;
        this.window = new JFrame();
        generateScreen();
    }

    public void generateScreen() {

        //create a main field
        window.setSize(250, 200);
        window.setTitle("Choose Cards");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the windows properly
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        //set background
        colourPanel = new JPanel();
        colourPanel.setBounds(0, 0, 250, 200);
        colourPanel.setLayout(null);
        window.add(colourPanel);

        String[] colourStr = {"red", "yellow", "green", "blue"};
        Color[] colours = {Color.red, Color.yellow, Color.green, Color.blue};
        for (int i=0; i<4; i++) {
            JButton colorButton = new JButton(colourStr[i]);
            colorButton.setBounds(55+70*(i/2), 15+70*(i%2), 70, 70);
            colorButton.setBackground(colours[i]);
            colorButton.setOpaque(true);
            int finalI = i;
            colorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    c.changeColour(colourStr[finalI]);
                    window.setVisible(false);
                }
            });
            colourPanel.add(colorButton);
        }
    }
}
