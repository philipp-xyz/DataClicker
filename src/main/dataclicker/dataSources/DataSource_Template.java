package main.dataclicker.dataSources;

import javax.swing.JButton;

import main.dataclicker.player.Player;

public class DataSource_Template {

    private String sourceName;
    private String sourceDescription;
    private int dataPerSecond;
    private int initialDataPerSecond;
    private int requiredData;
    private int initialCost;
    private int currentCost;
    private double costIncrease;
    private double dataIncrease;
    private int sourceAmountOwned;
    private int dataMultiplier = 1;
    private boolean sourceActive = false;
    private boolean sourceAvailable;

    public DataSource_Template(String sourceName, String sourceDescription, int dataPerSecond, int currentCost, double costIncrease, int requiredData) {
        this.sourceName = sourceName;
        this.sourceDescription = sourceDescription;
        this.dataPerSecond = dataPerSecond;
        this.initialDataPerSecond = dataPerSecond;
        this.currentCost = currentCost;
        this.costIncrease = costIncrease;
        this.requiredData = requiredData;
        sourceAmountOwned = 0;
    }

    public String getSourceName() {
        return sourceName;
    }

    public String getSourceDescription() {
        return sourceDescription;
    }

    public int getDataPerSecond() {
        return dataPerSecond * dataMultiplier;
    }

    public void setDataPerSecond(int dataPerSecond) {
		this.dataPerSecond = dataPerSecond;
	}

	public int getInitialDataPerSecond() {
		return initialDataPerSecond;
	}

	public void setInitialDataPerSecond(int initialDataPerSecond) {
		this.initialDataPerSecond = initialDataPerSecond;
	}

	public int getInitialCost() {
        return initialCost;
    }

    public int getCurrentCost() {
        return currentCost;
    }

    public double getCostIncrease() {
        return costIncrease;
    }

    public double getDataIncrease() {
        return dataIncrease;
    }

    public int getSourceAmountOwned() {
        return sourceAmountOwned;
    }
    
    public void setSourceAmountOwned(int sourceAmountOwned) {
		this.sourceAmountOwned = sourceAmountOwned;
	}

	public int getDataMultiplier() {
        return dataMultiplier;
    }

    public boolean isSourceActive() {
    	return sourceActive;
    }
    
    public void setSourceActive(boolean state) {
    	if (state == true) {
    		this.sourceActive = true;
    	} else this.sourceActive = false;
    }

    public boolean isSourceAvailable() {
        return sourceAvailable;
    }

    public void setDataMultiplier(int dataMultiplier) {
        this.dataMultiplier = dataMultiplier;
    }

    public void increaseAmountOwned(int addition) {
        this.sourceAmountOwned = this.sourceAmountOwned + addition;
    }

    public void increaseCurrentCost() {
        int currentCost = getCurrentCost();
        if (costIncrease < 1.00) {   //Guckt nach ob der Anstieg auch wirklich gro� genug ist, um den Preis zu erh�en (also mehr als 100% darstellt)
            costIncrease += 1.00;
        }
        currentCost = (int) (currentCost * costIncrease);
        this.currentCost = currentCost;
    }

    public void increaseDataPerSecond() {
        int dataPerSecond = getDataPerSecond();
        int initDataPerSecond = getInitialDataPerSecond();
        dataPerSecond = (dataPerSecond + initDataPerSecond) * dataMultiplier; 
        setDataPerSecond(dataPerSecond);
    }

    public void updateDataPerSecond() {
        int dataPerSecond = getDataPerSecond();
        dataPerSecond = (dataPerSecond ) * dataMultiplier; 
        setDataPerSecond(dataPerSecond);
    }
    
    public void toggleVisibility(JButton button) {
        if (Player.getDataAmount() >= requiredData) {
            button.setEnabled(true);
        } else {
        	 button.setEnabled(false);
        }

    }

    public void collectDataPerSecond() {
        if (this.sourceActive == true) {
        	int dataAmount = Player.getDataAmount();
            dataAmount = dataAmount + getDataPerSecond();
            Player.setDataAmount(dataAmount);
        }
    }
    
    public void purchaseDataSource() {
    	if (Player.getMoneyAmount()>= getCurrentCost()) {  //checkt ob der Player sich die Datenquelle leisten kann
    		if(isSourceActive()==false)
    			setSourceActive(true);
    		int playersMoney = Player.getMoneyAmount();
    		playersMoney=playersMoney-getCurrentCost();
    		Player.setMoneyAmount(playersMoney);				//Bezahlung der Datenquelle erfolgt
    		int amountOwned = getSourceAmountOwned();		
    		amountOwned= amountOwned+1;
    		setSourceAmountOwned(amountOwned);	//Anzahl der Datenquellen die man hat wird aktualisiert
    		if (amountOwned > 1)				//wenn es nicht die erste Quelle ihrer Art ist, die erworben wird, wird nun  die erarbeiteten Daten pro Sekunde aktualisiert
    		increaseDataPerSecond();		
    		int datapersec = getDataPerSecond();
    		Player.setCurrentDataPerSecond((Player.getCurrentDataPerSecond()+initialDataPerSecond*dataMultiplier));
    		increaseCurrentCost();			//Kosten der n�chsten Datenquelle werden erh�ht
    	}
    }
}

