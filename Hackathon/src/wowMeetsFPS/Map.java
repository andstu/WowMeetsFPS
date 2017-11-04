package wowMeetsFPS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Map extends JPanel implements ActionListener{
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //screensize
	private int delay = 5; //sets time between frames 
	private Timer spf = new Timer(delay, this); //seconds per frame. After x seconds the painting will refresh and update graphics
	private Image background;
	private boolean inGame = false;

	public Map(Color c) {
		JFrame window = new JFrame();
		initGraphics(window);
		initGame();
		
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

		
	}
	/*
	 * Initializes game
	 * Start timer
	 * Initialize variables?
	 * Other (I do not know what else needs to be put here)
	 */
	public void initGame() {
		spf.start();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	public void doDrawing(Graphics g) { //does the drawing
		//g.drawImage(background, 0, 0, null);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) { //executes actions here

		if(inGame) {//execute actions in here
			
		}
		repaint();
	}
	public int getHeight() { return (int) screenSize.getHeight(); }
	public int getWidth() { return (int) screenSize.getWidth(); }
	
}
