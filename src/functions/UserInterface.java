package functions;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

import main.NeanderCloud;

public class UserInterface {
	
	static int bttnX[] = new int[4];
	static int bttnY = 15;
	static int spaceBetween = NeanderCloud.WIDTH/10;
	int initX = (int) (NeanderCloud.WIDTH/2 - (boxWidth * 2 + spaceBetween * 1.5));
	
	static int boxWidth = 128;
	static int boxHeight = 64;
	
	public boolean click = false;
	
	public UserInterface() {
		// TODO Auto-generated constructor stub
		for(int i = 0; i < 4; i++) {
			bttnX[i] = initX + boxWidth * i + spaceBetween * i;
		}
	}
	
	public static void firstRender(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(24, bttnY*2 + boxHeight, NeanderCloud.WIDTH - 72, NeanderCloud.HEIGHT - (bttnY*2 + boxHeight) - 66);
		
		g.setColor(Color.gray);
		g.fillRect(24 + 6, bttnY*2 + boxHeight + 6, NeanderCloud.WIDTH - 84, NeanderCloud.HEIGHT - (bttnY*2 + boxHeight) - 78);
	}
	
	public static void scrollLimmiter(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, NeanderCloud.WIDTH, bttnY*2 + boxHeight);
		g.fillRect(0, bttnY*2 + boxHeight + (NeanderCloud.HEIGHT - (bttnY*2 + boxHeight) - 66), NeanderCloud.WIDTH, 200);
		
		g.setColor(Color.red);
		g.fillRect(24, bttnY*2 + boxHeight, NeanderCloud.WIDTH - 72, 6);
		g.fillRect(24, bttnY*2 + (NeanderCloud.HEIGHT - (bttnY*2) - 72), NeanderCloud.WIDTH - 72, 6);
	}
	
	public void tick() {
		if(click == true) {
			//System.out.println("UI Clicada");
			if(Interactions.mouseIntersection(bttnX[0], bttnY, boxWidth, boxHeight)) {
				NeanderCloud.state = 1;
			}else if(Interactions.mouseIntersection(bttnX[1], bttnY, boxWidth, boxHeight)) {
				NeanderCloud.state = 2;
			}else if(Interactions.mouseIntersection(bttnX[2], bttnY, boxWidth, boxHeight)) {
				int confirm = JOptionPane.showConfirmDialog(null, "Realmente deseja deslogar?", "Confirma a Saida", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(confirm == 0) {
					NeanderCloud.state = 0;
				}
			}else if(Interactions.mouseIntersection(bttnX[3], bttnY, boxWidth, boxHeight)) {
				System.exit(0);
			}
			
			click = false;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.orange);
		for(int i = 0; i < 4; i++) {
			if(i == 3) {
				g.setColor(Color.red);
			}
			g.fillRect(bttnX[i], bttnY, boxWidth, boxHeight);
		}
		
	}

}
