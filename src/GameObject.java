import java.awt.Rectangle;

public class GameObject {
int x;
int y;
int xspeedr;
int xspeedl;
int yspeedu;
int yspeedd;
int width;
int height;
int speed = 10;
boolean isactive = true;
Rectangle colbox;

public GameObject(int x, int y, int width, int height) {
colbox = new Rectangle(x, y, width, height);
	this.x=x;
	this.y=y;
			this.width=width;
			this.height=height;
xspeedr = 0;
yspeedu= 0;
xspeedl = 0;
yspeedd = 0;
}
public void update(){

x+=xspeedl;
	
	y+=yspeedd;
	x+=xspeedr;
	
	y+=yspeedu;
	 colbox.setBounds(x, y, width, height);
}

}
