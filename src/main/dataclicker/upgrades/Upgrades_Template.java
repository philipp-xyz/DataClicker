package main.dataclicker.upgrades;
import main.dataclicker.dataSources.*;
import main.dataclicker.player.Player;

public class Upgrades_Template {
	
	private String upgradeName;
	private String upgradeDescription;
	private int upgradeCost;
	private boolean upgradeAvailable;
	private boolean active;
	private int upgradeMultiplier;
	private static boolean upgradeRequirement;  //Die erforderung damit das Upgrade  Erhaelltlich ist soellte universell veränderbar sein
	
	
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
	public boolean getUpgradeRequirement() {
		return upgradeRequirement;
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
	
	
	public void togglevisibility() {		//noch ist das requirement relativ überflüssig -> gerne Inspirationen an mich weiterleiten
		if (active==true)					// ist das Upgrade bereits Aktiv kann man es nicht mehr kaufen
		{
			this.upgradeAvailable=false;
		}
		else
		{
			if (upgradeRequirement==true)
			{
			this.upgradeAvailable=true;
			}
			else 
			{
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
			dataSource.increaseDataPerSecond();
			
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