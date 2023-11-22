package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import pages.MainPage;

public class NeanderCloud extends Canvas{
	
	private static final long serialVersionUID = 1L;
	
	public static int WIDTH = 0;
	public static int HEIGHT = 0;
	public static int state = 0;
	
	private static MainPage frame;
	public static Toolkit tk;
	
	public static void main(String args[]) {
		NeanderCloud nC = new NeanderCloud();
		tk = Toolkit.getDefaultToolkit();
		
		WIDTH = (tk.getScreenSize().width / 4) * 3;
		HEIGHT = (tk.getScreenSize().height / 4) * 3;
		
		JFrame frame = new JFrame();
		
		frame.add(nC);
		
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.black);
		
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	public NeanderCloud() {
		
	}
	
	public void tick() {
		
	}
	
	public void render() {
		BufferStrategy bs = frame.getBufferStrategy();
		
		if(bs == null) {
			frame.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.red);
		g.fillRect(12, 12, WIDTH-12, HEIGHT-12);
		
		bs.show();
	}
	
}
