package project.csc207.lightsOutGame;
import org.junit.*;

import project.csc207.R;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertEquals;

public class LightTest {

    private Light testLight = new Light(0);

    @Test
    public void testGetId() {
        int result = testLight.getId();
        int correctId = 0;
        assertEquals(correctId, result);
    }

    @Test
    public void testGetState() {
        boolean result = testLight.getState();
        assertTrue(result);
    }

    @Test
    public void testGetBackground() {
        int result = testLight.getBackground();
        assertEquals(R.drawable.lightson, result);
    }

    @Test
    public void testSwitchLight() {
        testLight.switchLight();
        assertFalse(testLight.getState());
        testLight.switchLight();
        assertTrue(testLight.getState());
    }

    @Test
    public void testSetLight() {
        testLight.setLight(false);
        assertFalse(testLight.getState());
        testLight.setLight(true);
        assertTrue(testLight.getState());
    }

}
