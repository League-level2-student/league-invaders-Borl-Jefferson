import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.Timer;

public class ObjectManager implements ActionListener {
	Rocketship ship;
//int score = 0;
	int fired = 0;
	int score =0;
	Timer alientimer;
	ArrayList<Projectile> pro = new ArrayList<Projectile>();
	ArrayList<Alien> alien = new ArrayList<Alien>();
	Random r = new Random();

	ObjectManager(Rocketship rocketship) {
		this.ship = rocketship;
//	alientimer = new Timer(10000/3,this);
	}

	void addprojectile(Projectile single) {
		pro.add(single);
		fired += 1;
	}

	void addalien() {
		alien.add(new Alien(r.nextInt(LeagueInvaders.WIDTH), 0, 50, 50, r.nextInt(7) + 7));

	}

	void checkcol() {
		for (int i = 0; i < alien.size(); i++) {
			if (ship.col.intersects(alien.get(i).col)) {
				
				ship.isactive = false;
				break;
			}
		
		for(int j=0;j<pro.size();j++) {
			if((pro.get(j).col.intersects(alien.get(j).col))) {
				score++;
						alien.get(j).isactive=false;
						pro.get(j).isactive=false;
		}
		}
}
	}

	void draw(Graphics g) {
		ship.draw(g);
		for (int i = 0; alien.size() > i; i++) {
			alien.get(i).draw(g);
		}

		for (int j = 0; pro.size() > j; j++) {
			pro.get(j).draw(g);
		}
		System.out.println(pro);
	}

	void update() {
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
			// score+=1;
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
}
