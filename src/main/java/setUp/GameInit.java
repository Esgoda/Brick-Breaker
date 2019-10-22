package setUp;

import objects.Ball;
import objects.Player;
import setUp.frames.MainFrame;
import setUp.panels.GamePanel;

public class GameInit {
    private static final int X = 10;
    private static final int Y = 10;
    private static final int HEIGHT = 620;
    private static final int WIDTH = 700;
    private static final int DELAY = 8;
    private static final int PLAYER_START_POS = 310;
    private static final String TITLE = "Brick Breaker!";
    private static final int TOTAL_BRICKS = 21;

    private Player player;
    private Ball ball;

    public GameInit(){}

    public GameInit(Player player, Ball ball){
        this.player = player;
        this.ball = ball;
    }

    public void runGame(){
        player = new Player(PLAYER_START_POS);
        ball = new Ball();

        MainFrame gameContainer = new MainFrame(TITLE, X, Y, WIDTH, HEIGHT);
        GamePanel screen = new GamePanel(player, ball, DELAY);
        gameContainer.addPanel(screen);

        screen.getTimer().start();
    }
}
