package main.dataclicker.minigames.DataPONG;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class Variables {
	
	static JFrame jf1;
	static int screenwidth = 800 , screenheight = 600;
	
	static int x = 40, y = 250;		// distance from the right window boundary
	static int opponentx = 690, opponenty = 185;
	static int paddlewidth = 50, paddleheight = 200; // use it everywhere when paddles are used!
														
	static int ballx = 200, bally = 200;			
	
	static float speed = 1;	
	
	
	static boolean moveUp = false, moveDown = false;
	static boolean moveUpopponent = false, moveDownopponent = false;
	
	static int balldirection_x = 1, balldirection_y = -1;	// moves to top-right dir. when started!
	
	static int playerPoints = 0, opponentPoints = 0;
	
	static Font pixelfont;
	
	
	public Variables() {
		
		try {
			pixelfont = Font.createFont(Font.TRUETYPE_FONT, new File("res/coders_crux.ttf")).deriveFont(125f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/coders_crux.ttf"))); 
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	// Try and catch is used to prevent crashing if file no

	}

}
