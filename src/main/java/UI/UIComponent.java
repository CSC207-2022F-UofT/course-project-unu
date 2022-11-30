package UI;

import interfaceAdapters.Controller;

import javax.swing.*;

public abstract class UIComponent {

    Controller c;

    public UIComponent(Controller c) {
        this.c = c;
    }

    public JFrame createMainField(String screenName, int width, int height) {
        JFrame window = new JFrame();
        window.setSize(width, height);
        window.setTitle(screenName);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the windows properly
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        return window;
    }

    public abstract void generateScreen();

}
