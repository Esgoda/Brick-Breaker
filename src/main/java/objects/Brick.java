package objects;

import java.awt.*;

public class Brick extends GameObject{
    private int hitOrNot = 1;
    private int width, height;
    public Brick(){}

    public Brick(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void paint(Graphics2D g, int x, int y) {
        g.setColor(Color.cyan);
        g.fillRect(x, y, getWidth(), getHeight());

        g.setStroke(new BasicStroke(3));
        g.setColor(Color.DARK_GRAY);
        g.drawRect(x, y, getWidth(), getHeight());
    }

    public int getIsHitOrNot() {
        return hitOrNot;
    }

    public void setIsHitOrNot(int hitOrNot) {
        this.hitOrNot = hitOrNot;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
