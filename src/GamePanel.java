import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int ys = 0;
    int xs = 0;
    Rocketship ship = new Rocketship(250, 700, 50, 50);
    int currentState = MENU;
   Font tf = new Font("Arial", Font.PLAIN, 48);
   Font stf = new Font("Arial", Font.PLAIN, 24);
   Timer framedraw;
   GamePanel(){
  	framedraw = new Timer(1000/60,this);
		framedraw.start();
		
   }
  
  public void  updateMenuState() {  
	  
	  
  }
    public void updateGameState() {
ship.update();

    }
    public void updateEndState()  {
    	
    }
    
   
    public void drawMenuState(Graphics g) { 
    
	  g.setColor(Color.BLUE);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setFont(tf);
	  g.setColor(Color.WHITE);
	  g.drawString("League Invaders", 50, 100);
	  g.setFont(stf);
	  g.drawString("Press [ENTER] to start", 125, 400);
	  g.drawString("Don't press everything at the same time", 50, 450);
	  g.drawString("Press [SPACE] for a tuturial", 100, 500);
    }
   
    
    public void drawGameState(Graphics g) {  
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	ship.draw(g);
    	
    }
    
    public void drawEndState(Graphics g)  { 
    	g.setColor(Color.RED);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	g.setFont(tf);
  	  g.setColor(Color.WHITE);
  	  g.drawString("Nice Try", 50, 100);
  	  g.setFont(stf);
  	  g.drawString("You killed (enimies killed) enimies", 125, 400);
  	  g.drawString("Press [ENTER] to restart", 100, 500);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
	
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		       
		    } else {
		        currentState++;
		    }
		} 
		System.out.println(currentState);
		
		if (e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_W) {
		    System.out.println("UP");
ship.ru=ship.rd==0 ? -10:-20;
		    
		    
		    
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_S) {
		    System.out.println("DOWN");

		    ship. rd=ship.ru==0 ? 10:20;  
		    
		    
		
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_A) {
		    System.out.println("LEFT");

		    
		    ship. rl=ship.rr==0 ? -10:-20; 
		  
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_D) {
		    System.out.println("RIGHT");

		    ship.rr=ship.rl==0 ? 10:20;
		    
		    
		
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_D) {
//ship.respeedxr();
			ship.rr=0;
			if(ship.rl<-10) {
				ship.rl=-10;
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_S) {
	//		ship.respeedyd();
			ship.rd=0;
			if(ship.ru<-10) {
				ship.ru=-10;
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_A) {
	//		ship.respeedxl();
			ship.rl=0;
			if(ship.rr>10) {
				ship.rr=10;
			}
					
		}
		if(e.getKeyCode()==KeyEvent.VK_U || e.getKeyCode()==KeyEvent.VK_W) {
	//		ship.respeedyu();
		ship.ru=0;
		if(ship.rd>10) {
			ship.rd=10;
		}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
