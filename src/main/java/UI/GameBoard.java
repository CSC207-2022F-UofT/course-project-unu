package UI;

import game.Game;
import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

/**
 * when creating colour choosing page, use JPopMenu
 */
public class GameBoard{

    Controller c;
    ViewMethods vm;

    JFrame window;
    JPanel gamePanel;
    JLabel gameLabel;

    public GameBoard() {

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

        updatePlayer1Card(gameLabel);
        updatePlayer2Card(gameLabel);
        updatePlayer3Card(gameLabel);
        updatePlayer4Card(gameLabel);
        updateLastPlayed(gameLabel);


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

    public void updatePlayer1Card(JLabel bg) {
        JLabel card = createCardLabel(80, 460, 85, 120, "R-green");
        bg.add(card);
        JLabel lastCardText = new JLabel("My Last Played Card");
        lastCardText.setBounds(60, 420, 125, 40);
        lastCardText.setForeground(Color.white);
        bg.add(lastCardText);
    }

    public void updatePlayer2Card(JLabel bg) {
        JLabel card = createCardLabel(200, 60, 85, 120, "+4");
        bg.add(card);
    }

    public void updatePlayer3Card(JLabel bg) {
        JLabel card = createCardLabel(500, 60, 85, 120, "W");
        bg.add(card);
    }

    public void updatePlayer4Card(JLabel bg) {

        JLabel card = createCardLabel(800, 60, 85, 120, "R-green");
        bg.add(card);
    }

    public void updateLastPlayed(JLabel bg) {
        JLabel card = createCardLabel(300, 250, 85, 120, "R-green");
        bg.add(card);
        JLabel lastCardText = new JLabel("Last Card Played");
        lastCardText.setBounds(290, 210, 105, 40);
        lastCardText.setForeground(Color.white);
        bg.add(lastCardText);
    }

    public void addGameButtons(JLabel bg) {
        JButton playButton = new JButton("Play Card");
        playButton.setBounds(800, 450, 100, 60);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                new PlayCardWindow();
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

    public void displayAvailableCards(JLabel[] cardList) {
        JLabel availableCardText = new JLabel("My Cards");
        availableCardText.setBounds(260, 400, 70, 40);
        availableCardText.setForeground(Color.white);
        gameLabel.add(availableCardText);
        for (JLabel jLabel : cardList) {
            gameLabel.add(jLabel);
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
    public JLabel createCardLabel(int cardX, int cardY, int width, int height, String cardStr) {
        JLabel card = new JLabel();
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
            System.out.println(splitedCard);
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

        return card;
    }

    /**
     * special card
     * @param cardX
     * @param cardY
     * @param colour
     * @param label
     */
    public void createCardLabel(int cardX, int cardY, String colour, String label) {
        //TODO:imageicon
    }

    /**
     * create a colour choosing menu after the
     * @param wildCard
     */
    public void createColourChoosingMenu(JLabel wildCard) {
        JPopupMenu colourMenu = new JPopupMenu();
        JMenuItem colours[] = new JMenuItem[4];//0=red, 1=yellow, 2=green, 3=blue
        Color color[] = {Color.red, Color.yellow, Color.green, Color.blue};
        for (int i=0; i<colours.length; i++) {
            colours[i] = new JMenuItem();
            colours[i].setBackground(color[0]);
            //colours[i].addActionListener(gm.aHandler);
            colourMenu.add(colours[i]);
        }
        wildCard.addMouseListener(new MouseListener() {
            //see Video 3
            @Override
            public void mouseClicked(MouseEvent e) {
                colourMenu.show(wildCard, e.getX(), e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
