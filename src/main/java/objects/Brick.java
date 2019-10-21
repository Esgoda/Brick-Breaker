package objects;

import java.awt.*;

public class Brick {
    private boolean hitOrNot = false;

    public Brick(){}

    public Brick(int howMany) {}

    public void paint(Graphics g) {
        g.setColor(Color.cyan);
    }

    public boolean isHitOrNot() {
        return hitOrNot;
    }

    public void setHitOrNot(boolean hitOrNot) {
        this.hitOrNot = hitOrNot;
    }
}
