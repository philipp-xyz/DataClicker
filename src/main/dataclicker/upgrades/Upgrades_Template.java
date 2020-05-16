package main.dataclicker.upgrades;
import javax.swing.JButton;

import main.dataclicker.dataSources.*;
import main.dataclicker.player.Player;
import main.dataclicker.gui.*;

public class Upgrades_Template {
	
	private String upgradeName;
	private String upgradeDescription;
	private int upgradeCost;
	private boolean upgradeAvailable;
	private boolean active;
	private int upgradeMultiplier;
	private static boolean upgradeRequirement;  //Die erforderung damit das Upgrade  Erhaelltlich ist soellte universell ver�nderbar sein
	
	
	 public Upgrades_Template(String upgradeName, String upgradeDescription, int upgradeCost, int upgradeMultiplier, DataSource_Template dataSource) {
		this.upgradeName=upgradeName ;
		this.upgradeDescription=upgradeDescription;
		this.upgradeCost=upgradeCost;
		this.upgradeMultiplier=upgradeMultiplier;
	}
	 
	public void setUpgradeDescription(String text)
	{
		this.upgradeDescription=text;
	}
	public void checkUpgrade(DataSource_Template datasource, int amountNeeded, JButton button) {  //upgradeLevel ist eine Hilfsvariable f�r mich, welche nur einen Wert von 1 oder 2 haben soll || man kann code sparen indem man einfach das if-statement mit der übergebenen Variable macht
																							// does this work, i return it to rewrite it? or can i just Rewrite it without this line || return nur wenn man danach noch etwas mit einem Resultat der Funktion machen möchte, da wir aber nur einmal einen Wert setzen, ist die funktion void und gibt nichts zurück
		if(datasource.getSourceAmountOwned()>=amountNeeded){
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
	
	public void upgradeEffect(DataSource_Template dataSource)		
	{
			dataSource.setDataMultiplier(getUpgradeMultiplier());
			dataSource.updateDataPerSecond();
			int datapersec = dataSource.getDataPerSecond();
			Player.setCurrentDataPerSecond(Player.getCurrentDataPerSecond());
	}
	
	
	public void purchaseUpgrade(DataSource_Template datasource) {
		if (Player.getMoneyAmount()>= getUpgradeCost()) {
			
			int playersMoney = Player.getMoneyAmount();
			playersMoney =playersMoney-getUpgradeCost();    //Bezahlung des Upgrades
			Player.setMoneyAmount(playersMoney);   
			
			upgradeEffect(datasource);

		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}