package main.dataclicker.minigames.DataPONG;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	public static final int SIZE = 16;
	
	private static int x, y;
	private static int xVel, yVel;	// vakue either 1 or -1
	private int speed = 5;
	
	public Ball() {
		
		reset();
		
	}

	private void reset() {
		//initial position 
		x = Game.WIDTH / 2 - SIZE / 2;
		y = Game.HEIGHT / 2 - SIZE / 2;
		
		//initial velocities
		
		xVel = Game.sign(Math.random() * 2.0 - 1);		// equal chances of 1 or -1 
		yVel = Game.sign(Math.random() * 2.0 - 1);	
		
		
	}
	
	public static int getSize() {
		return SIZE;
	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}

	public void changeYDir() {
		yVel *= -1;
		
	}
	
	public void changeXDir() {
		xVel *= -1;
			
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, SIZE, SIZE);
		
	}

	public void update(Paddle player, Paddle aI) {
		
		//update movement
		x += xVel * speed;
		y += yVel * speed;
		
		//colision
		if(y + SIZE >= Game.HEIGHT || y <= 0) {
			changeYDir();
			
		}
		
		//with walls
		if(x + SIZE >= Game.WIDTH) {
			player.addPoint();
			speed *=  1.3;
			reset();
		}
		
		if(x <= 0) {
			aI.addPoint();
			reset();
			
		}
		
	}
	
	
}
