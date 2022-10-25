import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders{
	 
	public static final int HEIGHT = 800;
	public static final int WIDTH = 500;
		
public static void main(String[] args) {
JFrame jeff = new JFrame();

	LeagueInvaders li = new LeagueInvaders();
	
	

	setup(jeff);
	
}
public static void setup(JFrame fm) {
	GamePanel gp = new GamePanel();
	fm.add(gp);
	fm.setVisible(true);
	fm.setSize(WIDTH, HEIGHT);
	fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
