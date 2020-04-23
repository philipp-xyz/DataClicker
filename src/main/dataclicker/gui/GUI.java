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
	private static Upgrades_Template datenFutter;
	private static Upgrades_Template miniGames;	//könnte verwirrend sein
	private static Upgrades_Template gruppenInDeinerNähe;
	private static Upgrades_Template karperbrief;
	private static Upgrades_Template einNeuesSchiff;
	private static Upgrades_Template einNeuerMarktplatz;
	private static Upgrades_Template twoWayLiveChat;
	private static Upgrades_Template offlineEinbindung;
	private static Upgrades_Template waehlDeineBelohnung;
	private static Upgrades_Template callCenterSupport;
	private static Upgrades_Template onlineAusfüllformular;
	private static Upgrades_Template personalisierteSuche;
	private static Upgrades_Template werbung;
	private static Upgrades_Template statusModul;
	private static Upgrades_Template faceScanner;
	
	
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
		 		+ datasource.getSourceName()+" produziert "+datasource.getInitialDataPerSecond()+" pro Sekunde fÃ¼r jede gekaufte Instanz"+"<br>"
				+ "zur Zeit werden "+datasource.getDataPerSecond()+ " Daten pro Sekunde produziert.");
		 
		 else return(datasource.getSourceName()+": "+ datasource.getSourceDescription()+"<br>"
			 		+ datasource.getSourceName()+" produziert "+datasource.getInitialDataPerSecond()+" pro Sekunde fÃ¼r jede gekaufte Instanz"+"<br>"
					+ "zur Zeit werden 0 Daten pro Sekunde produziert.");
	 }
	 
	 public String buyersText(Buyers_Template buyer) {
		 return ("LvL: " + buyer.getLevel() + " " +  buyer.getName() + " kauft " + buyer.getPrice() + " Daten fï¿½r " + buyer.getValue() + "ï¿½");
	 }
	 
	 public String upgradesText(Upgrades_Template upgrade, DataSource_Template datasource) {
		 return (upgrade.getUpgradeName()+ " kostet: "+ upgrade.getUpgradeCost());
	 }
	 public String upgradesToolTip(Upgrades_Template upgrade, DataSource_Template datasource) {
		 return (upgrade.getUpgradeDescription()+"<br>"
				+ "Durch Kauf dieses Upgrades wird die produktivitÃ¤t von " + datasource.getSourceName()+ " verdoppelt.");
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
		 dataFarm = new DataSource_Template("Daten-Farm", "QualitÃ¤tsdaten aus Freilandhaltung", 2, 10, 1.15, 0);
		 dataBook = new DataSource_Template("Daten-Buch", "", 10, 50, 1.20, 2000);
		 dataPirate = new DataSource_Template("Daten-Pirat", "", 15, 100, 1.40, 3000);
		 dataHub = new DataSource_Template("Daten-Hub", "", 30, 150, 1.80, 6000);
		 dataGewinnspiele = new DataSource_Template("Daten-Gewinnspiele", "", 40, 200, 2.0, 8000);
		 dataScout24 = new DataSource_Template("Daten-Scout24", "", 50, 250, 2.25, 12000);
		 dataSearch = new DataSource_Template("Daten-Suche", "", 55, 300, 2.50, 20000);
		 whatsData = new DataSource_Template("Whats-Data", "", 60, 500, 3.0, 25000);
		 
		 //upgrades
		 zuchtBot = new Upgrades_Template("Zucht-Bot", "Zieht die Daten vom klein auf an und macht diese Loyal wie keine anderen", 20, 2, dataFarm);
		 datenFutter = new Upgrades_Template("Daten-Futter", "Füttere deine Daten-Sprößlinge hiermit und sie werden im Eiltempo zu inkriminierenden Datenpaketen", 100, 4, dataFarm);
		 miniGames = new Upgrades_Template("Mini Games", "Füttere deine Daten-Sprößlinge hiermit und sie werden im Eiltempo zu inkriminierenden Datenpaketen", 20, 2, dataBook);
		 gruppenInDeinerNähe = new Upgrades_Template("Gruppen-In-Deiner-Nähe", "Wir erstellen gruppen in größeren Städten und die Benutzer melden sich bei denen und zeigen uns was Sie gerne offline machen wie z.B. Yoga oder Rollenspielen]", 20, 4, dataBook);
		 karperbrief = new Upgrades_Template("Karperbrief", "Verschaff deinem Piraten exclusiven zutritt zu legalen gewässern", 20, 2, dataPirate);
		 einNeuesSchiff = new Upgrades_Template("Ein neues Schiff", "Auch ein online Pirat profitiert von einem neuen Schiff (PC) mit welchem er gefährlichere Gewässer besser und schneller erreichen kann", 20, 4, dataPirate);
		 einNeuerMarktplatz = new Upgrades_Template("Ein neuer Marktplatz", "Verschönere dein Datenhub mit einer schöneren Frontseite", 20, 2, dataHub);
		 twoWayLiveChat = new Upgrades_Template("Two way Livechat", "woher sollen die denn wissen das wir auch ihre Live-Chat seite aufzeichnen", 20, 4, dataHub);
		 offlineEinbindung = new Upgrades_Template("Offline Einbindung", "Lass die spieler richtig mitfiebern und gib ihnen die möglichkeit sich per Post mit rücksende beleg zu bewerben", 20, 2, dataGewinnspiele);
		 waehlDeineBelohnung = new Upgrades_Template("Waehl deine Belohnung", "Lassen wir unsere Mitspieler doch einfach schon im vorhinaus entscheiden welchen von 50 Gewinnen sie am besten finden, selbst diese Information ist in unserer Welt Bares !", 20, 4, dataGewinnspiele);
		 callCenterSupport = new Upgrades_Template("Call Center Support", "Für Premium-Kunden bieten wir einen 24/7 Call Center bei welchem sie innerhalb kürzester zeit Sich die seele vom Leib über ihr Angebot reden können und wir die beste ausrede haben mehr private Informationen zu erfragen", 20, 2, dataScout24);
		 onlineAusfüllformular = new Upgrades_Template("Online Ausfüllformular", "Warum söllten unsere Kunden noch ausserhalb unserer Website Hantieren wenn wir ihnen doch hier Alles bieten können", 20, 4, dataScout24);
		 personalisierteSuche = new Upgrades_Template("Personalisierte Suche", "Vorschläge die an vorherige  Suchen und wahlen zwischen den Suchergebnissen angelehnt sind freuen doch jeden Benutzer", 20, 2, dataSearch);
		 werbung = new Upgrades_Template("Werbung", "Funktioniert noch besser als es Klingt, platzieren wir verstreut ein wenig Werbung und sammeln daten darüber ob mit dieser interagiert wird finden wir noch mehr über die Leute heraus als diese wirklich zugeben wollen", 20, 4, dataSearch);
		 statusModul = new Upgrades_Template("Status Modul", "Klauen wir doch von der Konkurenz, geben wir den Nutzern die Möglichkeit ihree jede kleinste Bewegung hochzuladen und mit ihren Freunden und UNS zu teilen", 20, 2, whatsData);
		 faceScanner = new Upgrades_Template("Face Scanner", "Wir scannen jedes Bild und jedes Video das die Menschen durch uns versenden und finden Darüber mehr über ihr 	Umfeld heraus", 20, 4, whatsData);

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

		Timer everySecond = new Timer();		//erstellt einen Timer der jede Sekunde eine Aufgabe vollfï¿½hrt
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
		JButton upgrade2 = new JButton(upgradesText(datenFutter, dataFarm));
		upgradesPanel.add(upgrade2);
		upgrade2.setToolTipText("<html>"+upgradesToolTip(datenFutter, dataFarm));
		upgrade2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {				
				datenFutter.purchaseUpgrade(dataFarm);
				playerRessources.setText(playerRessources());
				dataSource1.setText(dataSourcesText(dataFarm));	//double rewrite??
				upgradesPanel.remove(upgrade2);  
			}
		});
		JButton upgrade3 = new JButton(upgradesText(miniGames, dataBook));
		upgradesPanel.add(upgrade3);
		upgrade3.setToolTipText("<html>"+upgradesToolTip(miniGames, dataBook));
		upgrade3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {				
				datenFutter.purchaseUpgrade(dataBook);
				playerRessources.setText(playerRessources());
				dataSource2.setText(dataSourcesText(dataBook));
				upgradesPanel.remove(upgrade3);  
			}
		});
		JButton upgrade4 = new JButton(upgradesText(gruppenInDeinerNähe, dataBook));
		upgradesPanel.add(upgrade4);
		upgrade4.setToolTipText("<html>"+upgradesToolTip(gruppenInDeinerNähe, dataBook));
		upgrade4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {				
				gruppenInDeinerNähe.purchaseUpgrade(dataBook);
				playerRessources.setText(playerRessources());
				dataSource2.setText(dataSourcesText(dataBook));
				upgradesPanel.remove(upgrade2);  
			}
		});
		JButton upgrade5 = new JButton(upgradesText(karperbrief, dataPirate));
		upgradesPanel.add(upgrade4);
		upgrade5.setToolTipText("<html>"+upgradesToolTip(karperbrief, dataPirate));
		upgrade5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {				
				karperbrief.purchaseUpgrade(dataPirate);
				playerRessources.setText(playerRessources());
				dataSource3.setText(dataSourcesText(dataPirate));
				upgradesPanel.remove(upgrade5);  
			}
		});
		JButton upgrade6 = new JButton(upgradesText(einNeuesSchiff, dataPirate));
		upgradesPanel.add(upgrade6);
		upgrade6.setToolTipText("<html>"+upgradesToolTip(einNeuesSchiff, dataPirate));
		upgrade6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {				
				einNeuesSchiff.purchaseUpgrade(dataPirate);
				playerRessources.setText(playerRessources());
				dataSource3.setText(dataSourcesText(dataPirate));
				upgradesPanel.remove(upgrade6);  
			}
		});
		JButton upgrade7 = new JButton(upgradesText(einNeuerMarktplatz , dataHub));
		upgradesPanel.add(upgrade7);
		upgrade7.setToolTipText("<html>"+upgradesToolTip(einNeuerMarktplatz, dataHub));
		upgrade7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {				
				einNeuerMarktplatz.purchaseUpgrade(dataHub);
				playerRessources.setText(playerRessources());
				dataSource4.setText(dataSourcesText(dataHub));
				upgradesPanel.remove(upgrade7);  
			}
		});
		JButton upgrade8 = new JButton(upgradesText(twoWayLiveChat, dataHub));
		upgradesPanel.add(upgrade8);
		upgrade8.setToolTipText("<html>"+upgradesToolTip(twoWayLiveChat, dataHub));
		upgrade8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {				
				twoWayLiveChat.purchaseUpgrade(dataHub);
				playerRessources.setText(playerRessources());
				dataSource4.setText(dataSourcesText(dataHub));
				upgradesPanel.remove(upgrade8);  
			}
		});
		JButton upgrade9 = new JButton(upgradesText(offlineEinbindung, dataGewinnspiele));
		upgradesPanel.add(upgrade9);
		upgrade9.setToolTipText("<html>"+upgradesToolTip(offlineEinbindung, dataGewinnspiele));
		upgrade9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {				
				offlineEinbindung.purchaseUpgrade(dataGewinnspiele);
				playerRessources.setText(playerRessources());
				dataSource5.setText(dataSourcesText(dataGewinnspiele));
				upgradesPanel.remove(upgrade9);  
			}
		});
		JButton upgrade10 = new JButton(upgradesText(waehlDeineBelohnung, dataGewinnspiele));
		upgradesPanel.add(upgrade4);
		upgrade10.setToolTipText("<html>"+upgradesToolTip(waehlDeineBelohnung, dataGewinnspiele));
		upgrade10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {				
				waehlDeineBelohnung.purchaseUpgrade(dataGewinnspiele);
				playerRessources.setText(playerRessources());
				dataSource5.setText(dataSourcesText(dataGewinnspiele));
				upgradesPanel.remove(upgrade10);  
			}
		});
		JButton upgrade11 = new JButton(upgradesText(callCenterSupport, dataScout24));
		upgradesPanel.add(upgrade4);
		upgrade11.setToolTipText("<html>"+upgradesToolTip(callCenterSupport, dataScout24));
		upgrade10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {				
				callCenterSupport.purchaseUpgrade(dataScout24);
				playerRessources.setText(playerRessources());
				dataSource6.setText(dataSourcesText(dataScout24));
				upgradesPanel.remove(upgrade10);  
			}
		});
		JButton upgrade12 = new JButton(upgradesText(onlineAusfüllformular, dataScout24));
		upgradesPanel.add(upgrade12);
		upgrade12.setToolTipText("<html>"+upgradesToolTip(onlineAusfüllformular, dataScout24));
		upgrade12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {				
				onlineAusfüllformular.purchaseUpgrade(dataScout24);
				playerRessources.setText(playerRessources());
				dataSource6.setText(dataSourcesText(dataScout24));
				upgradesPanel.remove(upgrade12);  
			}
		});
		JButton upgrade13 = new JButton(upgradesText(statusModul, whatsData));
		upgradesPanel.add(upgrade13);
		upgrade13.setToolTipText("<html>"+upgradesToolTip(statusModul, whatsData));
		upgrade13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {				
				statusModul.purchaseUpgrade(whatsData);
				playerRessources.setText(playerRessources());
				dataSource7.setText(dataSourcesText(whatsData));
				upgradesPanel.remove(upgrade13);  
			}
		});
		JButton upgrade14 = new JButton(upgradesText(faceScanner, whatsData));
		upgradesPanel.add(upgrade14);
		upgrade14.setToolTipText("<html>"+upgradesToolTip(faceScanner, whatsData));
		upgrade14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {				
				faceScanner.purchaseUpgrade(whatsData);
				playerRessources.setText(playerRessources());
				dataSource7.setText(dataSourcesText(whatsData));
				upgradesPanel.remove(upgrade14);  
			}
		});
		JButton upgrade15 = new JButton(upgradesText(personalisierteSuche, dataSearch));
		upgradesPanel.add(upgrade15);
		upgrade15.setToolTipText("<html>"+upgradesToolTip(personalisierteSuche, dataSearch));
		upgrade15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {				
				personalisierteSuche.purchaseUpgrade(dataSearch);
				playerRessources.setText(playerRessources());
				dataSource8.setText(dataSourcesText(dataSearch));
				upgradesPanel.remove(upgrade15);  
			}
		});
		JButton upgrade16 = new JButton(upgradesText(werbung, dataSearch));
		upgradesPanel.add(upgrade16);
		upgrade16.setToolTipText("<html>"+upgradesToolTip(werbung, dataSearch));
		upgrade16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {				
				werbung.purchaseUpgrade(dataSearch);
				playerRessources.setText(playerRessources());
				dataSource8.setText(dataSourcesText(dataSearch));
				upgradesPanel.remove(upgrade16);  
			}
		});
	}
	
	

}