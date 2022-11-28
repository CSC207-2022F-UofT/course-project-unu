package UI;

import interfaceAdapters.Controller;

import javax.swing.*;
import java.awt.*;

public class ViewMethods implements View{

    GameManager gm;
    GameBoard gameBoard;
    Controller c;

    public ViewMethods(GameManager gm) {
        this.gm = gm;
        this.c = new Controller();
        StartPage sp = new StartPage(c);
        /**
         * only comment out start page for testing
         * TODO: Change back to start page
         */

//        generateGameBoard(c);
//        String[] str = new String[7];
//        str[0] = "W";
//        str[1] = "+4";
//        str[2] = "1-red";
//        str[3] = "+2-green";
//        str[4] = "R-blue";
//        str[5] = "S-yellow";
//        str[6] = "0-red";
//        updateAvailableCards(str);
//        String[] str1 = new String[6];
//        str1[0] = "W";
//        str1[1] = "+4";
//        str1[2] = "1-red";
//        str1[3] = "+2-green";
//        str1[4] = "R-blue";
//        str1[5] = "S-yellow";
//
//        updateAvailableCards(str1);
//        updateMyLastPlayedCard("R-green");
//        updateMyLastPlayedCard("R-blue");
//        updateLastCardPlayed("S-blue");
//        updateBot1Card("+2-yellow");
//        updateBot1Card("D");
//        updateBot2Card("W");
//        updateBot2Card("D");
//        updateBot3Card("D");
//        updateBot3Card("+4");
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

    @Override
    public void updateAvailableCards(String[] cardList) {
        gameBoard.displayAvailableCards(cardList);
    }

    @Override
    public void requestColourChange() {
        new ChooseColourPage(c);
    }
    @Override
    public void generatePlayWindow(){

    }

}
