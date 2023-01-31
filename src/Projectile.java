import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Projectile extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;

	public static boolean gotImage = false;	
boolean isactive = true;
	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		if (needImage) {
		    loadImage ("bullet.png");
		}
		this.yspeedu=10;
		// TODO Auto-generated constructor stub
	}
	public void update() {
		super.update();
		y-=yspeedu;
		
		}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
	    g.fillRect(x, y, width, height);
	    if (gotImage) {
	    	g.drawImage(image, col.x, col.y, width, height, null);
	    	g.setColor(Color.RED);
g.drawRect(x, y, width, height);
	    } else {
	    	g.setColor(Color.BLUE);
	    	g.fillRect(x, y, width, height);
	    }
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
	public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10);
//return new Projectile(ship.x, ship.y)
	} 
}
