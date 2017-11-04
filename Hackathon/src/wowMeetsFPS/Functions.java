package wowMeetsFPS;

import java.awt.geom.Point2D;

public class Functions {

	public boolean collides(Point2D.Double aTL, Point2D.Double aBR, Point2D.Double bTL, Point2D.Double bBR) {
		Double aTLX = aTL.getX(), aTLY = aTL.getY();
		Double aBRX = aBR.getX(), aBRY = aBR.getY();
		Double bTLX = bTL.getX(), bTLY = bTL.getY();
		Double bBRX = bBR.getX(), bBRY = bBR.getY();
		
		if(aTLX.compareTo(bBRX) > 0 || bTLX.compareTo(aBRX) > 0){
			
			return false;
		}
		if(aTLY.compareTo(bBRY) > 0 || bTLY.compareTo(aBRY) > 0){
			
			return false;
		}
		return true;
	}
}
