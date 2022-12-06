
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

public GameObject(int x, int y, int width, int height) {
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
}

}
