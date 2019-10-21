package setUp;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class frameCreatorTest {
    private MainFrameCreator frame;

    @Test
    public void createFrameMethod() {
        //assemble
        String expected = "Testing Frame";
        int x = 10;
        int y = 10;
        int width = 700;
        int height = 500;
        //act
        frame = new MainFrameCreator(expected, x, y, width, height);
        //assert
        assertEquals(expected, frame.getTitle());
    }
}
