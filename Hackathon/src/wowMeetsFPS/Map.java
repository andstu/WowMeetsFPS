package wowMeetsFPS;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Map extends JPanel implements ActionListener{
	
	private int B_HEIGHT;//Height of the map
	private int B_WIDTH;//Width of the map
	
	private int delay = 5; //sets time between frames 
	private Timer spf = new Timer(delay, this); //seconds per frame. After x seconds the painting will refresh and update graphics
	
	
	public Map(Color c) {
		addKeyListener(new KeyAction());
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	public void doDrawing(Graphics g) {
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
