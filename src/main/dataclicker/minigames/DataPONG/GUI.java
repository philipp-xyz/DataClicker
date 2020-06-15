package main.dataclicker.minigames.DataPONG;

import javax.swing.JFrame;

public class GUI {

	public GUI(String title, Game game) {

		JFrame frame = new JFrame(title);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		
		
		frame.add(game);// inherits from component 				
						// assures that game is going to be a component object 
						// it'll inherit from an object which inherits from the component interface
		
		frame.pack();
		frame.setLocationRelativeTo(null);	
						// makes Game appear in the center of the screen
		frame.setVisible(true);
		
		
		
		game.start();
																
		
	}
	
}
