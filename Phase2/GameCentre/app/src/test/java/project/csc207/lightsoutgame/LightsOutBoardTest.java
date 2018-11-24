package project.csc207.lightsoutgame;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertEquals;

public class LightsOutBoardTest {

    private LightsOutBoardManager testBoardManager = new LightsOutBoardManager();
    private LightsOutBoard testBoard = testBoardManager.getLightsOutBoard();
    private LightsOutTestHelpMethods helper = new LightsOutTestHelpMethods();

    @Before
    public void setUp(){
        helper.getLightsAllOn(testBoard);
    }

    @Test
    public void testGetLight() {
        Light result = testBoard.getLight(0, 0);
        assertEquals(0, result.getId());
        assertTrue(result.getState());
        result = testBoard.getLight(2, 4);
        assertEquals(14, result.getId());
    }
}
