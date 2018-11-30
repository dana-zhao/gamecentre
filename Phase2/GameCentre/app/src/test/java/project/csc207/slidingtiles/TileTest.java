package project.csc207.slidingtiles;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import project.csc207.R;

public class TileTest {

    private Tile t1;
    private Tile t2;


    @Test
    public void constructorTest() {
        t1 = new Tile(1,1);
        t2 = new Tile(1);

        assertEquals(1, t1.getId());
        assertEquals(1, t1.getBackground());
        assertEquals(2, t2.getId());
        assertEquals(R.drawable.tile_2, t2.getBackground());

    }

    @Test
    public void compareTo() {
        assertEquals(1, t1.compareTo(t2));
    }
}