package wowMeetsFPS;

import java.awt.geom.Point2D;

import javax.swing.ImageIcon;

public class Obstacle {
	
	Point2D topLeft;
	Point2D botRight;
	ImageIcon image;
	
	public Obstacle(Point2D topLeft, Point2D botRight) {
		this.topLeft = topLeft;
		this.botRight = botRight;
	}
	public ImageIcon getImage() {
		return image;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}
}
