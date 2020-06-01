package main.dataclicker.minigames.DataPONG;

import main.dataclicker.minigames.DataPONG.Ball_movement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Gui();
		new Variables(); 
		new Movement(); 	// exists for changing direction (request) --> done by a timer!
		new Opponent_movement();
		new Ball_movement();
		new Ball_collision();

	}

}
