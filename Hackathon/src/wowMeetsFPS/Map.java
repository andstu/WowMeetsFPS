package wowMeetsFPS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Map extends JPanel{
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //screensize 
	private Image background = new ImageIcon(getClass().getResource("/pokegrass(background).png")).getImage();
	private boolean inGame = true;
	Character user;
	Character[] otherUsers;
	boolean right = false, left = false, down = false, up = false;
	
	public Map(Color c, Character player, Character[] otherPlayers) {
		user = player;
		otherUsers = otherPlayers;
		JFrame window = new JFrame();
		initGraphics(window);
		initGame();
	}
	
	//Readjusts the location of player and other players
	public void updateMap(Character player, Character[] otherPlayers)
	{
		user = player;
		otherUsers = otherPlayers;
	}
	public void initGraphics(JFrame window) {
		//panel
		this.addKeyListener(new KeyAction());
		this.addMouseListener(new MouseAim());
		this.setBackground(Color.black);
		this.setPreferredSize(new Dimension((int)screenSize.getWidth(), (int)screenSize.getHeight()));
		this.setFocusable(true); // I dont really know what this does but it makes it work
		//frame
		window.add(this);
		//window.setTitle("W.O.WITSANFPS");
		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		
	}
	/*
	 * Initializes game
	 * Start timer
	 * Initialize variables?
	 * Other (I do not know what else needs to be put here)
	 */
	public void initGame() {
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
	public void doDrawing(Graphics g) { //does the drawing
		int userLocX = (int) user.getLoc().getX();
		int userLocY = (int) user.getLoc().getY();
		g.drawImage(background, 0, 0, this);
		g.drawImage(user.getImage(), userLocX, userLocY, this);
		String name = user.getID();
		Font font = new Font("Comic Sans", Font.BOLD, 5);
		g.drawString(name, userLocX + user.getImage().getWidth(this)/2 - getFontMetrics(font).stringWidth(name), userLocY + 2);
		
		for(Character temp : otherUsers) {
			if(temp != null) {
				Font tempFont = new Font("Comic Sans", Font.BOLD, 5);
				int tempLocX = (int) temp.getLoc().getX();
				int tempLocY = (int) temp.getLoc().getY();
				String tempName = temp.getID();
				g.drawImage(temp.getImage(), tempLocX, tempLocY, this);
				g.drawString(tempName, tempLocX + user.getImage().getWidth(this)/2 - getFontMetrics(tempFont).stringWidth(tempName), tempLocY);
				for(Projectile p:  temp.getProjectiles()) {
					int x = (int) p.getPos().getX();
					int y = (int) p.getPos().getY();
					g.drawImage(p.getImage(), x, y, this);
				}
			}
		}
	
	}
	public void performAction() { //executes actions here

		if(inGame) {//execute actions in here
			user.move(right,left,up,down);
		}
		repaint();
	}
	
	private class MouseAim implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Point loc = e.getLocationOnScreen();
			user.attack(new Point2D.Double(loc.getX(), loc.getY()));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class KeyAction extends KeyAdapter {
		public void keyPressed(KeyEvent arg0) {
			switch(arg0.getKeyCode())
			{
			case(KeyEvent.VK_W):
				up = true;
				break;
			case(KeyEvent.VK_S):
				down = true;
				break;
			case(KeyEvent.VK_A):
				left = true;
				break;
			case(KeyEvent.VK_D):
				right = true;
				break;
			}
		}
		public void keyReleased(KeyEvent arg0)
		{

			switch(arg0.getKeyCode())
			{
			case(KeyEvent.VK_W):
				up = false;
				break;
			case(KeyEvent.VK_S):
				down = false;
				break;
			case(KeyEvent.VK_A):
				left = false;
				break;
			case(KeyEvent.VK_D):
				right = false;
				break;
			}

		}
	}	
	public int getHeight() { return (int) screenSize.getHeight(); }
	public int getWidth() { return (int) screenSize.getWidth(); }
	
}
