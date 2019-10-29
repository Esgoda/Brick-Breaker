package objects;

import java.awt.*;

public class Ball extends GameObject {
    private static final int X_START_POS = 250;
    private static final int Y_START_POS = 400;
    private static final int X_START_DIR = -1;
    private static final int Y_START_DIR = -2;

    private int xBallPos, yBallPos, xBallDir, yBallDir;

    public Ball() {
        this.xBallPos = X_START_POS;
        this.yBallPos = Y_START_POS;
        this.xBallDir = X_START_DIR;
        this.yBallDir = Y_START_DIR;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.pink);
        g.fillOval(getxBallPos(), getyBallPos(), 20, 20);
    }

    public void ballMovement() {
        setxBallPos(getxBallPos() + getxBallDir());
        setyBallPos(getyBallPos() + getyBallDir());

        ballDirection();
    }

    private void ballDirection() {
        if(getxBallPos() < 0) {
            setxBallDir(-getxBallDir());
        }
        if(getyBallPos() < 0) {
            setyBallDir(-getyBallDir());
        }
        if(getxBallPos() > 670) {
            setxBallDir(-getxBallDir());
        }
    }

    public int getxBallPos() {
        return xBallPos;
    }

    private void setxBallPos(int xBallPos) {
        this.xBallPos = xBallPos;
    }

    public int getyBallPos() {
        return yBallPos;
    }

    private void setyBallPos(int yBallPos) {
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
