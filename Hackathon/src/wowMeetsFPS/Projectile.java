package wowMeetsFPS;

import java.awt.geom.Point2D;

public class Projectile {
 //Interface to determine the projectiles of a character
	int range;
	int damage;
	int speed;
	Point2D position;
	Point2D unitVector; //This is the direction the projectile travels. Magnitude (sqrt(x^2 + y^2)) must = 1
	//
	public Projectile(int range, int damage, int speed, Point2D position) {
		this.range = range;
		this.damage = damage;
		this.speed = speed;
	}
	public void move() {
		Point2D distTrav = new Point2D.Double(unitVector.getX()*speed, unitVector.getY()*speed);
		position = new Point2D.Double(position.getX() + distTrav.getX(), position.getY() + distTrav.getY());
	}
	public Point2D getUnitV() {
		return unitVector;
	}
	public Point2D getPos() {
		return position;
	}
	public Point2D calcUnitVector(Point2D.Double mouseClick, Point2D playerPos) {
	
		Point2D directionVector = new Point2D.Double(mouseClick.getX() - playerPos.getX(), mouseClick.getY() - mouseClick.getY());
		double mag = Math.sqrt((Math.pow(directionVector.getX(), 2)) + Math.pow(directionVector.getY(), 2));
		Point2D unitV = new Point2D.Double(directionVector.getX()/mag, directionVector.getY()/mag);
		return unitV;
	}
}
