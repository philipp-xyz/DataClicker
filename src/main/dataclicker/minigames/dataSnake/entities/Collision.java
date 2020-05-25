package main.dataclicker.minigames.dataSnake.entities;

public class Collision {

    public static boolean collideSelf() {
        for(int i = 0; i < Snake.tails.size(); i++) {
            if(Snake.head.getX() == Snake.tails.get(i).getX() && Snake.head.getY() == Snake.tails.get(i).getY() && !Snake.tails.get(i).isWait()) {
                return true;
            }
        }
        return false;
    }

    public static boolean collideWall() {
        return (Snake.head.getX() < 0 || Snake.head.getX() > 25 || Snake.head.getY() < 0 || Snake.head.getY() > 25);
    }

    public static void collidePickup() {
        if(Snake.head.getX() == Snake.pickUp.getX() && Snake.head.getY() == Snake.pickUp.getY()) {
            Snake.pickUp.reset();
            Snake.addTail();

            Snake.score += 100;
            System.out.println(Snake.score);
        }
    }
}
