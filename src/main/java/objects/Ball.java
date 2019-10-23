package objects;

import java.awt.*;

public class Ball extends GameObject {
    private int xBallPos, yBallPos, xBallDir, yBallDir;

    public Ball() {
        this.xBallPos = 350;
        this.yBallPos = 400;
        this.xBallDir = -1;
        this.yBallDir = -2;
    }

    public Ball(int xBallPos, int yBallPos, int xBallDir, int yBallDir) {
        this.xBallPos = xBallPos;
        this.yBallPos = yBallPos;
        this.xBallDir = xBallDir;
        this.yBallDir = yBallDir;
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
