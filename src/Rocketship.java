import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		
	} 

	
	
	void draw(Graphics g) {
		 g.setColor(Color.BLUE);
	        g.fillRect(x, y, width, height);
	}
	
	
	public void right() {
        xspeedr=5;
    }
	public void left() {
        xspeedl=-5;
    }
	public void up() {
        yspeedu=-5;
    }
	public void down() {
        yspeedd=5;
        
        
    }
	public void respeedxr() {
		xspeedr=0;
	}
	public void respeedyd() {
		yspeedd=0;
	}
	public void respeedxl() {
		xspeedl=0;
	}
	public void respeedyu() {
		yspeedu=0;
	}
}
