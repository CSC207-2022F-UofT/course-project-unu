package UI;

import javax.swing.*;
import java.awt.*;

public class ViewMethods implements View{

    GameManager gm;
    JFrame window;

    public JPanel gamePanel[] = new JPanel[5];
    public JLabel gameLabel[] = new JLabel[5];

    public ViewMethods(GameManager gm) {
        this.gm = gm;

        createMainField();
        StartPage sp = new StartPage(this, window, gamePanel, gameLabel);
        sp.generateScreen();

        window.setVisible(true);
    }


    @Override
    public void createMainField() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the windows properly
        //window.getContentPane().setBackground(black);
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    @Override
    public void createBackground(int panelNum, String bgFileName) {
        ImageIcon startBG = new ImageIcon(this.getClass().getResource(bgFileName));
        gamePanel[panelNum] = new JPanel();
        gamePanel[panelNum].setBounds(0, 0, 800, 600);
        gamePanel[panelNum].setBackground(Color.blue);
        gamePanel[panelNum].setLayout(null);
        window.add(gamePanel[panelNum]);

        gameLabel[panelNum] = new JLabel();
        gameLabel[panelNum].setBounds(0, 0, 800, 600);
        gameLabel[panelNum].setIcon(startBG);

        gamePanel[panelNum].add(gameLabel[panelNum]);
    }
}
