package main.dataclicker.minigames.dataSweeper;

import javax.swing.JButton;

public class MineState {
	
	public JButton button;
	public boolean isMine;
	public int nearMines;
	public boolean isFlagged;
	public boolean isSwept;
	public int securedData=1;
	
	
	public boolean setMines() {
		double probability = Math.random() * 100;
		if (probability >= 80) {
			isMine = true;
		} else {
			isMine = false;
		}
		return isMine;
	}
	
	public boolean secureData() {
		if(isMine && isFlagged) {
			
			return true;
		}
		return false;
	}

	
	
}
