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

    public GameInit(){}

    public void runGame(){
        Player player = new Player(PLAYER_START_POS);
        Ball ball = new Ball();

        MainFrame gameContainer = new MainFrame(TITLE, X, Y, WIDTH, HEIGHT);
        GamePanel screen = new GamePanel(player, ball, DELAY);
        gameContainer.addPanel(screen);

        screen.getTimer().start();
    }
}
