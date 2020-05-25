package main.dataclicker.minigames.dataSnake.graphics;

import java.awt.image.BufferedImage;

public class Assets {


    private static final int width = 32, height = 32;

    public static BufferedImage data, tail, grassTile, grassTileBorder;
    public static BufferedImage head_W, head_A, head_S, head_D;


    public static void init() {

        SpriteSheet dataSheet = new SpriteSheet(ImageLoader.loadImage("/data.png"));
        SpriteSheet headSheet = new SpriteSheet(ImageLoader.loadImage("/headSheet.png"));
        SpriteSheet tailSheet = new SpriteSheet(ImageLoader.loadImage("/tail.png"));
        SpriteSheet grassWithBorder = new SpriteSheet(ImageLoader.loadImage("/tile_border.png"));
        SpriteSheet grassSheet = new SpriteSheet(ImageLoader.loadImage("/tile.png"));


        //Data
        data = dataSheet.crop(0, 0, width, height);

        //Hintergrund
        grassTile = grassSheet.crop(0, 0, width, height);
        grassTileBorder = grassWithBorder.crop(0, 0, width, height);

        //Schlange
        head_W = headSheet.crop(0, 0, width, height);
        head_A = headSheet.crop(width, 0, width, height);
        head_S = headSheet.crop(width * 2, 0, width, height);
        head_D = headSheet.crop(width * 3, 0, width, height);
        tail = tailSheet.crop(0, 0, width, height);


    }

}
