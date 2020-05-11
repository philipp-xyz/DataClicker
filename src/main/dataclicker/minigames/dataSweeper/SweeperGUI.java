package main.dataclicker.minigames.dataSweeper;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SweeperGUI {

	private JFrame frame;
	
	
    
    /**
	 * Launch the application.
	 */
	public static void createSweeper() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SweeperGUI window = new SweeperGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SweeperGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Datasweeper");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
