import objects.Ball;
import objects.Brick;
import objects.Player;
import setUp.MainFrameCreator;
import setUp.panels.GamePanel;

import javax.swing.Timer;

public class GamePlay {
    private boolean play = false;
    private int delay = 8;
    private int totalBricks = 21;
    private Player player;
    private Ball ball;
    private Brick brick;

    public GamePlay(){}

    public GamePlay(Player player, Ball ball, int totalBricks){
        this.player = player;
        this.ball = ball;
        this.totalBricks = totalBricks;
    }

    public void runGame(){
        player = new Player(310);
        ball = new Ball(120, 350, -1, -2);
        MainFrameCreator gameContainer = new MainFrameCreator("Brick Breaker!", 10, 10, 700, 620);
        GamePanel screen = new GamePanel(player, ball, delay);
        gameContainer.addPanel(screen);
        screen.getTimer().start();
    }
}