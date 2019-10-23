package setUp.logic;

import java.awt.*;

public class BrickWallGenerator {
    private int[][] brickWall;
    private int totalBricks;
    private int brickWidth;
    private int brickHeight;

    public BrickWallGenerator(){}

    //TODO make parameter single int with 'HowManyBricks' and derive row and col
    public BrickWallGenerator(int row, int col) {
        this.brickWidth = 540/col;
        this.brickHeight = 150/row;
        this.totalBricks = 21;

        brickWall = new int[row][col];
        generateBrickWall();
    }

    private void generateBrickWall() {
        for(int i = 0; i < brickWall.length; i++) {
            for(int j = 0; j < brickWall[0].length; j++) {
                brickWall[i][j] = 1;
            }
        }
    }

    private void drawBrick(Graphics2D g, int x, int y) {
        g.setColor(Color.cyan);
        g.fillRect(x, y, getBrickWidth(), getBrickHeight());

        g.setStroke(new BasicStroke(3));
        g.setColor(Color.BLACK);
        g.drawRoundRect(x, y, getBrickWidth(), getBrickHeight(), 5, 5);
    }

    public void drawWall(Graphics2D g) {
        for(int i = 0; i < brickWall.length; i++) {
            for (int j = 0; j < brickWall[0].length; j++) {
                if(brickWall[i][j] > 0) {
                    drawBrick(g, (j * getBrickWidth() + 80), (i * getBrickHeight() + 50));
                }
            }
        }
    }

    public void updateWall(int value, int row, int col) {
        brickWall[row][col] = value;
    }

    public int[][] getBrickWall() {
        return brickWall;
    }

    public int getTotalBricks() {
        return totalBricks;
    }

    public void setTotalBricks(int totalBricks) {
        this.totalBricks = totalBricks;
    }


    public int getBrickWidth() {
        return brickWidth;
    }

    public int getBrickHeight() {
        return brickHeight;
    }
}
