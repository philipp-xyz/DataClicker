package main.dataclicker.minigames.dataSnake.entities;

import java.util.concurrent.ThreadLocalRandom;

public class PickUp {

    public int x, y;

    public PickUp() {
        this.x = ThreadLocalRandom.current().nextInt(0, 25);
        this.y = ThreadLocalRandom.current().nextInt(0, 25);
    }

    public void reset() {
        this.x = ThreadLocalRandom.current().nextInt(0, 25);
        this.y = ThreadLocalRandom.current().nextInt(0, 25);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
