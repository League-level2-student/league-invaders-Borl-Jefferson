import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
   Font tf = new Font("Comic Sans", Font.PLAIN, 48);
  
  public void  updateMenuState() {  
	  g.setFont(tf);
	  g.setColor(Color.YELLOW);
	  g.drawString("text", x, y);
  }
    public void updateGameState() {
    	
    }
    public void updateEndState()  {
    	
    }
    
   
    public void drawMenuState(Graphics g) { 
    	g.setColor(Color.BLUE);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
}
    
    public void drawGameState(Graphics g) {  
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    }
    
    public void drawEndState(Graphics g)  { 
    	g.setColor(Color.RED);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    }


	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	
}
