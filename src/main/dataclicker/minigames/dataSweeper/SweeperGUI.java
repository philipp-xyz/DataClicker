package main.dataclicker.minigames.dataSweeper;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class SweeperGUI {
	
	public static int frameWidth = 666;  
	public static int frameHeight = 850;
	public static JFrame frame = new JFrame("Datasweeper");

	/**
	 * Initialize the contents of the frame.
	 */
	public static void sweeperInitialize() {
		frame.setSize(frameWidth, frameHeight);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // close operation can be made to add data/money?
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SweeperBoard board = new SweeperBoard();
		frame.setContentPane(board);
		
	}
	
	

}
