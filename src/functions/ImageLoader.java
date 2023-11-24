package functions;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	private BufferedImage spritesheet;
	private BufferedImage backgroundLogin;
	private BufferedImage backgroundMain;
	
	public ImageLoader(){
		try {
			spritesheet = ImageIO.read(new File("res/SpriteSheet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void justDraw(Graphics g) {
		g.drawImage(spritesheet, 0, 0, 576, 576, null);
	}

}
