import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {
	int xs=0;
	int ys=0;
	int ru=0;
	int rd=0;
	int rl=0;
	int rr=0;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	public Rocketship(int x, int y, int width, int height) {
	
			
		
		super(x, y, width, height);
		if (needImage) {
		    loadImage ("rocket.png");
		}
		// TODO Auto-generated constructor stub
		
	} 

	public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10);
} 
	
	void draw(Graphics g) {
		if(g!=null) {
		 //g.setColor(Color.BLUE);
	     //   g.fillRect(x, y, width, height);
	        if (gotImage) {
	        	g.drawImage(image, x, y, width, height, null);
	      
	        } else {
	        	g.setColor(Color.BLUE);
	        	g.fillRect(x, y, width, height);
	        }
	}
	}
	public void update() {

		 col.setBounds(x, y, width, height);

		   super.update();
		ys=ru+rd;
    	xs=rr+rl;
   // 	System.out.println("xs " + xs + " ys " + ys+" y " + y + " x " + x );
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
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
}
