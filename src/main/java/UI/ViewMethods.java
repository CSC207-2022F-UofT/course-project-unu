package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;

public class ViewMethods implements View{

    GameManager gm;
    GameBoard gameBoard;
    Controller c;

    public ViewMethods(GameManager gm, Controller c) {
        this.gm = gm;
        StartPage sp = new StartPage(c);
        /**
         * only comment out start page for testing
         * TODO: Change back to start page
         */
        this.c = c;
        generateGameBoard(c);
        String[] str = new String[7];
        str[0] = "W";
        str[1] = "+4";
        str[2] = "1-red";
        str[3] = "+2-green";
        str[4] = "R-blue";
        str[5] = "S-yellow";
        str[6] = "0-red";
        updateAvailableCards(str);
        updateMyLastPlayedCard("R-green");
        updateLastCardPlayed("S-blue");
        updateBot1Card("+4");
        updateBot1Card("D");
        updateBot2Card("W");
        updateBot3Card("D");
        //requestColorChange();
    }

    @Override
    public void generateGameBoard(Controller c) {
        gameBoard = new GameBoard(c);
    }

    @Override
    public void updateLastCardPlayed(String card) {
        gameBoard.updateLastPlayed(card);
    }

    @Override
    public void updateMyLastPlayedCard(String card) {
        gameBoard.updatePlayer1Card(card);
    }

    @Override
    public void updateBot1Card(String card) {
        gameBoard.updatePlayer2Card(card);
    }

    @Override
    public void updateBot2Card(String card) {
        gameBoard.updatePlayer3Card(card);
    }

    @Override
    public void updateBot3Card(String card) {
        gameBoard.updatePlayer4Card(card);
    }

    public void updateAvailableCards(String[] cardList) {
        JLabel[] cardLabels = new JLabel[cardList.length];
        for (int i=0; i<cardList.length; i++) {
            int cardX = 260 + 70*(i / 2);
            int cardY = 440 + 90*(i % 2);
            cardLabels[i] = gameBoard.createCardLabel(cardX, cardY, 60, 80, cardList[i]);
        }
        gameBoard.displayAvailableCards(cardLabels);
    }

    @Override
    public void requestColorChange() {
        new ChooseColourPage(c);
    }

    @Override
    public void generatePlayWindow() {

    }

}
