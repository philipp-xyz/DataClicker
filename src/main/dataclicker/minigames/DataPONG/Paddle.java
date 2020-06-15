package main.dataclicker.minigames.DataPONG;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Paddle {
	
	private int x, y;
	private int vel = 0;
	private int speed = 5;
	private static int width = 22, height = 85;
	public int score = 0; 
	private Color color;
	private boolean left;
	public static int paddleMid = height / 2;

	public Paddle(Color c , boolean left) {
		color = c;
		
		this.left = left;
		
		if(left) {
			x = 0;
		}
		else {
			x = Game.WIDTH - width; 
		}
		
		y = Game.HEIGHT / 2 - height / 2 + 100; // in the else part or not?????? tutorial doesn't use {}
	}
	
	public void addPoint() {
		score++;
		
		
	}

	public void draw(Graphics g) {
		//draw paddle
		g.setColor(color);
		g.fillRect(x, y, width, height);
		
		//draw score
		int sx;
		String scoreText = Integer.toString(score);
		Font font = new Font("Roboto", Font.PLAIN, 50);
		
		int strwidth = g.getFontMetrics(font).stringWidth(scoreText) + 1;
		int padding = 25;
		
		if (left) {
			sx = Game.WIDTH / 2 - padding - strwidth;
		}
		else {
			sx = Game.WIDTH / 2 + padding;
		} 
		g.setFont(font);
		g.drawString(scoreText, sx, 50);
	}

	public void update(Ball b) {
		//update position 
		y = Game.ensuresRange(y += vel, 0, Game.HEIGHT - height);// only updating if it's possible
		
		int ballx = b.getX();
		int bally = b.getY();
		
		//collisions with ball
		if(left) {
			
			if(ballx <= width && bally + Ball.SIZE >= y && bally <= y + height) {
				b.changeXDir();
			}
		}
		else {
			if(ballx + Ball.SIZE >= Game.WIDTH - width && bally + Ball.SIZE >= y && bally <= y+ height ) {
				b.changeXDir();
			}
		}
		
		Paddle.paddleMid = this.y + height / 2;
		
	}

	public void switchDirection(int direction) {
		vel = speed * direction;					
		
		
	}
	public void stop() {
		vel = 0;
	}
	
}
