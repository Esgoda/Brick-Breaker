package setUp.logic;

import objects.Ball;
import objects.Player;

import java.awt.*;

public class CollisionLogic {
    private int score = 0;
    public void ballToPaddleCollisionLogic(Ball ball, Player player) {
        Rectangle ballCollisionRect = new Rectangle(ball.getxBallPos(), ball.getyBallPos(), 20, 20);
        Rectangle playerCollisionRect = new Rectangle(player.getxPlayerPos(), 550, 100, 8);

        if(ballCollisionRect.intersects(playerCollisionRect)) {
            ball.setyBallDir(-ball.getyBallDir());
        }
    }

    public void ballToBrickWallCollisionLogic(Ball ball, BrickWallGenerator brickWall){
        ballToBrickCollisionLogic(ball, brickWall);
    }

    private void ballToBrickCollisionLogic(Ball ball, BrickWallGenerator brickWall) {
        A:for(int i = 0; i < brickWall.getBrickWall().length; i++) {
            for(int j = 0; j < brickWall.getBrickWall()[0].length; j++) {
                if(brickWall.getBrickWall()[i][j] > 0) {
                    int xBrickPos = j * brickWall.getBrickWidth() + 80;
                    int yBrickPos = i * brickWall.getBrickHeight() + 50;

                    Rectangle brickCollisionRect = new Rectangle(xBrickPos, yBrickPos, brickWall.getBrickWidth(), brickWall.getBrickHeight());
                    Rectangle ballCollisionRect =  new Rectangle(ball.getxBallPos(), ball.getyBallPos(), 20, 20);

                    if(ballCollisionRect.intersects(brickCollisionRect)) {
                        setScore(getScore() + 5);
                        brickWall.updateWall(0, i, j);;
                        brickWall.setTotalBricks(brickWall.getTotalBricks() - 1);

                        //TODO add a very small noise variable to the direction
                        if((ball.getxBallPos() + 19) <= brickCollisionRect.x || (ball.getxBallPos() + 1) >= (brickCollisionRect.x + brickCollisionRect.width)) {
                            ball.setxBallDir(-ball.getxBallDir());
                        } else {
                            ball.setyBallDir(-ball.getyBallDir());
                        }
                        break A;
                    }
                }
            }
        }
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
