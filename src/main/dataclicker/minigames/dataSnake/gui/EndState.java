package main.dataclicker.minigames.dataSnake.gui;

import main.dataclicker.minigames.dataSnake.Handler;

import java.awt.*;

public class EndState extends State {

    public EndState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
        if(handler.getMouseManager().isRightPressed()) {
            State.setState(handler.getGame().menuState);
        }

    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, handler.getWidth(), handler.getHeight());

        g.setColor(Color.RED);
        g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);

    }
}
