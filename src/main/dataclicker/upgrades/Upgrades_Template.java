package main.dataclicker.upgrades;

public class Upgrades_Template {
	private String upgradeName;
	private String upgradeDescription;
	private int upgradeCost;
	private boolean upgradeAvailable;
	private boolean active;
	private static boolean upgradeRequirement;  //Die erforderung damit das Upgrade  Ehälltlich ist söllte universell veränderbar sein
	
	
	 public Upgrades_Template(String upgradeName, String upgradeDescription, int upgradeCost, boolean upgradeAvailable, boolean active) {
		 this.upgradeName=upgradeName ;
			this.upgradeDescription=upgradeDescription;
			this.upgradeCost=upgradeCost;
			this.upgradeAvailable=upgradeAvailable;
			this.active=active;
			
	    }
	
	public boolean getRequirement(){
		return requirement;
	}
	
	public boolean getActive() {
		return active;
	}
	public void togglevisibility() {		//noch ist das requirement relativ überflüssig -> gerne Inspirationen an mich weiterleiten
		if (upgradeRequirement==true)
		this.upgradeAvailable=true;
		
	}
	public boolean getupgradeAvailable(){
		return upgradeAvailable;
	}
	public void setupgradeAvailable(boolean upgradeAvailable){
		this.upgradeAvailable=upgradeAvailable;
	}
	
}