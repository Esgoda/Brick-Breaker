package setUp.logic;

import objects.Ball;
import objects.Player;

import java.awt.*;

public class CollisionLogic {
    public void ballToPaddleCollisionLogic(Ball ball, Player player) {
        Rectangle ballCollisionRect = new Rectangle(ball.getxBallPos(), ball.getyBallPos(), 20, 20);
        Rectangle playerCollisionRect = new Rectangle(player.getxPlayerPos(), 550, 100, 8);

        if(ballCollisionRect.intersects(playerCollisionRect)) {
            ball.setyBallDir(-ball.getyBallDir());
        }
    }
}
