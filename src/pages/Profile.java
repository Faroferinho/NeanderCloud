package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import functions.UserInterface;
import main.NeanderCloud;

public class Profile {
	public boolean reset;
	public boolean isOnTheRightState = false;
	
	public static String name;
	public static String RdF;
	public static String CPF;
	
	public static int nameSize;
	public static int RdFSize;
	public static int CPFSize;

	public boolean mouseStatus = false;
	public boolean isEditing = false;

	static int auxHeight = 0;
	public static int scroll = 0;
	public static int spd = 11;
	
	
	static int imgX[] = new int[3];
	static int imgY = 335;
	static int spaceBetween = NeanderCloud.WIDTH/8;
	int initX =  (int) (NeanderCloud.WIDTH/2 - (boxWidth * 1.5 + spaceBetween));
	
	static int boxWidth = 150;
	static int boxHeight = 200;
	
	public boolean click = false;

	public Profile(String inName) {
		name = inName;
		
		for(int i = 0; i < 3; i++) {
			imgX[i] = initX + boxWidth*i + spaceBetween * i;
		}
	}
	
	public void genericRendering(Graphics g) {
		UserInterface.firstRender(g);
		g.setColor(Color.blue);
		g.fillRect(50, 132 + auxHeight, 100, 133);
		
		g.setColor(Color.orange);
		g.fillRect(180 * 4, 185 + auxHeight, 100, 50);
		
		g.setColor(Color.white);
		g.setFont(new Font("impact", 0, 20));
		g.drawString(name, 160, 165 + auxHeight);
		
		g.drawString("Biblioteca:", 75, imgY - 20 + auxHeight);
		
		g.setColor(Color.green);
		
		for(int i = 0; i < 3; i++) {
			//System.out.println("X: " + imgX[i] + ", Y: " + imgY + ", W: " + boxWidth + ", H: " + boxHeight);
			g.fillRect(imgX[i], imgY + auxHeight, boxWidth, boxHeight);
			g.fillRect(imgX[i], imgY*2 + auxHeight - 60, boxWidth, boxHeight);
		}
		
		if(scroll > 1) {
			auxHeight -= spd;
			//System.out.println("Scroll Down \nAuxHeight: " + auxHeight);
			scroll = 0;
		}else if(scroll < -1 && auxHeight < 0) {
			auxHeight += spd;
			//System.out.println("Scroll Down \nAuxHeight: " + auxHeight);
			scroll = 0;
		}
		UserInterface.scrollLimmiter(g);
	}
}
