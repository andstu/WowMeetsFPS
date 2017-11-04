package wowMeetsFPS;

import java.awt.Point;
import java.awt.geom.Point2D;

import javax.swing.ImageIcon;

public interface Character {
	/*
	 * Moves by Updating Pos
	 * Add speed to Pos
	 */
	public enum Dir{
		UP, DOWN, LEFT, RIGHT
	}
	
	public void move(Dir dir);
	/*
	 * Attack using projectiles
	 * Should have a linklist to store projectiles
	 * cooldown so no spamming
	 */
	public void attack(Point2D target);
	
	public int getHP();
	public int getDefense();
	public int getAttack();
	public int getSpeed();
	public ImageIcon getImage();
	public Point.Double getLoc();
	
	public void setHP(int hp);
	public void setDefense(int defense);
	public void setAttack(int attack);
	public void setSpeed(int speed);
	public ImageIcon setImage(ImageIcon sprite);
	public Point.Double setLoc(Point.Double location);
	
	public String getID();
	public void setID();
}
