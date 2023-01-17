import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
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
void draw(Graphics g){
	ship.draw(g);
	for (int i=0; alien.size()>i; i++) {
	alien.get(i).draw(g);
	}
	
	for(int j=0; pro.size()>j; j++) {
	pro.get(j).draw(g);
	}
}



void update() {
	for (int i=0; alien.size()>i; i++) {
		alien.get(i).update();
		
		if(alien.get(i).y > LeagueInvaders.HEIGHT) {
			alien.get(i).isactive = false;		
		}
		
	}
	for (int i=0; pro.size()>i; i++) {
	pro.get(i).update();

		if(pro.get(i).y < 0) {
			pro.get(i).isactive=false;
		}
	}
	removea();
	removep();
}
void removea() {
	Iterator<Alien>it=alien.iterator();
	while(it.hasNext()) {
		Alien eachAlien = it.next();
		if(!eachAlien.isactive)
			it.remove();
	}
}

void removep() {
	Iterator<Projectile>it=pro.iterator();
	while(it.hasNext()) {
		Projectile eachPro = it.next();
		if(!eachPro.isactive)
			it.remove();
	}
}
}
