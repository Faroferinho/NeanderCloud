package pages;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import functions.UserInterface;
import main.NeanderCloud;

public class Product {
	String name;
	int picX = 40;
	int picY = 120;
	int picW ;
	int picH ;
	
	BufferedImage img;

	public Product(int productID) {
		// TODO Auto-generated constructor stub
		int imgX = 0;
		int imgY = 0;
		
		switch(productID) {
		case 0:
			name = "";
			imgX = 0;
			imgY = 0;
			break;
		}
		
		img = NeanderCloud.iLoader.getSprite(imgX, imgY);
		
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g) {
		UserInterface.firstRender(g);
	}

}
