package main.dataclicker.minigames.dataSnake.gui;

import main.dataclicker.minigames.dataSnake.Handler;
import main.dataclicker.minigames.dataSnake.entities.Snake;
import main.dataclicker.minigames.dataSnake.graphics.Assets;
import main.dataclicker.player.Player;

import java.awt.*;

public class EndState extends State {

    private Rectangle restartButton = new Rectangle(handler.getWidth()/2-125, handler.getHeight()/2+50, 250, 75);

    private int scale;
    private boolean input = true;
    public boolean dataAdded = false;

    private Player player;


    public EndState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
        if(input) {
            restartButton();
        }

    }

    @Override
    public void render(Graphics g) {

        background(g);
        foreground(g);

    }

    private void restartButton() {

        if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() >= restartButton.x
                && handler.getMouseManager().getMouseX() <= restartButton.x + restartButton.width && handler.getMouseManager().getMouseY() >= restartButton.y
                && handler.getMouseManager().getMouseY() <= restartButton.y + restartButton.height) {

            input = false;
            System.out.println(input + " 1");

            System.out.println(handler.getMouseManager().isLeftPressed());
            System.out.println("data" + dataAdded);

            if(handler.getMouseManager().isLeftPressed() && dataAdded == false) {
                State.setState(handler.getGame().gameState);
                player.setDataAmount(Player.getDataAmount() + Snake.score);
                Snake.score = 0;
                dataAdded = true;
                input = true;
                System.out.println(input + " 2");

            }
        }

        if(handler.getMouseManager().getMouseX() >= restartButton.x && handler.getMouseManager().getMouseX() <= restartButton.x + restartButton.width
                && handler.getMouseManager().getMouseY() >= restartButton.y && handler.getMouseManager().getMouseY() <= restartButton.y + restartButton.height) {
            if(scale <= 10) {
                scale++;
            }
        } else {
            if(scale >= 0) {
                scale--;
            }
        }

    }

    private void foreground(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 60));
        g.drawString("Data: " + Snake.score, 50, 400);

        g.drawString("Gesamt: " + player.getDataAmount(), 300, 400); //How I get dataAmount??

        g.setColor(Color.RED);
        g.fillRect(handler.getWidth()/2-125, handler.getHeight()/2 + 50, 250, 75);

        g.drawImage(Assets.startButton, handler.getWidth() / 2 - 125 - 2 * scale, restartButton.y + restartButton.height - 75 - scale * 2, null);

    }

    private void background(Graphics g) {
        g.drawImage(Assets.menu_background1, 0, 0, null);
        g.drawImage(Assets.logo, 50, 50, null);
    }
}
