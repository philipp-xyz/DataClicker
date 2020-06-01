package main.dataclicker.minigames.DataPONG;

import java.util.Timer;
import java.util.TimerTask;

public class Ball_collision {
	Timer collision;
	
	public Ball_collision() {
		collision = new Timer();
		collision.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				if (Variables.bally + 50 >= Variables.screenheight || Variables.bally <= 0) {
					Variables.balldirection_y *= -1;
					Variables.bally = clamp (Variables.bally, 0, Variables.screenheight - 50); 
					// compares y-coordinates and gives them to bally 
					// ensures that y-coordinate is between both boundaries!
				}
				
				if(Variables.ballx +20 >= Variables.screenwidth) {
					Variables.ballx = Variables.screenwidth/ 2 -10;
					Variables.bally = Variables.screenheight/ 2 -10; 
					
					Variables.balldirection_x = -1;
					Variables.playerPoints += 1;
					
					Variables.speed *= 1.25; 
					
						
				}
				
				if(Variables.ballx <= 0) {
					Variables.ballx = Variables.screenwidth/ 2 -10;
					Variables.bally = Variables.screenheight/ 2 -10; 
					
					Variables.balldirection_x = 1;
					Variables.opponentPoints += 1;
					
					if(Variables.opponentPoints>=3) {
						Gui.gameOver();
					}
					
					
					Variables.speed *= 1.25;
				}
				
				if(Variables.ballx < Variables.x + Variables.paddlewidth && Variables.ballx > Variables.x && Variables.bally -20 < Variables.y + Variables.paddleheight && Variables.bally > Variables.y) {	
					//+25 because player is 25 Pixel large
					// creating a Rect. where collision happens  
					Variables.balldirection_x = 1;
					
				}
				
				if (Variables.ballx < Variables.opponentx + Variables.paddlewidth && Variables.ballx + 20 > Variables.opponentx && 
					Variables.bally < Variables.opponenty + Variables.paddleheight && Variables.bally + 20 > Variables.opponenty) {
					Variables.balldirection_x = -1;
				}
				
			}
			
		}, 0, 5);
	}
	
	static int clamp (int value, int min, int max) {
		
		return value <= min ? min : value >= max ? max : value; // works like an if- statement!
	}

}
