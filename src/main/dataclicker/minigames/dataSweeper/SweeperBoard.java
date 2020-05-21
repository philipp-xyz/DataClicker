package main.dataclicker.minigames.dataSweeper;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.dataclicker.gui.GUI;
import main.dataclicker.player.Player;

@SuppressWarnings("serial")
public class SweeperBoard extends JPanel {

	
	private final int ROWS = 10; // Y
	private final int COLUMNS = 10; // X
	private MineState Minefield[][];
	private int data; //data die der Spieler nach dem Spiel bekommt
	
	
	
	public SweeperBoard() {
		setLayout(new GridLayout(10, 10));
		Minefield = new MineState[ROWS][COLUMNS];
		buildButtonField();
	}
	

	public class MouseHandler extends MouseAdapter {
		public int r, c; // instance variables

		public MouseHandler(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == 1) {
				checkForMines(Minefield,r,c);
			
			} else if (e.getButton() == 3) { // getButton 2 für rechtsklick -> fahne setzen
				toggleFlag(Minefield,r,c);
			}
		}
	}
	
	public void toggleFlag(MineState[][] button, int row, int col) {
		if(button[row][col].isSwept)
			return;
		
		if(button[row][col].isFlagged) {
			button[row][col].button.setText("");
			button[row][col].isFlagged = false;
		}
		
		if(!button[row][col].isFlagged) {
			button[row][col].button.setIcon(
				new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/DataSweeper/11.png")));
			button[row][col].isFlagged = true;
			if(button[row][col].isMine) {
				MineState.numOfMines--;
				if(MineState.numOfMines <= 0) {
					gameOver();
				}
			}
		}
	}

	public void checkForMines(MineState[][] button, int row, int col) {
		int nearMines = 0;
		
		//check if row and col are inside of the minefield array
		if(row > ROWS-1)
			row = ROWS-1;
		if(row < 0)
			row = 0;
		if(col > COLUMNS-1)
			col = COLUMNS-1;
		if(col < 0)
			col = 0;
		
		if (button[row][col].isSwept || button[row][col].isFlagged) {
			return;
		}
		//fall für button = mine
		if (button[row][col].isMine) {
			nearMines = -1;
			int explodedMines = MineState.getExplodedMines() +1;
			MineState.setExplodedMines(explodedMines);
			if(explodedMines >= 3) {
				gameOver();
			}
			button[row][col].button.setIcon(
					new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/DataSweeper/9.png")));
		}
		//Fall für beliebiges Feld innterhalb des koordiantensystems
		else {
			for (int x = col-1 ; x <= col+1; x++) {
				for (int y = row-1; y<= row+1; y++) {
					
					if(x > COLUMNS-1 || x < 0 || y > ROWS-1 || y < 0)
						continue;
					
					if (button[y][x].isMine) {
						nearMines++;
					}
				}
			}
			//button[row][col].button.setText(""+nearMines);
			button[row][col].button.setIcon(new ImageIcon
					(GUI.class.getResource("/main/dataclicker/res/textures/DataSweeper/"+nearMines+".png")));
		
		}
		button[row][col].isSwept = true;
		if(nearMines == 0) {
			checkForMines(Minefield, row+1, col+1);
			checkForMines(Minefield, row+1, col);
			checkForMines(Minefield, row, col+1);
			checkForMines(Minefield, row-1, col-1);
			checkForMines(Minefield, row-1, col);
			checkForMines(Minefield, row, col-1);
		
		}
	}

	// This builds the "Minefield" with a ROWS*COLUMNS amount of buttons.
	// It works fine but I'm open to suggestions on a better way to do this.
	public void buildButtonField() {
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				Minefield[r][c] = new MineState();
				Minefield[r][c].button = new JButton("");
				Minefield[r][c].setMines();

				Minefield[r][c].button.addMouseListener(new MouseHandler(r, c));

				add(Minefield[r][c].button);
			}
		}
	}
	
	
	public void gameOver() {
		JTextField gameOver = new JTextField("GAME OVER", 20);
		SweeperGUI.frame.add(gameOver);
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				Minefield[r][c].secureData();
				Minefield[r][c].button.setEnabled(false);
				
			}
		}
		data = MineState.getSecuredData();
		JTextField dataGotten = new JTextField("Erbeutete Daten:"+data);
		SweeperGUI.frame.add(dataGotten);
		Player.setDataAmount(Player.getDataAmount()+data);
	}
}
