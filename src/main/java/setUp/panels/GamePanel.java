package setUp.panels;

import objects.Ball;
import objects.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends Panel implements KeyListener, ActionListener {
    private boolean gameStart, gameEnd;
    private Player player;
    private Ball ball;
    private Timer timer;

    public GamePanel(Player player, Ball ball, int delay){
        this.player = player;
        this.ball = ball;

        //set the listener in the main game panel
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
    }

    @Override
    public void paint(Graphics g) {
        //background
        g.setColor(Color.darkGray);
        g.fillRect(1, 1, 692, 592);

        //border
        g.setColor(Color.orange);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 690, 3);
        g.fillRect(690, 0, 3, 592);

        getPlayer().paint(g);
        getBall().paint(g);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
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
