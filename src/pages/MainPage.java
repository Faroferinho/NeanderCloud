package pages;

import java.awt.Color;
import java.awt.Graphics;

import functions.Interactions;
import functions.UserInterface;
import main.NeanderCloud;

public class MainPage {
	
	static int imgX[] = new int[3];
	static int imgY = 125;
	static int spaceBetween = NeanderCloud.WIDTH/8;
	int initX =  (int) (NeanderCloud.WIDTH/2 - (boxWidth * 1.5 + spaceBetween));
	
	static int boxWidth = 150;
	static int boxHeight = 200;
	
	public boolean click = false;
	
	static int auxHeight = 0;
	public static int scroll = 0;
	public static int spd = 11;
	
	public MainPage(){
		for(int i = 0; i < 3; i++) {
			imgX[i] = initX + boxWidth*i + spaceBetween * i;
		}
		
	}
	
	public void tick() {
		
		if(NeanderCloud.state == 1) {
			if(click == true) {
				for(int i = 0; i < 3; i++) {
					if((NeanderCloud.mY > 100 && NeanderCloud.mY < NeanderCloud.HEIGHT - 70) && (Interactions.mouseIntersection(imgX[i], imgY + auxHeight, boxWidth, boxHeight) ||
						Interactions.mouseIntersection(imgX[i], imgY*2 + auxHeight + boxHeight + 30, boxWidth, boxHeight) ||
						Interactions.mouseIntersection(imgX[i], imgY*3 + auxHeight + boxHeight*2 + 30, boxWidth, boxHeight))) {
						System.out.println("Clique");
						NeanderCloud.state = 3;
					}
				}
				click = false;
			}
			//System.out.println("Scroll Status: " + scroll);
			if(scroll > 1) {
				auxHeight -= spd;
				//System.out.println("Scroll Down \nAuxHeight: " + auxHeight);
				scroll = 0;
			}else if(scroll < -1 && auxHeight < 0) {
				auxHeight += spd;
				//System.out.println("Scroll Down \nAuxHeight: " + auxHeight);
				scroll = 0;
			}
		}
	}
	
	public void render(Graphics g) {
		UserInterface.firstRender(g);
		
		g.setColor(Color.green);
		
		for(int i = 0; i < 3; i++) {
			//System.out.println("X: " + imgX[i] + ", Y: " + imgY + ", W: " + boxWidth + ", H: " + boxHeight);
			g.fillRect(imgX[i], imgY + auxHeight, boxWidth, boxHeight);
			g.fillRect(imgX[i], imgY*2 + auxHeight + boxHeight + 30, boxWidth, boxHeight);
			g.fillRect(imgX[i], imgY*3 + auxHeight + boxHeight*2 + 30, boxWidth, boxHeight);
		}
		
		UserInterface.scrollLimmiter(g);
		
		
	}
}
