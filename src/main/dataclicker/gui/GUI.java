package main.dataclicker.gui;

import main.dataclicker.player.Player;
import main.dataclicker.upgrades.Upgrades_Template;

import java.awt.*;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JToolTip;

import main.dataclicker.buyers.Buyers_Template;
import main.dataclicker.dataSources.*;
import main.dataclicker.gui.GUI;
import main.dataclicker.upgrades.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GUI {

	private JFrame frame;
	private String title = "DataClicker";

	//Buyers
	private static Buyers_Template nsa;
	private static Buyers_Template krake;
	private static Buyers_Template mobile;
	private static Buyers_Template party;
	private static Buyers_Template eSport;
	private static Buyers_Template tech;
	private static Buyers_Template vegtables;
	private static Buyers_Template drump;

	//Datasources
	private static DataSource_Template dataFarm;
	private static DataSource_Template dataBook;
	private static DataSource_Template dataPirate;
	private static DataSource_Template dataHub;
	private static DataSource_Template dataGewinnspiele;
	private static DataSource_Template dataScout24;
	private static DataSource_Template whatsData;
	private static DataSource_Template dataSearch;
	
	//upgrades
	private static Upgrades_Template zuchtBot;
	
	//Beschriftung der Buttons die immer dem gelichen Formular folgt
	 public String playerRessources() {
		 return ("Data: " + main.dataclicker.player.Player.getDataAmount() + " Daten pro Sekunde: " + main.dataclicker.player.Player.getCurrentDataPerSecond() + " Money: " + main.dataclicker.player.Player.getMoneyAmount());
	 }
	 public String dataSourcesText(DataSource_Template datasource) {
		 return (datasource.getSourceName() + " kostet: " + datasource.getCurrentCost() + " in Besitz: " + datasource.getSourceAmountOwned());
	 }
	 
	 public String dataSourceToolTip(DataSource_Template datasource) {
		 if (datasource.getSourceAmountOwned() != 0)
			 return(datasource.getSourceName()+": "+ datasource.getSourceDescription()+"<br>"
		 		+ datasource.getSourceName()+" produziert "+datasource.getInitialDataPerSecond()+" pro Sekunde für jede gekaufte Instanz"+"<br>"
				+ "zur Zeit werden "+datasource.getDataPerSecond()+ " Daten pro Sekunde produziert.");
		 
		 else return(datasource.getSourceName()+": "+ datasource.getSourceDescription()+"<br>"
			 		+ datasource.getSourceName()+" produziert "+datasource.getInitialDataPerSecond()+" pro Sekunde für jede gekaufte Instanz"+"<br>"
					+ "zur Zeit werden 0 Daten pro Sekunde produziert.");
	 }
	 
	 public String buyersText(Buyers_Template buyer) {
		 return ("LvL: " + buyer.getLevel() + " " +  buyer.getName() + " kauft " + buyer.getPrice() + " Daten f�r " + buyer.getValue() + "�");
	 }
	 
	 public String upgradesText(Upgrades_Template upgrade, DataSource_Template datasource) {
		 return (upgrade.getUpgradeName()+ " kostet: "+ upgrade.getUpgradeCost());
	 }
	 public String upgradesToolTip(Upgrades_Template upgrade, DataSource_Template datasource) {
		 return (upgrade.getUpgradeDescription()+"<br>"
				+ "Durch Kauf dieses Upgrades wird die produktivität von " + datasource.getSourceName()+ " verdoppelt.");
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
		 mobile = new Buyers_Template("Mobile-Data", 1000, 250);
		 party =  new Buyers_Template("deutsche Daten Partei", 2000, 750);
		 eSport =  new Buyers_Template("Data eSport", 5555, 1337);
		 tech =  new Buyers_Template("Data Tech", 10000, 2000);
		 vegtables =  new Buyers_Template("Obst und Daten", 100000, 10000);
		 drump =  new Buyers_Template("Tonald Drump", 1000000, 0);

		 //Datasources
		 dataFarm = new DataSource_Template("Daten-Farm", "Qualitätsdaten aus Freilandhaltung", 2, 10, 1.15, 0);
		 dataBook = new DataSource_Template("Daten-Buch", "", 10, 50, 1.20, 2000);
		 dataPirate = new DataSource_Template("Daten-Pirat", "", 15, 100, 1.40, 3000);
		 dataHub = new DataSource_Template("Daten-Hub", "", 30, 150, 1.80, 6000);
		 dataGewinnspiele = new DataSource_Template("Daten-Gewinnspiele", "", 40, 200, 2.0, 8000);
		 dataScout24 = new DataSource_Template("Daten-Scout24", "", 50, 250, 2.25, 12000);
		 dataSearch = new DataSource_Template("Daten-Suche", "", 55, 300, 2.50, 20000);
		 whatsData = new DataSource_Template("Whats-Data", "", 60, 500, 3.0, 25000);
		 
		 //upgrades
		 zuchtBot = new Upgrades_Template("Zucht-Bot", "Zieht die Daten vom klein auf an und macht diese Loyal wie keine anderen", 20, 2, dataFarm);

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
		
		JButton dataSource1 = new JButton(dataSourcesText(dataFarm));
		dataSources.add(dataSource1);
		dataSource1.setToolTipText("<html>"+dataSourceToolTip(dataFarm)+"<html>");
		dataSource1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataFarm.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource1.setText(dataSourcesText(dataFarm));
				dataSource1.setToolTipText("<html>"+dataSourceToolTip(dataFarm)+"/<html>");
			}
		});

		Timer everySecond = new Timer();		//erstellt einen Timer der jede Sekunde eine Aufgabe vollf�hrt
		everySecond.schedule(new TimerTask() {
			public void run() {
				dataFarm.collectDataPerSecond();
				dataBook.collectDataPerSecond();
				dataGewinnspiele.collectDataPerSecond();
				dataHub.collectDataPerSecond();
				dataPirate.collectDataPerSecond();
				dataScout24.collectDataPerSecond();
				dataSearch.collectDataPerSecond();
				dataGewinnspiele.collectDataPerSecond();
				whatsData.collectDataPerSecond();
				playerRessources.setText(playerRessources());
			}
		}, 0, 1000);
		
		JButton dataSource2 = new JButton(dataSourcesText(dataBook));
		dataSources.add(dataSource2);
		dataSource2.setToolTipText("<html>"+dataSourceToolTip(dataBook)+"<html>");
		 try {
			    dataSource2.setIcon(new ImageIcon(getClass().getResource("../res/textures/databook_logo_small.png")));
			  } catch (Exception ex) {
			    System.out.println(ex);
			  }
		 
		dataSource2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataBook.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource2.setText(dataSourcesText(dataBook));
				dataSource2.setToolTipText("<html>"+dataSourceToolTip(dataBook)+"<html>");
			}
		});

		JButton dataSource3 = new JButton(dataSourcesText(dataPirate));
		dataSources.add(dataSource3);
		dataSource3.setToolTipText("<html>"+dataSourceToolTip(dataPirate)+"<html>");
		dataSource3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataPirate.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource3.setText(dataSourcesText(dataPirate));
				dataSource3.setToolTipText("<html>"+dataSourceToolTip(dataPirate)+"<html>");
			}
		});

		JButton dataSource4 = new JButton(dataSourcesText(dataHub)); 
		dataSources.add(dataSource4);
		dataSource4.setToolTipText("<html>"+dataSourceToolTip(dataHub)+"<html>");
		dataSource4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataHub.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource4.setText(dataSourcesText(dataHub));
				dataSource4.setToolTipText("<html>"+dataSourceToolTip(dataHub)+"<html>");
			}
		});

		JButton dataSource5 = new JButton(dataSourcesText(dataGewinnspiele));
		dataSources.add(dataSource5);
		dataSource5.setToolTipText("<html>"+dataSourceToolTip(dataGewinnspiele)+"<html>");
		dataSource5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataGewinnspiele.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource5.setText(dataSourcesText(dataGewinnspiele));
				dataSource5.setToolTipText("<html>"+dataSourceToolTip(dataGewinnspiele)+"<html>");
			}
		});

		JButton dataSource6 = new JButton(dataSourcesText(dataScout24));
		dataSources.add(dataSource6);
		dataSource6.setToolTipText("<html>"+dataSourceToolTip(dataScout24)+"<html>");
		dataSource6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataScout24.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource6.setText(dataSourcesText(dataScout24));
				dataSource6.setToolTipText("<html>"+dataSourceToolTip(dataScout24)+"<html>");
			}
		});

		JButton dataSource7 = new JButton(dataSourcesText(dataSearch));
		dataSources.add(dataSource7);
		dataSource7.setToolTipText("<html>"+dataSourceToolTip(dataSearch)+"<html>");
		dataSource7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataSearch.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource7.setText(dataSourcesText(dataSearch));
				dataSource7.setToolTipText("<html>"+dataSourceToolTip(dataSearch)+"<html>");
			}
		});

		JButton dataSource8 = new JButton(dataSourcesText(whatsData));
		dataSources.add(dataSource8);
		dataSource8.setToolTipText("<html>"+dataSourceToolTip(whatsData)+"<html>");
		dataSource8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				whatsData.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource8.setText(dataSourcesText(whatsData));
				dataSource8.setToolTipText("<html>"+dataSourceToolTip(whatsData)+"<html>");
			}
		});

		JPanel dataBankPanel = new JPanel();
		frame.getContentPane().add(dataBankPanel, BorderLayout.CENTER);
		
		JButton dataBank = new JButton("Datenbank");
		dataBank.addActionListener(new ActionListener() { //überprüft wann geclickt wird und was in dem Falle passiert
			public void actionPerformed(ActionEvent click) {
				main.dataclicker.player.Player.dataClick();		//added die durch klicken dazugewonnene Anzahl von Daten
				playerRessources.setText(playerRessources()); //updatet das Label welches die aktuelle Anzahl an Daten anzeigt
				
			}
		});
		dataBankPanel.add(dataBank);
		
		JPanel buyersPanel = new JPanel();
		buyersPanel.setLayout(new GridLayout(10,1));
		frame.getContentPane().add(buyersPanel, BorderLayout.WEST);
		
		JButton buyer1 = new JButton(buyersText(nsa));
		buyersPanel.add(buyer1);
		buyer1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				nsa.buy();
				playerRessources.setText(playerRessources());
				buyer1.setText(buyersText(nsa));
			}
		});

		JButton buyer2 = new JButton(buyersText(krake));
		buyersPanel.add(buyer2);
		buyer2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				krake.buy();
				playerRessources.setText(playerRessources());
				buyer2.setText(buyersText(krake));
			}
		});

		JButton buyer3 = new JButton(buyersText(mobile));
		buyersPanel.add(buyer3);
		buyer3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				mobile.buy();
				playerRessources.setText(playerRessources());
				buyer3.setText(buyersText(mobile));
			}
		});
		
		JButton buyer4 = new JButton(buyersText(party));
		buyersPanel.add(buyer4);
		buyer4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				party.buy();
				playerRessources.setText(playerRessources());
				buyer4.setText(buyersText(party));
			}
		});
		
		JButton buyer5 = new JButton(buyersText(eSport));
		buyersPanel.add(buyer5);
		buyer5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				eSport.buy();
				playerRessources.setText(playerRessources());
				buyer5.setText(buyersText(eSport));
			}
		});
		
		JButton buyer6 = new JButton(buyersText(tech));
		buyersPanel.add(buyer6);
		buyer6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				tech.buy();
				playerRessources.setText(playerRessources());
				buyer6.setText(buyersText(tech));
			}
		});
		
		JButton buyer7 = new JButton(buyersText(vegtables));
		buyersPanel.add(buyer7);
		buyer7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				vegtables.buy();
				playerRessources.setText(playerRessources());
				buyer7.setText(buyersText(vegtables));
			}
		});
		
		JButton buyer8 = new JButton(buyersText(drump));
		buyersPanel.add(buyer8);
		buyer8.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				nsa.buy();
				krake.buy();
				mobile.buy();
				eSport.buy();
				tech.buy();
				vegtables.buy();
				drump.buy();
				playerRessources.setText(playerRessources());
				buyer1.setText(buyersText(nsa));
				buyer2.setText(buyersText(krake));
				buyer3.setText(buyersText(mobile));
				buyer4.setText(buyersText(party));
				buyer5.setText(buyersText(eSport));
				buyer6.setText(buyersText(tech));
				buyer7.setText(buyersText(vegtables));
				buyer8.setText(buyersText(drump));
			}
		});

		JPanel upgradesPanel = new JPanel();
		frame.getContentPane().add(upgradesPanel, BorderLayout.SOUTH);
		
		JButton upgrade1 = new JButton(upgradesText(zuchtBot, dataFarm));
		upgradesPanel.add(upgrade1);
		upgrade1.setToolTipText("<html>"+upgradesToolTip(zuchtBot, dataFarm));
		upgrade1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {				
				zuchtBot.purchaseUpgrade(dataFarm);
				playerRessources.setText(playerRessources());
				dataSource1.setText(dataSourcesText(dataFarm));
				upgradesPanel.remove(upgrade1);   //der button wird removed, da man Upgrades nur 1 mal erwerben kann
			}
		});
		
		
	}
	
	

}