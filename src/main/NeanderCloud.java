package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import functions.Interactions;
import pages.LoginPage;


public class NeanderCloud extends Canvas implements Runnable, MouseListener, MouseMotionListener, KeyListener{
	
	private static final long serialVersionUID = 1L;
	
	public static int WIDTH = 0;
	public static int HEIGHT = 0;
	public static int state = 0;
	public static int mX;
	public static int mY;
	
	public static Toolkit tk;
	
	public static LoginPage loginP;
	
	
	public static void main(String args[]) {
		NeanderCloud nC = new NeanderCloud();
		tk = Toolkit.getDefaultToolkit();
		
		WIDTH = (tk.getScreenSize().width / 4) * 3;
		HEIGHT = (tk.getScreenSize().height / 4) * 3;
		System.out.println("Largura: " + WIDTH + ", Altura: " + HEIGHT);
		
		
		loginP = new LoginPage();
		
		
		
		JFrame frame = new JFrame();
		
		frame.add(nC);
		
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.black);
		
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		new Thread(nC).start();
	}
	
	public NeanderCloud() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
	}
	
	public static void tick() {
		
		switch(state) {
		case 0:
			loginP.tick();
			break;
		}
		
		
	}
	
	public void render() {
		// Eu crio uma BufferStrategy, ou seja, guardo memória para poder mostrar a prox. imagem;
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		//Crio um grafico usando os graficos do bs;
		Graphics g = bs.getDrawGraphics();
		
		switch(state) {
		case 0:
			loginP.render(g);
			break;
		}
		
		
		bs.show();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		loginP.click = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mX = e.getX();
		mY = e.getY();
		//System.out.println("X do Mouse: " + mX + " , Y do Mouse: " + mY);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Status do Inserir Senha: " + loginP.insertInfo);
		if(loginP.insertInfo == 1) {
			loginP.userID = Interactions.textAtualizer(e);
		}else if(loginP.insertInfo == 2) {
			loginP.userPassword = Interactions.textAtualizer(e);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
