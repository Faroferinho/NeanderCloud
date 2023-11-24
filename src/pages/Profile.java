package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import functions.Interactions;
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
		
		g.drawImage(NeanderCloud.iLoader.getSprite(1066*0, 0), imgX[0], imgY + auxHeight, boxWidth, boxHeight, null);
		g.drawImage(NeanderCloud.iLoader.getSprite(1066*1, 0), imgX[1], imgY + auxHeight, boxWidth, boxHeight, null);
		g.drawImage(NeanderCloud.iLoader.getSprite(1066*2, 0), imgX[2], imgY + auxHeight, boxWidth, boxHeight, null);
		g.drawImage(NeanderCloud.iLoader.getSprite(1066*3, 0), imgX[0], imgY*2 + auxHeight, boxWidth, boxHeight, null);
		g.drawImage(NeanderCloud.iLoader.getSprite(1066*4, 0), imgX[1], imgY*2 + auxHeight, boxWidth, boxHeight, null);
		g.drawImage(NeanderCloud.iLoader.getSprite(1066*5, 0), imgX[2], imgY*2 + auxHeight, boxWidth, boxHeight, null);
		g.drawImage(NeanderCloud.iLoader.getSprite(1066*0, 1600), imgX[0], imgY*3 + auxHeight, boxWidth, boxHeight, null);
		g.drawImage(NeanderCloud.iLoader.getSprite(1066*1, 1600), imgX[1], imgY*3 + auxHeight, boxWidth, boxHeight, null);
		g.drawImage(NeanderCloud.iLoader.getSprite(1066*2, 1600), imgX[2], imgY*3 + auxHeight, boxWidth, boxHeight, null);
		
		if(scroll > 1 && auxHeight > -(imgY*2 + boxHeight - 120)) {
			auxHeight -= UserInterface.spd;
			//System.out.println("Scroll Down \nAuxHeight: " + auxHeight);
			scroll = 0;
		}else if(scroll < -1 && auxHeight < 0) {
			auxHeight += UserInterface.spd;
			//System.out.println("Scroll Down \nAuxHeight: " + auxHeight);
			scroll = 0;
		}
		
		if(NeanderCloud.state == 2) {
			if(click == true) {
				int auxX = 0;
				int auxY = 1;
				for(int i = 0; i < 9; i++) {
					if(Interactions.mouseIntersection(imgX[auxX], imgY*auxY + auxHeight, boxWidth, boxHeight)) {
						System.out.println("Produto: " + i);
						NeanderCloud.productID = i;
						NeanderCloud.state = 3;
					}
					
					auxX++;
					if(auxX == 2) {
						auxX = 0;
						auxY++;
					}
				}
				click = false;
			}
			//System.out.println("Scroll Status: " + scroll);
			if(scroll > 1 && auxHeight > -imgY*4 - 25) {
				auxHeight -= UserInterface.spd;
				//System.out.println("Scroll Down \nAuxHeight: " + auxHeight);
				System.out.println("AuxHeight: " + auxHeight);
				scroll = 0;
			}else if(scroll < -1 && auxHeight < 0) {
				auxHeight += UserInterface.spd;
				//System.out.println("Scroll Down \nAuxHeight: " + auxHeight);
				scroll = 0;
			}
		}
		
		UserInterface.scrollLimmiter(g);
	}
}
