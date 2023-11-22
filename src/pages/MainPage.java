package pages;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainPage extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public MainPage(Dimension screenSize, Canvas nC){
		
		add(nC);
		setPreferredSize(screenSize);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.black);
		
		pack();
		setVisible(true);
	}
	
}
