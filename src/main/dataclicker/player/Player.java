package main.dataclicker.player;

public class Player {
    private static int dataAmount = 0;
    private static int dataPerClick = 1;
    private static int clickMultiplier = 1;
    private static int moneyAmount = 0;
    private static int currentDataPerSecond;

    public Player() {
    }

    public static int getDataAmount() {
        return dataAmount;
    }

    public static void setDataAmount(int dataAmount) {
        Player.dataAmount = dataAmount;
    }

    public static int getDataPerClick() {
        return dataPerClick;
    }

    public void setDataPerClick(int dataPerClick) {
        Player.dataPerClick = dataPerClick;
    }

    public int getClickMultiplier() {
        return clickMultiplier;
    }

    public void setClickMultiplier(int clickMultiplier) {
        Player.clickMultiplier = clickMultiplier;
    }

    public static int getMoneyAmount() {
        return moneyAmount;
    }

    public static void setMoneyAmount(int moneyAmount) {
        Player.moneyAmount = moneyAmount;
    }

    public int getCurrentDataPerSecond() {
        return currentDataPerSecond;
    }

    public void setCurrentDataPerSecond(int currentDataPerSecond) {
        Player.currentDataPerSecond = currentDataPerSecond;
    }

    public static void dataClick() {
        int dataAmount = getDataAmount();
        int clickAmount = getDataPerClick();
        dataAmount += clickAmount;
        setDataAmount(dataAmount);
    }

    public void purchaseDataSource(String sourceName) {
    }

    public void sellData() {
    }
}
