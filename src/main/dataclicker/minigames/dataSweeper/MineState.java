package main.dataclicker.minigames.dataSweeper;

import javax.swing.JButton;

public class MineState {
	
	public JButton button;
	public boolean isMine;
	public int nearMines;
	public boolean isFlagged;
	public boolean isSwept;
	public static int securedData=1;
	public static int numOfMines = 0;
	public static int explodedMines = 0;
	
	
	public boolean setMines() {
		double probability = Math.random() * 100;
		if (probability >= 80) {
			isMine = true;
			numOfMines++;
		} else {
			isMine = false;
		}
		return isMine;
	}
	
	
	
	public static int getExplodedMines() {
		return explodedMines;
	}

	public static void setExplodedMines(int explodedMines) {
		MineState.explodedMines = explodedMines;
	}
	
	public static int getSecuredData() {
		return securedData;
	}
	
	public void secureData() {
		if(isMine && isFlagged) {
			securedData = securedData+125;
		}
	}

	
	
}
