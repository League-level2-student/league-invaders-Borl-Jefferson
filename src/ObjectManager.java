import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Rocketship ship;
ArrayList <Projectile>pro=new ArrayList <Projectile>();
ArrayList <Alien>alien=new ArrayList <Alien>();
Random r = new Random();
ObjectManager(Rocketship rocketship) {
	this.ship=rocketship;
}
void addprojectile(Projectile single) {
	pro.add(single);
}
void addalien (){
	alien.add(new Alien(r.nextInt(LeagueInvaders.WIDTH),0,50,50, r.nextInt(7)+7));

}
void update() {
	for (int i=0; alien.size()>i; i++) {
		alien.get(i).update();
		ADD THE Y CHECK THING
	}
}
}
