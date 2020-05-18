package main.dataclicker.minigames.dataSweeper;

import java.awt.*;

import javax.swing.JPanel;


public class SweeperBoard extends JPanel {
	
	int spacing = 2; //spacing between cells
	
	int cell = 40; //cells sind quadratisch, höhe und breite werden in einem integer fest gehalten
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, SweeperGUI.frameWidth, SweeperGUI.frameHeight);
		g.setColor(Color.gray);
		for (int x = 0; x < 9; x++) {
			for ( int y = 0; y < 10; y++) {
				g.fillRect(spacing+x*cell, spacing+y*cell+cell, cell-2*spacing, cell-2*spacing);
			}
		}
	}

}
