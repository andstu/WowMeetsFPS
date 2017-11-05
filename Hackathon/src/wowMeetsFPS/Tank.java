package wowMeetsFPS;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class Tank implements Character, Serializable {
	private Point2D.Double location;
	private ImageIcon imageUp = new ImageIcon(getClass().getResource("/Facingback.png")), 
					  imageDown = new ImageIcon(getClass().getResource("/FrontFacing.png")), 
					  imageLeft = new ImageIcon(getClass().getResource("/FacingLeft.png")), 
					  imageRight = new ImageIcon(getClass().getResource("/FacingRight.png"));
	private Image current = imageDown.getImage();
	private String id;
	private int defense, attack, hp, speed = 10;
	LinkedList<Projectile> projectiles;
	
	public Tank(String id) {
		this.id = id;
		location = new Point2D.Double(200, 200);
	}

	@Override
	public void move(boolean r, boolean l, boolean u, boolean d) {
		// TODO Auto-generated method stub
		int x = 0, y = 0;
		if(r) {
			x = speed; 
		}
		if(l) {
			x = -speed;
		}
		if(u) {
			y = -speed;
		}
		if(d) {
			y = speed;
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
	public Image getImage() {
		return current;
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
	public void setImage(ImageIcon sprite, Dir direction) {

		switch(direction) {
		case UP: current = imageUp.getImage(); 
			break;
		case DOWN: current = imageDown.getImage();
			break;
		case LEFT: current = imageLeft.getImage();
			break;
		case RIGHT: current = imageRight.getImage();
			break;
		}
		
	}

	@Override
	public void setLoc(Point2D.Double location) {
		// TODO Auto-generated method stub
		this.location = location;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public LinkedList<Projectile> getProjectiles() {
		// TODO Auto-generated method stub
		return projectiles;
	}

}
