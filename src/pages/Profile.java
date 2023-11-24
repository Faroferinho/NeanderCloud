package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.UserInterface;

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
	
	public static boolean overName = false;
	public static boolean overRdF = false;
	public static boolean overCPF = false;
	
	public boolean mouseAuxRun = false;
	public boolean mouseAuxEdit = false;
	public boolean mouseAuxRead = false;
	public boolean mouseAuxSign = false;

	public Profile(String inName) {
		name = inName;
	}
	
	public void genericRendering(Graphics g) {
		UserInterface.firstRender(g);
		g.setColor(Color.blue);
		g.fillRect(50, 132, 100, 133);
		
		g.setColor(Color.white);
		g.setFont(new Font("impact", 0, 20));
		g.drawString(name, 160, 165);
	}
}
