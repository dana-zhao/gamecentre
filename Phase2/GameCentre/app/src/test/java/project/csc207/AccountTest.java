package project.csc207;

import org.junit.Test;

import project.csc207.slidingtiles.Board;
import project.csc207.slidingtiles.BoardManager;
import project.csc207.slidingtiles.Tile;
import java.util.List;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void getUserName() {
        Account newAccount = new Account("1234", "4321");
        assertEquals("1234", newAccount.getUserName());
    }

    @Test
    public void getPassword() {
        Account newAccount = new Account("1234", "4321");
        assertEquals("4321", newAccount.getPassword());
    }

    @Test
    public void getBoardManager() {
        Account newAccount = new Account("1234", "4321");
        Tile[][] tiles = new Tile[3][3];
        Board newBoard = new Board(tiles);
        BoardManager newBm = new BoardManager();

        assertEquals("1234", newAccount.getUserName());
    }

    @Test
    public void setBoardManager() {
    }

    @Test
    public void getLightsOutBoardManager() {
    }

    @Test
    public void setCatchballScoreForSave() {
    }

    @Test
    public void getCatchballScoreForSave() {
    }

    @Test
    public void setLightsOutBoardManager() {
    }

    @Test
    public void setLightOutScores() {
    }

    @Test
    public void getLightOutScores() {
    }

    @Test
    public void setSlidingTileScores() {
    }

    @Test
    public void getSlidingTileScores() {
    }

    @Test
    public void getCatchBallScore() {
    }

    @Test
    public void setCatchBallScore() {
    }
}