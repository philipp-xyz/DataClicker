package main.dataclicker.minigames.DataPONG;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyinput extends KeyAdapter {
	
	private  static Paddle player;
	private  static boolean up1 = false;
	private  static boolean down1 = false;
	
	private  static Paddle AI;
	private  static boolean up2 = false;
	private  static boolean down2 = false;
	
	
	public Keyinput(Paddle pd1, Paddle pd2) {
		player = pd1;
		AI = pd2;

	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) {		// change to AI movement!
			AI.switchDirection(-1);		// Movement up
			up2 = true;
			
		}
		
		if(key == KeyEvent.VK_DOWN) {	// change to AI movement!	
			AI.switchDirection(1);	// Movement down
			down2 = true;				 
		}
		
		if(key == KeyEvent.VK_W) {
			player.switchDirection(-1);
			up1 = true;
		}
		
		if(key == KeyEvent.VK_S) {
			player.switchDirection(1);
			down1 = true;
		}
	}
	
	public static void ai_Movement() {
		if(Ball.getX() >= Game.WIDTH * 0.66 ) {
			if(Ball.getY() <= Paddle.paddleMid) {
				AI.switchDirection(-1);
				up2 = true;
				down2 = false;
				
			}
			if(Ball.getY() >= Paddle.paddleMid) {
				AI.switchDirection(1);
				down2 = true;
				up2 = false;
			}
			
		}
	}

	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) {
			up2 = false;
			
		}
		
		if(key == KeyEvent.VK_DOWN) {
			down2 = false;				 
		}
		
		if(key == KeyEvent.VK_W) {
			up1 = false;
		}
		
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
