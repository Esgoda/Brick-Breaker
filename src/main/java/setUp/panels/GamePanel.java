package setUp.panels;

import objects.Ball;
import objects.Player;
import setUp.logic.BrickWallGenerator;
import setUp.logic.CollisionLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends Panel implements KeyListener, ActionListener {
    private CollisionLogic ballPlayerCollision = new CollisionLogic();
    private BrickWallGenerator wallGenerator = new BrickWallGenerator(3, 7);
    private Image backgroundImage;
    private boolean gameStart = false, gameEnd = false;
    private Timer timer;
    private Player player;
    private Ball ball;

    public GamePanel(Player player, Ball ball, int delay) {
        this.player = player;
        this.ball = ball;

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

        getPlayer().paint(g);
        getBall().paint(g);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        ballPlayerCollision.ballToPaddleCollisionLogic(getBall(), getPlayer());
        ball.ballMovement(gameStart);
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
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public boolean isGameStart() {
        return gameStart;
    }

    public void setGameStart(boolean gameStart) {
        this.gameStart = gameStart;
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
