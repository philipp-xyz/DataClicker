package main.dataclicker.minigames.dataSnake.input;

import main.dataclicker.minigames.dataSnake.entities.Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_W:
                if(!(Snake.head.getDirection() == Direction.S && Snake.waitToMove)) {
                    Snake.head.setDirection(Direction.W);
                    Snake.waitToMove = true;
                }
                break;
            case KeyEvent.VK_A:
                if(!(Snake.head.getDirection() == Direction.D && Snake.waitToMove)) {
                    Snake.head.setDirection(Direction.A);
                    Snake.waitToMove = true;
                }
                break;
            case KeyEvent.VK_D:
                if(!(Snake.head.getDirection() == Direction.A && Snake.waitToMove)) {
                    Snake.head.setDirection(Direction.D);
                    Snake.waitToMove = true;
                }
                break;
            case KeyEvent.VK_S:
                if(!(Snake.head.getDirection() == Direction.W && Snake.waitToMove)) {
                    Snake.head.setDirection(Direction.S);
                    Snake.waitToMove = true;
                }
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
