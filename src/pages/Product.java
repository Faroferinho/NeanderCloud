package pages;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import functions.UserInterface;
import main.NeanderCloud;

public class Product {
	String name;
	int spriteX = 0;
	int spriteY = 0;
	int picX = 40;
	int picY = 120;
	int picW;
	int picH;
	
	static BufferedImage img;

	public Product() {
		// TODO Auto-generated constructor stub
		switch(NeanderCloud.productID) {
		case 1:
			spriteX += 1066;
		case 2:
			spriteX += 1066;
		case 3:
			spriteX += 1066;
			break;
		case 4:
			spriteX += 1066;
			break;
		case 5:
			spriteX += 1066;
			break;
		case 6:
			spriteX = 0;
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		}
		img = NeanderCloud.iLoader.getSprite(spriteX, spriteY);
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g) {
		UserInterface.firstRender(g);
	}

}
