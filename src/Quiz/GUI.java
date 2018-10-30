package Quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {
	public JTextField input = new JTextField("", 5);
	public JLabel label = new JLabel("");
	public JLabel label1 = new JLabel("");
	public JButton but1 = new JButton("1");
	public JButton but2 = new JButton("2");
	public JButton but3 = new JButton("3");
	public JButton but4 = new JButton("4");
	public JButton but5 = new JButton("Подсказка 50/50");
	public JButton but6 = new JButton("Справка");
	public JButton but7 = new JButton("Ввести имя");
	public String number = "0";
	public String name;
	
	public GUI () {
		super("Quiz");
		//this.setBounds(0, 0, 650, 700);
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(10, 1, 2, 2));
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
		ButtonEventListener be = new ButtonEventListener();
		but1.addActionListener(be);
		but2.addActionListener(be);
		but3.addActionListener(be);
		but4.addActionListener(be);
		but5.addActionListener(be);	
		but6.addActionListener(be);
		but7.addActionListener(be);
	}
	
	class ButtonEventListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == but1) {
				number = but1.getText();
				but1.setSelected(true);
			}
			else if (e.getSource() == but2) {
				number = but2.getText();
				but2.setSelected(true);
			}
			else if (e.getSource() == but3)
				number = but3.getText();
			else if (e.getSource() == but4)
				number = but4.getText();
			else if (e.getSource() == but5)
				number = "5";
			else if (e.getSource() == but6) {
				number = "6";
				but6.setSelected(true);
			}
			else if (e.getSource() == but7)	{
				name = input.getText();
				but7.setSelected(true);
				but7.setEnabled(false);				
			}
		}	
	}
}

