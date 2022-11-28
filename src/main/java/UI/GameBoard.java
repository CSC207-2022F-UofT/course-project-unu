package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard{

    Controller c;

    JFrame window;
    JPanel gamePanel;
    JLabel gameLabel;
    JLabel player1Card;
    JLabel player2Card;
    JLabel player3Card;
    JLabel player4Card;
    JLabel lastPlayedCard;
    JLabel[] myAvailableMoves;

    public GameBoard(Controller c) {
        this.c = c;
        this.player1Card = new JLabel();
        this.player2Card = new JLabel();
        this.player3Card = new JLabel();
        this.player4Card = new JLabel();
        this.lastPlayedCard = new JLabel();
        this.myAvailableMoves = new JLabel[16];
        for (int i=0; i<this.myAvailableMoves.length; i++) {
            this.myAvailableMoves[i] = new JLabel();
        }
        generateScreen();
    }

    public void generateScreen() {
        //create a main field
        window = new JFrame();
        window.setSize(1000, 700);
        window.setTitle("Game Board");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the windows properly
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        //set background
        gamePanel = new JPanel();
        gamePanel.setBounds(0, 0, 1000, 700);
        gamePanel.setLayout(null);
        window.add(gamePanel);
        gameLabel = new JLabel();
        gameLabel.setBounds(0, 0, 1000, 700);
        ImageIcon startBG = new ImageIcon(this.getClass().getResource("/gameBoardBG.png"));
        Image bgImg = startBG.getImage();
        Image adjustedBg = bgImg.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
        startBG = new ImageIcon(adjustedBg);

        gameLabel.setIcon(startBG);
        gamePanel.add(gameLabel);

        createPlayers(gameLabel);
        addGameButtons(gameLabel);
        JLabel[] labels = {this.player1Card, this.player2Card, this.player3Card, this.player4Card, this.lastPlayedCard};
        for (int i=0; i<labels.length; i++) {
            gameLabel.add(labels[i]);
        }
        for (int i=0; i<this.myAvailableMoves.length; i++) {
            gameLabel.add(this.myAvailableMoves[i]);
        }
    }

    public void createPlayers(JLabel bg) {
        JLabel bot1 = new JLabel();
        ImageIcon bot1Icon = new ImageIcon(this.getClass().getResource("/RedBot.png"));
        Image bot1Img = bot1Icon.getImage();
        Image adjustedBot1 = bot1Img.getScaledInstance(60, 70, Image.SCALE_SMOOTH);
        bot1.setBounds(100, 80, 60, 70);
        bot1Icon = new ImageIcon(adjustedBot1);
        bot1.setIcon(bot1Icon);

        JLabel bot2 = new JLabel();
        ImageIcon bot2Icon = new ImageIcon(this.getClass().getResource("/StripeBot.png"));
        Image bot2Img = bot2Icon.getImage();
        Image adjustedBot2 = bot2Img.getScaledInstance(60, 70, Image.SCALE_SMOOTH);
        bot2.setBounds(400, 80, 60, 70);
        bot2Icon = new ImageIcon(adjustedBot2);
        bot2.setIcon(bot2Icon);

        JLabel bot3 = new JLabel();
        ImageIcon bot3Icon = new ImageIcon(this.getClass().getResource("/WhiteBot.png"));
        Image bot3Img = bot3Icon.getImage();
        Image adjustedBot3 = bot3Img.getScaledInstance(60, 70, Image.SCALE_SMOOTH);
        bot3.setBounds(700, 80, 60, 70);
        bot3Icon = new ImageIcon(adjustedBot3);
        bot3.setIcon(bot3Icon);
        bg.add(bot1);
        bg.add(bot2);
        bg.add(bot3);
    }

    public void updatePlayer1Card(String cardStr) {
        if (cardStr.equals("D")) {
            updateDrawSymbol(this.player1Card, 80, 460, 85, 120);
        } else {
            updateCardLabel(this.player1Card, 80, 460, 85, 120, cardStr);
        }
        JLabel lastCardText = new JLabel("My Last Played Card");
        lastCardText.setBounds(60, 420, 125, 40);
        lastCardText.setForeground(Color.white);
        gameLabel.add(lastCardText);
    }
    public void updatePlayer2Card(String cardStr) {
        if (cardStr.equals("D")) {
            updateDrawSymbol(this.player2Card, 200, 60, 85, 120);
        } else {
            updateCardLabel(this.player2Card, 200, 60, 85, 120, cardStr);
        }
    }

    public void updatePlayer3Card(String cardStr) {
        if (cardStr.equals("D")) {
            updateDrawSymbol(this.player3Card, 500, 60, 85, 120);
        } else {
            updateCardLabel(this.player3Card, 500, 60, 85, 120, cardStr);
        }
    }

    public void updatePlayer4Card(String cardStr) {
        if (cardStr.equals("D")) {
            updateDrawSymbol(this.player4Card, 800, 60, 85, 120);
        } else {
            updateCardLabel(this.player4Card, 800, 60, 85, 120, cardStr);
        }

    }

    public void updateLastPlayed(String cardStr) {
        updateCardLabel(this.lastPlayedCard, 300, 250, 85, 120, cardStr);
        JLabel lastCardText = new JLabel("Last Card Played");
        lastCardText.setBounds(290, 210, 105, 40);
        lastCardText.setForeground(Color.white);
        gameLabel.add(lastCardText);
    }

    public void addGameButtons(JLabel bg) {
        JButton playButton = new JButton("Play Card");
        playButton.setBounds(800, 450, 100, 60);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                new PlayCardWindow(c);
            }
        });
        bg.add(playButton);
        JButton drawButton = new JButton("Draw Card");
        drawButton.setBounds(800, 540, 100, 60);
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.drawCard();
            }
        });
        bg.add(drawButton);
    }

    public void displayAvailableCards(String[] cardList) {
        JLabel availableCardText = new JLabel("My Cards");
        availableCardText.setBounds(260, 400, 70, 40);
        availableCardText.setForeground(Color.white);
        gameLabel.add(availableCardText);

        for (int i=0; i<this.myAvailableMoves.length; i++) {
            if (i<cardList.length) {
                this.myAvailableMoves[i].setVisible(true);
                int cardX = 260 + 70*(i / 2);
                int cardY = 440 + 90*(i % 2);
                updateCardLabel(this.myAvailableMoves[i], cardX, cardY, 60, 80, cardList[i]);
            } else {
                this.myAvailableMoves[i].setVisible(false);
            }
        }
    }


    /**
     * number card
     * @param cardX
     * @param cardY
     * @param cardStr
     * I will give a string that represents the card, which will be in the form of "value-colour"
     * For example: number card "1-red"
     * plus four card "+4"
     * plus two card "+2-red"
     * reverse card "R-red"
     * skip card "S-red"
     * wild card "W"
     */
    public void updateCardLabel(JLabel card, int cardX, int cardY, int width, int height, String cardStr) {
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
        card.setIcon(null);
        card.setOpaque(true);
        card.setFont(new Font("Monospace", Font.PLAIN, 30));
        card.setHorizontalAlignment(SwingConstants.CENTER);
        card.setBorder(BorderFactory.createLineBorder(Color.white));
    }

    public void updateDrawSymbol(JLabel card, int cardX, int cardY, int width, int height) {
        ImageIcon cardBack = new ImageIcon(this.getClass().getResource("/CardBackSide.png"));
        Image cardBackImg = cardBack.getImage();
        Image adjustedCardBack = cardBackImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        cardBack = new ImageIcon(adjustedCardBack);
        card.setIcon(cardBack);
        card.setBounds(cardX, cardY, width, height);
        card.setText("");
        card.setBackground(null);
    }


}
