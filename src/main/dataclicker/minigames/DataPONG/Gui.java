package main.dataclicker.minigames.DataPONG;
import java.awt.BorderLayout;

import javax.swing.*;

import main.dataclicker.minigames.DataPONG.Draw;

public class Gui {
	
	public Gui() {
		
		Variables.jf1 = new JFrame();
		Variables.jf1.setSize(Variables.screenwidth, Variables.screenheight);
		Variables.jf1.setTitle("Pong");
		Variables.jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes the Application Red cross on top-right corner
		Variables.jf1.setLayout(null);
		Variables.jf1.setResizable(false);		// allows the user to resize the screen --> relative variables for GUI 
		Variables.jf1.setVisible(true);
		Variables.jf1.setLocationRelativeTo(null);	// allows the application window to appear within the center of the screen
		Variables.jf1.addKeyListener(new KeyHandler());	// is responsible for the visible Input done by the user
		Variables.jf1.requestFocus();
		
		Draw.labelDraw = new Draw();
		Draw.labelDraw.setBounds(0,0, Variables.screenwidth, Variables.screenheight);
		Draw.labelDraw.setVisible(true);		
		
		Variables.jf1.getContentPane().add(Draw.labelDraw, BorderLayout.CENTER);	
		
		
		
		
	}

	static void gameOver() {		//
		
		Variables.speed = 0;
		// add rewards for dataclicker 
		
		JLabel gameOver = new JLabel("GAMEOVER");
		Variables.jf1.getContentPane().add(gameOver, BorderLayout.CENTER);
		Movement.paddlespeed = 99999999;
		
	
		
	}
	
	
}
