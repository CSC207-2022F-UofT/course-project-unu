package UI;

import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard implements View{

    //private final Controller c;

    private final JLabel label;

    public GameBoard() {
        final JFrame frame = new JFrame();
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        label = new JLabel();
        frame.add(label);

        // TODO: ask if we can have a default Game initializer
        //Game g = new Game();
        //c = new Controller(g)

        frame.setVisible(true);
    }

    @Override
    public void createStartPage() {

    }

    @Override
    public void createGamePage() {

    }

    @Override
    public void updateCardDeck() {

    }

    @Override
    public void chooseColour() {

    }
}
