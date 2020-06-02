
package main.dataclicker.minigames.DataPONG;

import java.util.Timer;
import java.util.TimerTask;

public class Ball_movement {
	Timer move;
	
	public Ball_movement() {
		move = new Timer();
		
		move.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				Variables.ballx += Variables.balldirection_x * Variables.speed;
				Variables.bally += Variables.balldirection_y * Variables.speed;
				
			}
			
		}, 0, 4); // put in variable class
		
	}

}
