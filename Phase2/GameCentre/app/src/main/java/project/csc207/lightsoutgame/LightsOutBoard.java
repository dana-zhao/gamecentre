package project.csc207.lightsoutgame;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * the Board for Lights Out Game
 */

public class LightsOutBoard implements Serializable, Iterable<Light> {

    /**
     * Length of rows
     */
    static int NUM_ROWS = 5;

    /**
     * Length of columns
     */
    static int NUM_COLS = 5;

    /**
     * All the moves made to the board.
     */

    private Light[][] lights = new Light[NUM_COLS][NUM_ROWS];


    /**
     * A new board of lights in row-major order.
     * Precondition: len(lights) == NUM_ROWS * NUM_COLS
     *
     * @param lights the lights for the board
     */
    LightsOutBoard(List<Light> lights) {
        Iterator<Light> iter = lights.iterator();

        for (int row = 0; row != LightsOutBoard.NUM_ROWS; row++) {
            for (int col = 0; col != LightsOutBoard.NUM_COLS; col++) {
                this.lights[row][col] = iter.next();
            }
        }
    }


    Light getLight(int row, int col){
        return lights[row][col];
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
         * The row of the current light.
         */
        int row = 0;

        /**
         * The column of the current light.
         */
        int col = 0;

        /**
         * Id of light.
         */
        int id = 0;

        @Override
        public boolean hasNext() {
            return id < (NUM_COLS * NUM_ROWS);
        }

        @Override
        public Light next() {
            Light nextLight = getLight(row, col);
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
            id++;
            return nextLight;
        }
    }
}

