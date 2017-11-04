package common;

import java.awt.geom.Point2D;

public class Projectile {
 //Interface to determine the projectiles of a character
	int range;
	int damage;
	int speed;
	Point2D.Double position;
	Point2D.Double unitVector; //This is the direction the projectile travels. Magnitude (sqrt(x^2 + y^2)) must = 1
	//
	public Projectile(int range, int damage, int speed, Point2D.Double position, Point2D.Double target) {
		this.range = range;
		this.damage = damage;
		this.speed = speed;
		this.unitVector = calcUnitVector(target, position);
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
	public Point2D.Double calcUnitVector(Point2D.Double destination, Point2D.Double start) {
	
		Point2D directionVector = new Point2D.Double(destination.getX() - start.getX(), destination.getY() - start.getY());
		double mag = Math.sqrt((Math.pow(directionVector.getX(), 2)) + Math.pow(directionVector.getY(), 2));
		Point2D.Double unitV = new Point2D.Double(directionVector.getX()/mag, directionVector.getY()/mag);
		return unitV;
	}
}
