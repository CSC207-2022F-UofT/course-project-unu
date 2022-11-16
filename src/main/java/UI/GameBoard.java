package UI;

import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * when creating colour choosing page, use JPopMenu
 */
public class GameBoard{

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




    /**
     * number card
     * @param cardX
     * @param cardY
     * @param colour
     * @param number
     */
    public void createCardLabel(int cardX, int cardY, Color colour, int number) {
        JLabel cardLabel = new JLabel();
        cardLabel.setBounds(cardX, cardY, 50, 100);
        cardLabel.setText(String.valueOf(number));
        cardLabel.setBackground(colour);

        //TODO:
        //gamePanel[2].add(cardLabel);

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
