package Quiz;

import javax.swing.*;
import java.awt.*;

public class NameWindow extends JFrame {
    JTextField input = new JTextField("", 5);
    JButton nameButton = new JButton("Ввести имя");
    String name;
    Helper helper;
    GameQuiz game;
    NameWindow(Helper e, GameQuiz g){
        super("Quiz");
        helper = e;
        game = g;
        this.setBounds(300, 200, 500, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(null);

        JLabel label = new JLabel("Привет! Для начала скажи, как я могу к тебе обращаться?");
        label.setLocation(30, 10);
        label.setSize(470,40);

        input.setLocation(10,50);
        input.setSize(470,40);

        nameButton.setLocation(250,100);
        nameButton.setSize(200,35);

        container.add(label);
        container.add(input);
        container.add(nameButton);
        this.setVisible(true);
        NameButtonEventListener be = new NameButtonEventListener(this);
        nameButton.addActionListener(be);
    }

//    @Override
//    public void run() {
//
//    }
}
