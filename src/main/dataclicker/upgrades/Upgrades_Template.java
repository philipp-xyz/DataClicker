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
	public void checkUpgradeRequirement(int upgradeLevel) {  //upgradeLevel ist eine Hilfsvariable für mich, welche nur einen Wert von 1 oder 2 haben soll
		return upgradeRequirement;// does this work, i return it to rewrite it? or can i just Rewrite it without this line
		if (upgradeLevel==1)
		{
			if (Datasource.sourceAmountOwned>=25)
				upgradeRequirement=true;
			else upgradeRequirement=false;
		}
		else
		if (upgradeLevel==2)
		{
			if (Datasource.sourceAmountOwned>=50)
				upgradeRequirement=true;
			else upgradeRequirement=false;
		}
		else
			System.out.println("SIR YOU HAVE FAILED, no really pls only input 1 or 2 as upgradeLevel");
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