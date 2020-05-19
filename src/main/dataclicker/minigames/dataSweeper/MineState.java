package main.dataclicker.minigames.dataSweeper;

import javax.swing.JButton;

public class MineState {
	
	public JButton button;
	public boolean isMine;
	public int nearMines;
	public boolean isFlagged;
	public boolean isSwept;
	
	public boolean setMines() {
		double probability = Math.random() * 100;
		if (probability >= 80) {
			isMine = true;
		} else {
			isMine = false;
		}
		return isMine;
	}

}
