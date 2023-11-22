package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import functions.Interactions;
import main.NeanderCloud;

public class LoginPage {
	
	int borderLeft = NeanderCloud.WIDTH/4;
	int borderTop = 24;
	
	static boolean insertID = false;
	static boolean insertPassword = false;
	public static boolean click;
	
	static Interactions inter;

	public LoginPage() {
		inter = new Interactions();
	}
	
	public void tick() {
		
		if(click) {
			System.out.println("Clique");
			if(inter.mouseIntersection(borderLeft + 20, NeanderCloud.HEIGHT/3 + 10, borderLeft*2 - 40, 40) == true) {
				insertID = true;
				System.out.println("Borda ID");
			}else if(inter.mouseIntersection(borderLeft + 20, NeanderCloud.HEIGHT/3*2 + 10, borderLeft*2 - 40, 40) == true) {
				System.out.println("Borda Senha");
			}
		}
		
		
		if(insertID) {
			insertID = false;
		}
		
		if(insertPassword) {
			insertPassword = false;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(226, 163, 0));
		g.fillRoundRect(borderLeft-12, 12, borderLeft*2 + 24, NeanderCloud.HEIGHT-24*3, 23, 23);
		
		g.setColor(Color.red);
		g.fillRoundRect(borderLeft, 24, borderLeft*2, NeanderCloud.HEIGHT-24*4, 16, 16);
		
		g.setColor(Color.white);
		g.setFont(new Font("arial", 1, 16));
		g.drawString("Conta: ", borderLeft+25, NeanderCloud.HEIGHT/3);
		g.drawString("Senha: ", borderLeft+25, NeanderCloud.HEIGHT/3*2);
		
		g.fillRoundRect(borderLeft + 20, NeanderCloud.HEIGHT/3 + 10, borderLeft*2 - 40, 40, 6, 6);
		g.fillRoundRect(borderLeft + 20, NeanderCloud.HEIGHT/3*2 + 10, borderLeft*2 - 40, 40, 6, 6);
		
		g.setColor(Color.black);
		g.drawRoundRect(borderLeft + 20, NeanderCloud.HEIGHT/3 + 10, borderLeft*2 - 40, 40, 6, 6);
		g.drawRoundRect(borderLeft + 20, NeanderCloud.HEIGHT/3*2 + 10, borderLeft*2 - 40, 40, 6, 6);
		
		
	}
	
}
