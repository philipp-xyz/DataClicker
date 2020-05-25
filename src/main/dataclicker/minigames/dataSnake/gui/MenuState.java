package main.dataclicker.minigames.dataSnake.gui;

import main.dataclicker.minigames.dataSnake.Handler;

import java.awt.*;

public class MenuState extends State{

    private Font menuFont = new Font("Arial", Font.BOLD, 20);
    private int scale;

    private boolean ready = false;
    private boolean input = true;

    private Rectangle startButton = new Rectangle(handler.getWidth()/2-125, handler.getHeight()/2+50, 250, 75);


    public MenuState(Handler handler) {
        super(handler);

    }

    @Override
    public void tick() {
        /*if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed()) {
            State.setState(handler.getGame().gameState);
        }*/

        if(input) {
            startButton();
        }

    }

    @Override
    public void render(Graphics g) {

        foreground(g);

        //Hintergrund
        /*g.setColor(Color.lightGray);
        g.fillRect(0, 0, handler.getWidth(), handler.getHeight());*/

        //test
        /*g.setColor(Color.RED);
        //g.fillRect(280, 500, 250, 100);
        g.fillRect(handler.getWidth()/2-125, handler.getHeight()/2 + 50, 250, 75);*/

        /*g.setColor(Color.BLACK);
        g.setFont(menuFont);
        g.drawString("Linke und Rechte Maustaste gleichzeitig druecken um zu starten", 100, 100);*/

        /*g.setColor(Color.RED);
        g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
        //g.fillRect(100, 100, 100, 100);*/

    }

    public void startButton() {

        if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() >= startButton.x
                && handler.getMouseManager().getMouseX() <= startButton.x + startButton.width && handler.getMouseManager().getMouseY() >= startButton.y
                && handler.getMouseManager().getMouseY() <= startButton.y + startButton.height) {

            input = false;
            ready = true;
            if(handler.getMouseManager().isLeftPressed()) {
                State.setState(handler.getGame().gameState);
            }
        }

        if(handler.getMouseManager().getMouseX() >= startButton.x && handler.getMouseManager().getMouseX() <= startButton.x + startButton.width
        && handler.getMouseManager().getMouseY() >= startButton.y && handler.getMouseManager().getMouseY() <= startButton.y + startButton.height) {
            if(scale <= 10) {
                scale++;
            }
        } else {
            if(scale >= 0) {
                scale--;
            }
        }
    }

    public void foreground(Graphics g) {

        /*g.setColor(Color.RED);
        g.fillRect(handler.getWidth()/2-125, handler.getHeight()/2 + 50, 250, 75);*/

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 60 + scale));
        g.drawString("Start", handler.getWidth() / 2 - 75 - 2 * scale, startButton.y + startButton.height - 25);
    }



    public void restart() {
        input = true;
        ready = false;
    }



}
