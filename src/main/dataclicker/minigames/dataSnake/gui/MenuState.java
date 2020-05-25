package main.dataclicker.minigames.dataSnake.gui;

import main.dataclicker.minigames.dataSnake.Handler;
import main.dataclicker.minigames.dataSnake.graphics.Assets;

import java.awt.*;


public class MenuState extends State{

    public Font menuFont = new Font("Arial", Font.BOLD, 20);

    private int scale;
    public boolean input = true;

    private Rectangle startButton = new Rectangle(handler.getWidth()/2-125, handler.getHeight()/2+50, 250, 75);


    public MenuState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
        if(input) {
            startButton();
        }

    }

    @Override
    public void render(Graphics g) {
        background(g);
        foreground(g);
    }

    public void startButton() {

        if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() >= startButton.x
                && handler.getMouseManager().getMouseX() <= startButton.x + startButton.width && handler.getMouseManager().getMouseY() >= startButton.y
                && handler.getMouseManager().getMouseY() <= startButton.y + startButton.height) {

            input = false;

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

        g.drawImage(Assets.logo, 50, 50, null);

        /*g.setColor(Color.RED);
        g.fillRect(handler.getWidth()/2-125, handler.getHeight()/2 + 50, 250, 75);*/

        g.drawImage(Assets.startButton, handler.getWidth() / 2 - 125 - 2 * scale, startButton.y + startButton.height - 75 - scale * 2, null);

        g.drawImage(Assets.keys, handler.getWidth()/2 - 40, handler.getHeight()/2 + 250, null);

    }

    public void background(Graphics g) {
        g.drawImage(Assets.menu_background1, 0, 0, null);

    }


}
