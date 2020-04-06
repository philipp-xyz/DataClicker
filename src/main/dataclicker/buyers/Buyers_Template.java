package main.dataclicker.buyers;

import main.dataclicker.player.Player;
import main.dataclicker.gui.*;

public class Buyers_Template 
{
	private static String name;
	private int level;
	private int price;
	private int value;
	
	public Buyers_Template(String name, int price, int value)
	{
		this.name = name;
		this.level = 0;
		this.price = price;
		this.value = value;
	}
	public static String getName()
	{
		return name;
	}
	public void buy()
	{
		if(main.dataclicker.player.Player.getDataAmount() >= price)
		{
			level = level + 1;
			main.dataclicker.player.Player.setDataAmount(main.dataclicker.player.Player.getDataAmount() - price);
			price = price * 2;
			main.dataclicker.player.Player.setMoneyAmount(main.dataclicker.player.Player.getMoneyAmount() + value);
		}	
	}
}