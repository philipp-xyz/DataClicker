package main.dataclicker.minigames.DataPONG;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class Draw extends JLabel {
	
	public static Draw labelDraw;
	
	protected void paintComponent (Graphics g) {	// order of which comes first is important
		super.paintComponent(g);					// if background last then only background visible!
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);	
		// no hard edges --> half transparend pixel is added to an existing pixel to soften the edge!
		
		g.setColor(Color.BLACK);					// Backgroundcolor
		g.fillRect(0, 0, Variables.screenwidth, Variables.screenheight); 
		g.setColor(Color.WHITE);					// Playercolor
		
		for (int i = 0; i<=30; i++) {
			g.fillRect(Variables.screenwidth/2 -5 , i * 20, 20, 20);	// middle line to divide player side 
		}
		
		g.fillRect(Variables.x, Variables.y, Variables.paddlewidth, Variables.paddleheight);
		g.fillRect(Variables.opponentx, Variables.opponenty, Variables.paddlewidth, Variables.paddleheight);
		
		g.setFont(Variables.pixelfont);
		g.drawString(Integer.toString(Variables.playerPoints), 165,  70);
		g.drawString(Integer.toString(Variables.opponentPoints), 590,  70);
		
		g.fillRect(Variables.ballx, Variables.bally, 20, 20);
			repaint();	
	}
	

}
