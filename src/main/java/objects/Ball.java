package objects;

import java.awt.*;

public class Ball {
    private int xBallPos, yBallPos, xBallDir, yBallDir;
    //120, 350, -1, -2
    public Ball() {}

    public Ball(int xBallPos, int yBallPos, int xBallDir, int yBallDir) {
        this.xBallPos = xBallPos;
        this.yBallPos = yBallPos;
        this.xBallDir = xBallDir;
        this.yBallDir = yBallDir;
    }

    public void draw(Graphics g) {
        g.setColor(Color.pink);
        g.fillOval(this.getxBallPos(), this.yBallPos, 20, 20);
    }

    public int getxBallPos() {
        return xBallPos;
    }

    public void setxBallPos(int xBallPos) {
        this.xBallPos = xBallPos;
    }

    public int getyBallPos() {
        return yBallPos;
    }

    public void setyBallPos(int yBallPos) {
        this.yBallPos = yBallPos;
    }

    public int getxBallDir() {
        return xBallDir;
    }

    public void setxBallDir(int xBallDir) {
        this.xBallDir = xBallDir;
    }

    public int getyBallDir() {
        return yBallDir;
    }

    public void setyBallDir(int yBallDir) {
        this.yBallDir = yBallDir;
    }
}
