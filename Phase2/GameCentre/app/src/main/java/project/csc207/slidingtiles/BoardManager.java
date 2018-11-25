package project.csc207.slidingtiles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manage a board, including swapping tiles, checking for a win, and managing taps.
 */
public class BoardManager implements Serializable {

    /**
     * The board being managed.
     */
    private Board board;


    /**
     * Manage a board that has been pre-populated.
     *
     * @param board the board
     */
    BoardManager(Board board) {
        this.board = board;
    }

    /**
     * Return the current board.
     */
    Board getBoard() {
        return board;
    }

    /**
     * Manage a new shuffled board.
     *
     * @param boardSize the size of the board.
     */
    BoardManager(int boardSize) {
        List<Tile> tiles = new ArrayList<>();
        final int numTiles = boardSize * boardSize;
        for (int tileNum = 0; tileNum != numTiles - 1; tileNum++) {
            tiles.add(new Tile(tileNum));
        }
        tiles.add(new Tile(24));
        Collections.shuffle(tiles);
        this.board = new Board(tiles, boardSize);
//        while (!(isSolvable(boardSize, tiles))){
//            Collections.shuffle(tiles);
//        }
        this.board = new Board(tiles, boardSize);
    }

//    /**
//     * Check to make sure board is solvable
//     * Citations: https://www.geeksforgeeks.org/check-instance-15-puzzle-solvable/
//     * https://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html?
//     * @param boardSize the size of board
//     * @return
//     */
//    private boolean isSolvable(int boardSize, List<Tile> tiles) {
//        List<Integer> tileNums = new ArrayList<>();
//        for (Tile t: tiles) {
//            tileNums.add(t.getId());
//        }
//        if (boardSize % 2 == 1) {
//
//        }
//        else {
//
//        }
//    }

    private int numOfInversions(List<Integer> tileNums) {
        int inversions = 0;
        for (int i = 0; i < tileNums.size() - 1; i++) {

        }
        return inversions;
    }

    /**
     * Return whether the tiles are in row-major order.
     *
     * @return whether the tiles are in row-major order
     */
    boolean puzzleSolved() {
        boolean solved = true;
        for (int i = 0; i < board.numTiles() - 1; i++) {
            int row = i / Board.NUM_ROWS;
            int col = i % Board.NUM_COLS;
            int id = i + 1;
            Tile tileToCheck = board.getTile(row, col);
            if (tileToCheck.getId() != id) {
                solved = false;
                break;
            }
        }
        return solved;
    }

    /**
     * Return whether any of the four surrounding tiles is the blank tile.
     *
     * @param position the tile to check
     * @return whether the tile at position is surrounded by a blank tile
     */
    boolean isValidTap(int position) {

        int row = position / Board.NUM_COLS;
        int col = position % Board.NUM_COLS;
        int blankId = 25;
        // Are any of the 4 the blank tile?
        Tile above = row == 0 ? null : board.getTile(row - 1, col);
        Tile below = row == Board.NUM_ROWS - 1 ? null : board.getTile(row + 1, col);
        Tile left = col == 0 ? null : board.getTile(row, col - 1);
        Tile right = col == Board.NUM_COLS - 1 ? null : board.getTile(row, col + 1);
        return (below != null && below.getId() == blankId)
                || (above != null && above.getId() == blankId)
                || (left != null && left.getId() == blankId)
                || (right != null && right.getId() == blankId);
    }

    /**
     * Process a touch at position in the board, swapping tiles as appropriate.
     *
     * @param position the position
     */
    void touchMove(int position) {

        int row = position / Board.NUM_ROWS;
        int col = position % Board.NUM_COLS;
        int blankId = 25;

        Tile above = row == 0 ? null : board.getTile(row - 1, col);
        Tile below = row == Board.NUM_ROWS - 1 ? null : board.getTile(row + 1, col);
        Tile left = col == 0 ? null : board.getTile(row, col - 1);
        Tile right = col == Board.NUM_COLS - 1 ? null : board.getTile(row, col + 1);
        if ((above != null) && blankId == above.getId()) {
            board.swapTiles(row - 1, col, row, col);
        } else if ((below != null) && blankId == below.getId()) {
            board.swapTiles(row + 1, col, row, col);
        } else if ((left != null) && blankId == left.getId()) {
            board.swapTiles(row, col - 1, row, col);
        } else if ((right != null) && blankId == right.getId()) {
            board.swapTiles(row, col + 1, row, col);
        }
    }

}


