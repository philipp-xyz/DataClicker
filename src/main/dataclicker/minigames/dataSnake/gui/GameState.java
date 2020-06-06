package main.dataclicker.minigames.dataSnake.gui;

import main.dataclicker.minigames.dataSnake.Handler;
import main.dataclicker.minigames.dataSnake.entities.Collision;
import main.dataclicker.minigames.dataSnake.entities.Snake;
import main.dataclicker.minigames.dataSnake.graphics.Assets;
import main.dataclicker.minigames.dataSnake.input.Direction;
import java.awt.*;

public class GameState extends State {

    Point p;

    public GameState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {

        try {
            Thread.sleep(100);

            Snake.move();
            Snake.waitToMove = false;

            handler.getGame().endState.moneyAdded = false;

            Collision.collidePickup();

            if(Collision.collideSelf() || Collision.collideWall()) {
                Snake.tails.clear();
                State.setState(handler.getGame().endState);
                Snake.head.setX(10);
                Snake.head.setY(10);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void render(Graphics g) {
        grid(g);
        drawHead(g);
        drawTail(g);
        drawPickup(g);

    }

    public void grid(Graphics g) {
        for(int i = 0; i < 25; i++) {
            for(int j = 0; j < 25; j++) {
                //g.drawRect(i * 32, j * 32, 32, 32);
                g.drawImage(Assets.grassTileBorder, i * 32, j * 32, null);
            }
        }
    }

    public void drawHead(Graphics g) {
        if(Snake.head.getDirection() == Direction.W) {
            p = Snake.ptc(Snake.head.getX(), Snake.head.getY());
            g.drawImage(Assets.head_W, p.x, p.y, null);
        }

        if(Snake.head.getDirection() == Direction.A) {
            p = Snake.ptc(Snake.head.getX(), Snake.head.getY());
            g.drawImage(Assets.head_A, p.x, p.y, null);
        }

        if(Snake.head.getDirection() == Direction.S) {
            p = Snake.ptc(Snake.head.getX(), Snake.head.getY());
            g.drawImage(Assets.head_S, p.x, p.y, null);
        }

        if(Snake.head.getDirection() == Direction.D) {
            p = Snake.ptc(Snake.head.getX(), Snake.head.getY());
            g.drawImage(Assets.head_D, p.x, p.y, null);
        }
    }

    public void drawTail(Graphics g) {
        for(int i = 0; i < Snake.tails.size(); i++) {
            p = Snake.ptc(Snake.tails.get(i).getX(), Snake.tails.get(i).getY());
            g.drawImage(Assets.tail, p.x, p.y, null);
        }
    }

    protected void drawPickup(Graphics g) {

        /*try {
            image = ImageIO.read(getClass().getResourceAsStream("/data.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        p = Snake.ptc(Snake.pickUp.getX(), Snake.pickUp.getY());
        g.drawImage(Assets.data, p.x, p.y, null);
    }


}
