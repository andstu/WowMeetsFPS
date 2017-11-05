package wowMeetsFPS;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Projectile implements Serializable{
 //Interface to determine the projectiles of a character
	private String imageLocation = "/fireball.png";
	int range;
	int damage;
	int speed;
	Character[] enemies;
	Point2D.Double position;
	Point2D.Double unitVector; //This is the direction the projectile travels. Magnitude (sqrt(x^2 + y^2)) must = 1
	//
	public Projectile(int range, int damage, int speed, Point2D.Double position, Point2D.Double target) {
		this.range = range;
		this.damage = damage;
		this.speed = speed;
		this.unitVector = calcUnitVector(target, position);
		//Dan doesn't know what he is doing... WE HAD TO ADD THIS
		this.position = position;
	}
	public void move() {
		Point2D distTrav = new Point2D.Double(unitVector.getX()*speed, unitVector.getY()*speed);
		position = new Point2D.Double(position.getX() + distTrav.getX(), position.getY() + distTrav.getY());
		DetermineCollision();
	}
	public Point2D getUnitV() {
		return unitVector;
	}
	public Point2D getPos() {
		return position;
	}
	public Point2D.Double calcUnitVector(Point2D.Double destination, Point2D.Double start) {
	
		Point2D directionVector = new Point2D.Double(destination.getX() - start.getX(), destination.getY() - start.getY());
		double mag = Math.sqrt((Math.pow(directionVector.getX(), 2)) + Math.pow(directionVector.getY(), 2));
		Point2D.Double unitV = new Point2D.Double(directionVector.getX()/mag, directionVector.getY()/mag);
		return unitV;
	}
	
	void DetermineCollision()
	{
		for(int i = 0; i < enemies.length; i++)
		{
			Point2D.Double enemyPos = enemies[i].getLoc();
			if(position.getX() == enemyPos.getX() && position.getY() == enemyPos.getY())
			{
				enemies[i].setHP(enemies[i].getHP() - damage); //YO, CHECK THIS CAUSE STATS ARE WACK AND NEED A TAKE DAMAGE METHOD
				enemies[i].setLoc(new Point2D.Double(0, 0)); //TEST
			}
		}
	}
	public Image getImage() {
		return new ImageIcon(getClass().getResource(imageLocation)).getImage();
	}
}
