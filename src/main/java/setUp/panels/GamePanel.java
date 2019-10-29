package setUp.panels;

import objects.Ball;
import objects.Player;
import setUp.logic.BrickWallGenerator;
import setUp.logic.CollisionLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends Panel implements KeyListener, ActionListener {
    private CollisionLogic collisionLogic = new CollisionLogic();
    private BrickWallGenerator wallGenerator = new BrickWallGenerator(3, 7);
    private Image backgroundImage;
    private boolean gameStart;
    private int score;
    private Timer timer;
    private Player player;
    private Ball ball;

    public GamePanel(Player player, Ball ball, int delay) {
        this.player = player;
        this.ball = ball;
        this.score = 0;
        this.gameStart = false;

        //set the listener in the main game panel
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        timer = new Timer(delay, this);
        backgroundImage = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/images/game_background.png"));
    }

    @Override
    public void paint(Graphics g) {
        //background
        g.drawImage(backgroundImage, 0, 0, null);

        wallGenerator.drawWall((Graphics2D)g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("serif", Font.BOLD, 20));
        g.drawString("SCORE: " + score, 570, 30);

        endGameListener(g);
        winGameListener(g);

        getPlayer().paint(g);
        getBall().paint(g);

        g.dispose();
    }

    private void endGameListener(Graphics g) {
        if (ball.getyBallPos() > 590) {
            g.setColor(Color.RED);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("GAME OVER", 250, 300);

            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Score: " + score, 290, 350);

            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to restart", 250, 400);
        }
    }

    private void winGameListener(Graphics g) {
        if(wallGenerator.getTotalBricks() <=0 ) {
            g.setColor(Color.RED);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("WINNER", 260, 300);

            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Score: " + score, 270, 350);

            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to restart", 250, 400);

            ball.setxBallDir(0);
            ball.setyBallDir(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        collisionLogic.ballToPaddleCollisionLogic(getBall(), getPlayer());
        score = collisionLogic.getScore();
        if(gameStart) {
            ball.ballMovement();
            collisionLogic.ballToBrickWallCollisionLogic(getBall(), wallGenerator);
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        gameStart = true;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(player.getxPlayerPos() >= 600) {
                player.setxPlayerPos(600);
            } else {
                player.moveRight();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(player.getxPlayerPos() < 10) {
                player.setxPlayerPos(10);
            } else {
                player.moveLeft();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            restartGame();
            gameStart = true;
        }
    }

    private void restartGame() {
        ball = new Ball();
        collisionLogic.setScore(0);
        player = new Player(310);
        wallGenerator = new BrickWallGenerator(3, 7);
        timer.restart();

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    private Player getPlayer() {
        return player;
    }

    private Ball getBall() {
        return ball;
    }

    public Timer getTimer() {
        return timer;
    }
}
