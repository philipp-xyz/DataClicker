package main.dataclicker.minigames.dataSlots;
import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;


public class SlotGui {

	public static int frameWidth = 500;  
	public static int frameHeight = 500;
	JFrame frame = new JFrame("DataSlots") ;
	void setLayout(null);
	JLabel label1= new JLabel();
	
	label1.setBounds(2,2,50,25); 
	textField1.setBounds(10,2,50,25);
	
	
	public void Initialize() {
		frame.setSize(frameWidth, frameHeight);
		frame.setResizable(true);
		frame.setVisible(true);}
	
	
	
}
