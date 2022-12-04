package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * UI component, extends the abstract UIComponent
 * this class generates the main game board UI that allows the user to interact with the game
 * the user can choose to play card or draw card
 * the game board will also update the last move that each player has taken, such as the card played or drawn
 * the game board will also update the real player's card on hand
 */
public class GameBoard extends UIComponent{

    JFrame window;
    JPanel gamePanel;
    JLabel gameLabel;
    JLabel player1Card;
    JLabel player2Card;
    JLabel player3Card;
    JLabel player4Card;
    JLabel lastPlayedCard;
    JLabel[] myAvailableMoves;

    /**
     * Constructor, creates a new game board window
     * @param c the controller object that the game board will interact with
     */
    public GameBoard(Controller c) {
        super(c);
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

    /**
     * sets up the screen of the game board
     */
    public void generateScreen() {
        //create a main field
        window = super.createMainField("Game Board", 1000, 700);

        //set background
        gamePanel = new JPanel();
        gamePanel.setBounds(0, 0, 1000, 700);
        gamePanel.setLayout(null);
        window.add(gamePanel);
        gameLabel = new JLabel();
        gameLabel.setBounds(0, 0, 1000, 700);
        ImageIcon startBG = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/gameBoardBG.png")));
        Image bgImg = startBG.getImage();
        Image adjustedBg = bgImg.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
        startBG = new ImageIcon(adjustedBg);
        gameLabel.setIcon(startBG);
        gamePanel.add(gameLabel);

        //add player labels and play game buttons
        createPlayerLabel(gameLabel);
        addGameButtons(gameLabel);
        JLabel[] labels = {this.player1Card, this.player2Card, this.player3Card, this.player4Card, this.lastPlayedCard};
        for (JLabel label : labels) {
            gameLabel.add(label);
        }
        for (JLabel myAvailableMove : this.myAvailableMoves) {
            gameLabel.add(myAvailableMove);
        }
    }

    /**
     * add the bot player labels to the background
     * @param bg the background label
     */
    public void createPlayerLabel(JLabel bg) {
        JLabel bot1 = new JLabel();
        bot1.setBounds(100, 80, 60, 70);
        bot1.setIcon(super.adjustedImage("/RedBot.png", 60, 70));

        JLabel bot2 = new JLabel();
        bot2.setBounds(400, 80, 60, 70);
        bot2.setIcon(super.adjustedImage("/StripeBot.png", 60, 70));

        JLabel bot3 = new JLabel();
        bot3.setBounds(700, 80, 60, 70);
        bot3.setIcon(super.adjustedImage("/WhiteBot.png", 60, 70));
        bg.add(bot1);
        bg.add(bot2);
        bg.add(bot3);
    }

    /**
     * helper method, update's each player's action
     * @param card the card label of each player
     * @param cardX x position of the card label
     * @param cardY y position of the card label
     * @param width card width
     * @param height card height
     * @param cardStr string representation of card
     */
    public void updateAction(JLabel card, int cardX, int cardY, int width, int height, String cardStr){
        if (cardStr.equals("D")) {
            updateDrawSymbol(card, cardX, cardY, width, height);
        } else {
            updateCardLabel(card, cardX, cardY, width, height, cardStr);
        }
    }

    /**
     * methods updating each player's card
     * @param cardStr string representation of a card
     */
    public void updatePlayer1Card(String cardStr) {
        updateAction(this.player1Card, 80, 460, 85, 120, cardStr);

        JLabel lastCardText = new JLabel("My Last Played Card");
        lastCardText.setBounds(60, 420, 125, 40);
        lastCardText.setForeground(Color.white);
        gameLabel.add(lastCardText);
    }
    public void updatePlayer2Card(String cardStr) {
        updateAction(this.player2Card,200, 60, 85, 120, cardStr);
    }
    public void updatePlayer3Card(String cardStr) {
        updateAction(this.player3Card, 500, 60, 85, 120, cardStr);
    }
    public void updatePlayer4Card(String cardStr) {
        updateAction(this.player4Card, 800, 60, 85, 120, cardStr);
    }

    /**
     * update the last played card of the game
     * @param cardStr the string representation of the card
     */
    public void updateLastPlayed(String cardStr) {
        updateCardLabel(this.lastPlayedCard, 300, 250, 85, 120, cardStr);
        JLabel lastCardText = new JLabel("Last Card Played");
        lastCardText.setBounds(290, 210, 105, 40);
        lastCardText.setForeground(Color.white);
        gameLabel.add(lastCardText);
    }

    /**
     * add and set actions to the game buttons (play and draw) buttons
     * so the user can make a move
     * @param bg the background label that the game buttons will be added to
     */
    public void addGameButtons(JLabel bg) {
        JButton playButton = new JButton("Play Card");
        playButton.setBounds(800, 450, 100, 60);
        playButton.addActionListener(e -> c.requestPossibleMoves());
        bg.add(playButton);
        JButton drawButton = new JButton("Draw Card");
        drawButton.setBounds(800, 540, 100, 60);
        drawButton.addActionListener(e -> c.drawCard());
        bg.add(drawButton);
    }

    /**
     * display all the cards on the user's hand
     * @param cardList an arraylist of string representation of cards on the user's hand
     */
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
     * update a label with the corresponding card given a string representation of the card
     * @param cardX x position of card
     * @param cardY y position of card
     * @param cardStr the string representation of a card
     * cardStr convention
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
        String cardText = super.getCardText(cardStr);
        Color cardColor = super.getCardColor(cardStr);
        if (cardColor == Color.yellow) {
            card.setForeground(Color.black);
        } else {
            card.setForeground(Color.white);
        }

        card.setText(cardText);
        card.setBackground(cardColor);
        card.setIcon(null);
        card.setOpaque(true);
        card.setFont(new Font("Monospace", Font.PLAIN, 30));
        card.setHorizontalAlignment(SwingConstants.CENTER);
        card.setBorder(BorderFactory.createLineBorder(Color.white));
    }

    /**
     * update a card label with the draw card symbol
     * @param card card label
     * @param cardX x position of the card
     * @param cardY y position of the card
     * @param width card width
     * @param height card height
     */
    public void updateDrawSymbol(JLabel card, int cardX, int cardY, int width, int height) {
        card.setIcon(super.adjustedImage("/CardBackSide.png", width, height));
        card.setBounds(cardX, cardY, width, height);
        card.setText("");
        card.setBackground(null);
    }

    /**
     * make the game window disappear after a game has end
     */
    public void discardWindow() {
        window.setVisible(false);
    }

}
