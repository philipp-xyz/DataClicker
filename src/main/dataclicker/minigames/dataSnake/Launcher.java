package main.dataclicker.minigames.dataSnake;

import main.dataclicker.minigames.dataSnake.gui.Game;

public class Launcher {

    public static void main(String[] args) {

        Game game = new Game("DataSnake", 800, 800);
        game.start();

    }
}
