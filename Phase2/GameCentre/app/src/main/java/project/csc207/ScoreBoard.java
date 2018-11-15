package project.csc207;

/* interface for all different games to count score
 */
public interface ScoreBoard {

    /*
    calculated score
     */
    public void scoreCount();

    /*
    Compare the score before the game and after, store the higher one.
     */
    public void updateHigherScore();

    /*
    Add the moves.
     */
    public void addMoves();

    /*
    Subtract the moves.
    */
    public void subtractMoves();

    /*
    Convert the string version time to the int version.
     */
    public void convertTime();

    /*
    The setter for time.
     */
    void timeTaken(String takentime);


}

