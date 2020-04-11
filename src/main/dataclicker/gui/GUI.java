package main.dataclicker.gui;

import main.dataclicker.player.Player;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import main.dataclicker.buyers.Buyers_Template;
import main.dataclicker.dataSources.*;
import main.dataclicker.gui.GUI;

import javax.swing.JLabel;

public class GUI {

	private JFrame frame;
	private String title = "DataClicker";
	private static  Buyers_Template nsa;
	private static Buyers_Template krake;
	private static DataSource_Template musterSource;
	
	 public String playerRessources() {
		 return ("Data: "+main.dataclicker.player.Player.getDataAmount()+" Daten pro Sekunde: "+main.dataclicker.player.Player.getCurrentDataPerSecond()+" Money: "+main.dataclicker.player.Player.getMoneyAmount());
	 }

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
		 //Buyer
		 nsa = new  Buyers_Template("NSA", 10, 50);
		 krake = new Buyers_Template("Daten-Krake", 50, 200);
		 
		 //Datasources
		 musterSource = new DataSource_Template("Free Data", "genau das was versprochen wird", 2, 10, 1.15, 0);
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
		
		JLabel playerRessources = new JLabel(playerRessources());
		playerRessourcesPanel.add(playerRessources);
		
		JPanel dataSources = new JPanel();
		dataSources.setLayout(new GridLayout(10,1));
		frame.getContentPane().add(dataSources, BorderLayout.EAST);
		
		JButton dataSource1 = new JButton(musterSource.getSourceName()+" Kostet: "+musterSource.getCurrentCost());
		dataSources.add(dataSource1);
		dataSource1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				musterSource.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource1.setText(musterSource.getSourceName()+" Kostet: "+musterSource.getCurrentCost());
			}
		});
		Timer everySecond = new Timer();		//erstellt einen Timer der jede Sekunde eine Aufgabe vollführt
		everySecond.schedule(new TimerTask() {
			public void run() {
				musterSource.collectDataPerSecond();
				playerRessources.setText(playerRessources());
			}
		}, 0, 1000);
		
		JButton dataSource2 = new JButton("2nd DataSource");
		dataSources.add(dataSource2);

		/*JButton dataSource3 = new JButton("3rd DataSource");
		dataSources.add(dataSource3);*/
		
		JPanel dataBankPanel = new JPanel();
		frame.getContentPane().add(dataBankPanel, BorderLayout.CENTER);
		
		JButton dataBank = new JButton("Datenbank");
		dataBank.addActionListener(new ActionListener() { //Ã¼berprÃ¼ft wann geclickt wird und was in dem Falle passiert
			public void actionPerformed(ActionEvent click) {
				main.dataclicker.player.Player.dataClick();		//added die durch klicken dazugewonnene Anzahl von Daten
				playerRessources.setText(playerRessources()); //updatet das Label welches die aktuelle Anzahl an Daten anzeigt
				
			}
		});
		dataBankPanel.add(dataBank);
		
		JPanel buyersPanel = new JPanel();
		buyersPanel.setLayout(new GridLayout(10,1));
		frame.getContentPane().add(buyersPanel, BorderLayout.WEST);
		
		JButton buyer1 = new JButton("LvL: " + nsa.getLevel() + " " +  nsa.getName() + " kauft " + nsa.getPrice() + " Daten für " + nsa.getValue() + "€");
		buyersPanel.add(buyer1);
		buyer1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				nsa.buy();
				playerRessources.setText(playerRessources());
				buyer1.setText("LvL: " + nsa.getLevel() + " " +  nsa.getName() + " kauft " + nsa.getPrice() + " Daten für " + nsa.getValue() + "€");
			}
		});

		JButton buyer2 = new JButton("LvL: " + krake.getLevel() + " " +  krake.getName() + " kauft " + krake.getPrice() + " Daten für " + krake.getValue() + "€");
		buyersPanel.add(buyer2);
		buyer2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				krake.buy();
				playerRessources.setText(playerRessources());
				buyer2.setText("LvL: " + krake.getLevel() + " " +  krake.getName() + " kauft " + krake.getPrice() + " Daten für " + krake.getValue() + "€");
			}
		});

		JButton btnNewButton_1 = new JButton("New button");
		buyersPanel.add(btnNewButton_1);

		JPanel upgradesPanel = new JPanel();
		frame.getContentPane().add(upgradesPanel, BorderLayout.SOUTH);
		
		
	}
	
	

}