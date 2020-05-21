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
	private int data; // data die der Spieler nach dem Spiel bekommt
	public JTextField tries = new JTextField("O O O");
	public JPanel overview = new JPanel();
	public JTextField minesLeft = new JTextField("", 0);
	public int hiddenMines = 0;
	public int explodedMines = 0;

	public SweeperBoard() {
		setLayout(new GridLayout(10, 10));
		Minefield = new MineState[ROWS][COLUMNS];
		buildButtonField();
		minesLeft.setText("Anzahl an Minen: " + hiddenMines);
	}

	public class MouseHandler extends MouseAdapter {
		public int r, c; // instance variables

		public MouseHandler(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == 1) {
				checkForMines(Minefield, r, c);

			} else if (e.getButton() == 3) { // getButton 2 für rechtsklick -> fahne setzen
				toggleFlag(Minefield, r, c);
			}
		}
	}

	public void toggleFlag(MineState[][] button, int row, int col) {
		// macht nichts wenn das feld schon aufegdeckt ist
		if (button[row][col].isSwept)
			return;

		// Fall für wenn eine Flagge schonmal gessetzt wurde
		if (button[row][col].isFlagged) {
			button[row][col].button.setText("");
			button[row][col].button.setIcon(null);
			button[row][col].isFlagged = false;
			if (button[row][col].isMine)
				hiddenMines++;
			return;
		}
		// Setzen der Flagge
		if (!button[row][col].isFlagged) {
			button[row][col].button
					.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/DataSweeper/11.png")));
			button[row][col].isFlagged = true;
			if (button[row][col].isMine) {
				hiddenMines--;
				if (hiddenMines <= 0) {
					gameWon();
				}
			}
		}
	}

	public void checkForMines(MineState[][] button, int row, int col) {
		int nearMines = 0;

		// check if row and col are inside of the minefield array
		if (row > ROWS - 1)
			row = ROWS - 1;
		if (row < 0)
			row = 0;
		if (col > COLUMNS - 1)
			col = COLUMNS - 1;
		if (col < 0)
			col = 0;

		if (button[row][col].isSwept || button[row][col].isFlagged) {
			return;
		}
		// fall für button = mine
		if (button[row][col].isMine) {
			nearMines = -1;
			explodedMines += 1;
			hiddenMines--;

			if (explodedMines == 1) {
				tries.setText("X O O");
			}
			if (explodedMines == 2) {
				tries.setText("X X O");
			}
			if (explodedMines >= 3) {
				tries.setText("X X X");
				gameOver();
			}
			button[row][col].button
					.setIcon(new ImageIcon(GUI.class.getResource("/main/dataclicker/res/textures/DataSweeper/9.png")));
		}
		// Fall für beliebiges Feld innterhalb des koordiantensystems
		else {
			for (int x = col - 1; x <= col + 1; x++) {
				for (int y = row - 1; y <= row + 1; y++) {

					if (x > COLUMNS - 1 || x < 0 || y > ROWS - 1 || y < 0)
						continue;

					if (button[y][x].isMine) {
						nearMines++;
					}
				}
			}
			// button[row][col].button.setText(""+nearMines);
			button[row][col].button.setIcon(new ImageIcon(
					GUI.class.getResource("/main/dataclicker/res/textures/DataSweeper/" + nearMines + ".png")));

		}
		button[row][col].isSwept = true;
		if (nearMines == 0) {
			checkForMines(Minefield, row + 1, col + 1);
			checkForMines(Minefield, row + 1, col);
			checkForMines(Minefield, row, col + 1);
			checkForMines(Minefield, row - 1, col - 1);
			checkForMines(Minefield, row - 1, col);
			checkForMines(Minefield, row, col - 1);
			checkForMines(Minefield, row + 1, col - 1);
			checkForMines(Minefield, row - 1, col + 1);

		}
	}

	// This builds the "Minefield" with a ROWS*COLUMNS amount of buttons.
	// It works fine but I'm open to suggestions on a better way to do this.
	public void buildButtonField() {
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				Minefield[r][c] = new MineState();
				Minefield[r][c].button = new JButton("");
				boolean isMine = Minefield[r][c].setMines();
				if (isMine)
					hiddenMines++;

				Minefield[r][c].button.addMouseListener(new MouseHandler(r, c));

				add(Minefield[r][c].button);
			}
		}
	}

	public void gameOver() {
		collectData();
		JTextField gameOver = new JTextField("GAME OVER Erbeutete Daten: " + data, 0);
		overview.add(gameOver);
		Player.setDataAmount(Player.getDataAmount() + data);
	}

	public void gameWon() {
		collectData();
		JTextField gameOver = new JTextField("GAME WON Erbeutete Daten: " + data, 0);
		overview.add(gameOver);
		Player.setDataAmount(Player.getDataAmount() + data);
	}

	public int collectData() {
		data = 0;
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				boolean isSecured = Minefield[r][c].secureData();
				if (isSecured)
					data += 125;
				Minefield[r][c].button.setEnabled(false);

			}
		}
		return data;
	}
}
