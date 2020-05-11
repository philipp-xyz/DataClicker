package main.dataclicker.minigames.dataSweeper;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import main.dataclicker.gui.GUI;

public class SweeperMain {
	
	static GUI gui = new GUI();
	
	public static void createDataSweeper() {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				JFrame frame = new JFrame("Datasweeper");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//close operation can be made to add data/money?
				
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				JPanel panel = new JPanel(); 
				panel.setLayout(new GridLayout());
				
			}
			
			
		});
	}
}
