package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayCardWindow extends UIComponent {

    JFrame window;
    JPanel playPanel;

    public PlayCardWindow(Controller c) {
        super(c);
        generateScreen();
    }

    public void generateScreen() {

        //create a main field
        window = super.createMainField("Choose Cards", 250, 200);
        window.setSize(250, 200);

        //set background
        playPanel = new JPanel();
        playPanel.setBounds(0, 0, 250, 200);
        playPanel.setLayout(null);
        window.add(playPanel);
    }

    public void createAvailableMoves(String[] availableMoves) {
        JButton[] cardButtons = new JButton[availableMoves.length];
        for (int i=0; i< cardButtons.length; i++) {
            int cardX = 50*(i / 3);
            int cardY = 50*(i % 3);
            cardButtons[i] = createCardButtons(cardX, cardY, 50, 50, availableMoves[i]);
            playPanel.add(cardButtons[i]);
        }
    }

    public JButton createCardButtons(int cardX, int cardY, int width, int height, String cardStr) {

        JButton card = new JButton();
        card.setBounds(cardX, cardY, width, height);

        String cardText = super.getCardText(cardStr);
        Color cardColor = getCardColor(cardStr);
        if (cardColor == Color.yellow) {
            card.setForeground(Color.black);
        } else {
            card.setForeground(Color.white);
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
