package objects;

import java.awt.*;

public class Brick {
    private boolean hitOrNot = false;

    public Brick(){}

    public void draw(Graphics g) {

    }

    public boolean isHitOrNot() {
        return hitOrNot;
    }

    public void setHitOrNot(boolean hitOrNot) {
        this.hitOrNot = hitOrNot;
    }
}
