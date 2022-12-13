import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int xs=0;
	int ys=0;
	int ru=0;
	int rd=0;
	int rl=0;
	int rr=0;
	public Rocketship(int x, int y, int width, int height) {
	
		super(x, y, width, height);

		// TODO Auto-generated constructor stub
		
	} 

	
	
	void draw(Graphics g) {
		 g.setColor(Color.BLUE);
	        g.fillRect(x, y, width, height);
	}
	public void update() {
	   	y+=ys;
	   	x+=xs;
		ys=rr+rl;
    	xs=rd+ru;
	}
        
}
