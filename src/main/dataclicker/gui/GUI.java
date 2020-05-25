package main.dataclicker.gui;

import main.dataclicker.minigames.dataSnake.graphics.Assets;
import main.dataclicker.minigames.dataSnake.gui.Game;
import main.dataclicker.upgrades.Upgrades_Template;
<<<<<<< Updated upstream
=======
//import main.dataclicker.minigames.dataSweeper.*;
>>>>>>> Stashed changes

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

	public String upgradesText(Upgrades_Template upgrade, DataSource_Template datasource) {
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
		vegtables = new Buyers_Template("Obst und Daten", 10, 50);
		mobile = new Buyers_Template("Mobile-Data", 50, 200);
		tech = new Buyers_Template("Data Tech", 1000, 250);
		eSport = new Buyers_Template("Data eSport", 2000, 750);
		party = new Buyers_Template("deutsche Daten Partei", 5555, 1337);
		nsa = new Buyers_Template("NSA", 10000, 2000);
		krake = new Buyers_Template("Daten-Krake", 100000, 10000);
		drump = new Buyers_Template("Tonald Drump", 1000000, 0);

		// Datasources
		dataFarm = new DataSource_Template("Daten-Farm", "Qualitaetsdaten aus Freilandhaltung", 1, 10, 1.15, 0);
		dataBook = new DataSource_Template("Daten-Buch", "", 10, 50, 1.20, 100);
		dataPirate = new DataSource_Template("Daten-Pirat", "", 15, 100, 1.40, 300);
		dataHub = new DataSource_Template("Daten-Hub", "", 30, 150, 1.80, 550);
		dataGewinnspiele = new DataSource_Template("Daten-Gewinnspiele", "", 40, 200, 2.0, 850);
		dataScout24 = new DataSource_Template("Daten-Scout24", "", 50, 250, 2.25, 1300);
		dataSearch = new DataSource_Template("Daten-Suche", "", 55, 300, 2.50, 18000);
		whatsData = new DataSource_Template("Whats-Data", "", 60, 500, 3.0, 24000);

		// upgrades
		zuchtBot = new Upgrades_Template("Zucht-Bot",
				"Zieht die Daten vom klein auf an und macht diese Loyal wie keine anderen", 20, 2, dataFarm);
		datenFutter = new Upgrades_Template("Daten-Futter",
				"Fï¿½ttere deine Daten-Sprï¿½ï¿½linge hiermit und sie werden im Eiltempo zu inkriminierenden Datenpaketen",
				100, 4, dataFarm);
		miniGames = new Upgrades_Template("Mini Games",
				"Fï¿½ttere deine Daten-Sprï¿½ï¿½linge hiermit und sie werden im Eiltempo zu inkriminierenden Datenpaketen",
				100, 2, dataBook);
		gruppenInDeinerNaehe = new Upgrades_Template("Gruppen-In-Deiner-Nï¿½he",
				"Wir erstellen gruppen in grï¿½ï¿½eren Stï¿½dten und die Benutzer melden sich bei denen und zeigen uns was Sie gerne offline machen wie z.B. Yoga oder Rollenspielen]",
				500, 4, dataBook);
		karperbrief = new Upgrades_Template("Karperbrief",
				"Verschaff deinem Piraten exclusiven zutritt zu legalen gewï¿½ssern", 200, 2, dataPirate);
		einNeuesSchiff = new Upgrades_Template("Ein neues Schiff",
				"Auch ein online Pirat profitiert von einem neuen Schiff (PC) mit welchem er gefï¿½hrlichere Gewï¿½sser besser und schneller erreichen kann",
				1000, 4, dataPirate);
		einNeuerMarktplatz = new Upgrades_Template("Ein neuer Marktplatz",
				"Verschï¿½nere dein Datenhub mit einer schï¿½neren Frontseite", 300, 2, dataHub);
		twoWayLiveChat = new Upgrades_Template("Two way Livechat",
				"woher sollen die denn wissen das wir auch ihre Live-Chat seite aufzeichnen", 1200, 4, dataHub);
		offlineEinbindung = new Upgrades_Template("Offline Einbindung",
				"Lass die spieler richtig mitfiebern und gib ihnen die mï¿½glichkeit sich per Post mit rï¿½cksende beleg zu bewerben",
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
		fl_playerRessourcesPanel.setVgap(50);
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

		JButton dataFarmIcon = new JButton();
		dataFarmIcon.setIcon(
				new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/dataFarm_logo_small.png")));
		GridBagConstraints gbc_dataFarm1Icon = new GridBagConstraints();
		gbc_dataFarm1Icon.fill = GridBagConstraints.BOTH;
		gbc_dataFarm1Icon.insets = new Insets(0, 0, 5, 0);
		gbc_dataFarm1Icon.gridx = 0;
		gbc_dataFarm1Icon.gridy = 0;
		dataSources.add(dataFarmIcon, gbc_dataFarm1Icon);

		JButton dataFarmButton = new JButton("<html>" + dataSourcesText(dataFarm));
		GridBagConstraints gbc_dataFarmButton = new GridBagConstraints();
		gbc_dataFarmButton.fill = GridBagConstraints.BOTH;
		gbc_dataFarmButton.insets = new Insets(0, 0, 5, 0);
		gbc_dataFarmButton.gridx = 1;
		gbc_dataFarmButton.gridy = 0;
		dataSources.add(dataFarmButton, gbc_dataFarmButton);
		dataFarmButton.setToolTipText("<html>" + dataSourceToolTip(dataFarm) + "<html>");
		dataFarmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataFarm.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataFarmButton.setText("<html>" + dataSourcesText(dataFarm));
				dataFarmButton.setToolTipText("<html>" + dataSourceToolTip(dataFarm) + "/<html>");
			}
		});

		JButton dataBookIcon = new JButton();
		dataBookIcon.setIcon(
				new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/databook_logo_small.png")));
		GridBagConstraints gbc_dataBookIcon = new GridBagConstraints();
		gbc_dataBookIcon.fill = GridBagConstraints.BOTH;
		gbc_dataBookIcon.insets = new Insets(0, 0, 5, 0);
		gbc_dataBookIcon.gridx = 0;
		gbc_dataBookIcon.gridy = 1;
		dataSources.add(dataBookIcon, gbc_dataBookIcon);

		JButton dataBookButton = new JButton("<html>" + dataSourcesText(dataBook));
		GridBagConstraints gbc_dataBookButton = new GridBagConstraints();
		gbc_dataBookButton.fill = GridBagConstraints.BOTH;
		gbc_dataBookButton.insets = new Insets(0, 0, 5, 0);
		gbc_dataBookButton.gridx = 1;
		gbc_dataBookButton.gridy = 1;
		dataSources.add(dataBookButton, gbc_dataBookButton);
		dataBookButton.setToolTipText("<html>" + dataSourceToolTip(dataBook) + "<html>");

		dataBookButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataBook.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataBookButton.setText("<html>" + dataSourcesText(dataBook));
				dataBookButton.setToolTipText("<html>" + dataSourceToolTip(dataBook) + "<html>");
			}
		});

		JButton dataPirateIcon = new JButton();
		dataPirateIcon.setIcon(
				new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/dataPirate_logo_small.png")));
		GridBagConstraints gbc_dataPirateIcon = new GridBagConstraints();
		gbc_dataPirateIcon.fill = GridBagConstraints.BOTH;
		gbc_dataPirateIcon.insets = new Insets(0, 0, 5, 0);
		gbc_dataPirateIcon.gridx = 0;
		gbc_dataPirateIcon.gridy = 2;
		dataSources.add(dataPirateIcon, gbc_dataPirateIcon);
		dataPirateIcon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
<<<<<<< HEAD
<<<<<<< Updated upstream
<<<<<<< HEAD
				main.dataclicker.minigames.dataSweeper.SweeperGUI.sweeperInitialize();
				//Game dataSnake = new Game("DataSnake", 800, 800);
				//dataSnake.start();
=======
				SweeperGUI sweeper = new main.dataclicker.minigames.dataSweeper.SweeperGUI();
				sweeper.sweeperInitialize();
>>>>>>> master
=======
			//	main.dataclicker.minigames.dataSweeper.SweeperGUI.createSweeper();
>>>>>>> Stashed changes
			}
		});

		JButton dataSource3 = new JButton("<html>" + dataSourcesText(dataPirate));
		GridBagConstraints gbc_dataSource3 = new GridBagConstraints();
		gbc_dataSource3.fill = GridBagConstraints.BOTH;
		gbc_dataSource3.insets = new Insets(0, 0, 5, 0);
		gbc_dataSource3.gridx = 1;
		gbc_dataSource3.gridy = 2;
		dataSources.add(dataSource3, gbc_dataSource3);
		dataSource3.setToolTipText("<html>" + dataSourceToolTip(dataPirate) + "<html>");
		dataSource3.addActionListener(new ActionListener() {
=======
				Game dataSnake = new Game("DataSnake", 800, 800);
				dataSnake.start();
				//SweeperGUI sweeper = new main.dataclicker.minigames.dataSweeper.SweeperGUI();
				//sweeper.sweeperInitialize();
			}
		});

		JButton dataPirateButton = new JButton("<html>" + dataSourcesText(dataPirate));
		GridBagConstraints gbc_dataPirateButton = new GridBagConstraints();
		gbc_dataPirateButton.fill = GridBagConstraints.BOTH;
		gbc_dataPirateButton.insets = new Insets(0, 0, 5, 0);
		gbc_dataPirateButton.gridx = 1;
		gbc_dataPirateButton.gridy = 2;
		dataSources.add(dataPirateButton, gbc_dataPirateButton);
		dataPirateButton.setToolTipText("<html>" + dataSourceToolTip(dataPirate) + "<html>");
		dataPirateButton.addActionListener(new ActionListener() {
>>>>>>> master
			@Override
			public void actionPerformed(ActionEvent click) {
				dataPirate.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataPirateButton.setText("<html>" + dataSourcesText(dataPirate));
				dataPirateButton.setToolTipText("<html>" + dataSourceToolTip(dataPirate) + "<html>");
			}
		});
		JButton dataHubIcon = new JButton();
		dataHubIcon
				.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/dataHub_logo_small.png")));
		GridBagConstraints gbc_dataHubIcon = new GridBagConstraints();
		gbc_dataHubIcon.fill = GridBagConstraints.BOTH;
		gbc_dataHubIcon.insets = new Insets(0, 0, 5, 0);
		gbc_dataHubIcon.gridx = 0;
		gbc_dataHubIcon.gridy = 3;
		dataSources.add(dataHubIcon, gbc_dataHubIcon);

		JButton dataHubButton = new JButton("<html>" + dataSourcesText(dataHub));
		GridBagConstraints gbc_dataHubButton = new GridBagConstraints();
		gbc_dataHubButton.fill = GridBagConstraints.BOTH;
		gbc_dataHubButton.insets = new Insets(0, 0, 5, 0);
		gbc_dataHubButton.gridx = 1;
		gbc_dataHubButton.gridy = 3;
		dataSources.add(dataHubButton, gbc_dataHubButton);
		dataHubButton.setToolTipText("<html>" + dataSourceToolTip(dataHub) + "<html>");
		dataHubButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataHub.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataHubButton.setText("<html>" + dataSourcesText(dataHub));
				dataHubButton.setToolTipText("<html>" + dataSourceToolTip(dataHub) + "<html>");
			}
		});

		JButton dataGewinnspieleIcon = new JButton();
		dataGewinnspieleIcon.setIcon(
				new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/gewinnspiel_logo_small.png")));
		GridBagConstraints gbc_dataGewinnspieleIcon = new GridBagConstraints();
		gbc_dataGewinnspieleIcon.fill = GridBagConstraints.BOTH;
		gbc_dataGewinnspieleIcon.insets = new Insets(0, 0, 5, 0);
		gbc_dataGewinnspieleIcon.gridx = 0;
		gbc_dataGewinnspieleIcon.gridy = 4;
		dataSources.add(dataGewinnspieleIcon, gbc_dataGewinnspieleIcon);

		JButton dataGewinnspieleButton = new JButton("<html>" + dataSourcesText(dataGewinnspiele));
		GridBagConstraints gbc_dataGewinnspieleButton = new GridBagConstraints();
		gbc_dataGewinnspieleButton.fill = GridBagConstraints.BOTH;
		gbc_dataGewinnspieleButton.insets = new Insets(0, 0, 5, 0);
		gbc_dataGewinnspieleButton.gridx = 1;
		gbc_dataGewinnspieleButton.gridy = 4;
		dataSources.add(dataGewinnspieleButton, gbc_dataGewinnspieleButton);
		dataGewinnspieleButton.setToolTipText("<html>" + dataSourceToolTip(dataGewinnspiele) + "<html>");
		dataGewinnspieleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataGewinnspiele.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataGewinnspieleButton.setText("<html>" + dataSourcesText(dataGewinnspiele));
				dataGewinnspieleButton.setToolTipText("<html>" + dataSourceToolTip(dataGewinnspiele) + "<html>");
			}
		});

		JButton dataScoutIcon = new JButton();
		dataScoutIcon.setIcon(
				new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/dataScout_logo_small.png")));
		GridBagConstraints gbc_dataScoutIcon = new GridBagConstraints();
		gbc_dataScoutIcon.fill = GridBagConstraints.BOTH;
		gbc_dataScoutIcon.insets = new Insets(0, 0, 5, 0);
		gbc_dataScoutIcon.gridx = 0;
		gbc_dataScoutIcon.gridy = 5;
		dataSources.add(dataScoutIcon, gbc_dataScoutIcon);

		JButton dataScoutButton = new JButton("<html>" + dataSourcesText(dataScout24));
		GridBagConstraints gbc_dataScoutButton = new GridBagConstraints();
		gbc_dataScoutButton.fill = GridBagConstraints.BOTH;
		gbc_dataScoutButton.insets = new Insets(0, 0, 5, 0);
		gbc_dataScoutButton.gridx = 1;
		gbc_dataScoutButton.gridy = 5;
		dataSources.add(dataScoutButton, gbc_dataScoutButton);
		dataScoutButton.setToolTipText("<html>" + dataSourceToolTip(dataScout24) + "<html>");
		dataScoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataScout24.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataScoutButton.setText("<html>" + dataSourcesText(dataScout24));
				dataScoutButton.setToolTipText("<html>" + dataSourceToolTip(dataScout24) + "<html>");
			}
		});

		JButton dataSearchIcon = new JButton();
		dataSearchIcon
				.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/doogle_logo_small.png")));
		GridBagConstraints gbc_dataSearchIcon = new GridBagConstraints();
		gbc_dataSearchIcon.fill = GridBagConstraints.BOTH;
		gbc_dataSearchIcon.insets = new Insets(0, 0, 5, 0);
		gbc_dataSearchIcon.gridx = 0;
		gbc_dataSearchIcon.gridy = 6;
		dataSources.add(dataSearchIcon, gbc_dataSearchIcon);

		JButton dataSearchButton = new JButton("<html>" + dataSourcesText(dataSearch));
		GridBagConstraints gbc_dataSearchButton = new GridBagConstraints();
		gbc_dataSearchButton.fill = GridBagConstraints.BOTH;
		gbc_dataSearchButton.insets = new Insets(0, 0, 5, 0);
		gbc_dataSearchButton.gridx = 1;
		gbc_dataSearchButton.gridy = 6;
		dataSources.add(dataSearchButton, gbc_dataSearchButton);
		dataSearchButton.setToolTipText("<html>" + dataSourceToolTip(dataSearch) + "<html>");
		dataSearchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataSearch.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSearchButton.setText("<html>" + dataSourcesText(dataSearch));
				dataSearchButton.setToolTipText("<html>" + dataSourceToolTip(dataSearch) + "<html>");
			}
		});

		JButton whatsDataIcon = new JButton();
		whatsDataIcon.setIcon(
				new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/whatsData_logo_small.png")));
		GridBagConstraints gbc_whatsDataIcon = new GridBagConstraints();
		gbc_whatsDataIcon.fill = GridBagConstraints.BOTH;
		gbc_whatsDataIcon.insets = new Insets(0, 0, 5, 0);
		gbc_whatsDataIcon.gridx = 0;
		gbc_whatsDataIcon.gridy = 7;
		dataSources.add(whatsDataIcon, gbc_whatsDataIcon);

		JButton whatsDataButton = new JButton("<html>" + dataSourcesText(whatsData));
		GridBagConstraints gbc_whatsDataButton = new GridBagConstraints();
		gbc_whatsDataButton.fill = GridBagConstraints.BOTH;
		gbc_whatsDataButton.gridx = 1;
		gbc_whatsDataButton.gridy = 7;
		dataSources.add(whatsDataButton, gbc_whatsDataButton);
		whatsDataButton.setToolTipText("<html>" + dataSourceToolTip(whatsData) + "<html>");
		whatsDataButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				whatsData.purchaseDataSource();
				playerRessources.setText(playerRessources());
				whatsDataButton.setText("<html>" + dataSourcesText(whatsData));
				whatsDataButton.setToolTipText("<html>" + dataSourceToolTip(whatsData) + "<html>");
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
		dataBank.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/databank_icon.png")));
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

		JButton vegetableButton = new JButton(buyersText(vegtables));
		GridBagConstraints gbc_vegetableButton = new GridBagConstraints();
		gbc_vegetableButton.fill = GridBagConstraints.BOTH;
		gbc_vegetableButton.insets = new Insets(0, 0, 5, 5);
		gbc_vegetableButton.gridx = 0;
		gbc_vegetableButton.gridy = 0;
		buyersPanel.add(vegetableButton, gbc_vegetableButton);
		vegetableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				vegtables.buy();
				playerRessources.setText(playerRessources());
				vegetableButton.setText(buyersText(vegtables));
			}
		});

		JButton vegetableIcon = new JButton("");
		vegetableIcon.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/data_krake_small.png")));
		GridBagConstraints gbc_vegetableIcon = new GridBagConstraints();
		gbc_vegetableIcon.insets = new Insets(0, 0, 5, 0);
		gbc_vegetableIcon.gridx = 1;
		gbc_vegetableIcon.gridy = 0;
		buyersPanel.add(vegetableIcon, gbc_vegetableIcon);

		JButton buyerMobile = new JButton(buyersText(mobile));
		GridBagConstraints gbc_buyerMobile = new GridBagConstraints();
		gbc_buyerMobile.fill = GridBagConstraints.BOTH;
		gbc_buyerMobile.insets = new Insets(0, 0, 5, 5);
		gbc_buyerMobile.gridx = 0;
		gbc_buyerMobile.gridy = 1;
		buyersPanel.add(buyerMobile, gbc_buyerMobile);
		buyerMobile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				mobile.buy();
				playerRessources.setText(playerRessources());
				buyerMobile.setText(buyersText(mobile));
			}
		});

		JButton buyerMobileIcon = new JButton("");
		buyerMobileIcon.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/data_krake_small.png")));
		GridBagConstraints gbc_buyer2Icon = new GridBagConstraints();
		gbc_buyer2Icon.insets = new Insets(0, 0, 5, 0);
		gbc_buyer2Icon.gridx = 1;
		gbc_buyer2Icon.gridy = 1;
		buyersPanel.add(buyerMobileIcon, gbc_buyer2Icon);

		JButton buyerTech = new JButton(buyersText(tech));
		GridBagConstraints gbc_buyer3 = new GridBagConstraints();
		gbc_buyer3.fill = GridBagConstraints.BOTH;
		gbc_buyer3.insets = new Insets(0, 0, 5, 5);
		gbc_buyer3.gridx = 0;
		gbc_buyer3.gridy = 2;
		buyersPanel.add(buyerTech, gbc_buyer3);
		buyerTech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				tech.buy();
				playerRessources.setText(playerRessources());
				buyerTech.setText(buyersText(tech));
			}
		});

		JButton buyerTechIcon = new JButton("");
		buyerTechIcon.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/data_krake_small.png")));
		GridBagConstraints gbc_buyer3Icon = new GridBagConstraints();
		gbc_buyer3Icon.insets = new Insets(0, 0, 5, 0);
		gbc_buyer3Icon.gridx = 1;
		gbc_buyer3Icon.gridy = 2;
		buyersPanel.add(buyerTechIcon, gbc_buyer3Icon);

		JButton buyerESport = new JButton(buyersText(eSport));
		GridBagConstraints gbc_buyer4 = new GridBagConstraints();
		gbc_buyer4.fill = GridBagConstraints.BOTH;
		gbc_buyer4.insets = new Insets(0, 0, 5, 5);
		gbc_buyer4.gridx = 0;
		gbc_buyer4.gridy = 3;
		buyersPanel.add(buyerESport, gbc_buyer4);
		buyerESport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				eSport.buy();
				playerRessources.setText(playerRessources());
				buyerESport.setText(buyersText(eSport));
			}
		});

		JButton buyerESportIcon = new JButton("");
		buyerESportIcon.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/data_krake_small.png")));
		GridBagConstraints gbc_buyer4Icon = new GridBagConstraints();
		gbc_buyer4Icon.insets = new Insets(0, 0, 5, 0);
		gbc_buyer4Icon.gridx = 1;
		gbc_buyer4Icon.gridy = 3;
		buyersPanel.add(buyerESportIcon, gbc_buyer4Icon);

		JButton buyerParty = new JButton(buyersText(party));
		GridBagConstraints gbc_buyer5 = new GridBagConstraints();
		gbc_buyer5.fill = GridBagConstraints.BOTH;
		gbc_buyer5.insets = new Insets(0, 0, 5, 5);
		gbc_buyer5.gridx = 0;
		gbc_buyer5.gridy = 4;
		buyersPanel.add(buyerParty, gbc_buyer5);
		buyerParty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				party.buy();
				playerRessources.setText(playerRessources());
				buyerParty.setText(buyersText(party));
			}
		});

		JButton buyerPartyIcon = new JButton("");
		buyerPartyIcon.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/data_krake_small.png")));
		GridBagConstraints gbc_buyer5Icon = new GridBagConstraints();
		gbc_buyer5Icon.insets = new Insets(0, 0, 5, 0);
		gbc_buyer5Icon.gridx = 1;
		gbc_buyer5Icon.gridy = 4;
		buyersPanel.add(buyerPartyIcon, gbc_buyer5Icon);

		JButton buyerNsa = new JButton(buyersText(nsa));
		GridBagConstraints gbc_buyer6 = new GridBagConstraints();
		gbc_buyer6.fill = GridBagConstraints.BOTH;
		gbc_buyer6.insets = new Insets(0, 0, 5, 5);
		gbc_buyer6.gridx = 0;
		gbc_buyer6.gridy = 5;
		buyersPanel.add(buyerNsa, gbc_buyer6);
		buyerNsa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				nsa.buy();
				playerRessources.setText(playerRessources());
				buyerNsa.setText(buyersText(nsa));
			}
		});

		JButton buyerNsaIcon = new JButton("");
		buyerNsaIcon.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/data_krake_small.png")));
		GridBagConstraints gbc_buyer6Icon = new GridBagConstraints();
		gbc_buyer6Icon.insets = new Insets(0, 0, 5, 0);
		gbc_buyer6Icon.gridx = 1;
		gbc_buyer6Icon.gridy = 5;
		buyersPanel.add(buyerNsaIcon, gbc_buyer6Icon);

		JButton buyerKrake = new JButton(buyersText(krake));
		GridBagConstraints gbc_buyer7 = new GridBagConstraints();
		gbc_buyer7.fill = GridBagConstraints.BOTH;
		gbc_buyer7.insets = new Insets(0, 0, 5, 5);
		gbc_buyer7.gridx = 0;
		gbc_buyer7.gridy = 6;
		buyersPanel.add(buyerKrake, gbc_buyer7);
		buyerKrake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				krake.buy();
				playerRessources.setText(playerRessources());
				buyerKrake.setText(buyersText(krake));
			}
		});

		JButton buyerKrakeIcon = new JButton("");
		buyerKrakeIcon.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/data_krake_small.png")));
		GridBagConstraints gbc_buyer7Icon = new GridBagConstraints();
		gbc_buyer7Icon.insets = new Insets(0, 0, 5, 0);
		gbc_buyer7Icon.gridx = 1;
		gbc_buyer7Icon.gridy = 6;
		buyersPanel.add(buyerKrakeIcon, gbc_buyer7Icon);

		JButton buyerDrump = new JButton(buyersText(drump));
		GridBagConstraints gbc_buyer8 = new GridBagConstraints();
		gbc_buyer8.insets = new Insets(0, 0, 0, 5);
		gbc_buyer8.fill = GridBagConstraints.BOTH;
		gbc_buyer8.gridx = 0;
		gbc_buyer8.gridy = 7;
		buyersPanel.add(buyerDrump, gbc_buyer8);

		JButton buyerDrumpIcon = new JButton("");
		buyerDrumpIcon.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/data_krake_small.png")));
		GridBagConstraints gbc_buyer8Icon = new GridBagConstraints();
		gbc_buyer8Icon.gridx = 1;
		gbc_buyer8Icon.gridy = 7;
		buyersPanel.add(buyerDrumpIcon, gbc_buyer8Icon);
		buyerDrump.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				nsa.buy();
				krake.buy();
				mobile.buy();
				eSport.buy();
				tech.buy();
				vegtables.buy();
				drump.buy();
				playerRessources.setText(playerRessources());
				vegetableButton.setText(buyersText(nsa));
				buyerMobile.setText(buyersText(krake));
				buyerTech.setText(buyersText(mobile));
				buyerESport.setText(buyersText(party));
				buyerParty.setText(buyersText(eSport));
				buyerNsa.setText(buyersText(tech));
				buyerKrake.setText(buyersText(vegtables));
				buyerDrump.setText(buyersText(drump));
			}
		});

		JPanel upgradesPanel = new JPanel();
		frame.getContentPane().add(upgradesPanel, BorderLayout.SOUTH);

		JButton upgradeZuchtBotButton = new JButton(upgradesText(zuchtBot, dataFarm));
		upgradesPanel.add(upgradeZuchtBotButton);
		upgradeZuchtBotButton.setToolTipText("<html>" + upgradesToolTip(zuchtBot, dataFarm));
		upgradeZuchtBotButton.setVisible(false);
		upgradeZuchtBotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				zuchtBot.purchaseUpgrade(dataFarm);
				playerRessources.setText(playerRessources());
				dataFarmButton.setText("<html>" + dataSourcesText(dataFarm));
				upgradesPanel.remove(upgradeZuchtBotButton); // der button wird removed, da man Upgrades nur 1 mal erwerben kann
			}
		});

		JButton upgradeDatenFutterButton = new JButton(upgradesText(datenFutter, dataFarm));
		upgradesPanel.add(upgradeDatenFutterButton);
		upgradeDatenFutterButton.setToolTipText("<html>" + upgradesToolTip(datenFutter, dataFarm));
		upgradeDatenFutterButton.setVisible(false);
		upgradeDatenFutterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				datenFutter.purchaseUpgrade(dataFarm);
				playerRessources.setText(playerRessources());
				dataFarmButton.setText("<html>" + dataSourcesText(dataFarm)); // double rewrite??
				upgradesPanel.remove(upgradeDatenFutterButton);
			}
		});

		JButton upgradeMiniGamesButton = new JButton(upgradesText(miniGames, dataBook));
		upgradesPanel.add(upgradeMiniGamesButton);
		upgradeMiniGamesButton.setToolTipText("<html>" + upgradesToolTip(miniGames, dataBook));
		upgradeMiniGamesButton.setVisible(false);
		upgradeMiniGamesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				datenFutter.purchaseUpgrade(dataBook);
				playerRessources.setText(playerRessources());
				dataBookButton.setText("<html>" + dataSourcesText(dataBook));
				upgradesPanel.remove(upgradeMiniGamesButton);
			}
		});

		JButton upgradeGruppeButton = new JButton(upgradesText(gruppenInDeinerNaehe, dataBook));
		upgradesPanel.add(upgradeGruppeButton);
		upgradeGruppeButton.setToolTipText("<html>" + upgradesToolTip(gruppenInDeinerNaehe, dataBook));
		upgradeGruppeButton.setVisible(false);
		upgradeGruppeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				gruppenInDeinerNaehe.purchaseUpgrade(dataBook);
				playerRessources.setText(playerRessources());
				dataBookButton.setText("<html>" + dataSourcesText(dataBook));
				upgradesPanel.remove(upgradeDatenFutterButton);
			}
		});

		JButton upgradeKarperBriefButton = new JButton(upgradesText(karperbrief, dataPirate));
		upgradesPanel.add(upgradeGruppeButton);
		upgradeKarperBriefButton.setToolTipText("<html>" + upgradesToolTip(karperbrief, dataPirate));
		upgradeKarperBriefButton.setVisible(false);
		upgradeKarperBriefButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				karperbrief.purchaseUpgrade(dataPirate);
				playerRessources.setText(playerRessources());
				dataPirateButton.setText("<html>" + dataSourcesText(dataPirate));
				upgradesPanel.remove(upgradeKarperBriefButton);
			}
		});

		JButton upgradeSchiffButton = new JButton(upgradesText(einNeuesSchiff, dataPirate));
		upgradesPanel.add(upgradeSchiffButton);
		upgradeSchiffButton.setToolTipText("<html>" + upgradesToolTip(einNeuesSchiff, dataPirate));
		upgradeSchiffButton.setVisible(false);
		upgradeSchiffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				einNeuesSchiff.purchaseUpgrade(dataPirate);
				playerRessources.setText(playerRessources());
				dataPirateButton.setText("<html>" + dataSourcesText(dataPirate));
				upgradesPanel.remove(upgradeSchiffButton);
			}
		});
		JButton upgradeMarktplatzButton = new JButton(upgradesText(einNeuerMarktplatz, dataHub));
		upgradesPanel.add(upgradeMarktplatzButton);
		upgradeMarktplatzButton.setVisible(false);
		upgradeMarktplatzButton.setToolTipText("<html>" + upgradesToolTip(einNeuerMarktplatz, dataHub));
		upgradeMarktplatzButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				einNeuerMarktplatz.purchaseUpgrade(dataHub);
				playerRessources.setText(playerRessources());
				dataHubButton.setText("<html>" + dataSourcesText(dataHub));
				upgradesPanel.remove(upgradeMarktplatzButton);
			}
		});

		JButton upgradeLiveChatButton = new JButton(upgradesText(twoWayLiveChat, dataHub));
		upgradesPanel.add(upgradeLiveChatButton);
		upgradeLiveChatButton.setToolTipText("<html>" + upgradesToolTip(twoWayLiveChat, dataHub));
		upgradeLiveChatButton.setVisible(false);
		upgradeLiveChatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				twoWayLiveChat.purchaseUpgrade(dataHub);
				playerRessources.setText(playerRessources());
				dataHubButton.setText("<html>" + dataSourcesText(dataHub));
				upgradesPanel.remove(upgradeLiveChatButton);
			}
		});
		JButton upgradeOfflineButton = new JButton(upgradesText(offlineEinbindung, dataGewinnspiele));
		upgradesPanel.add(upgradeOfflineButton);
		upgradeOfflineButton.setToolTipText("<html>" + upgradesToolTip(offlineEinbindung, dataGewinnspiele));
		upgradeOfflineButton.setVisible(false);
		upgradeOfflineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				offlineEinbindung.purchaseUpgrade(dataGewinnspiele);
				playerRessources.setText(playerRessources());
				dataGewinnspieleButton.setText("<html>" + dataSourcesText(dataGewinnspiele));
				upgradesPanel.remove(upgradeOfflineButton);
			}
		});
		JButton upgradeBelohnungButton = new JButton(upgradesText(waehlDeineBelohnung, dataGewinnspiele));
		upgradesPanel.add(upgradeBelohnungButton);
		upgradeBelohnungButton.setToolTipText("<html>" + upgradesToolTip(waehlDeineBelohnung, dataGewinnspiele));
		upgradeBelohnungButton.setVisible(false);
		upgradeBelohnungButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				waehlDeineBelohnung.purchaseUpgrade(dataGewinnspiele);
				playerRessources.setText(playerRessources());
				dataGewinnspieleButton.setText("<html>" + dataSourcesText(dataGewinnspiele));
				upgradesPanel.remove(upgradeBelohnungButton);
			}
		});
		JButton upgradeCallCenterButton = new JButton(upgradesText(callCenterSupport, dataScout24));
		upgradesPanel.add(upgradeCallCenterButton);
		upgradeCallCenterButton.setToolTipText("<html>" + upgradesToolTip(callCenterSupport, dataScout24));
		upgradeCallCenterButton.setVisible(false);
		upgradeBelohnungButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				callCenterSupport.purchaseUpgrade(dataScout24);
				playerRessources.setText(playerRessources());
				dataScoutButton.setText("<html>" + dataSourcesText(dataScout24));
				upgradesPanel.remove(upgradeBelohnungButton);
			}
		});
		JButton upgradeFormularButton = new JButton(upgradesText(onlineAusfuellformular, dataScout24));
		upgradesPanel.add(upgradeFormularButton);
		upgradeFormularButton.setToolTipText("<html>" + upgradesToolTip(onlineAusfuellformular, dataScout24));
		upgradeFormularButton.setVisible(false);
		upgradeFormularButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				onlineAusfuellformular.purchaseUpgrade(dataScout24);
				playerRessources.setText(playerRessources());
				dataScoutButton.setText("<html>" + dataSourcesText(dataScout24));
				upgradesPanel.remove(upgradeFormularButton);
			}
		});
		JButton upgradeStatusModulButton = new JButton(upgradesText(statusModul, whatsData));
		upgradesPanel.add(upgradeStatusModulButton);
		upgradeStatusModulButton.setToolTipText("<html>" + upgradesToolTip(statusModul, whatsData));
		upgradeStatusModulButton.setVisible(false);
		upgradeStatusModulButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				statusModul.purchaseUpgrade(whatsData);
				playerRessources.setText(playerRessources());
				dataSearchButton.setText("<html>" + dataSourcesText(whatsData));
				upgradesPanel.remove(upgradeStatusModulButton);
			}
		});
		JButton upgradeFaceScannerButton = new JButton(upgradesText(faceScanner, whatsData));
		upgradesPanel.add(upgradeFaceScannerButton);
		upgradeFaceScannerButton.setToolTipText("<html>" + upgradesToolTip(faceScanner, whatsData));
		upgradeFaceScannerButton.setVisible(false);
		upgradeFaceScannerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				faceScanner.purchaseUpgrade(whatsData);
				playerRessources.setText(playerRessources());
				dataSearchButton.setText("<html>" + dataSourcesText(whatsData));
				upgradesPanel.remove(upgradeFaceScannerButton);
			}
		});
		JButton upgradeSucheButton = new JButton(upgradesText(personalisierteSuche, dataSearch));
		upgradesPanel.add(upgradeSucheButton);
		upgradeSucheButton.setVisible(false);
		upgradeSucheButton.setToolTipText("<html>" + upgradesToolTip(personalisierteSuche, dataSearch));
		upgradeSucheButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				personalisierteSuche.purchaseUpgrade(dataSearch);
				playerRessources.setText(playerRessources());
				whatsDataButton.setText("<html>" + dataSourcesText(dataSearch));
				upgradesPanel.remove(upgradeSucheButton);
			}
		});
		JButton upgradeWerbungButton = new JButton(upgradesText(werbung, dataSearch));
		upgradesPanel.add(upgradeWerbungButton);
		upgradeWerbungButton.setToolTipText("<html>" + upgradesToolTip(werbung, dataSearch));
		upgradeWerbungButton.setVisible(false);
		upgradeWerbungButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				werbung.purchaseUpgrade(dataSearch);
				playerRessources.setText(playerRessources());
				whatsDataButton.setText("<html>" + dataSourcesText(dataSearch));
				upgradesPanel.remove(upgradeWerbungButton);
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
		
		Timer dataSourceVisibility = new Timer();
		dataSourceVisibility.schedule(new TimerTask() {
			public void run() {
				dataBook.toggleVisibility(dataBookButton);
				dataBook.toggleVisibility(dataBookIcon);
				dataPirate.toggleVisibility(dataPirateButton);
				dataPirate.toggleVisibility(dataPirateIcon);
				dataHub.toggleVisibility(dataHubButton);
				dataHub.toggleVisibility(dataHubIcon);
				dataGewinnspiele.toggleVisibility(dataGewinnspieleButton);
				dataGewinnspiele.toggleVisibility(dataGewinnspieleIcon);
				dataScout24.toggleVisibility(dataScoutButton);
				dataScout24.toggleVisibility(dataScoutIcon);
				dataSearch.toggleVisibility(dataSearchButton);
				dataSearch.toggleVisibility(dataSearchIcon);
				whatsData.toggleVisibility(whatsDataButton);
				whatsData.toggleVisibility(whatsDataIcon);
			}
		}, 0, 1000);

		Timer upgradeVisibility = new Timer();
		upgradeVisibility.schedule(new TimerTask() {
			public void run() {
				zuchtBot.checkUpgrade(dataFarm, 2, upgradeZuchtBotButton);
				datenFutter.checkUpgrade(dataFarm, 5, upgradeDatenFutterButton);
				miniGames.checkUpgrade(dataBook, 2, upgradeMiniGamesButton);
				gruppenInDeinerNaehe.checkUpgrade(dataBook, 5, upgradeGruppeButton);
				karperbrief.checkUpgrade(dataPirate, 2, upgradeKarperBriefButton);
				einNeuesSchiff.checkUpgrade(dataPirate, 5, upgradeSchiffButton);
				einNeuerMarktplatz.checkUpgrade(dataHub, 2, upgradeMarktplatzButton);
				twoWayLiveChat.checkUpgrade(dataHub, 5, upgradeLiveChatButton);
				offlineEinbindung.checkUpgrade(dataGewinnspiele, 2, upgradeOfflineButton);
				waehlDeineBelohnung.checkUpgrade(dataGewinnspiele, 5, upgradeBelohnungButton);
				callCenterSupport.checkUpgrade(dataScout24, 2, upgradeCallCenterButton);
				onlineAusfuellformular.checkUpgrade(dataScout24, 5, upgradeFormularButton);
				personalisierteSuche.checkUpgrade(dataSearch, 2, upgradeStatusModulButton);
				werbung.checkUpgrade(dataSearch, 5, upgradeFaceScannerButton);
				statusModul.checkUpgrade(whatsData, 2, upgradeSucheButton);
				faceScanner.checkUpgrade(whatsData, 2, upgradeWerbungButton);

			}
		}, 0, 1000);

	}

}