package Quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {
	public JButton button = new JButton("cyka bla");
	public JTextField input = new JTextField("", 5);
	public JLabel label = new JLabel("");
	public JLabel label1 = new JLabel("");
	public String s = "";
	public JButton but1 = new JButton("1");
	public JButton but2 = new JButton("2");
	public JButton but3 = new JButton("3");
	public JButton but4 = new JButton("4");
	public String number = "0";
	
	public GUI () {
		super("Quiz");
		this.setBounds(100, 100, 400, 400);
		//this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(8, 1, 2, 2));
		container.add(label);
		container.add(label1);
		container.add(input);
		container.add(but1);
		container.add(but2);
		container.add(but3);
		container.add(but4);
		ButtonEventListener be = new ButtonEventListener();
		but1.addActionListener(be);
		but2.addActionListener(be);
		but3.addActionListener(be);
		but4.addActionListener(be);
		button.addActionListener(be);
		container.add(button);
		
	}
	
	public String getName() {
		return this.s;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNumber() {
		return this.number;
	}
	
	class ButtonEventListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == but1)
				setNumber(but1.getText());
			else if (e.getSource() == but2)
				setNumber(but2.getText());
			else if (e.getSource() == but3)
				setNumber(but3.getText());
			else if (e.getSource() == but4)
				setNumber(but4.getText());
			else if (e.getSource() == button) {
				s = input.getText();
			}
			//JOptionPane.showMessageDialog(null, s, "output", JOptionPane.PLAIN_MESSAGE);
		}	
	}
}

