package common;

import java.awt.geom.Point2D;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class Tank implements Character {
	private Point2D.Double location;
	private ImageIcon image;
	private String id;
	private int defense, attack, hp, speed;
	LinkedList<Projectile> projectiles;
	
	public Tank(String id) {
		this.id = id;
	}

	@Override
	public void move(Dir dir) {
		// TODO Auto-generated method stub
		int x = 0, y = 0;
		switch(dir) {
		case UP: y = speed; break;
		case DOWN: y = -1 * speed; break;
		case LEFT: x = -1 * speed; break;
		case RIGHT: x = speed; break;
		}
		location.setLocation(location.getX() + x, location.getY() + y);
	}

	@Override
	public void attack(Point2D.Double target) {
		// TODO Auto-generated method stub
		projectiles.add(new Projectile(50, attack, 10, location, target));
	}

	@Override
	public int getHP() {
		// TODO Auto-generated method stub
		return hp;
	}

	@Override
	public int getDefense() {
		// TODO Auto-generated method stub
		return defense;
	}

	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return attack;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}

	@Override
	public ImageIcon getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point2D.Double getLoc() {
		// TODO Auto-generated method stub
		return location;
	}

	@Override
	public void setHP(int hp) {
		// TODO Auto-generated method stub
		this.hp = hp;
	}

	@Override
	public void setDefense(int defense) {
		// TODO Auto-generated method stub
		this.defense = defense;
	}

	@Override
	public void setAttack(int attack) {
		// TODO Auto-generated method stub
		this.attack = attack;
	}

	@Override
	public void setSpeed(int speed) {
		// TODO Auto-generated method stub
		this.speed = speed;
	}

	@Override
	public void setImage(ImageIcon sprite) {
		// TODO Auto-generated method stub
		this.image = sprite;
	}

	@Override
	public void setLoc(Point2D.Double location) {
		// TODO Auto-generated method stub
		this.location = location;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Projectile> getProjectiles() {
		// TODO Auto-generated method stub
		return projectiles;
	}

}
