package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PlayCardWindow extends UIComponent {

    JFrame window;
    JPanel playPanel;

    public PlayCardWindow(Controller c, List<String> cards) {
        super(c);
        generateScreen();
        createPossibleMoves(cards);
    }

    public void generateScreen() {

        //create a main field
        window = super.createMainField("Choose Cards", 250, 200);

        //set background
        playPanel = new JPanel();
        playPanel.setBounds(0, 0, 250, 200);
        playPanel.setLayout(null);
        window.add(playPanel);
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
        card.addActionListener(e -> {
            c.playCard(cardStr);
            window.setVisible(false);
        });

        return card;
    }
}
