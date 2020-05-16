package main.dataclicker.minigames.dataSnake.gui;

import main.dataclicker.minigames.dataSnake.Handler;

import java.awt.*;

public class MenuState extends State{


    public MenuState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
        if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed()) {
            State.setState(handler.getGame().gameState);
        }

    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.lightGray);
        g.fillRect(0, 0, handler.getWidth(), handler.getHeight());

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Linke und Rechte Maustaste gleichzeitig druecken um zu starten", 100, 100);

        g.setColor(Color.RED);
        g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
        //g.fillRect(100, 100, 100, 100);

    }
}
