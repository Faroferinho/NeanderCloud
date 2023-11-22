package pages;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.NeanderCloud;

public class MainPage extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JFrame frame = new JFrame("Login");
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JLabel userIDLable = new JLabel("ID:");
	JTextField userIDField = new JTextField();
	JLabel userPasswordLable = new JLabel("Password:");
	JPasswordField userPasswordField = new JPasswordField();
	JLabel messageLable = new JLabel("");

	public MainPage(NeanderCloud nC, int w, int h){
		JFrame frame = new JFrame();
		
		
		userIDLable.setBounds(50, 100, 75, 25);
		userIDField.setBounds(150, 100, 200, 25);
		userPasswordLable.setBounds(50, 200, 75, 25);
		userPasswordField.setBounds(150, 200, 200, 25);
		
		messageLable.setBounds(125, 350, 250, 35);
		messageLable.setFont(new Font(null, Font.ITALIC, 25));
		
		loginButton.setBounds(125, 250, 100, 25);
		loginButton.addActionListener(this);
		resetButton.setBounds(225, 250, 100, 25);
		resetButton.addActionListener(this);
		
		
		frame.add(nC);
		frame.add(userIDLable);
		frame.add(userIDField);
		frame.add(userPasswordLable);
		frame.add(userPasswordField);
		frame.add(messageLable);
		frame.add(loginButton);
		frame.add(resetButton);
		
		
		frame.setSize(w, h);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
