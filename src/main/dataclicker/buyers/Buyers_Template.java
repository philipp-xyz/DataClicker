package main.dataclicker.buyers;

import main.dataclicker.player.Player;

import javax.swing.JButton;

public class Buyers_Template {
	private String name;
	private int level;
	private int price;
	private int value;
	private int requiredData;

	public Buyers_Template(String name, int price, int value) {
		this.name = name;
		this.level = 0;
		this.price = price;
		this.value = value;
		this.requiredData = price - 20;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getValue() {
		return value;
	}

	public int getLevel() {
		return level;
	}
	
	public void toggleVisibility(JButton button) {
        if (Player.getDataAmount() >= requiredData) {
            button.setEnabled(true);
        } else {
        	 button.setEnabled(false);
        }

    }
	
	public void buy() {
		if (main.dataclicker.player.Player.getDataAmount() >= price) {
			level = level + 1;
			main.dataclicker.player.Player.setDataAmount(main.dataclicker.player.Player.getDataAmount() - price);
			price = (int) (price * 1.2);
			main.dataclicker.player.Player.setMoneyAmount(main.dataclicker.player.Player.getMoneyAmount() + value);
		}
	}
	
}