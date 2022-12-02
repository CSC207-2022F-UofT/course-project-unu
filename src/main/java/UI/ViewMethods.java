package UI;

import interfaceAdapters.Controller;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class ViewMethods implements View{

    GameManager gm;
    GameBoard gameBoard;
    Controller c;

    public ViewMethods(GameManager gm) {
        this.gm = gm;
        this.c = new Controller(this);
        new ResultPage(c, true);
        new StartPage(c);
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
    public void generatePlayWindow(List<String> cards) {
        new PlayCardWindow(c, cards);
    }

}
