package objects;

import java.awt.*;

public class Player extends GameObject{
    private int xPlayerPos;

    public Player(){}

    public Player(int xPlayerPos) {
        this.xPlayerPos = xPlayerPos;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(this.xPlayerPos, 550, 100, 8);
    }

    public void moveRight() {
        setxPlayerPos(getxPlayerPos()+20);
    }

    public void moveLeft() {
        setxPlayerPos(getxPlayerPos()-20);
    }

    public int getxPlayerPos() {
        return xPlayerPos;
    }

    public void setxPlayerPos(int xPlayerPos) {
        this.xPlayerPos = xPlayerPos;
    }
}
