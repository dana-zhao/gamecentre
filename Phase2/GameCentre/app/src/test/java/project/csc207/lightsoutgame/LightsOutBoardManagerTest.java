package project.csc207.lightsoutgame;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertEquals;

public class LightsOutBoardManagerTest {

    private LightsOutBoardManager testBoardManager = new LightsOutBoardManager();
    private LightsOutBoard testBoard = testBoardManager.getLightsOutBoard();

    @Test
    public void testAllLightsOut() {
        testBoard.getLight(4, 4).setLight(true);
        LightsOutTestHelpMethods.getLightsAllOff(testBoard);
        Light testLight = testBoard.getLight(0,0);
        testLight.setLight(true);
        assertFalse(testBoardManager.allLightsOut());
        testLight.setLight(false);
        assertTrue(testBoardManager.allLightsOut());
    }

    @Test
    public void testGetLightsAround() {
        //Test light in the middle of the grid
        List<Light> results = testBoardManager.getLightsAround(7);
        assertEquals(7, results.get(0).getId());
        assertEquals(2, results.get(1).getId());
        assertEquals(12, results.get(2).getId());
        assertEquals(6, results.get(3).getId());
        assertEquals(8, results.get(4).getId());
        assertEquals(5, results.size());
        //Test light on the side of the grid
        results = testBoardManager.getLightsAround(9);
        assertEquals(9, results.get(0).getId());
        assertEquals(4, results.get(1).getId());
        assertEquals(14, results.get(2).getId());
        assertEquals(8, results.get(3).getId());
        assertEquals(4, results.size());
    }

    @Test
    public void testTouchToSwitch() {
        LightsOutTestHelpMethods.getLightsAllOn(testBoard);
        testBoardManager.touchToSwitch(7);
        assertFalse(testBoard.getLight(0, 2).getState());
        assertFalse(testBoard.getLight(1, 1).getState());
        assertFalse(testBoard.getLight(2, 2).getState());
        assertFalse(testBoard.getLight(1, 3).getState());
        testBoardManager.touchToSwitch(7);
        assertTrue(testBoard.getLight(0, 2).getState());
        assertTrue(testBoard.getLight(1, 1).getState());
        assertTrue(testBoard.getLight(2, 2).getState());
        assertTrue(testBoard.getLight(1, 3).getState());
    }
}
