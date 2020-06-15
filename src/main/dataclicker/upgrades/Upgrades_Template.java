package main.dataclicker.upgrades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.dataclicker.dataSources.*;
import main.dataclicker.player.Player;
import main.dataclicker.gui.*;
import main.dataclicker.minigames.blackJack.bj.BJ;
import main.dataclicker.minigames.dataSlots.Slotsmain;
import main.dataclicker.minigames.dataSnake.gui.Game;
import main.dataclicker.minigames.dataSweeper.SweeperGUI;

public class Upgrades_Template {

	private String upgradeName;
	private String upgradeDescription;
	private int upgradeCost;
	private boolean upgradeAvailable;
	private boolean active;
	private int upgradeMultiplier;
	private static boolean upgradeRequirement;  //Die erforderung damit das Upgrade  Erhaelltlich ist soellte universell ver�nderbar sein
	private DataSource_Template dataSource;

	public Upgrades_Template(String upgradeName, String upgradeDescription, int upgradeCost, int upgradeMultiplier, DataSource_Template dataSource) {
		this.upgradeName=upgradeName ;
		this.upgradeDescription=upgradeDescription;
		this.upgradeCost=upgradeCost;
		this.upgradeMultiplier=upgradeMultiplier;
		this.dataSource = dataSource;

	}

	public Upgrades_Template(String upgradeName, String upgradeDescription, int upgradeCost) {
		this.upgradeName=upgradeName ;
		this.upgradeDescription=upgradeDescription;
		this.upgradeCost=upgradeCost;
	}

	public void setUpgradeDescription(String text)
	{
		this.upgradeDescription=text;
	}
	public void checkUpgrade(int amountNeeded, JButton button) {  //upgradeLevel ist eine Hilfsvariable f�r mich, welche nur einen Wert von 1 oder 2 haben soll || man kann code sparen indem man einfach das if-statement mit der übergebenen Variable macht
		// does this work, i return it to rewrite it? or can i just Rewrite it without this line || return nur wenn man danach noch etwas mit einem Resultat der Funktion machen möchte, da wir aber nur einmal einen Wert setzen, ist die funktion void und gibt nichts zurück
		if(dataSource.getSourceAmountOwned()>=amountNeeded){
			button.setVisible(true);
		} 
	}
	
	public void checkMGUpgrade(JButton button) {
		if(Player.getMoneyAmount() >= upgradeCost) {
			button.setVisible(true);
		}
	}

	public String getUpgradeName() {
		return upgradeName;
	}

	public String getUpgradeDescription() {
		return upgradeDescription;
	}

	public int getUpgradeCost() {
		return upgradeCost;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getUpgradeMultiplier() {
		return upgradeMultiplier;
	}


	public void togglevisibility() {		//noch ist das requirement relativ �berfl�ssig -> gerne Inspirationen an mich weiterleiten
		if (active==true) {					// ist das Upgrade bereits Aktiv kann man es nicht mehr kaufen{
			this.upgradeAvailable=false;
		}
		else{
			if (upgradeRequirement==true){
				this.upgradeAvailable=true;
			}
			else {
				this.upgradeAvailable=false;
			}
		}


	}
	public boolean getupgradeAvailable(){
		return upgradeAvailable;
	}
	public void setupgradeAvailable(boolean upgradeAvailable){
		this.upgradeAvailable=upgradeAvailable;
	}

	public void upgradeEffect()		
	{
			int firstdps = dataSource.getDataPerSecond();
			dataSource.setDataMultiplier(getUpgradeMultiplier());
			dataSource.updateDataPerSecond();
			
			int seconddps = dataSource.getDataPerSecond();
			int diffdps = seconddps - firstdps;
			Player.setCurrentDataPerSecond(Player.getCurrentDataPerSecond()+diffdps);
		

	}

	public void upgradeMG(JButton button) {
		if(button.getName() == "Sweeper")
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent click) {
					SweeperGUI sweeper = new main.dataclicker.minigames.dataSweeper.SweeperGUI();
					sweeper.sweeperInitialize();
				}
			});

		if(button.getName() == "BJ") {
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent click) {
					new BJ("Black Jack", 800, 800);
				}
			});
		}
		
		if(button.getName() == "pong") {
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent click) {
					new main.dataclicker.minigames.DataPONG.Game();
				}
			});
		}

		if(button.getName() == "Snake") {
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent click) {
					Game dataSnake = new Game("DataSnake", 800, 800);
					dataSnake.start();
				}
			});

		}
		if(button.getName() == "slots") {
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent click) {
					Slotsmain slots = new main.dataclicker.minigames.dataSlots.Slotsmain();
					slots.main(null);
				}
			});
		}
	}

	public boolean purchaseMGUpgrade(JButton icon) {
		if (Player.getMoneyAmount()>= getUpgradeCost()) {

			int playersMoney = Player.getMoneyAmount();
			playersMoney =playersMoney-getUpgradeCost();    //Bezahlung des Upgrades
			Player.setMoneyAmount(playersMoney);
			upgradeMG(icon);
			return true;

		}
		else return false;
	}

	public boolean purchaseUpgrade() {
		if (Player.getMoneyAmount()>= getUpgradeCost()) {

			int playersMoney = Player.getMoneyAmount();
			playersMoney =playersMoney-getUpgradeCost();    //Bezahlung des Upgrades
			Player.setMoneyAmount(playersMoney);   

			upgradeEffect();
			return true;
		}
		else return false;
	}


}