package main.dataclicker.minigames.dataSweeper;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.dataclicker.gui.GUI;

public class SweeperBoard extends JPanel {

	private final int ROWS = 10; // Y
	private final int COLUMNS = 10; // X
	private int numOfMines;
	private double probability;
	private int minesLeft;
	private JButton Minefield[][];
	private boolean hasMine = false;
	private JButton cell;

	public SweeperBoard() {
		setLayout(new GridLayout(10, 10));
		Minefield = new JButton[ROWS][COLUMNS];
		buildButtonField();
	}

	// Adds one to the total number of mines.
	public void addMine() {
		numOfMines++;
	}

	// Removes one from the total number of mines.
	public void removeMine() {
		numOfMines--;
	}

	// Assigns a JButton the value of true or false, which represents whether or not
	// it
	public boolean setMines(JButton button) {
		probability = Math.random() * 100;
		if (probability >= 80) {
			hasMine = true;
			addMine();
			button.setText(" ");
		} else {
			hasMine = false;
		}
		return hasMine;
	}

	public class MouseHandler extends MouseAdapter {
		public int r, c; // instance variables

		public MouseHandler(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == 1) {
				int nearMines = checkForMines(Minefield,r,c);
				if(nearMines == 9)
					Minefield[r][c].setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/DataSweeper/9.png")));
				else
					Minefield[r][c].setText(""+nearMines);

			} else if (e.getButton() == 2) { // getButton 2 für rechtsklick -> fahne setzen
				Minefield[r][c].setText("F");
			}
		}
	}

	public int checkForMines(JButton[][] button, int row, int col) {
		int nearMines = 0;
		if (button[row][col].getText() == " ") {
			nearMines = 9;
			//button[row][col].setIcon("/main/dataclicker/res/textures/DataSweeper/9.png");
		} // Fall für linke obere Ecke
		else if (col == 0 && row == 0) {
			for (int y = row; y <= row + 1; y++) {
				for (int x = col; x <= col + 1; x++) {
					if (button[y][x].getText() == " ") {
						nearMines++;
					}
				}
			}
		} 
		//Fall für obere rechte ecke
		else if(row == 0 && col == COLUMNS-1) {
			for(int y = row; y<= row+1; y++) {
				for( int x = col; x>= col-1; x--) {
					if (button[y][x].getText() == " ") {
						nearMines++;
					}
				}
			}
		}
		//Fall für untere linke ecke
		else if(row== ROWS-1 && col == 0) {
			for(int y = row; y>= row-1; y--) {
				for( int x = col; x<= col+1; x++) {
					if (button[y][x].getText() == " ") {
						nearMines++;
					}
				}
			}
		}
		//Fall für untere rechte Ecke
		else if(row == ROWS-1 && col == COLUMNS -1) {
			for(int y = row; y>= row+1; y--) {
				for( int x = col; x>= col-1; x--) {
					if (button[y][x].getText() == " ") {
						nearMines++;
					}
				}
			}
		}

		// Fall für wenn der Button am oberen BildschirmRand geklickt wurde
		else if (row == 0) {
			for (int x = col - 1; x <= col + 1; x++) { // checks all adjacent coloums
				int y = row;
				while (y < row + 2) { // checks the adjacent rows
					if (button[y][x].getText() == " ") {
						nearMines++;
					}
					y++;
				}

			}
			// Fall für wenn der Button am unteren BildschirmRand geklickt wurde
		} else if (row == ROWS - 1) {
			for (int x = col - 1; x <= col + 1; x++) { // checks all adjacent coloums
				int y = row;
				while (y > ROWS - 2) { // checks the adjacent rows
					if (button[y][x].getText() == " ") {
						nearMines++;
					}
					y--;
				}

			}
			// Fall für wenn der Button am linken BildschirmRand geklickt wurde
		} else if (col == 0) {
			for (int y = row - 1; y <= row + 1; y++) {
				int x = col;
				while (x < col + 2) {
					if (button[y][x].getText() == " ") {
						nearMines++;
					}
					x++;
				}
			}
			// Fall für den rechten Bildschirmrand
		} else if (col == COLUMNS - 1) {
			for (int y = row - 1; y <= row + 1; y++) {
				int x = col;
				while (x > col - 2) {
					if (button[y][x].getText() == " ") {
						nearMines++;
					}
					x--;
				}
			}
		}
		//Fall für beliebiges Feld innterhalb des koordiantensystems
		else {
			for (int x = col-1 ; x <= col+1; x++) {
				for (int y = row-1; y<= row+1; y++) {
					if (button[y][x].getText() == " ") {
						nearMines++;
					}
				}
			}
		}
		
		return nearMines;

	}

	// This builds the "Minefield" with a ROWS*COLUMNS amount of buttons.
	// It works fine but I'm open to suggestions on a better way to do this.
	public void buildButtonField() {
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				Minefield[r][c] = new JButton("");

				setMines(Minefield[r][c]);

				Minefield[r][c].addMouseListener(new MouseHandler(r, c));

				add(Minefield[r][c]);
			}
		}
	}
}
