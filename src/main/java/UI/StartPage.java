package UI;

import javax.swing.*;

public class StartPage {

    GameManager gm;
    JFrame window;
    ImageIcon startBG;
    JLabel myLabel;

    JButton startGameButton;
    JButton exitButton;
    JButton instruction;

    public StartPage(GameManager gm){

        this.gm = gm;

        createStartPage();

        window.setVisible(true);

    }

    public void createStartPage() {

        startBG = new ImageIcon(this.getClass().getResource("/bg.jpg"));
        myLabel = new JLabel(startBG);
        myLabel.setSize(800, 600);

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the windows properly
        //window.getContentPane().setBackground(black);
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.add(myLabel);

        startGameButton = new JButton("Start");
        startGameButton.setBounds(120, 300, 100, 50);
        instruction = new JButton("Instruction");
        instruction.setBounds(120, 365, 100, 50);
        exitButton = new JButton("Exit");
        exitButton.setBounds(120, 430, 100, 50);

        //startGameButton.addActionListener();

        myLabel.add(startGameButton);
        myLabel.add(exitButton);
        myLabel.add(instruction);

//        messageText = new JTextArea();
//        messageText.setBounds();
    }


}
