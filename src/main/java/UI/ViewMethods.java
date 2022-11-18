package UI;

import javax.swing.*;
import java.awt.*;

public class ViewMethods implements View{

    GameManager gm;
    GameBoard gameBoard;

    public ViewMethods(GameManager gm) {
        this.gm = gm;
        //StartPage sp = new StartPage();
        /**
         * only comment out start page for testing
         * TODO: Change back to start page
         */
        generateGameBoard();
        String[] str = new String[7];
        str[0] = "W";
        str[1] = "+4";
        str[2] = "1-red";
        str[3] = "+2-green";
        str[4] = "R-blue";
        str[5] = "S-yellow";
        str[6] = "0-red";
        displayAvailableCards(str);
    }

    @Override
    public void generateGameBoard() {
        gameBoard = new GameBoard();
    }

    public void displayAvailableCards(String[] cardList) {
        JLabel[] cardLabels = new JLabel[cardList.length];
        for (int i=0; i<cardList.length; i++) {
            System.out.println(i);
            int cardX = 260 + 70*(i / 2);
            System.out.println(cardX);
            int cardY = 440 + 90*(i % 2);
            System.out.println(cardY);
            cardLabels[i] = gameBoard.createCardLabel(cardX, cardY, 60, 80, cardList[i]);
        }
        gameBoard.displayAvailableCards(cardLabels);
    }


    @Override
    public void updateLastCardPlayed() {

    }

    @Override
    public void updateCardDrawn() {

    }

    @Override
    public void updateCardPlayed() {

    }

    @Override
    public void updateMyLastPlayedCard() {

    }

    @Override
    public void updateBot1Card() {

    }

    @Override
    public void updateBot2Card() {

    }

    @Override
    public void updateBot3Card() {

    }
    
    

    @Override
    public void requestColorChange() {

    }


}
