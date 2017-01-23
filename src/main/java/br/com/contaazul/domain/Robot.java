package br.com.contaazul.domain;

public class Robot {

    private int x;
    private int y;
    private Direction direction;

    public Robot() {
        this(0, 0, Direction.NORTH);
    }

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void increaseX() {
        x++;
    }

    public void increaseY() {
        y++;
    }

    public void decreaseX() {
        x--;
    }

    public void decreaseY() {
        y--;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %c)", x, y, direction.getCode());
    }

}
