package main.dataclicker.minigames.dataSweeper;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class SweeperGUI {
	
	public static int frameWidth = 666;  
	public static int frameHeight = 850;

	/**
	 * Initialize the contents of the frame.
	 */
	public static void sweeperInitialize() {
		JFrame frame = new JFrame("Datasweeper");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // close operation can be made to add data/money?
		frame.setSize(frameWidth, frameHeight);
		frame.setResizable(true);
		frame.setVisible(true);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SweeperBoard board = new SweeperBoard();
		frame.setContentPane(board);
		
	}
	
	

}
