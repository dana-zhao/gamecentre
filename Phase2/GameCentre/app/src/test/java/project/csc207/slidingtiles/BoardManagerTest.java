package project.csc207.slidingtiles;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardManagerTest {
    private final int EVEN_SIZE = 4;
    private final int ODD_SIZE = 5;
    private SlidingTilesHelpMethods help = new SlidingTilesHelpMethods();

    /*@Before
    public void setUp() {
        List<Tile> tiles = new ArrayList<>();
        Integer[] testTileNumbers = {12, 1, 10, 2, 7, 11, 4, 14, 5, 16, 9, 15, 8, 13, 6, 3};
        for (int tileNum : testTileNumbers) {
            tiles.add(new Tile(tileNum));
        }
        Board testEvenBoard = new Board(tiles);
        testEvenBoardManager.setBoard(testEvenBoard);
    }*/

    @Test
    public void testBoardManagerConstructor() {
        //Test that odd sized board is solvable
        BoardManager testBoardManager = new BoardManager(ODD_SIZE);
        Board testBoard = testBoardManager.getBoard();
        List<Integer> tileNums = new ArrayList<>();
        for (Tile t: testBoard){
            tileNums.add(t.getId());
        }
        int inversions = SlidingTilesHelpMethods.getInversions(tileNums, ODD_SIZE);
        assertEquals(inversions % 2, 0);
        //Test that even sized board is solvable
        testBoardManager = new BoardManager(EVEN_SIZE);
        testBoard = testBoardManager.getBoard();
        tileNums = new ArrayList<>();
        for (Tile t: testBoard){
            tileNums.add(t.getId());
        }
        inversions = SlidingTilesHelpMethods.getInversions(tileNums, EVEN_SIZE);
        if (testBoard.getBlankRow() % 2 == 1) {
            assertEquals(inversions % 2, 1);
        }
        else {
            assertEquals(inversions % 2, 0);
        }
    }

    @Test
    public void testPuzzleSolved() {
        //Test solved board
        List<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < EVEN_SIZE * EVEN_SIZE; i++) {
            tiles.add(new Tile(i));
        }
        Board testSolvedBoard = new Board(tiles);
        BoardManager testSolvedBoardManager = new BoardManager(EVEN_SIZE);
        testSolvedBoardManager.setBoard(testSolvedBoard);
        assertTrue(testSolvedBoardManager.puzzleSolved());
        //Test unsolved board
        tiles.clear();
        Integer[] testTileNumbers = {0, 1, 2, 3, 4, 6, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        for (int t: testTileNumbers) {
            tiles.add(new Tile(t));
        }
        testSolvedBoard = new Board(tiles);
        testSolvedBoardManager.setBoard(testSolvedBoard);
        assertFalse(testSolvedBoardManager.puzzleSolved());
    }

    /*@Test
    public void testNumOfInversions() {
        Integer[] testTileNumbers = {12, 1, 10, 2, 7, 11, 4, 14, 5, 16, 9, 15, 8, 13, 6, 3};
        List<Integer> tileArray = new ArrayList<>();
        tileArray.addAll(Arrays.asList(testTileNumbers));
        int num = testBoardManager.numOfInversions(tileArray, 4);
        assertEquals(num, 49);
    }
    */

}
