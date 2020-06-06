package main.dataclicker.minigames.dataSlots;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import main.dataclicker.player.Player;



public class SlotGui {

	public static int frameWidth = 500;
	public static int frameHeight = 500;

	static JFrame frame = new JFrame("DataSlots");
	GridBagLayout gbl_slots = new GridBagLayout();

	static int Gui_slot1;

	public int getGui_slot1() {
		return Gui_slot1;
	}

	public static void setGui_slot1(int variable) {
		Gui_slot1 = variable;
	}

	static int Gui_slot2;

	public int getGui_slot2() {
		return Gui_slot2;
	}

	public static void setGui_slot2(int variable) {
		Gui_slot2 = variable;
	}

	static int Gui_slot3;

	public int getGui_slot3() {
		return Gui_slot3;
	}

	public static void setGui_slot3(int variable) {
		Gui_slot3 = variable;
	}
	
	public static JLabel label1 = new JLabel("Trommelwirbel ....");
	public static JLabel label2 = new JLabel("" + Gui_slot1);
	public static JLabel label3 = new JLabel("" + Gui_slot2);
	public static JLabel label4 = new JLabel("" + Gui_slot3);

	
	
	public static void addComponentsToPanel(JPanel panel) {
		
		
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.fill = GridBagConstraints.BOTH;
		gbc_label1.gridx=3;
		gbc_label1.gridy=3;
		panel.add(label1, gbc_label1);

		
		
		GridBagConstraints gbc_label2 = new GridBagConstraints();
		gbc_label2.fill = GridBagConstraints.BOTH;
		gbc_label2.gridx=1;
		gbc_label2.gridy=1;
		panel.add(label2, gbc_label2);
		

		GridBagConstraints gbc_label3 = new GridBagConstraints();
		gbc_label3.fill = GridBagConstraints.BOTH;
		gbc_label3.gridx=3;
		gbc_label3.gridy=1;
		panel.add(label3, gbc_label3);
		
		
		GridBagConstraints gbc_label4 = new GridBagConstraints();
		gbc_label4.fill = GridBagConstraints.BOTH;
		gbc_label4.gridx=5;
		gbc_label4.gridy=1;
		panel.add(label4, gbc_label4);

		JButton startbutton = new JButton("Start Knopf Preis : 250");
		GridBagConstraints gbc_startbutton = new GridBagConstraints();
		gbc_startbutton.fill = GridBagConstraints.BOTH;
		gbc_startbutton.gridx=1;
		gbc_startbutton.gridy=2;
		panel.add(startbutton, gbc_startbutton);
		startbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {

					if (Player.getMoneyAmount()>=250) {
					Slotsmain.setRun(true);
					Player.setMoneyAmount(Player.getMoneyAmount()-250);
					}
					else
						startbutton.setText("You need more Money");
			}

		});
		
		JButton stopbutton = new JButton("Stop Knopf");
		GridBagConstraints gbc_stopbutton = new GridBagConstraints();
		gbc_stopbutton.fill = GridBagConstraints.BOTH;
		gbc_stopbutton.gridx=5;
		gbc_stopbutton.gridy=2;
		panel.add(stopbutton, gbc_stopbutton);
		stopbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {

				
					Slotsmain.setRun(false);
					Slotsmain.stopper();
			}

		});
	}

	public static void createAndShowGUI(boolean help) {

		frame.setResizable(true);
		if (help == true) {
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			frame.getContentPane().add(Slotsmain.panel);

			frame.pack();
			frame.setVisible(true);
		}
		if (help == false) {
			frame.add(Slotsmain.panel);
			frame.setVisible(true);
		}
	}

	public static void refreshLabels() {
		// Timer dataSourceVisibility = new Timer();
		// dataSourceVisibility.schedule(new TimerTask() {

		GridBagConstraints gbc_label2 = new GridBagConstraints();
		gbc_label2.fill = GridBagConstraints.BOTH;
		gbc_label2.gridx=1;
		gbc_label2.gridy=1;
		
		

		GridBagConstraints gbc_label3 = new GridBagConstraints();
		gbc_label3.fill = GridBagConstraints.BOTH;
		gbc_label3.gridx=3;
		gbc_label3.gridy=1;
	
		
		
		GridBagConstraints gbc_label4 = new GridBagConstraints();
		gbc_label4.fill = GridBagConstraints.BOTH;
		gbc_label4.gridx=5;
		gbc_label4.gridy=1;
		
		label2.setText("" + Gui_slot1);

		Slotsmain.panel.add(label2, gbc_label2);

		label3.setText("" + Gui_slot2);

		Slotsmain.panel.add(label3,gbc_label3);

		label4.setText("" + Gui_slot3);

		Slotsmain.panel.add(label4, gbc_label4);

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

	
	// frame.setLayout(gbl_slots);
	// frame.setLayout(gbl_slots);
	// gbl_slots.layoutContainer(frame);

	// gbl_slots.layoutContainer(frame);

}
