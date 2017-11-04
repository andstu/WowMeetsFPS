package wowMeetsFPS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Map extends JPanel implements ActionListener{
	
	private int B_HEIGHT;//Height of the map
	private int B_WIDTH;//Width of the map
	
	private int delay = 5; //sets time between frames 
	private Timer spf = new Timer(delay, this); //seconds per frame. After x seconds the painting will refresh and update graphics
	private Image background;
	
	public Map(Color c) {
		addKeyListener(new KeyAction());
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		
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

		
	}
	public int getHeight() { return B_HEIGHT; }
	public int getWidth() { return B_WIDTH; }
}
