package main.dataclicker.minigames.dataSnake.entities;



import main.dataclicker.minigames.dataSnake.gui.Game;

import java.awt.*;

public class Parts {

    private int xCoord, yCoord, width, heigth;

    public Parts(int xCoord, int yCoord, int tileSize) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        width = tileSize;
        heigth = tileSize;

    }

    public void tick() {


    }

    public void draw(Graphics g) {
        /*g.setColor(Color.DARK_GRAY);
        g.fillRect(xCoord * width, yCoord * heigth, width, heigth);*/       //außenrand snake
        g.setColor(Color.GREEN);
        g.fillRect(xCoord * width + 2, yCoord * heigth + 2, width-2, heigth-2);

    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
}
