package main.dataclicker.minigames.dataSnake.gui;

import main.dataclicker.inputs.MouseManager;
import main.dataclicker.minigames.dataSnake.Handler;
import main.dataclicker.minigames.dataSnake.graphics.Assets;
import main.dataclicker.minigames.dataSnake.input.KeyManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private Gui gui;

    public static final int WIDTH = 800, HEIGHT = 800;

    public int width, height;
    public String title;

    private Thread thread;
    private boolean running = false;

    private BufferStrategy bufferStrategy;
    private Graphics g;

    private KeyManager keyManager;
    private MouseManager mouseManager;

    private Handler handler;

    public State gameState;
    public MenuState menuState;
    public EndState endState;


    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;

        keyManager = new KeyManager();
        mouseManager = new MouseManager();

    }

    public void init() {
        gui = new Gui(title, width, height);
        gui.getFrame().addKeyListener(keyManager);
        gui.getFrame().addMouseListener(mouseManager);
        gui.getFrame().addMouseMotionListener(mouseManager);
        gui.getCanvas().addMouseListener(mouseManager);
        gui.getCanvas().addMouseMotionListener(mouseManager);

        Assets.init();

        handler = new Handler(this);

        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        endState = new EndState(handler);

        State.setState(menuState);

    }

    private void tick() {

        if (State.getState() != null) {
            State.getState().tick();
        }

    }

    private void render() {

        bufferStrategy = gui.getCanvas().getBufferStrategy();
        if(bufferStrategy == null) {
            gui.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        if (State.getState() != null) {
            State.getState().render(g);
        }

        bufferStrategy.show();
        g.dispose();

    }

    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;

        long timeNow;
        long lastTime = System.nanoTime();

        while (running) {
            timeNow = System.nanoTime();
            delta += (timeNow - lastTime) / timePerTick;
            lastTime = timeNow;

            if(delta >= 1) {
                tick();
                render();
                delta--;
            }
        }
        stop();
    }

    public void start() {
        if(running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start(); //ruft run() auf
    }

    public void stop() {
        if(!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public KeyManager getKeyManager() {
        return keyManager;
    }


    public MouseManager getMouseManager() {
        return mouseManager;
    }


}
