package main.dataclicker.minigames.dataSweeper;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import main.dataclicker.gui.GUI;

public class dummy {
	
	static GUI gui = new GUI();
	
	public static void createDataSweeper() {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				JFrame frame = new JFrame("Datasweeper");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
			
			
		});
	}
}
