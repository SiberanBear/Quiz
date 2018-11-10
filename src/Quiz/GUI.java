package Quiz;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUI extends JFrame implements Runnable
{
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Привет! Для начала скажи, как я могу к тебе обращаться?");
    private JLabel label1 = new JLabel("");
    private JButton answer1Button = new JButton("1");
    private JButton answer2Button = new JButton("2");
    private JButton answer3Button = new JButton("3");
    private JButton answer4Button = new JButton("4");
    private JButton hintButton = new JButton("Подсказка 50/50");
    private JButton helpButton = new JButton("Справка");
    private JButton but7 = new JButton("Ввести имя");
    private String name;
    private Event even;
    private GameQuiz ga;

    GUI(Event eve, GameQuiz g) {
        super("Quiz");
        even = eve;
        ga = g;
        this.setBounds(300, 200, 500, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(null);

        label.setLocation(30, 10);
        label.setSize(470,40);

        input.setLocation(10,50);
        input.setSize(470,40);

        but7.setLocation(250,100);
        but7.setSize(200,35);

        container.add(label);
        container.add(input);
        container.add(but7);

        this.setVisible(true);

        ButtonEventListener be = new ButtonEventListener();
        but7.addActionListener(be);
    }

    public class form2 extends JFrame
    {
        form2()
        {
            super("Quiz");
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
            answer2Button.setLocation(250,160);
            answer2Button.setSize(200,40);
            answer3Button.setLocation(30,220);
            answer3Button.setSize(200,40);
            answer4Button.setLocation(250,220);
            answer4Button.setSize(200,40);

            hintButton.setLocation(5,280);
            hintButton.setSize(477,40);
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
            label1.setText("Для начала, выберите тематику вопросов: 1.МатМех 2.География");

            ButtonEventListener be = new ButtonEventListener();
            answer1Button.addActionListener(be);
            answer2Button.addActionListener(be);
            answer3Button.addActionListener(be);
            answer4Button.addActionListener(be);
            hintButton.addActionListener(be);
            helpButton.addActionListener(be);
        }
    }
    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == helpButton) {
                JOptionPane.showMessageDialog(null,
                        "Правила очень простые: Я буду задавать вопросы, \n"
                                + "а тебе нужно будет выбрать из четырёх вариантов ответа единственно верный. \n"
                                + "За правильный ответ будет начислено 100 очков, за неправильный - отнято 300. \n"
                                + "Так же я могу немного помочь. Но увы не бесплатно. Цена в 300 очков меня вполне устроит. \n"
                                + "Как выиграть? Останься в плюсе до конца! Удачной игры!");
            }
            if (even.getNumber().equals("0")) {
                if (e.getSource() == answer1Button) {
                    even.setNumber(answer1Button.getText());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    setMessage(ga.getQ(), "");
                }
                else if (e.getSource() == answer2Button) {
                    even.setNumber(answer2Button.getText());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    setMessage(ga.getQ(), "");
                }
                else if (e.getSource() == but7) {
                    name = input.getText();
                    if (!name.equals("")) {
                        GUI.form2 f = new GUI.form2();
                        f.setVisible(true);
                        GUI.this.setVisible(false);
                    }
                }
            }
            else {
                if(e.getSource() == answer1Button) {
                    ga.setAnswer(answer1Button.getText());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    setMessage(ga.getQ(), ga.getBotAnswer());
                }
                else if (e.getSource() == answer2Button) {
                    ga.setAnswer(answer2Button.getText());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    setMessage(ga.getQ(), ga.getBotAnswer());
                }
                else if (e.getSource() == answer3Button) {
                    ga.setAnswer(answer3Button.getText());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    setMessage(ga.getQ(), ga.getBotAnswer());
                }
                else if (e.getSource() == answer4Button) {
                    ga.setAnswer(answer4Button.getText());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    setMessage(ga.getQ(), ga.getBotAnswer());
                }
                else if (e.getSource() == hintButton) {
                    ga.setAnswer("5");
                    if (ga.point < 300)
                        label1.setText("У тебя недостаточно очков");
                    else{
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        setMessage(ga.getQ(), ga.getHint());
                    }
                }
            }

            if (ga.choise == 0 && ga.point >= 0)
                setMessage(", You win!", "Вы набрали " + ga.point + " очков!");
            if (ga.point < 0)
                setMessage(", Game over!", "У вас " + ga.point + " очков");
        }
    }


    private void setMessage(String message1, String message2){
        label.setText("<html>" + name + message1  + "</html>");
        label1.setText(message2);
    }

    @Override
    public void run() {
        try {
            this.setVisible(true);
            even.startGame(name, ga, even);
        } catch (FileException e1) {
            e1.printStackTrace();
        }
    }
}