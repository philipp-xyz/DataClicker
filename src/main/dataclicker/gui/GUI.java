package main.dataclicker.gui;

import main.dataclicker.player.Player;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import main.dataclicker.buyers.Buyers_Template;
import main.dataclicker.gui.GUI;

import java.awt.FlowLayout;
import javax.swing.JLabel;

public class GUI {

	private JFrame frame;
	private String title = "DataClicker";
	private static  Buyers_Template mustermann;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		 mustermann = new  Buyers_Template("Max Mustermann", 10, 50);
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(title);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel playerRessourcesPanel = new JPanel();  //Anzeige von Daten & Geld welches der Spieler zur Zeit hat
		FlowLayout fl_playerRessourcesPanel = (FlowLayout) playerRessourcesPanel.getLayout();
		fl_playerRessourcesPanel.setVgap(50);
		frame.getContentPane().add(playerRessourcesPanel, BorderLayout.NORTH);
		
		JLabel playerRessources = new JLabel("Data: "+main.dataclicker.player.Player.getDataAmount()+" Money: "+main.dataclicker.player.Player.getMoneyAmount());
		playerRessourcesPanel.add(playerRessources);
		
		JPanel dataSources = new JPanel();
		frame.getContentPane().add(dataSources, BorderLayout.EAST);
		
		JButton dataSource1 = new JButton("1st DataSource");
		dataSources.add(dataSource1);
		
		JButton dataSource2 = new JButton("2nd DataSource");
		dataSources.add(dataSource2);
		
		JPanel dataBankPanel = new JPanel();
		frame.getContentPane().add(dataBankPanel, BorderLayout.CENTER);
		
		JButton dataBank = new JButton("Datenbank");
		dataBank.addActionListener(new ActionListener() { //überprüft wann geclickt wird und was in dem Falle passiert
			public void actionPerformed(ActionEvent click) {
				main.dataclicker.player.Player.dataClick();		//added die durch klicken dazugewonnene Anzahl von Daten
				playerRessources.setText("Data: "+main.dataclicker.player.Player.getDataAmount()+" Money: "+main.dataclicker.player.Player.getMoneyAmount()); //updatet das Label welches die aktuelle Anzahl an Daten anzeigt
				
			}
		});
		dataBankPanel.add(dataBank);
		
		JPanel buyersPanel = new JPanel();
		frame.getContentPane().add(buyersPanel, BorderLayout.WEST);
		
		JButton buyer1 = new JButton(mustermann.getName());
		buyersPanel.add(buyer1);
		buyer1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				mustermann.buy();
				playerRessources.setText("Data: "+main.dataclicker.player.Player.getDataAmount()+" Money: "+main.dataclicker.player.Player.getMoneyAmount());
			}
		});
		
		JButton btnNewButton_1 = new JButton("New button");
		buyersPanel.add(btnNewButton_1);
		
		JPanel upgradesPanel = new JPanel();
		frame.getContentPane().add(upgradesPanel, BorderLayout.SOUTH);
		
		
	}
	
	

}