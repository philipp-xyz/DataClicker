package main.dataclicker.minigames.DataPONG;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferStrategy;

import main.dataclicker.player.Player;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -668240625892092763L;

	public static final int WIDTH = 1000;
	public static final int HEIGHT = WIDTH * 9/16; //assures a 16:9 ratio
	
	public boolean running = false;
	private Thread gameThread;
	
	private Ball ball;
	private Paddle player;
	private Paddle AI;
	
	
	public Game() {
		
		canvasSetup();
		initialize();
		
		new GUI("DataPONG", this);
		
		this.addKeyListener(new Keyinput(player, AI));
		this.setFocusable(true);
	}
	
	
	
	private void initialize() {
		
		// initialize ball 
		ball = new Ball();
		
		
		
		
		// initialize paddles
		player = new Paddle(Color.green, true);
		AI = new Paddle(Color.red, false); 			// refering to paddles class deciding whether Paddle is located left(player) or right(AI)
	}



	private void canvasSetup() {

		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT)); 
	
	}



	@Override
	public void run() {
		this.requestFocus();
		//game timer		
		//find out how it the game loop works!
		
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		
		while(AI.score <= 3) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
			
				update();
				delta--;
				
			}
			
			if (running) draw();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				
				timer += 1000;
				System.out.println("FPS: "+ frames);
				frames = 0;
			}
		}
		gameOver();
		 
		
		
	}

	private void update() {
		
		//update ball
		ball.update(player, AI);
		
		
		
		//update paddles
		player.update(ball);
		AI.update(ball);
		
		
		// AI movement
		
		Keyinput.ai_Movement();
	}



	private void draw() {
		
		// initialize drawing tools
		
		
		BufferStrategy buffer = this.getBufferStrategy();
		
		if(buffer == null) {
			
			this.createBufferStrategy(3);
			return;
			
		}
		
		Graphics g = buffer.getDrawGraphics();
		
		
		//draw background
		drawBackground(g);
		
		
		
		// draw ball
		ball.draw(g);
		
		
		// draw paddles --> adding the score into the Paddles class
		player.draw(g);
		AI.draw(g);
		
		
		// dispose actually draw 
		g.dispose();
		buffer.show();
		

		
	}



	private void drawBackground(Graphics g) {
		//black background
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT); 
		
		//dotted line
		g.setColor(Color.white);
		Graphics2D g2d = (Graphics2D) g;
		Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] {10}, 0); // float[]{10} puts a stroke every 10px
		g2d.setStroke(dashed);
		g2d.drawLine(WIDTH / 2, 0,WIDTH / 2, HEIGHT);
		
		
	}



	public void start() {
		// TODO Auto-generated method stub
		
		gameThread = new Thread(this);
		gameThread.start();
		running = true;
		
		
	}
	
	
	public void gameOver() {
		int data = player.score * 250;
		Player.setDataAmount(Player.getDataAmount()+data);
		
		try {
			gameThread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public static int sign(double d) {
		
		if(d <= 0) {
			return -1;
		}
		else {
			return 1;
		}
	}
	
	
	/*public static void main (String[] args) {
		
		new Game();
	}*/



	public static int ensuresRange(int val, int min, int max) {
		return Math.min(Math.max(val, min), max);
		 
	}
	

}
