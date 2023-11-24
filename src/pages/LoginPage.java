package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JOptionPane;

import functions.Interactions;
import main.NeanderCloud;

public class LoginPage {
	
	int borderLeft = NeanderCloud.WIDTH/4;
	int borderTop = 24;
	
	public int insertInfo = 0;
	public boolean click;
	
	public String userID = "";
	public String userPassword = "";

	public LoginPage() {
		
	}
	
	public void tick() {
		
		if(click) {
			System.out.println("Clique");
			if(Interactions.mouseIntersection(borderLeft + 20, NeanderCloud.HEIGHT/3 + 10, borderLeft*2 - 40, 40) == true) {
				//System.out.println("Borda ID");
				Interactions.text = "";
				insertInfo = 1;
			}else if(Interactions.mouseIntersection(borderLeft + 20, NeanderCloud.HEIGHT/3*2 - 40, borderLeft*2 - 40, 40) == true) {
				//System.out.println("Borda Senha");
				Interactions.text = "";
				insertInfo = 2;
				//System.out.println("Status do Inserir Senha: " + insertPassword);
			}else {
				insertInfo = 0;
			}
			
			if(Interactions.mouseIntersection(NeanderCloud.WIDTH/2-50, NeanderCloud.HEIGHT - (48 * 3) - 16, 100, 60)) {
				if(Interactions.verifyAccount(userID, userPassword)) {
					System.out.println("Estado: " + NeanderCloud.state);
					userID = "";
					userPassword = "";
					NeanderCloud.state = 1;
				}else {
					JOptionPane.showMessageDialog(null, "Login e/ou Senha Incorretos", "Erro ao Efetuar o Login", JOptionPane.PLAIN_MESSAGE);
				}
			}
			
			click = false;
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
		g.drawString("Senha: ", borderLeft+25, NeanderCloud.HEIGHT/3*2 - 50);
		
		g.fillRoundRect(borderLeft + 20, NeanderCloud.HEIGHT/3 + 10, borderLeft*2 - 40, 40, 6, 6);
		g.fillRoundRect(borderLeft + 20, NeanderCloud.HEIGHT/3*2 - 40, borderLeft*2 - 40, 40, 6, 6);
		
		g.setColor(new Color(226, 163, 0));
		g.fillRect(NeanderCloud.WIDTH/2-50, NeanderCloud.HEIGHT - (48 * 3) - 16, 100, 60);
		g.setColor(new Color(226, 255, 0));
		
		g.drawRect(NeanderCloud.WIDTH/2-50, NeanderCloud.HEIGHT - (48 * 3) - 16, 100, 60);
		
		g.setColor(Color.black);
		g.drawRoundRect(borderLeft + 20, NeanderCloud.HEIGHT/3 + 10, borderLeft*2 - 40, 40, 6, 6);
		g.drawRoundRect(borderLeft + 20, NeanderCloud.HEIGHT/3*2 - 40, borderLeft*2 - 40, 40, 6, 6);
		
		g.drawString(userID, borderLeft + 25, NeanderCloud.HEIGHT/3 + 37);
		g.drawString(userPassword, borderLeft + 25, NeanderCloud.HEIGHT/3*2  - 14);
		
		g.fillRoundRect(borderLeft, 24, borderLeft*2, 40, 16, 16);
		g.drawImage(NeanderCloud.iLoader.getLogo(), NeanderCloud.WIDTH/2 - 256, 40, 510, 103, null);
	}
	
}
