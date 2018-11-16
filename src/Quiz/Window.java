package Quiz;
import javax.swing.*;
import java.awt.*;

class Window extends JFrame {
    private JLabel label = new JLabel();
    JLabel label1 = new JLabel("");
    JButton answer1Button = new JButton("1");
    JButton answer2Button = new JButton("2");
    JButton answer3Button = new JButton("3");
    JButton answer4Button = new JButton("4");
    JButton hintButton = new JButton("Подсказка 50/50");
    private String name;
    Helper helper;
    GameQuiz game;

    Window(Helper h, GameQuiz g, String n) {
        super("Quiz");
        name = n;
        helper = h;
        game = g;
        this.setBounds(300, 150, 500, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(null);

        label.setLocation(10, 0);
        label.setSize(470,80);
        label1.setLocation(10,80);
        label1.setSize(470,30);

        answer1Button.setLocation(30,160);
        answer1Button.setSize(200,40);
        //answer1Button.setText(helper.reader.theme.get(0));
        answer2Button.setLocation(250,160);
        answer2Button.setSize(200,40);
        //answer2Button.setText(helper.reader.theme.get(1));
        answer3Button.setLocation(30,220);
        answer3Button.setSize(200,40);
        answer4Button.setLocation(250,220);
        answer4Button.setSize(200,40);

        hintButton.setLocation(5,280);
        hintButton.setSize(477,40);
        JButton helpButton = new JButton("Справка");
        helpButton.setLocation(5,330);
        helpButton.setSize(477,40);

        container.add(label);
        container.add(label1);
        container.add(answer1Button);
        container.add(answer2Button);
        container.add(answer3Button);
        container.add(answer4Button);
        container.add(hintButton);
        container.add(helpButton);

        label.setText("<html>Приятно познакомиться, " + name + "! Давай сыграем!"
                + "<br>Для ответа на вопросы используйте кнопки от 1 до 4.</html>");
        label1.setText("Для начала, выберите тематику вопросов: 1.Матмех, 2.География");

        ButtonEventListener be = new ButtonEventListener(this);
        answer1Button.addActionListener(be);
        answer2Button.addActionListener(be);
        answer3Button.addActionListener(be);
        answer4Button.addActionListener(be);

        HelpButtonEventListener hbe = new HelpButtonEventListener(helpButton);
        helpButton.addActionListener(hbe);

        HintButtonEventListener hbe1 = new HintButtonEventListener(this);
        hintButton.addActionListener(hbe1);
    }

    void setMessage(String message1, String message2) {
        label.setText(name + ", " + message1);
        label1.setText(message2);
    }
}