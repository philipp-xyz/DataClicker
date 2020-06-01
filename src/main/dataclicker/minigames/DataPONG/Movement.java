package main.dataclicker.minigames.DataPONG;

import java.util.Timer;
import java.util.TimerTask;

public class Movement {
	public static int paddlespeed = 6; 
	static Timer move;
	public Movement() {
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(Variables.moveUp == true) {
					
					if(Variables.y >= 20) {
						Variables.y -=2;
						
					}
				}
				else if(Variables.moveDown == true) {
						
						if(Variables.y <= Variables.screenheight - Variables.paddleheight - 65) {
							Variables.y += 2;
							
						}
				}
			}
			
		}, 0, paddlespeed);
	}

}
