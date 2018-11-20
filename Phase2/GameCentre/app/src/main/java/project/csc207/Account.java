package project.csc207;
import java.io.Serializable;

import project.csc207.slidingtiles.BoardManager;

public class Account implements Serializable {

    /*
    The account saved boardManager
     */
    private BoardManager bm;

    /**
    The score for the current account.
     */
    private double scores = 0;

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
    Return the score for the current user.
     */
    public double getScore() {
        return scores;
    }

    /**
    Return the score for the current user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Return the saved boardManager
     */
    public BoardManager getBm() {
        return bm;
    }

    public void setBm(BoardManager bm) {
        this.bm = bm;
    }
}
