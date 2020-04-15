package main.dataclicker.upgrades;
import dataSources.Datasources;
public class Upgrades_Template {
	private String upgradeName;
	private String upgradeDescription;
	private int upgradeCost;
	private boolean upgradeAvailable;
	private boolean active;
	private static boolean upgradeRequirement;  //Die erforderung damit das Upgrade  Erhaelltlich ist soellte universell veränderbar sein
	
	
	 public Upgrades_Template(String upgradeName, String upgradeDescription, int upgradeCost, boolean upgradeAvailable, boolean active) {
		 this.upgradeName=upgradeName ;
			this.upgradeDescription=upgradeDescription;
			this.upgradeCost=upgradeCost;
			this.upgradeAvailable=upgradeAvailable;
			this.active=active;
	
	    }
	public void setUpgradeDescription(String text)
	{
		this.upgradeDescription=text;
	}
	public boolean getUpgradeRequirement() {
		return upgradeRequirement;
	}
	
	public boolean getActive() {
		return active;
	}
	public void togglevisibility() {		//noch ist das requirement relativ überflüssig -> gerne Inspirationen an mich weiterleiten
		if (active==true)					// ist das Upgrade bereits Aktiv kann man es nicht mehr kaufen
		{
			this.upgradeAvailable=false
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
	public void upgrade1Effect()		//Das erste Upgrade setzt den Multiplier auf 2, das 2. auf 4, hätten wir mehr würden wir so immer weiter richtung 2^2 weiterarbeiten
	{
		DataSource.setDataMultiplier(2);
	}
	public void upgrade2Effect()
	{
		DataSource.setDataMultiplier(4);
	}
}