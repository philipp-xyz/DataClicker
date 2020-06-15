package main.dataclicker.gui;

import main.dataclicker.minigames.blackJack.bj.BJ;
import main.dataclicker.minigames.dataSnake.gui.Game;
import main.dataclicker.upgrades.Upgrades_Template;
//import main.dataclicker.minigames.dataSweeper.*;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import main.dataclicker.buyers.Buyers_Template;
import main.dataclicker.dataSources.*;
import main.dataclicker.minigames.dataSweeper.SweeperGUI;

import javax.swing.JLabel;

public class GUI {

	private JFrame frame;
	private String title = "DataClicker";

	// Buyers
	private static Buyers_Template nsa;
	private static Buyers_Template krake;
	private static Buyers_Template mobile;
	private static Buyers_Template party;
	private static Buyers_Template eSport;
	private static Buyers_Template tech;
	private static Buyers_Template vegtables;
	private static Buyers_Template drump;

	// Datasources
	private static DataSource_Template dataFarm;
	private static DataSource_Template dataBook;
	private static DataSource_Template dataPirate;
	private static DataSource_Template dataHub;
	private static DataSource_Template dataGewinnspiele;
	private static DataSource_Template dataScout24;
	private static DataSource_Template whatsData;
	private static DataSource_Template dataSearch;

	// upgrades
	private static Upgrades_Template zuchtBot;
	private static Upgrades_Template datenFutter;
	private static Upgrades_Template miniGames; // kï¿½nnte verwirrend sein
	private static Upgrades_Template gruppenInDeinerNaehe;
	private static Upgrades_Template karperbrief;
	private static Upgrades_Template einNeuesSchiff;
	private static Upgrades_Template einNeuerMarktplatz;
	private static Upgrades_Template twoWayLiveChat;
	private static Upgrades_Template offlineEinbindung;
	private static Upgrades_Template waehlDeineBelohnung;
	private static Upgrades_Template callCenterSupport;
	private static Upgrades_Template onlineAusfuellformular;
	private static Upgrades_Template personalisierteSuche;
	private static Upgrades_Template werbung;
	private static Upgrades_Template statusModul;
	private static Upgrades_Template faceScanner;
	private static Upgrades_Template minigameDataSnake;
	private static Upgrades_Template minigameDataPong;
	private static Upgrades_Template minigameDataJack;
	private static Upgrades_Template minigameDataSweeper;
	private static Upgrades_Template minigameDataSlots;

	// Beschriftung der Buttons die immer dem gelichen Formular folgt
	public String playerRessources() {
		return ("Data: " + main.dataclicker.player.Player.getDataAmount() + " Daten pro Sekunde: "
				+ main.dataclicker.player.Player.getCurrentDataPerSecond() + " Geld: "
				+ main.dataclicker.player.Player.getMoneyAmount());
	}

	public String dataSourcesText(DataSource_Template datasource) {
		return (datasource.getSourceName() + " kostet: " + datasource.getCurrentCost() + "<br>" + " in Besitz: "
				+ datasource.getSourceAmountOwned());
	}

	public String dataSourceToolTip(DataSource_Template datasource) {
		if (datasource.getSourceAmountOwned() != 0)
			return (datasource.getSourceName() + ": " + datasource.getSourceDescription() + "<br>"
					+ datasource.getSourceName() + " produziert " + datasource.getInitialDataPerSecond()
					+ " pro Sekunde für jede gekaufte Instanz" + "<br>" + "zur Zeit werden "
					+ datasource.getDataPerSecond() + " Daten pro Sekunde produziert.");

		else
			return (datasource.getSourceName() + ": " + datasource.getSourceDescription() + "<br>"
					+ datasource.getSourceName() + " produziert " + datasource.getInitialDataPerSecond()
					+ " pro Sekunde für jede gekaufte Instanz" + "<br>"
					+ "zur Zeit werden 0 Daten pro Sekunde produziert.");
	}

	public String buyersText(Buyers_Template buyer) {
		// return ("LvL: " + buyer.getLevel() + " " + buyer.getName() + " kauft " +
		// buyer.getPrice() + " Daten fï¿½r "
		// + buyer.getValue() + "ï¿½");
		if (buyer.getName() == "Tonald Drump") {
			return (buyer.getName() + " kauft " + buyer.getPrice() + " Daten und gibt dir einmal alles Andere");
		}
		return (buyer.getName() + " kauft " + buyer.getPrice() + " Daten fuer " + buyer.getValue() + " Euro");
	}

	public String upgradesText(Upgrades_Template upgrade) {
		return (upgrade.getUpgradeName() + " kostet: " + upgrade.getUpgradeCost());
	}

	public String upgradesToolTip(Upgrades_Template upgrade, DataSource_Template datasource) {
		return (upgrade.getUpgradeDescription() + "<br>" + "Durch Kauf dieses Upgrades wird die produktivitÃ¤t von "
				+ datasource.getSourceName() + " verdoppelt.");
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
		// Buyer
		vegtables = new Buyers_Template("Obst und Daten", 10, 25);
		mobile = new Buyers_Template("Mobile-Data", 50, 125);
		tech = new Buyers_Template("Data Tech", 150, 550);
		eSport = new Buyers_Template("Data eSport", 500, 1000);
		party = new Buyers_Template("deutsche Daten Partei", 1500, 1500);
		nsa = new Buyers_Template("NSA", 10000, 2000);
		krake = new Buyers_Template("Daten-Krake", 100000, 10000);
		drump = new Buyers_Template("Tonald Drump", 1000000, 0);

		// Datasources
		dataFarm = new DataSource_Template("Daten-Farm", "Qualitaetsdaten aus Freilandhaltung", 1, 10, 1.15, 0);
		dataBook = new DataSource_Template("Daten-Buch", "", 10, 50, 1.20, 10);
		dataPirate = new DataSource_Template("Daten-Pirat", "", 15, 100, 1.40, 30);
		dataHub = new DataSource_Template("Daten-Hub", "", 30, 150, 1.80, 50);
		dataGewinnspiele = new DataSource_Template("Daten-Gewinnspiele", "", 40, 200, 2.0, 80);
		dataScout24 = new DataSource_Template("Daten-Scout24", "", 50, 250, 2.25, 150);
		dataSearch = new DataSource_Template("Daten-Suche", "", 55, 300, 2.50, 300);
		whatsData = new DataSource_Template("Whats-Data", "", 60, 500, 3.0, 500);


		// upgrades
		zuchtBot = new Upgrades_Template("Zucht-Bot",
				"Zieht die Daten vom klein auf an und macht diese Loyal wie keine anderen", 20, 2, dataFarm);
		datenFutter = new Upgrades_Template("Daten-Futter",
				"Fuettere deine Daten-Sproesslinge hiermit und sie werden im Eiltempo zu inkriminierenden Datenpaketen",
				100, 4, dataFarm);
		miniGames = new Upgrades_Template("Mini Games",
				"Fuettere deine Daten-Sproesslinge hiermit und sie werden im Eiltempo zu inkriminierenden Datenpaketen",
				100, 2, dataBook);
		gruppenInDeinerNaehe = new Upgrades_Template("Gruppen-In-Deiner-Naehe",
				"Wir erstellen gruppen in groesseren Staedten und die Benutzer melden sich bei denen und zeigen uns was Sie gerne offline machen wie z.B. Yoga oder Rollenspielen]",
				500, 4, dataBook);
		karperbrief = new Upgrades_Template("Karperbrief",
				"Verschaff deinem Piraten exclusiven zutritt zu legalen gewaessern", 200, 2, dataPirate);
		einNeuesSchiff = new Upgrades_Template("Ein neues Schiff",
				"Auch ein online Pirat profitiert von einem neuen Schiff (PC) mit welchem er gefï¿½hrlichere Gewï¿½sser besser und schneller erreichen kann",
				1000, 4, dataPirate);
		einNeuerMarktplatz = new Upgrades_Template("Ein neuer Marktplatz",
				"Verschoenere dein Datenhub mit einer schoeneren Frontseite", 300, 2, dataHub);
		twoWayLiveChat = new Upgrades_Template("Two way Livechat",
				"woher sollen die denn wissen das wir auch ihre Live-Chat seite aufzeichnen", 1200, 4, dataHub);
		offlineEinbindung = new Upgrades_Template("Offline Einbindung",
				"Lass die spieler richtig mitfiebern und gib ihnen die moeglichkeit sich per Post mit rï¿½cksende beleg zu bewerben",
				400, 2, dataGewinnspiele);
		waehlDeineBelohnung = new Upgrades_Template("Waehl deine Belohnung",
				"Lassen wir unsere Mitspieler doch einfach schon im vorhinaus entscheiden welchen von 50 Gewinnen sie am besten finden, selbst diese Information ist in unserer Welt Bares !",
				2000, 4, dataGewinnspiele);
		callCenterSupport = new Upgrades_Template("Call Center Support",
				"Fï¿½r Premium-Kunden bieten wir einen 24/7 Call Center bei welchem sie innerhalb kï¿½rzester zeit Sich die seele vom Leib ï¿½ber ihr Angebot reden kï¿½nnen und wir die beste ausrede haben mehr private Informationen zu erfragen",
				500, 2, dataScout24);
		onlineAusfuellformular = new Upgrades_Template("Online Ausfï¿½llformular",
				"Warum sï¿½llten unsere Kunden noch ausserhalb unserer Website Hantieren wenn wir ihnen doch hier Alles bieten kï¿½nnen",
				2500, 4, dataScout24);
		personalisierteSuche = new Upgrades_Template("Personalisierte Suche",
				"Vorschlï¿½ge die an vorherige  Suchen und wahlen zwischen den Suchergebnissen angelehnt sind freuen doch jeden Benutzer",
				600, 2, dataSearch);
		werbung = new Upgrades_Template("Werbung",
				"Funktioniert noch besser als es Klingt, platzieren wir verstreut ein wenig Werbung und sammeln daten darï¿½ber ob mit dieser interagiert wird finden wir noch mehr ï¿½ber die Leute heraus als diese wirklich zugeben wollen",
				3000, 4, dataSearch);
		statusModul = new Upgrades_Template("Status Modul",
				"Klauen wir doch von der Konkurenz, geben wir den Nutzern die Mï¿½glichkeit ihree jede kleinste Bewegung hochzuladen und mit ihren Freunden und UNS zu teilen",
				1000, 2, whatsData);
		faceScanner = new Upgrades_Template("Face Scanner",
				"Wir scannen jedes Bild und jedes Video das die Menschen durch uns versenden und finden Darï¿½ber mehr ï¿½ber ihr 	Umfeld heraus",
				5005, 4, whatsData);
		minigameDataSnake = new Upgrades_Template("Data-Snake!", "Spiele Snake um Geld zu erspielen! Klicke einfach auf das Bild der Daten-Krake", 12500);
		minigameDataJack = new Upgrades_Template("Black Jack!", "Klicke auf das Data-Tech icon um Geld durch Black Jack zugewinnen", 500);
		minigameDataPong = new Upgrades_Template("Pong!", "Ab jetzt bietet DataScout24 auch Pong zum kennenlernen an! Klicke einfach auf das Icon", 1500);
		minigameDataSweeper = new Upgrades_Template("Mine? Nein, Data-Sweeper!", "Die Datenpiraten brauchen hilfe um ihre Schätze zu sichern, klicke auf das Icon um ihnen zu helfen", 500);
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
		frame.setBounds(100, 100, 1500, 786);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel playerRessourcesPanel = new JPanel(); // Anzeige von Daten & Geld welches der Spieler zur Zeit hat

		// frame.setResizable(false);

		// JPanel playerRessourcesPanel = new JPanel(); //Anzeige von Daten & Geld
		// welches der Spieler zur Zeit hat

		FlowLayout fl_playerRessourcesPanel = (FlowLayout) playerRessourcesPanel.getLayout();
		fl_playerRessourcesPanel.setVgap(10);
		frame.getContentPane().add(playerRessourcesPanel, BorderLayout.NORTH);

		JLabel playerRessources = new JLabel(playerRessources());
		playerRessourcesPanel.add(playerRessources);

		JPanel dataSources = new JPanel();
		dataSources.setBorder(null);
		frame.getContentPane().add(dataSources, BorderLayout.EAST);
		GridBagLayout gbl_dataSources = new GridBagLayout();
		gbl_dataSources.columnWidths = new int[] { 60, 91, 0 };
		gbl_dataSources.rowHeights = new int[] { 50, 50, 50, 50, 50, 50, 50, 63, 0 };
		gbl_dataSources.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_dataSources.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		dataSources.setLayout(gbl_dataSources);

		JButton dataSource1Icon = new JButton();
		dataSource1Icon.setIcon(
				new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/dataFarm_logo_small.png")));
		GridBagConstraints gbc_dataSource1Icon = new GridBagConstraints();
		gbc_dataSource1Icon.fill = GridBagConstraints.BOTH;
		gbc_dataSource1Icon.insets = new Insets(0, 0, 5, 0);
		gbc_dataSource1Icon.gridx = 0;
		gbc_dataSource1Icon.gridy = 0;
		dataSources.add(dataSource1Icon, gbc_dataSource1Icon);

		JButton dataSource1 = new JButton("<html>" + dataSourcesText(dataFarm));
		GridBagConstraints gbc_dataSource1 = new GridBagConstraints();
		gbc_dataSource1.fill = GridBagConstraints.BOTH;
		gbc_dataSource1.insets = new Insets(0, 0, 5, 0);
		gbc_dataSource1.gridx = 1;
		gbc_dataSource1.gridy = 0;
		dataSources.add(dataSource1, gbc_dataSource1);
		dataSource1.setToolTipText("<html>" + dataSourceToolTip(dataFarm) + "<html>");
		dataSource1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataFarm.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource1.setText("<html>" + dataSourcesText(dataFarm));
				dataSource1.setToolTipText("<html>" + dataSourceToolTip(dataFarm) + "/<html>");
			}
		});

		JButton dataSource2Icon = new JButton();
		dataSource2Icon.setIcon(
				new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/databook_logo_small.png")));
		GridBagConstraints gbc_dataSource2Icon = new GridBagConstraints();
		gbc_dataSource2Icon.fill = GridBagConstraints.BOTH;
		gbc_dataSource2Icon.insets = new Insets(0, 0, 5, 0);
		gbc_dataSource2Icon.gridx = 0;
		gbc_dataSource2Icon.gridy = 1;
		dataSources.add(dataSource2Icon, gbc_dataSource2Icon);

		JButton dataSource2 = new JButton("<html>" + dataSourcesText(dataBook));
		GridBagConstraints gbc_dataSource2 = new GridBagConstraints();
		gbc_dataSource2.fill = GridBagConstraints.BOTH;
		gbc_dataSource2.insets = new Insets(0, 0, 5, 0);
		gbc_dataSource2.gridx = 1;
		gbc_dataSource2.gridy = 1;
		dataSources.add(dataSource2, gbc_dataSource2);
		dataSource2.setToolTipText("<html>" + dataSourceToolTip(dataBook) + "<html>");

		dataSource2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataBook.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource2.setText("<html>" + dataSourcesText(dataBook));
				dataSource2.setToolTipText("<html>" + dataSourceToolTip(dataBook) + "<html>");
			}
		});

		JButton dataSource3Icon = new JButton();
		dataSource3Icon.setName("Sweeper");
		dataSource3Icon.setIcon(
				new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/dataPirate_logo_small.png")));
		GridBagConstraints gbc_dataSource3Icon = new GridBagConstraints();
		gbc_dataSource3Icon.fill = GridBagConstraints.BOTH;
		gbc_dataSource3Icon.insets = new Insets(0, 0, 5, 0);
		gbc_dataSource3Icon.gridx = 0;
		gbc_dataSource3Icon.gridy = 2;
		dataSources.add(dataSource3Icon, gbc_dataSource3Icon);
		

		JButton dataSource3 = new JButton("<html>" + dataSourcesText(dataPirate));
		GridBagConstraints gbc_dataSource3 = new GridBagConstraints();
		gbc_dataSource3.fill = GridBagConstraints.BOTH;
		gbc_dataSource3.insets = new Insets(0, 0, 5, 0);
		gbc_dataSource3.gridx = 1;
		gbc_dataSource3.gridy = 2;
		dataSources.add(dataSource3, gbc_dataSource3);
		dataSource3.setToolTipText("<html>" + dataSourceToolTip(dataPirate) + "<html>");
		dataSource3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataPirate.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource3.setText("<html>" + dataSourcesText(dataPirate));
				dataSource3.setToolTipText("<html>" + dataSourceToolTip(dataPirate) + "<html>");
			}
		});

		JButton dataSource4Icon = new JButton();
		dataSource4Icon
		.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/dataHub_logo_small.png")));
		GridBagConstraints gbc_dataSource4Icon = new GridBagConstraints();
		gbc_dataSource4Icon.fill = GridBagConstraints.BOTH;
		gbc_dataSource4Icon.insets = new Insets(0, 0, 5, 0);
		gbc_dataSource4Icon.gridx = 0;
		gbc_dataSource4Icon.gridy = 3;
		dataSources.add(dataSource4Icon, gbc_dataSource4Icon);

		JButton dataSource4 = new JButton("<html>" + dataSourcesText(dataHub));
		GridBagConstraints gbc_dataSource4 = new GridBagConstraints();
		gbc_dataSource4.fill = GridBagConstraints.BOTH;
		gbc_dataSource4.insets = new Insets(0, 0, 5, 0);
		gbc_dataSource4.gridx = 1;
		gbc_dataSource4.gridy = 3;
		dataSources.add(dataSource4, gbc_dataSource4);
		dataSource4.setToolTipText("<html>" + dataSourceToolTip(dataHub) + "<html>");
		dataSource4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataHub.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource4.setText("<html>" + dataSourcesText(dataHub));
				dataSource4.setToolTipText("<html>" + dataSourceToolTip(dataHub) + "<html>");
			}
		});

		JButton dataSource5Icon = new JButton();
		dataSource5Icon.setName("BJ");
		dataSource5Icon.setIcon(
				new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/gewinnspiel_logo_small.png")));
		GridBagConstraints gbc_dataSource5Icon = new GridBagConstraints();
		gbc_dataSource5Icon.fill = GridBagConstraints.BOTH;
		gbc_dataSource5Icon.insets = new Insets(0, 0, 5, 0);
		gbc_dataSource5Icon.gridx = 0;
		gbc_dataSource5Icon.gridy = 4;
		dataSources.add(dataSource5Icon, gbc_dataSource5Icon);
		

		JButton dataSource5 = new JButton("<html>" + dataSourcesText(dataGewinnspiele));
		GridBagConstraints gbc_dataSource5 = new GridBagConstraints();
		gbc_dataSource5.fill = GridBagConstraints.BOTH;
		gbc_dataSource5.insets = new Insets(0, 0, 5, 0);
		gbc_dataSource5.gridx = 1;
		gbc_dataSource5.gridy = 4;
		dataSources.add(dataSource5, gbc_dataSource5);
		dataSource5.setToolTipText("<html>" + dataSourceToolTip(dataGewinnspiele) + "<html>");
		dataSource5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataGewinnspiele.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource5.setText("<html>" + dataSourcesText(dataGewinnspiele));
				dataSource5.setToolTipText("<html>" + dataSourceToolTip(dataGewinnspiele) + "<html>");
			}
		});

		JButton dataSource6Icon = new JButton();
		dataSource6Icon.setName("pong");
		dataSource6Icon.setIcon(
				new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/dataScout_logo_small.png")));
		GridBagConstraints gbc_dataSource6Icon = new GridBagConstraints();
		gbc_dataSource6Icon.fill = GridBagConstraints.BOTH;
		gbc_dataSource6Icon.insets = new Insets(0, 0, 5, 0);
		gbc_dataSource6Icon.gridx = 0;
		gbc_dataSource6Icon.gridy = 5;
		dataSources.add(dataSource6Icon, gbc_dataSource6Icon);
		
		

		JButton dataSource6 = new JButton("<html>" + dataSourcesText(dataScout24));
		GridBagConstraints gbc_dataSource6 = new GridBagConstraints();
		gbc_dataSource6.fill = GridBagConstraints.BOTH;
		gbc_dataSource6.insets = new Insets(0, 0, 5, 0);
		gbc_dataSource6.gridx = 1;
		gbc_dataSource6.gridy = 5;
		dataSources.add(dataSource6, gbc_dataSource6);
		dataSource6.setToolTipText("<html>" + dataSourceToolTip(dataScout24) + "<html>");
		dataSource6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataScout24.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource6.setText("<html>" + dataSourcesText(dataScout24));
				dataSource6.setToolTipText("<html>" + dataSourceToolTip(dataScout24) + "<html>");
			}
		});

		JButton dataSource7Icon = new JButton();
		dataSource7Icon
		.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/doogle_logo_small.png")));
		GridBagConstraints gbc_dataSource7Icon = new GridBagConstraints();
		gbc_dataSource7Icon.fill = GridBagConstraints.BOTH;
		gbc_dataSource7Icon.insets = new Insets(0, 0, 5, 0);
		gbc_dataSource7Icon.gridx = 0;
		gbc_dataSource7Icon.gridy = 6;
		dataSources.add(dataSource7Icon, gbc_dataSource7Icon);

		JButton dataSource7 = new JButton("<html>" + dataSourcesText(dataSearch));
		GridBagConstraints gbc_dataSource7 = new GridBagConstraints();
		gbc_dataSource7.fill = GridBagConstraints.BOTH;
		gbc_dataSource7.insets = new Insets(0, 0, 5, 0);
		gbc_dataSource7.gridx = 1;
		gbc_dataSource7.gridy = 6;
		dataSources.add(dataSource7, gbc_dataSource7);
		dataSource7.setToolTipText("<html>" + dataSourceToolTip(dataSearch) + "<html>");
		dataSource7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataSearch.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource7.setText("<html>" + dataSourcesText(dataSearch));
				dataSource7.setToolTipText("<html>" + dataSourceToolTip(dataSearch) + "<html>");
			}
		});

		JButton dataSource8Icon = new JButton();
		dataSource8Icon.setIcon(
				new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/whatsData_logo_small.png")));
		GridBagConstraints gbc_dataSource8Icon = new GridBagConstraints();
		gbc_dataSource8Icon.fill = GridBagConstraints.BOTH;
		gbc_dataSource8Icon.insets = new Insets(0, 0, 5, 0);
		gbc_dataSource8Icon.gridx = 0;
		gbc_dataSource8Icon.gridy = 7;
		dataSources.add(dataSource8Icon, gbc_dataSource8Icon);

		JButton dataSource8 = new JButton("<html>" + dataSourcesText(whatsData));
		GridBagConstraints gbc_dataSource8 = new GridBagConstraints();
		gbc_dataSource8.fill = GridBagConstraints.BOTH;
		gbc_dataSource8.gridx = 1;
		gbc_dataSource8.gridy = 7;
		dataSources.add(dataSource8, gbc_dataSource8);
		dataSource8.setToolTipText("<html>" + dataSourceToolTip(whatsData) + "<html>");
		dataSource8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				whatsData.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource8.setText("<html>" + dataSourcesText(whatsData));
				dataSource8.setToolTipText("<html>" + dataSourceToolTip(whatsData) + "<html>");
			}
		});

		try {
		} catch (Exception ex) {
			System.out.println(ex);
		}

		JPanel dataBankPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) dataBankPanel.getLayout();
		flowLayout.setVgap(50);
		flowLayout.setHgap(50);
		frame.getContentPane().add(dataBankPanel, BorderLayout.CENTER);

		JButton dataBank = new JButton("");
		dataBank.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/DatenbankV1.png")));
		dataBank.addActionListener(new ActionListener() { // Ã¼berprÃ¼ft wann geclickt wird und was in dem Falle
			// passiert
			public void actionPerformed(ActionEvent click) {
				main.dataclicker.player.Player.dataClick(); // added die durch klicken dazugewonnene Anzahl von Daten
				playerRessources.setText(playerRessources()); // updatet das Label welches die aktuelle Anzahl an Daten
				// anzeigt

			}
		});
		dataBankPanel.add(dataBank);

		JPanel buyersPanel = new JPanel();
		frame.getContentPane().add(buyersPanel, BorderLayout.WEST);
		GridBagLayout gbl_buyersPanel = new GridBagLayout();
		gbl_buyersPanel.columnWidths = new int[] { 80, 80, 0 };
		gbl_buyersPanel.rowHeights = new int[] { 60, 60, 60, 60, 60, 60, 60, 60, 0 };
		gbl_buyersPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_buyersPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		buyersPanel.setLayout(gbl_buyersPanel);

		JButton buyer1 = new JButton(buyersText(vegtables));
		GridBagConstraints gbc_buyer1 = new GridBagConstraints();
		gbc_buyer1.fill = GridBagConstraints.BOTH;
		gbc_buyer1.insets = new Insets(0, 0, 5, 5);
		gbc_buyer1.gridx = 0;
		gbc_buyer1.gridy = 0;
		buyersPanel.add(buyer1, gbc_buyer1);
		buyer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				vegtables.buy();
				playerRessources.setText(playerRessources());
				buyer1.setText(buyersText(vegtables));
			}
		});

		JButton buyer1Icon = new JButton("");
		buyer1Icon.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/Obsthaendler_small.png")));
		GridBagConstraints gbc_buyer1Icon = new GridBagConstraints();
		gbc_buyer1Icon.insets = new Insets(0, 0, 5, 0);
		gbc_buyer1Icon.gridx = 1;
		gbc_buyer1Icon.gridy = 0;
		buyersPanel.add(buyer1Icon, gbc_buyer1Icon);

		JButton buyer2 = new JButton(buyersText(mobile));
		GridBagConstraints gbc_buyer2 = new GridBagConstraints();
		gbc_buyer2.fill = GridBagConstraints.BOTH;
		gbc_buyer2.insets = new Insets(0, 0, 5, 5);
		gbc_buyer2.gridx = 0;
		gbc_buyer2.gridy = 1;
		buyersPanel.add(buyer2, gbc_buyer2);
		buyer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				mobile.buy();
				playerRessources.setText(playerRessources());
				buyer2.setText(buyersText(mobile));
			}
		});

		JButton buyer2Icon = new JButton("");
		buyer2Icon.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/mobile_data_small.png")));
		GridBagConstraints gbc_buyer2Icon = new GridBagConstraints();
		gbc_buyer2Icon.insets = new Insets(0, 0, 5, 0);
		gbc_buyer2Icon.gridx = 1;
		gbc_buyer2Icon.gridy = 1;
		buyersPanel.add(buyer2Icon, gbc_buyer2Icon);

		JButton buyer3 = new JButton(buyersText(tech));
		GridBagConstraints gbc_buyer3 = new GridBagConstraints();
		gbc_buyer3.fill = GridBagConstraints.BOTH;
		gbc_buyer3.insets = new Insets(0, 0, 5, 5);
		gbc_buyer3.gridx = 0;
		gbc_buyer3.gridy = 2;
		buyersPanel.add(buyer3, gbc_buyer3);
		buyer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				tech.buy();
				playerRessources.setText(playerRessources());
				buyer3.setText(buyersText(tech));
			}
		});

		JButton buyer3Icon = new JButton("");
		buyer3Icon.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/Data_Tech_small.png")));
		GridBagConstraints gbc_buyer3Icon = new GridBagConstraints();
		gbc_buyer3Icon.insets = new Insets(0, 0, 5, 0);
		gbc_buyer3Icon.gridx = 1;
		gbc_buyer3Icon.gridy = 2;
		buyersPanel.add(buyer3Icon, gbc_buyer3Icon);

		JButton buyer4 = new JButton(buyersText(eSport));
		GridBagConstraints gbc_buyer4 = new GridBagConstraints();
		gbc_buyer4.fill = GridBagConstraints.BOTH;
		gbc_buyer4.insets = new Insets(0, 0, 5, 5);
		gbc_buyer4.gridx = 0;
		gbc_buyer4.gridy = 3;
		buyersPanel.add(buyer4, gbc_buyer4);
		buyer4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				eSport.buy();
				playerRessources.setText(playerRessources());
				buyer4.setText(buyersText(eSport));
			}
		});

		JButton buyer4Icon = new JButton("");
		buyer4Icon.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/data_esport_small.png")));
		GridBagConstraints gbc_buyer4Icon = new GridBagConstraints();
		gbc_buyer4Icon.insets = new Insets(0, 0, 5, 0);
		gbc_buyer4Icon.gridx = 1;
		gbc_buyer4Icon.gridy = 3;
		buyersPanel.add(buyer4Icon, gbc_buyer4Icon);

		JButton buyer5 = new JButton(buyersText(party));
		GridBagConstraints gbc_buyer5 = new GridBagConstraints();
		gbc_buyer5.fill = GridBagConstraints.BOTH;
		gbc_buyer5.insets = new Insets(0, 0, 5, 5);
		gbc_buyer5.gridx = 0;
		gbc_buyer5.gridy = 4;
		buyersPanel.add(buyer5, gbc_buyer5);
		buyer5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				party.buy();
				playerRessources.setText(playerRessources());
				buyer5.setText(buyersText(party));
			}
		});

		JButton buyer5Icon = new JButton("");
		buyer5Icon.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/Deutsche_Daten_Partei_small.png")));
		GridBagConstraints gbc_buyer5Icon = new GridBagConstraints();
		gbc_buyer5Icon.insets = new Insets(0, 0, 5, 0);
		gbc_buyer5Icon.gridx = 1;
		gbc_buyer5Icon.gridy = 4;
		buyersPanel.add(buyer5Icon, gbc_buyer5Icon);

		JButton buyer6 = new JButton(buyersText(nsa));
		GridBagConstraints gbc_buyer6 = new GridBagConstraints();
		gbc_buyer6.fill = GridBagConstraints.BOTH;
		gbc_buyer6.insets = new Insets(0, 0, 5, 5);
		gbc_buyer6.gridx = 0;
		gbc_buyer6.gridy = 5;
		buyersPanel.add(buyer6, gbc_buyer6);
		buyer6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				nsa.buy();
				playerRessources.setText(playerRessources());
				buyer6.setText(buyersText(nsa));
			}
		});

		JButton buyer6Icon = new JButton("");
		buyer6Icon.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/NSA_small.png")));
		GridBagConstraints gbc_buyer6Icon = new GridBagConstraints();
		gbc_buyer6Icon.insets = new Insets(0, 0, 5, 0);
		gbc_buyer6Icon.gridx = 1;
		gbc_buyer6Icon.gridy = 5;
		buyersPanel.add(buyer6Icon, gbc_buyer6Icon);

		JButton buyer7 = new JButton(buyersText(krake));
		GridBagConstraints gbc_buyer7 = new GridBagConstraints();
		gbc_buyer7.fill = GridBagConstraints.BOTH;
		gbc_buyer7.insets = new Insets(0, 0, 5, 5);
		gbc_buyer7.gridx = 0;
		gbc_buyer7.gridy = 6;
		buyersPanel.add(buyer7, gbc_buyer7);
		buyer7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				krake.buy();
				playerRessources.setText(playerRessources());
				buyer7.setText(buyersText(krake));
			}
		});

		JButton buyer7Icon = new JButton("");
		buyer7Icon.setName("Snake");
		buyer7Icon.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/data_krake_small.png")));
		GridBagConstraints gbc_buyer7Icon = new GridBagConstraints();
		gbc_buyer7Icon.insets = new Insets(0, 0, 5, 0);
		gbc_buyer7Icon.gridx = 1;
		gbc_buyer7Icon.gridy = 6;
		buyersPanel.add(buyer7Icon, gbc_buyer7Icon);

		JButton buyer8 = new JButton(buyersText(drump));
		GridBagConstraints gbc_buyer8 = new GridBagConstraints();
		gbc_buyer8.insets = new Insets(0, 0, 0, 5);
		gbc_buyer8.fill = GridBagConstraints.BOTH;
		gbc_buyer8.gridx = 0;
		gbc_buyer8.gridy = 7;
		buyersPanel.add(buyer8, gbc_buyer8);

		JButton buyer8Icon = new JButton("");
		buyer8Icon.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/tonald_drump_small.png")));
		GridBagConstraints gbc_buyer8Icon = new GridBagConstraints();
		gbc_buyer8Icon.gridx = 1;
		gbc_buyer8Icon.gridy = 7;
		buyersPanel.add(buyer8Icon, gbc_buyer8Icon);
		buyer8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
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

		JButton upgrade1 = new JButton(upgradesText(zuchtBot));
		upgradesPanel.add(upgrade1);
		upgrade1.setToolTipText("<html>" + upgradesToolTip(zuchtBot, dataFarm));
		upgrade1.setVisible(false);
		upgrade1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if(zuchtBot.purchaseUpgrade()) {
					playerRessources.setText(playerRessources());
					dataSource1.setText("<html>" + dataSourcesText(dataFarm));
					upgradesPanel.remove(upgrade1); // der button wird removed, da man Upgrades nur 1 mal erwerben kann
				}
			}
		});

		JButton upgrade2 = new JButton(upgradesText(datenFutter));
		upgradesPanel.add(upgrade2);
		upgrade2.setToolTipText("<html>" + upgradesToolTip(datenFutter, dataFarm));
		upgrade2.setVisible(false);
		upgrade2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if(datenFutter.purchaseUpgrade()) {
					playerRessources.setText(playerRessources());
					dataSource1.setText("<html>" + dataSourcesText(dataFarm)); // double rewrite??
					upgradesPanel.remove(upgrade2);
				}
			}
		});

		JButton upgrade3 = new JButton(upgradesText(miniGames));
		upgradesPanel.add(upgrade3);
		upgrade3.setToolTipText("<html>" + upgradesToolTip(miniGames, dataBook));
		upgrade3.setVisible(false);
		upgrade3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if(datenFutter.purchaseUpgrade()) {
					playerRessources.setText(playerRessources());
					dataSource2.setText("<html>" + dataSourcesText(dataBook));
					upgradesPanel.remove(upgrade3);
				}
			}
		});

		JButton upgrade4 = new JButton(upgradesText(gruppenInDeinerNaehe));
		upgradesPanel.add(upgrade4);
		upgrade4.setToolTipText("<html>" + upgradesToolTip(gruppenInDeinerNaehe, dataBook));
		upgrade4.setVisible(false);
		upgrade4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if(gruppenInDeinerNaehe.purchaseUpgrade()) {
					playerRessources.setText(playerRessources());
					dataSource2.setText("<html>" + dataSourcesText(dataBook));
					upgradesPanel.remove(upgrade4);
				}
			}
		});

		JButton upgrade5 = new JButton(upgradesText(karperbrief));
		upgradesPanel.add(upgrade5);
		upgrade5.setToolTipText("<html>" + upgradesToolTip(karperbrief, dataPirate));
		upgrade5.setVisible(false);
		upgrade5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if(karperbrief.purchaseUpgrade()) {
					playerRessources.setText(playerRessources());
					dataSource3.setText("<html>" + dataSourcesText(dataPirate));
					upgradesPanel.remove(upgrade5);
				}
			}
		});

		JButton upgrade6 = new JButton(upgradesText(einNeuesSchiff));
		upgradesPanel.add(upgrade6);
		upgrade6.setToolTipText("<html>" + upgradesToolTip(einNeuesSchiff, dataPirate));
		upgrade6.setVisible(false);
		upgrade6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if(einNeuesSchiff.purchaseUpgrade()) {
					playerRessources.setText(playerRessources());
					dataSource3.setText("<html>" + dataSourcesText(dataPirate));
					upgradesPanel.remove(upgrade6);
				}
			}
		});
		JButton upgrade7 = new JButton(upgradesText(einNeuerMarktplatz));
		upgradesPanel.add(upgrade7);
		upgrade7.setVisible(false);
		upgrade7.setToolTipText("<html>" + upgradesToolTip(einNeuerMarktplatz, dataHub));
		upgrade7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if(einNeuerMarktplatz.purchaseUpgrade()) {
					playerRessources.setText(playerRessources());
					dataSource4.setText("<html>" + dataSourcesText(dataHub));
					upgradesPanel.remove(upgrade7);
				}
			}
		});

		JButton upgrade8 = new JButton(upgradesText(twoWayLiveChat));
		upgradesPanel.add(upgrade8);
		upgrade8.setToolTipText("<html>" + upgradesToolTip(twoWayLiveChat, dataHub));
		upgrade8.setVisible(false);
		upgrade8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if(twoWayLiveChat.purchaseUpgrade()) {
					playerRessources.setText(playerRessources());
					dataSource4.setText("<html>" + dataSourcesText(dataHub));
					upgradesPanel.remove(upgrade8);
				}
			}
		});
		JButton upgrade9 = new JButton(upgradesText(offlineEinbindung));
		upgradesPanel.add(upgrade9);
		upgrade9.setToolTipText("<html>" + upgradesToolTip(offlineEinbindung, dataGewinnspiele));
		upgrade9.setVisible(false);
		upgrade9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if(offlineEinbindung.purchaseUpgrade()) {
					playerRessources.setText(playerRessources());
					dataSource5.setText("<html>" + dataSourcesText(dataGewinnspiele));
					upgradesPanel.remove(upgrade9);
				}
			}
		});
		JButton upgrade10 = new JButton(upgradesText(waehlDeineBelohnung));
		upgradesPanel.add(upgrade10);
		upgrade10.setToolTipText("<html>" + upgradesToolTip(waehlDeineBelohnung, dataGewinnspiele));
		upgrade10.setVisible(false);
		upgrade10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if(waehlDeineBelohnung.purchaseUpgrade()) {
					playerRessources.setText(playerRessources());
					dataSource5.setText("<html>" + dataSourcesText(dataGewinnspiele));
					upgradesPanel.remove(upgrade10);
				}
			}
		});
		JButton upgrade11 = new JButton(upgradesText(callCenterSupport));
		upgradesPanel.add(upgrade11);
		upgrade11.setToolTipText("<html>" + upgradesToolTip(callCenterSupport, dataScout24));
		upgrade11.setVisible(false);
		upgrade10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if(callCenterSupport.purchaseUpgrade()) {
					playerRessources.setText(playerRessources());
					dataSource6.setText("<html>" + dataSourcesText(dataScout24));
					upgradesPanel.remove(upgrade11);
				}
			}
		});
		JButton upgrade12 = new JButton(upgradesText(onlineAusfuellformular));
		upgradesPanel.add(upgrade12);
		upgrade12.setToolTipText("<html>" + upgradesToolTip(onlineAusfuellformular, dataScout24));
		upgrade12.setVisible(false);
		upgrade12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if(onlineAusfuellformular.purchaseUpgrade()) {
					playerRessources.setText(playerRessources());
					dataSource6.setText("<html>" + dataSourcesText(dataScout24));
					upgradesPanel.remove(upgrade12);
				}
			}
		});
		JButton upgrade13 = new JButton(upgradesText(statusModul));
		upgradesPanel.add(upgrade13);
		upgrade13.setToolTipText("<html>" + upgradesToolTip(statusModul, whatsData));
		upgrade13.setVisible(false);
		upgrade13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if(statusModul.purchaseUpgrade()) {
					playerRessources.setText(playerRessources());
					dataSource7.setText("<html>" + dataSourcesText(whatsData));
					upgradesPanel.remove(upgrade13);
				}
			}
		});
		JButton upgrade14 = new JButton(upgradesText(faceScanner));
		upgradesPanel.add(upgrade14);
		upgrade14.setToolTipText("<html>" + upgradesToolTip(faceScanner, whatsData));
		upgrade14.setVisible(false);
		upgrade14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if(faceScanner.purchaseUpgrade()) {
					playerRessources.setText(playerRessources());
					dataSource7.setText("<html>" + dataSourcesText(whatsData));
					upgradesPanel.remove(upgrade14);
				}
			}
		});
		JButton upgrade15 = new JButton(upgradesText(personalisierteSuche));
		upgradesPanel.add(upgrade15);
		upgrade15.setVisible(false);
		upgrade15.setToolTipText("<html>" + upgradesToolTip(personalisierteSuche, dataSearch));
		upgrade15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if(personalisierteSuche.purchaseUpgrade()) {
					playerRessources.setText(playerRessources());
					dataSource8.setText("<html>" + dataSourcesText(dataSearch));
					upgradesPanel.remove(upgrade15);
				}
			}
		});
		JButton upgrade16 = new JButton(upgradesText(werbung));
		upgradesPanel.add(upgrade16);
		upgrade16.setToolTipText("<html>" + upgradesToolTip(werbung, dataSearch));
		upgrade16.setVisible(false);
		upgrade16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if(werbung.purchaseUpgrade()) {
					playerRessources.setText(playerRessources());
					dataSource8.setText("<html>" + dataSourcesText(dataSearch));
					upgradesPanel.remove(upgrade16);
				}
			}
		});
		
		JButton upgradeSweeper = new JButton(upgradesText(minigameDataSweeper));
		upgradeSweeper.setName("Sweeper");
		upgradesPanel.add(upgradeSweeper);
		upgradeSweeper.setToolTipText(minigameDataSweeper.getUpgradeDescription());
		upgradeSweeper.setVisible(false);
		upgradeSweeper.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(minigameDataSweeper.purchaseMGUpgrade(dataSource3Icon)) {
					playerRessources.setText(playerRessources());
					upgradesPanel.remove(upgradeSweeper);
				}
			}
			
		});
		
		JButton upgradeBlackJack = new JButton(upgradesText(minigameDataJack));
		upgradeBlackJack.setName("BJ");
		upgradesPanel.add(upgradeBlackJack);
		upgradeBlackJack.setToolTipText(minigameDataJack.getUpgradeDescription());
		upgradeBlackJack.setVisible(false);
		upgradeBlackJack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(minigameDataJack.purchaseMGUpgrade(dataSource5Icon)) {
					playerRessources.setText(playerRessources());
					upgradesPanel.remove(upgradeBlackJack);
				}
			}
			
		});
		
		JButton upgradePong = new JButton(upgradesText(minigameDataPong));
		upgradePong.setName("Pong");
		upgradesPanel.add(upgradePong);
		upgradePong.setToolTipText(minigameDataPong.getUpgradeDescription());
		upgradePong.setVisible(false);
		upgradePong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(minigameDataSweeper.purchaseMGUpgrade(dataSource6Icon)) {
					playerRessources.setText(playerRessources());
					upgradesPanel.remove(upgradePong);
				}
			}
			
		});
		
		JButton upgradeSnake = new JButton(upgradesText(minigameDataSnake));
		upgradeSnake.setName("Snake");
		upgradesPanel.add(upgradeSnake);
		upgradeSnake.setToolTipText(minigameDataSnake.getUpgradeDescription());
		upgradeSnake.setVisible(false);
		upgradeSnake.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(minigameDataSweeper.purchaseMGUpgrade(buyer7Icon)) {
					playerRessources.setText(playerRessources());
					upgradesPanel.remove(upgradeSnake);
				}
			}
			
		});

		Timer everySecond = new Timer(); // erstellt einen Timer der jede Sekunde eine Aufgabe vollfï¿½hrt
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

	/*	Timer dataSourceVisibility = new Timer();
		dataSourceVisibility.schedule(new TimerTask() {
			public void run() {
				dataBook.toggleVisibility(dataSource2);
				dataBook.toggleVisibility(dataSource2Icon);
				dataPirate.toggleVisibility(dataSource3);
				dataPirate.toggleVisibility(dataSource3Icon);
				dataHub.toggleVisibility(dataSource4);
				dataHub.toggleVisibility(dataSource4Icon);
				dataGewinnspiele.toggleVisibility(dataSource5);
				dataGewinnspiele.toggleVisibility(dataSource5Icon);
				dataScout24.toggleVisibility(dataSource6);
				dataScout24.toggleVisibility(dataSource6Icon);
				dataSearch.toggleVisibility(dataSource7);
				dataSearch.toggleVisibility(dataSource7Icon);
				whatsData.toggleVisibility(dataSource8);
				whatsData.toggleVisibility(dataSource8Icon);
			}
		}, 0, 1000);
*/
		Timer buyerVisibility = new Timer();
		buyerVisibility.schedule(new TimerTask() {
			public void run() {
				vegtables.toggleVisibility(buyer1);
				mobile.toggleVisibility(buyer2);
				tech.toggleVisibility(buyer3);
				eSport.toggleVisibility(buyer4);
				party.toggleVisibility(buyer5);
				nsa.toggleVisibility(buyer6);
				krake.toggleVisibility(buyer7);
				drump.toggleVisibility(buyer8);
				vegtables.toggleVisibility(buyer1Icon);
				mobile.toggleVisibility(buyer2Icon);
				tech.toggleVisibility(buyer3Icon);
				eSport.toggleVisibility(buyer4Icon);
				party.toggleVisibility(buyer5Icon);
				nsa.toggleVisibility(buyer6Icon);
				krake.toggleVisibility(buyer7Icon);
				drump.toggleVisibility(buyer8Icon);
			}
		}, 0, 1000);

		Timer upgradeVisibility = new Timer();
		upgradeVisibility.schedule(new TimerTask() {
			public void run() {
				zuchtBot.checkUpgrade(5, upgrade1);
				datenFutter.checkUpgrade(15, upgrade2);
				miniGames.checkUpgrade(7, upgrade3);
				gruppenInDeinerNaehe.checkUpgrade(20, upgrade4);
				karperbrief.checkUpgrade(9, upgrade5);
				einNeuesSchiff.checkUpgrade(25, upgrade6);
				einNeuerMarktplatz.checkUpgrade(11, upgrade7);
				twoWayLiveChat.checkUpgrade(35, upgrade8);
				offlineEinbindung.checkUpgrade(15, upgrade9);
				waehlDeineBelohnung.checkUpgrade(40, upgrade10);
				callCenterSupport.checkUpgrade(17, upgrade11);
				onlineAusfuellformular.checkUpgrade(50, upgrade12);
				personalisierteSuche.checkUpgrade(20, upgrade13);
				werbung.checkUpgrade(55, upgrade14);
				statusModul.checkUpgrade(22, upgrade15);
				faceScanner.checkUpgrade(75, upgrade16);
				minigameDataSweeper.checkMGUpgrade(upgradeSweeper);
				minigameDataJack.checkMGUpgrade(upgradeBlackJack);
				minigameDataSnake.checkMGUpgrade(upgradeSnake);
				minigameDataPong.checkMGUpgrade(upgradePong);

			}
		}, 0, 1000);

	}

}