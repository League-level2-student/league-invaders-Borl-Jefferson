import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
boolean isactive;
	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	public void update() {
		y-=yspeedu;
		}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
	    g.fillRect(x, y, width, height);
	}
}
