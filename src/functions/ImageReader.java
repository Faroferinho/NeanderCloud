package functions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageReader {
	
	private BufferedImage spritesheet;
	private BufferedImage backgroundLogin;
	private BufferedImage backgroundMain;
	
	public ImageReader(){
		try {
			spritesheet = ImageIO.read(new File("res/spritesheet"));
			backgroundLogin = ImageIO.read(new File("res/backgroundLogin"));
			backgroundMain = ImageIO.read(new File("res/backgroundMain"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
