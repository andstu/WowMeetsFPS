package wowMeetsFPS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import wowMeetsFPS.Character.Dir;

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
		g.drawImage(background, 0, 0, this);
		g.drawImage(user.getImage(), (int) user.getLoc().getX(), (int) user.getLoc().getY(), this);
		
	}
	public void performAction() { //executes actions here

		if(inGame) {//execute actions in here
			user.move(right,left,up,down);
		}
		repaint();
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
