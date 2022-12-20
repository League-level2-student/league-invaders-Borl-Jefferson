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
	   
		   
		ys=ru+rd;
    	xs=rr+rl;
    	System.out.println("xs " + xs + " ys " + ys+" y " + y + " x " + x );
    	if(y+ys+height+height/2<LeagueInvaders.HEIGHT && y+ys>=0) {

y+=ys;
    	}
    	else if(y+ys>=0) {
    		y=LeagueInvaders.HEIGHT-height-height/2;
    	}
    	if(x+xs+width<LeagueInvaders.WIDTH && x+xs>=0 ) {
    		x+=xs;
    	}
    	else if(x+xs>=0) {
    	x=LeagueInvaders.WIDTH-width;
    	}
    	//
    	
	}
        
}
