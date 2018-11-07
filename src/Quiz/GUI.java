package Quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame implements Runnable {
	public JTextField input = new JTextField("", 5);
	public JLabel label = new JLabel("Привет! Для начала скажи, как я могу к тебе обращаться?");
	public JLabel label1 = new JLabel("");
	public  JButton but1 = new JButton("1");
	public  JButton but2 = new JButton("2");
	public  JButton but3 = new JButton("3");
	public  JButton but4 = new JButton("4");
	public JButton but5 = new JButton("Подсказка 50/50");
	public JButton but6 = new JButton("Справка");
	public JButton but7 = new JButton("Ввести имя");
	public JButton but8 = new JButton("Начать игру!");
	public  String number;
	public String name;
	Event even;
	GameQuiz ga;
	boolean flag = true;
	boolean flag1;
	
	public GUI (Event eve, GameQuiz g) {
		super("Quiz");
		even = eve;
		ga = g;
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(11, 1, 2, 2));
		container.add(label);
		container.add(label1);
		container.add(input);
		container.add(but1);
		container.add(but2);
		container.add(but3);
		container.add(but4);
		container.add(but5);
		container.add(but6);
		container.add(but7);
		container.add(but8);
		ButtonEventListener be = new ButtonEventListener();
		but1.addActionListener(be);
		but2.addActionListener(be);
		but3.addActionListener(be);
		but4.addActionListener(be);
		but5.addActionListener(be);	
		but6.addActionListener(be);
		but7.addActionListener(be);
		but8.addActionListener(be);
	}
	
	class ButtonEventListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			if (even.getNumber() == "0") {
				if (e.getSource() == but1) {
					even.setNumber(but1.getText());	
					setMessage1("Тематика выбрана, вы готовы начать игру?");
				}
				else if (e.getSource() == but2) {
					even.setNumber(but2.getText());	
					setMessage1("Тематика выбрана, вы готовы начать игру?");
				}
				
				else if (e.getSource() == but7)	{
					name = input.getText();
					but7.setEnabled(false);	
					setMessage1("Приятно познакомиться, " + name + "!\nДавай сыграем! "
							+ "\nДля ответа на вопросы используйте клавиши от 1 до 4. Справка вызывается по нажатию клавиши 0");
					setMessage2("Для начала, выберите тематику вопросов: 1.матмех, 2.география");
				}
			}
				
			else {	
				if(e.getSource() == but1) {	
					ga.setAnswer(but1.getText());
					setMessage2(ga.botAnswer);					
					}
				else if (e.getSource() == but2) {
					ga.setAnswer(but2.getText());
					setMessage2(ga.botAnswer);			
					}
				else if (e.getSource() == but3) {
					ga.setAnswer(but3.getText());
					setMessage2(ga.botAnswer);
					}
				else if (e.getSource() == but4) {
					ga.setAnswer(but4.getText());
					setMessage2(ga.botAnswer);
					}
				else if (e.getSource() == but5)
					number = "5";
				else if (e.getSource() == but6) {
					number = "6";
					setMessage1(ga.getQ());
					setMessage2(even.help);
				}

				else if (e.getSource() == but8) {
					ga.setAnswer("8");
					setMessage1(ga.getQ());
				}
			}
			if (ga.choise == 0)
				setMessage2("Нет вопросов");
			if (ga.point < 0) 
				setMessage2("ПРойгрыш");
			
		}
		
		public void setMessage1(String s) {
			label.setText(s);
		}
		
		public void setMessage2(String s) {
			label1.setText(s);
		}		
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

