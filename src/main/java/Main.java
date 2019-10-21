import setUp.mainFrameCreator;
import setUp.panels.gamePanel;

public class main {
    public static void main(String[] args) {
        mainFrameCreator gameContainer = new mainFrameCreator("Brick Breaker!", 10, 10, 700, 500);
        gameContainer.addPanel(new gamePanel());
    }
}

