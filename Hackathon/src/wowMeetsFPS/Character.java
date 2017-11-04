package wowMeetsFPS;

import java.awt.geom.Point2D;
import java.util.LinkedList;

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
	public void attack(Point2D.Double target);
	
	public int getHP();
	public int getDefense();
	public int getAttack();
	public int getSpeed();
	public ImageIcon getImageIcon();
	public Point2D.Double getLoc();
	
	public void setHP(int hp);
	public void setDefense(int defense);
	public void setAttack(int attack);
	public void setSpeed(int speed);
	public void setImage(ImageIcon sprite);
	public void setLoc(Point2D.Double location);
	
	public String getID();
	
	public LinkedList<Projectile> getProjectiles();
}
