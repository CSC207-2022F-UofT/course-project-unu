package UI;

import javax.swing.*;
import java.awt.*;

public class ViewMethods implements View{

    GameManager gm;

    public ViewMethods(GameManager gm) {
        this.gm = gm;
        //StartPage sp = new StartPage();
        /**
         * only comment out start page for testing
         * TODO: Change back to start page
         */
        GameBoard gameBoard = new GameBoard();
    }

    @Override
    public void generateGame() {

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
    public void updateBot1Card() {

    }

    @Override
    public void updateBot2Card() {

    }

    @Override
    public void updateBot3Card() {

    }

}
