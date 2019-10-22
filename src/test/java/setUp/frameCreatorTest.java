package setUp;

import org.junit.Test;
import setUp.frames.MainFrame;

import static org.junit.Assert.assertEquals;

public class frameCreatorTest {
    private MainFrame frame;

    @Test
    public void createFrameMethod() {
        //assemble
        String expected = "Testing Frame";
        int x = 10;
        int y = 10;
        int width = 700;
        int height = 500;
        //act
        frame = new MainFrame(expected, x, y, width, height);
        //assert
        assertEquals(expected, frame.getTitle());
    }
}
