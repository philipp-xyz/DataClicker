package main.dataclicker.minigames.dataSweeper;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class SweeperGUI {
	
	public static int frameWidth = 515;  
	public static int frameHeight = 350;
	JFrame frame = new JFrame("Datasweeper");
	

	/**
	 * Initialize the contents of the frame.
	 */
	public void sweeperInitialize() {
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
		frame.getContentPane().add(board, BorderLayout.CENTER);
		frame.getContentPane().add(board.overview, BorderLayout.NORTH);
		board.overview.add(board.tries);
		board.overview.add(board.minesLeft);
		
	}
	
	

}
