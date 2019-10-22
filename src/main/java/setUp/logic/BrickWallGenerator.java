package setUp.logic;

import objects.Brick;

import java.awt.*;

public class BrickWallGenerator {
    private Brick brick;
    private int[][] wall;
    private int width;
    private int height;

    public BrickWallGenerator(){}

    //TODO make parameter single int with 'HowManyBricks' and derive row and col
    public BrickWallGenerator(int row, int col) {
        this.width = 540/col;
        this.height = 150/row;

        wall = new int[row][col];
        brick = new Brick(width, height);
    }

    public void drawWall(Graphics2D g) {
        generateBrickWall();
        for(int i = 0; i < wall.length; i++) {
            for (int j = 0; j < wall[0].length; j++) {
                if(wall[i][j] > 0) {
                    brick.paint(g, (j * getWidth() + 80), (i * getHeight() + 50));
                }
            }
        }
    }

    private void generateBrickWall() {
        for(int i = 0; i < wall.length; i++) {
            for(int j = 0; j < wall[0].length; j++) {
                wall[i][j] = brick.getIsHitOrNot();
            }
        }
    }

    public int[][] getWall() {
        return wall;
    }

    public void setWall(int[][] wall) {
        this.wall = wall;
    }

    public Brick getBrick() {
        return brick;
    }

    public void setBrick(Brick brick) {
        this.brick = brick;
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
