package functions;

import java.awt.event.KeyEvent;
import java.util.HashMap;

import main.NeanderCloud;

public class Interactions {
	
	public static String text = "";
	HashMap<String, String> logInfo = new HashMap<String, String>();
	
	public Interactions(){
		logInfo.put("Conrado", "Conrado08");
		logInfo.put("Seila", "1234");
		logInfo.put("Faroferinho", "4321");
		logInfo.put("Dragonzord", "sadee3i");
		logInfo.put("Conta", "Senha");
	}
	
	public static boolean mouseIntersection(int x, int y, int w, int h) {
		
		int mx = NeanderCloud.mX;
		int my = NeanderCloud.mY;
		
		System.out.println("X: " + mx + ", Y: " + my);
		
		if(my > y && my < y + h) {
			//System.out.println("Botão Clicado Y");
			if(mx > x && mx < x + w) {
				// Mouse toca um Retangulo;
				//System.out.println("Botão Clicado X");
				return true;
			}
		}
		
		return false;
	}
	
	
	
	public static String textAtualizer(KeyEvent e) {
		
		char auxCharTyped = e.getKeyChar();
		
		System.out.println("Caracter escrito foi: " + auxCharTyped + " e seu Código é: " + e.getKeyCode());
		
		if((e.getKeyCode() > 47 && e.getKeyCode() < 91) || e.getKeyCode() == 0 || e.getKeyCode() == 32) {
			text += auxCharTyped;
		}
		
		if(e.getKeyCode() == 8) {
			if(!text.equals(null) && (text.length() > 0)) {
				text = text.substring(0, text.length() - 1);
			}
		}
		
		return text;
		
	}
	
	public boolean verifyAccount(String account, String password) {
		return false;
	}

}
