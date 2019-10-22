package objects;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Player player;

    @Before
    public void setUp() {
        player = new Player();
    }

    @Test
    public void moveRight() {
        //assemble
        int expected = 120;
        player.setxPlayerPos(100);
        //act
        player.moveRight();
        int actual = player.getxPlayerPos();
        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void moveLeft() {
        //assemble
        int expected = 80;
        player.setxPlayerPos(100);
        //act
        player.moveLeft();
        int actual = player.getxPlayerPos();
        //assert
        assertEquals(expected, actual);
    }
}
