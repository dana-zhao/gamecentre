package project.csc207.lightsOutGame;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.*;
import static org.junit.Assert.assertEquals;

public class LightsOutBoardManagerTest {

    private LightsOutBoardManager testBoardManager = new LightsOutBoardManager();
    private LightsOutBoard testBoard = testBoardManager.getLightsOutBoard();

    @Before
    public void setUp(){
        LightsOutTestHelpMethods.getLightsAllOn(testBoard);
    }

    @Test
    public void testAllLightsOut() {
        Light testLight = testBoard.getLight(0,0);
        testLight.setLight(false);
        assertFalse(testBoardManager.allLightsOut());
        testLight.setLight(true);
        assertTrue(testBoardManager.allLightsOut());
    }

    @Test
    public void testGetLightsAround() {

    }
}
