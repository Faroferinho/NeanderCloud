package functions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	private BufferedImage spritesheet;
	
	public ImageLoader(){
		try {
			spritesheet = ImageIO.read(new File("res/SpriteSheet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedImage getSprite(int x, int y) {
		int width = 1066;
		int height = 1600;
		
		return spritesheet.getSubimage(x, y, width, height);
	}
	
	public BufferedImage getLogo() {
		return spritesheet.getSubimage(1066, 1600, 524, 103);
	}
	
	

}
