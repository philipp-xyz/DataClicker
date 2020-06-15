package main.dataclicker.minigames.DataPONG;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyinput extends KeyAdapter {
	
	private Paddle player;
	private boolean up1 = false;
	private boolean down1 = false;
	
	private Paddle AI;
	private boolean up2 = false;
	private boolean down2 = false;
	
	
	public Keyinput(Paddle pd1, Paddle pd2) {
		player = pd1;
		AI = pd2;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
/*		if(key == KeyEvent.VK_UP) {		// change to AI movement!
			AI.switchDirection(-1);		// Movement up
			up2 = true;
			
		}
		
		if(key == KeyEvent.VK_DOWN) {	// change to AI movement!	
			AI.switchDirection(1);	// Movement down
			down2 = true;				 
		}
*/		
		if(key == KeyEvent.VK_W) {
			player.switchDirection(-1);
			up1 = true;
		}
		
		if(key == KeyEvent.VK_S) {
			player.switchDirection(1);
			down1 = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) {
			up2 = false;
			
		}
		
/*		if(key == KeyEvent.VK_DOWN) {
			down2 = false;				 
		}
		
		if(key == KeyEvent.VK_W) {
			up1 = false;
		}
*/		
		if(key == KeyEvent.VK_S) {
			down1 = false;
		}
		
		if(!up1 && !down1) {		//stops lagging while paddles moving!
			player.stop();
		}
		
		if(!up2 && !down2) {
			AI.stop();
		}
	}
	
}
