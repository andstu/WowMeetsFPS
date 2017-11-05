package wowMeetsFPS;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class Tank implements Character, Serializable {
	private Point2D.Double location;
	private String imageUp = "/Facingback.png", 
					  imageDown = "/FrontFacing.png", 
					  imageLeft = "/FacingLeft.png", 
					  imageRight = "/FacingRight.png";
	private String currentDirectory;
	private String id;
	private int defense, attack, hp, speed = 1;
	LinkedList<Projectile> projectiles;
	
	public Tank(String id) {
		this.id = id;
		location = new Point2D.Double(200, 200);
		currentDirectory = imageDown;
	}
	
	public ImageIcon ImageIconFromString(String input)
	{
		return new ImageIcon(getClass().getResource(input));
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
		return ImageIconFromString(currentDirectory).getImage();
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
	public void setImage(Dir direction) {
		
		switch(direction) {
		case UP: currentDirectory = imageUp; 
			break;
		case DOWN: currentDirectory = imageDown;
			break;
		case LEFT: currentDirectory = imageLeft;
			break;
		case RIGHT: currentDirectory = imageRight;
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
	
	@Override
	public void move(boolean right, boolean left, boolean up, boolean down) {
		// TODO Auto-generated method stub

		int x = 0, y = 0;
		if(right) {
			x = speed; 
			setImage(Dir.RIGHT);
			currentDirectory = imageRight;
		}
		if(left)
		{
			x = -speed;
			setImage(Dir.LEFT);
			currentDirectory = imageLeft;
		}
		if(up)
		{
			y = -speed;
			setImage(Dir.UP);
			currentDirectory = imageUp;
		}
		if(down)
		{
			y = speed;
			setImage(Dir.DOWN);
			currentDirectory = imageDown;
		}

		location.setLocation(location.getX() + x, location.getY() + y);
	}

	
}
