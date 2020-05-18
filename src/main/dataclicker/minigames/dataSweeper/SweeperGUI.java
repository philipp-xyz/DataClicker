package main.dataclicker.minigames.dataSweeper;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class SweeperGUI {
	
	public static int frameWidth = 375;  
	public static int frameHeight = 500;


	/**
	 * Create the application.
	 */
	public SweeperGUI() {
		sweeperInitialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void sweeperInitialize() {
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
