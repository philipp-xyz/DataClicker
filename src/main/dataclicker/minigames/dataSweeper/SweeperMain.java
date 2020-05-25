package main.dataclicker.minigames.dataSweeper;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import main.dataclicker.gui.GUI;

public class SweeperMain {
	
	static SweeperGUI gui = new SweeperGUI();
	
	public static void createDataSweeper() {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				gui.sweeperInitialize();
				
			}
			
			
		});
	}
}
