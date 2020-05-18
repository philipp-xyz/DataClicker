package main.dataclicker.minigames.dataSnake;

import main.dataclicker.inputs.MouseManager;
import main.dataclicker.minigames.dataSnake.gui.Game;
import main.dataclicker.minigames.dataSnake.input.KeyManager;

public class Handler {


    private Game game;

    public Handler(Game game) {
        this.game = game;
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }

    public int getWidth() {
        return game.width;
    }

    public int getHeight() {
        return game.height;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
