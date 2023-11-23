package main;

import java.awt.Color;
import java.awt.Graphics;

import functions.Interactions;

public class UserInterface {
	
	static int bttnX[] = new int[4];
	static int bttnY = 15;
	static int spaceBetween = NeanderCloud.WIDTH/16;
	int initX = NeanderCloud.WIDTH/8;
	
	static int boxWidth = 128;
	static int boxHeight = 64;
	
	public boolean click = false;
	
	public UserInterface() {
		// TODO Auto-generated constructor stub
		for(int i = 0; i < 4; i++) {
			bttnX[i] = initX + boxWidth*i + spaceBetween * i;
		}
	}
	
	public static void firstRender(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(24, bttnY*2 + boxHeight, NeanderCloud.WIDTH - 72, NeanderCloud.HEIGHT - (bttnY*2 + boxHeight) - 66);
		
		g.setColor(Color.gray);
		g.fillRect(24 + 6, bttnY*2 + boxHeight + 6, NeanderCloud.WIDTH - 84, NeanderCloud.HEIGHT - (bttnY*2 + boxHeight) - 78);
	}
	
	public void tick() {
		if(click == true) {
			System.out.println("UI Clicada");
			if(Interactions.mouseIntersection(bttnX[0], bttnY, boxWidth, boxHeight)) {
				NeanderCloud.state = 1;
			}else if(Interactions.mouseIntersection(bttnX[1], bttnY, boxWidth, boxHeight)) {
				NeanderCloud.state = 2;
			}else if(Interactions.mouseIntersection(bttnX[2], bttnY, boxWidth, boxHeight)) {
				NeanderCloud.state = 3;
			}else if(Interactions.mouseIntersection(bttnX[3], bttnY, boxWidth, boxHeight)) {
				System.exit(0);
			}
			
			click = false;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.orange);
		for(int i = 0; i < 4; i++) {
			if(i == 3) {
				g.setColor(Color.red);
			}
			g.fillRect(bttnX[i], bttnY, boxWidth, boxHeight);
		}
		
	}

}
