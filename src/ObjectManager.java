import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import java.awt.Rectangle;
import javax.swing.Timer;

public class ObjectManager implements ActionListener {
	Rocketship ship;
	Timer alientimer;
	ArrayList<Projectile> pro = new ArrayList<Projectile>();
	ArrayList<Alien> alien = new ArrayList<Alien>();
	Random r = new Random();
	int score =0;
	int shots =0;
int alientotal =0;
boolean userinput = false;

String empty = "";
int change;
int base;

	ObjectManager(Rocketship rocketship) {
		this.ship = rocketship;
		
//	alientimer = new Timer(10000/3,this);
		alien=new ArrayList<Alien>();
		pro=new ArrayList<Projectile>();
	}

	void addprojectile(Projectile single) {
		pro.add(single);
		shots++;
	}

	void addalien() {
		if(userinput=true) {
		alien.add(new Alien(r.nextInt(LeagueInvaders.WIDTH), 0, 50, 50, r.nextInt(change) + base));
		}
		else {
		alien.add(new Alien(r.nextInt(LeagueInvaders.WIDTH), 0, 50, 50, r.nextInt(5) + 3));
		}
		alientotal++;
	}

	void draw(Graphics g) {
		ship.draw(g);
		for (int i = 0; alien.size() > i; i++) {
			alien.get(i).draw(g);
		}

		for (int j = 0; pro.size() > j; j++) {
			pro.get(j).draw(g);
		}
	}

	void update() {
		checkcol();
		System.out.println(pro.size());
		for (int i = 0; alien.size() > i; i++) {
			alien.get(i).update();

			if (alien.get(i).y > LeagueInvaders.HEIGHT) {
				alien.get(i).isactive = false;
			}

		}
		for (int i = 0; pro.size() > i; i++) {
			pro.get(i).update();

			if (pro.get(i).y < 0) {
				pro.get(i).isactive = false;
			}
		}
		removea();
		removep();
	}

	void removea() {
		Iterator<Alien> it = alien.iterator();
		while (it.hasNext()) {
			Alien eachAlien = it.next();
			if (!eachAlien.isactive)
				it.remove();
			score++;
		}
	}

	void removep() {
		Iterator<Projectile> it = pro.iterator();
		while (it.hasNext()) {
			Projectile eachPro = it.next();
			if (!eachPro.isactive)
				it.remove();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addalien();
	}

	public void checkcol() {

		for (int i = 0; alien.size() > i; i++) {

		if (ship.colbox.intersects(alien.get(i).colbox)){
			alien.get(i).isactive=false;
					ship.isactive=false;
			}

			for (int j = 0; pro.size() > j; j++) {
			
				if(pro.get(j).colbox.intersects(alien.get(i).colbox)) {
					pro.get(j).isactive=false;
					alien.get(i).isactive=false;
			}
			}
		}

	}

}
