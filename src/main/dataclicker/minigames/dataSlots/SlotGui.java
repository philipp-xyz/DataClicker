package main.dataclicker.minigames.dataSlots;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class SlotGui {

	public static int frameWidth = 500;
	public static int frameHeight = 500;

	

	static JFrame frame = new JFrame("DataSlots");
	GridBagLayout gbl_slots = new GridBagLayout();

	

	static int Gui_Slot1;

	public int getGui_Slot1() {
		return Gui_Slot1;
	}

	public static void setGui_Slot1(int variable) {
		Gui_Slot1 = variable;
	}

	static int Gui_Slot2;

	public int getGui_Slot2() {
		return Gui_Slot2;
	}

	public static void setGui_Slot2(int variable) {
		Gui_Slot2 = variable;
	}

	static int Gui_Slot3;

	public int getGui_Slot3() {
		return Gui_Slot3;
	}

	public static void setGui_Slot3(int variable) {
		Gui_Slot3 = variable;
	}
	public static   JLabel label2 = new JLabel(""+Gui_Slot1);
	public static   JLabel label1= new JLabel("Win or Lose Label");
	public static 	JLabel label3 = new JLabel(""+Gui_Slot2);
	public static	JLabel label4 = new JLabel(""+Gui_Slot3);
	
	
	public static void addComponentsToPane(Container pane) {
         
	       
	         
		 	
	        pane.add(label1, BorderLayout.PAGE_START);
	         
	        
	        
	      
	        label2.setPreferredSize(new Dimension(166, 50));
	        pane.add(label2, BorderLayout.LINE_START);
	        
	       
	        label3.setPreferredSize(new Dimension(166, 50));
	        pane.add(label3, BorderLayout.CENTER);
	         
	        
	        label4.setPreferredSize(new Dimension(166, 50));
	        pane.add(label4, BorderLayout.LINE_END);
	        
	        
	        
	        JButton button = new JButton("Start Knopf");
	        pane.add(button, BorderLayout.PAGE_END);
	        button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent click) {
					
					if (Slotsmain.getRun()==true)
					{
						Slotsmain.setRun(false);
					}
					else
						Slotsmain.setRun(true);
					}
			
	        });
	}

	public static void createAndShowGUI(boolean help) {

		if (help == true) {
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			addComponentsToPane(frame.getContentPane());

			frame.pack();
			frame.setVisible(true);
		}
		if (help == false) {
			addComponentsToPane(frame.getContentPane());
			frame.setVisible(true);
		}
	}

	public static void refreshLabels() {
		// Timer dataSourceVisibility = new Timer();
		// dataSourceVisibility.schedule(new TimerTask() {
		
		
		
		
		label2.setText("" + Gui_Slot1);
		
		Slotsmain.pane.add(label2, BorderLayout.LINE_START);

		label3.setText("" + Gui_Slot2);
		
		Slotsmain.pane.add(label3, BorderLayout.CENTER);

		label4.setText("" + Gui_Slot3);
		
		Slotsmain.pane.add(label4, BorderLayout.LINE_END);

		

		createAndShowGUI(false);
	}
	// }, 0, 1000);

	public static void main(String[] args) {
		/* Use an appropriate Look and Feel */

		/* Turn off metal's use bold fonts */
		UIManager.put("swing.boldMetal", Boolean.FALSE);

		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(true);
			}
		});
	}

	// gbl_slots.layoutContainer(frame);
	// gbl_slots.layoutContainer(frame);

	// gbl_slots.columnWeights = new double[]{1.0f};
	// gbl_slots.rowWeights = new double[] {0.0f,0.0f,0.0f};

	public void Initialize() {
		frame.setSize(frameWidth, frameHeight);
		frame.setResizable(true);
		frame.setVisible(true);
	}
	// frame.setLayout(gbl_slots);
	// frame.setLayout(gbl_slots);
	// gbl_slots.layoutContainer(frame);

	// gbl_slots.layoutContainer(frame);

}
