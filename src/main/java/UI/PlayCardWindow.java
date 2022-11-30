package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PlayCardWindow {

    JFrame window;
    JPanel playPanel;
    Controller c;

    public PlayCardWindow(Controller c, List<String> cards) {
        //TODO: figure out why can the parameter passed be null
        this.c = c;
        this.window = new JFrame();
        generateScreen();
        createPossibleMoves(cards);
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
        playPanel = new JPanel();
        playPanel.setBounds(0, 0, 250, 200);
        playPanel.setLayout(null);
        window.add(playPanel);
//        String[] str = new String[7];
//        str[0] = "W";
//        str[1] = "+4";
//        str[2] = "1-red";
//        str[3] = "+2-green";
//        str[4] = "R-blue";
//        str[5] = "S-yellow";
//        str[6] = "0-red";
//        createAvailableMoves(str);
    }

    public void createPossibleMoves(List<String> possibleMoves) {
        JButton[] cardButtons = new JButton[possibleMoves.size()];
        for (int i=0; i< cardButtons.length; i++) {
            int cardX = 50*(i / 3);
            int cardY = 50*(i % 3);
            cardButtons[i] = createCardButtons(cardX, cardY, 50, 50, possibleMoves.get(i));
            playPanel.add(cardButtons[i]);
        }
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
