package project.csc207.slidingtiles;
import java.util.List;

class SlidingTilesHelpMethods {
    /**
     * Copy of getInversions to help test if boards are solvable
     * @param tileNums list of tile ids
     * @param boardSize size of board
     * @return number of inversions
     */
    static int getInversions(List<Integer> tileNums, int boardSize) {
        int inversions = 0;
        //Remove the blank tile
        tileNums.remove(Integer.valueOf(boardSize * boardSize));
        for (int i = 0; i < tileNums.size(); i++) {
            for (int j = i + 1; j < tileNums.size(); j++) {
                if (tileNums.get(j) < tileNums.get(i)) {
                    inversions++;
                }
            }
        }
        return inversions;
    }
}
