package project.csc207.lightsOutGame;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Stack;

/**
 * the Board for Lights Out Game
 */

public class LightsOutBoard implements Serializable, Iterable<Light> {


    static int NUM_ROWS = 5;

    static int NUM_COLS = 5;

    /**
     * All the moves made to the board.
     */

    private Light[][] lights = new Light[NUM_COLS][NUM_ROWS];


    /**
     * A new board of tiles in row-major order.
     * Precondition: len(tiles) == NUM_ROWS * NUM_COLS
     *
     * @param lights the tiles for the board
     */
    LightsOutBoard(List<Light> lights) {
        Iterator<Light> iter = lights.iterator();

        for (int row = 0; row != LightsOutBoard.NUM_ROWS; row++) {
            for (int col = 0; col != LightsOutBoard.NUM_COLS; col++) {
                this.lights[row][col] = iter.next();
            }
        }
    }


    public Light getLight(int row, int col){
        return lights[row][col];
    }

    public int numLights() {
        return NUM_COLS*NUM_COLS;
    }

    @NonNull
    @Override
    public String toString() {
        return "Board{" +
                "tiles=" + Arrays.toString(lights) +
                '}';
    }

    @NonNull
    public Iterator<Light> iterator() {
        return new LightsOutBoardIterator();
    }

    class LightsOutBoardIterator implements Iterator<Light>{
        /**
         * The row of the current tile.
         */
        int row = 0;

        /**
         * The column of the current tile.
         */
        int col = 0;

        @Override
        public boolean hasNext() {
            return !(getLight(row, col).getId() == (NUM_COLS * NUM_ROWS));
        }

        @Override
        public Light next() {
            Light next = getLight(row, col);
            if (col < NUM_COLS - 1) {
                col++;
            } else {
                if (row == NUM_ROWS - 1) {
                    col = NUM_COLS - 1;
                    row = NUM_ROWS - 1;
                } else {
                    row++;
                    col = 0;
                }

            }
            return next;
        }
    }
}

