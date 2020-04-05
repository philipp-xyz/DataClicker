package main.dataclicker.dataSources;

import main.dataclicker.player.Player;

public class DataSource_Template {

    private String sourceName;
    private String sourceDescription;
    private int dataPerSecond;
    private int requiredData;
    private int initialCost;
    private static int currentCost;
    private double costIncrease;
    private double dataIncrease;
    private int sourceAmountOwned;
    private int dataMultiplier;
    private boolean sourceActive;
    private boolean sourceAvailable;
    private Player player;


    public String getSourceName() {
        return sourceName;
    }

    public String getSourceDescription() {
        return sourceDescription;
    }

    public int getDataPerSecond() {
        return dataPerSecond;
    }

    public int getInitialCost() {
        return initialCost;
    }

    public static int getCurrentCost() {
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

    public int getDataMultiplier() {
        return dataMultiplier;
    }

    public boolean isSourceActive() {
        return sourceActive;
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
        if (costIncrease < 1.00) {
            costIncrease += 1.00;
        }
        currentCost = (int) (currentCost * costIncrease);
        DataSource_Template.currentCost = currentCost;
    }

    public void increaseDataPerSecond() {
        int dataPerSecond = getDataPerSecond();
        dataPerSecond = dataPerSecond * dataMultiplier;
        this.dataPerSecond = dataPerSecond;
    }

    public boolean toggleVisibility(int dataAmount) {
        if (player.getDataAmount() >= requiredData) {
            return true;
        } else {
            return false;
        }

    }

    public void collectDataPerSecond(int dataPerSecond) {
        int dataAmount = player.getDataAmount();
        dataAmount = dataAmount + dataPerSecond;
    }
}

