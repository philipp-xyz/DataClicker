package main.dataclicker.buyers;

import main.dataclicker.player.Player;

public class Buyers_Template 
{
	private String name;
	private int level;
	private int preis;
	private int gewinn;
	//private int dataAmount;
	//private int moneyAmount;
	
	public Buyers_Template(String name, int preis, int gewinn)
	{
		this.name = name;
		this.level = 1;
		this.preis = preis;
		this.gewinn = gewinn;
	}
	public void kauf()
	{
		if(player.getdataAmount() >= preis)
		{
			level = level + 1;
			dataAmount = dataAmount - preis;
			preis = preis * 2;
			moneyAmount = moneyAmount + gewinn;
		}	
	}
}