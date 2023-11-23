package pages;

import java.awt.Color;
import java.awt.Graphics;

import main.NeanderCloud;
import main.UserInterface;

public class MainPage {
	
	static int imgX[] = new int[3];
	static int imgY = 15;
	static int spaceBetween = NeanderCloud.WIDTH/16;
	int initX = NeanderCloud.WIDTH/8;
	
	static int boxWidth = 128;
	static int boxHeight = 64;
	
	public MainPage(){
		for(int i = 0; i < 3; i++) {
			imgX[i] = initX + boxWidth*i + spaceBetween * i;
		}
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		UserInterface.firstRender(g);
		
		g.setColor(Color.blue);
		for(int i = 0; i < 3; i++) {
			System.out.println("X: " + imgX[i] + ", Y: " + imgY + ", W: " + boxWidth + ", H: " + boxHeight);
			g.fillRect(imgX[i], imgY, boxWidth, boxHeight);
		}
	}
}
