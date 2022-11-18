package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayCardWindow {

    JFrame window;
    JPanel playPanel;
    Controller c;

    public PlayCardWindow(Controller c) {
        this.c = c;
        generateScreen();
    }

    public void generateScreen() {

        //create a main field
        window = new JFrame();
        window.setSize(400, 300);
        window.setTitle("Game Board");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the windows properly
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        //set background
        playPanel = new JPanel();
        playPanel.setBounds(0, 0, 1000, 700);
        playPanel.setLayout(null);
        window.add(playPanel);
        playPanel.add(createCardButtons(100, 100, 50, 50, "W"));

    }

    public void createAvailableMoves(String[] availableMoves) {
        JButton[] cardButtons = new JButton[availableMoves.length];

    }


    public JButton createCardButtons(int cardX, int cardY, int width, int height, String cardStr) {

        JButton card = new JButton();
        card.setBounds(cardX, cardY, width, height);
        card.setForeground(Color.white);
        String cardText = "";
        Color cardColor = Color.white;
        if (cardStr.equals("+4")) {
            cardText = cardStr;
            cardColor = Color.black;
        } else if (cardStr.equals("W")) {
            cardText = cardStr;
            cardColor = Color.black;
        } else {
            String[] splitedCard = cardStr.split("-");
            String text = splitedCard[0];
            String colour = splitedCard[1];
            cardText = text;
            switch (colour) {
                case "red":
                    cardColor = Color.red;
                    break;
                case "yellow":
                    cardColor = Color.yellow;
                    break;
                case "green":
                    cardColor = Color.green;
                    break;
                case "blue":
                    cardColor = Color.blue;
                    break;
            }
        }

        card.setText(cardText);
        card.setBackground(cardColor);
        card.setOpaque(true);
        card.setFont(new Font("Monospace", Font.PLAIN, 30));
        card.setHorizontalAlignment(SwingConstants.CENTER);
        card.setBorder(BorderFactory.createLineBorder(Color.white));
        card.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.playCard(cardStr);
                window.setVisible(false);
            }
        });

        return card;
    }
}
