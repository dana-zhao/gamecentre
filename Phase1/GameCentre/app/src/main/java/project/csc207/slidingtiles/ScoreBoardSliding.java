package project.csc207.slidingtiles;


public class ScoreBoardSliding implements project.csc207.ScoreBoard {

    /*
    The new score that is fetched from the user account.
     */
    private double newScore;

    /*
    The string version of the time from game.
     */
    private String newtime;

    /*
    The default moves for game.
     */
    private int moves = 0;

    /*
    The score that is fetched after game.
     */
    private double score;

    /*
    The converted version of time.
     */
    private int updatedTime;

    ScoreBoardSliding(project.csc207.Account account) {
        this.newScore = account.getScore();
    }

    /*
    calculated score
     */
    public void scoreCount() {
        // based on my designed rule, calculate score
        double total = (1 / (moves + updatedTime)) * 1000;
        score = total;
        //updateHigherScore();

    }

    /*
    Add the moves.
     */
    public void addMoves() {
        moves++;
    }

    /*
    Subtract the moves.
    */
    public void subtractMoves() {
        if (moves >= 0) {
            moves--;
        }
    }

    /*
    The getter for moves.
     */
    public int getMoves() {
        return moves;
    }

    /*
     The getter for score.
      */
    public double getScore() {
        return score;
    }

    /*
    The setter for time.
     */
    public void timeTaken(String takentime) {
        newtime = takentime;

    }

    /*
    Convert the string version time to the int version.
     */
    public void convertTime() {
        String[] minSec = newtime.split(":");
        int min = Integer.parseInt(minSec[0]);
        int secs = Integer.parseInt(minSec[1]);
        int minsSecs = min * 60;
        updatedTime = minsSecs + secs;
    }

    /*
    Compare the score before the game and after, store the higher one.
     */
    public void updateHigherScore() {
        if (newScore > score) {
            score = newScore;
        }

    }
}
