package project.csc207;
import java.io.Serializable;

import project.csc207.lightsoutgame.LightsOutBoardManager;
import project.csc207.slidingtiles.BoardManager;

public class Account implements Serializable {

    /**
    The account saved boardManager
     */
    private BoardManager bm;

    /**
     * the Account Saved LightsOutBoardManager
     */
    private LightsOutBoardManager lbm;

    private int catchBallScoreForSave;

    /**
    The score for the current account.
     */
    public int slidingTileScores;

    /**
     The score for the current account.
     */
    public int catchBallScore;
    /**
     The score for the current account.
     */
    public int lightOutScores0;



    /**
    The username of the account currently logged in.
     */
    private String userName;

    /**
    The password of the account currently logged in.
     */
    private String password;

    /**
    Create a new account.
     */
    Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.bm = null;
    }


    /**
    Return the current account's username.
     */
    public String getUserName() {
        return userName;
    }

    /**
    Return the highest catch ball score for the current user.
     */

    /**
    Return the score for the current user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Return the saved boardManager
     */
    public BoardManager getBoardManager() {
        return bm;
    }

    /**
     * Set the saved boardManager
     */
    public void setBoardManager(BoardManager bm) {
        this.bm = bm;
    }

    /**
     * Return the saved LightOutBoardManager
     * @return saved LightOutBoardManager
     */
    public LightsOutBoardManager getLightsOutBoardManager() {
        return lbm;
    }

    public void setCatchballScoreForSave(int catchballScoreForSave) {
        this.catchBallScoreForSave = catchballScoreForSave;
    }

    public int getCatchballScoreForSave() {
        return catchBallScoreForSave;
    }

    /**
     * set the saved LightsOutBoardManager
     * @param lbm the given LightsOutBoardManager
     */
    public void setLightsOutBoardManager(LightsOutBoardManager lbm) {
        this.lbm = lbm;
    }


}
