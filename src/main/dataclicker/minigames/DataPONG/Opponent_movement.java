package main.dataclicker.minigames.DataPONG;

import java.util.Timer;
import java.util.TimerTask;

public class Opponent_movement {
	
	Timer move;
	
	public Opponent_movement() {
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
/*				if(Variables.moveUpopponent == true) {
					
					if(Variables.opponenty >= 20) {
						Variables.opponenty -=2;
						
					}
				}
				else if(Variables.moveDownopponent == true) {
						
						if(Variables.opponenty <= Variables.screenheight - Variables.paddleheight - 65) {
							Variables.opponenty += 2;
							
						}
				}
*/				
				if(Variables.ballx >= Variables.screenwidth/2 -10) {
					
					if(Variables.ballx == Variables.opponenty) {
						
					}
					else if(Variables.bally > Variables.opponenty + 75) {
						
						if(Variables.opponenty <= Variables.screenheight - Variables.paddleheight - 65) {
							Variables.opponenty +=2;
						}
						
					}
					else if(Variables.opponenty < Variables.opponenty +75) {
						
						if(Variables.opponenty >= 20) {
							Variables.opponenty -= 2;
						}
					}
					
				}
				
			}	
		}, 0, 6); 

	}
}
