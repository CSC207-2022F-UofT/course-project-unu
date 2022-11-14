package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeChoosingPage {
    JFrame window;
    ViewMethods vm;

    public JPanel gamePanel[];
    public JLabel gameLabel[];

    public ModeChoosingPage(ViewMethods vm, JFrame window, JPanel gamePanel[], JLabel gameLabel[]){

        this.vm = vm;
        this.window = window;
        this.gamePanel = gamePanel;
        this.gameLabel = gameLabel;

        generateScreen();

    }

    public void createModeChoosingButtons() {}


    public void generateScreen() {
        vm.createBackground(0,"/bg.jpg");
        createModeChoosingButtons();
    }
}
