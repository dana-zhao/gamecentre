package project.csc207;

import org.junit.Test;

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
    public void setCatchballScoreForSave() {
        Account newAccount = new Account("1234", "4321");
        newAccount.setCatchballScoreForSave(90);

        assertEquals(90, newAccount.getCatchballScoreForSave());
    }

    @Test
    public void getCatchballScoreForSave() {
        Account newAccount = new Account("1234", "4321");
        newAccount.setCatchballScoreForSave(9);

        assertEquals(9, newAccount.getCatchballScoreForSave());
    }


    @Test
    public void setLightOutScores() {
        Account newAccount = new Account("1234", "4321");
        newAccount.setLightOutScores(10);

        assertEquals(10, newAccount.getLightOutScores());
    }

    @Test
    public void getLightOutScores() {
        Account newAccount = new Account("1234", "4321");
        newAccount.setLightOutScores(10);
        newAccount.setLightOutScores(1);

        assertEquals(10, newAccount.getLightOutScores());

        newAccount.setLightOutScores(100);
        assertEquals(100, newAccount.getLightOutScores());
    }

    @Test
    public void setSlidingTileScores() {
        Account newAccount = new Account("1234", "4321");
        newAccount.setSlidingTileScores(100);
        newAccount.setSlidingTileScores(1);

        assertEquals(100, newAccount.getSlidingTileScores());

        newAccount.setSlidingTileScores(1000);
        assertEquals(1000, newAccount.getSlidingTileScores());
    }

    @Test
    public void getSlidingTileScores() {
        Account newAccount = new Account("1234", "4321");
        newAccount.setSlidingTileScores(100);
        newAccount.setSlidingTileScores(1);

        assertEquals(100, newAccount.getSlidingTileScores());

        newAccount.setSlidingTileScores(1000);
        assertEquals(1000, newAccount.getSlidingTileScores());
    }

    @Test
    public void getCatchBallScore() {
        Account newAccount = new Account("1234", "4321");
        newAccount.setCatchBallScore(120);
        newAccount.setCatchBallScore(1);

        assertEquals(120, newAccount.getCatchBallScore());

        newAccount.setCatchBallScore(1000);
        assertEquals(1000, newAccount.getCatchBallScore());
    }

    @Test
    public void setCatchBallScore() {
        Account newAccount = new Account("1234", "4321");
        newAccount.setCatchBallScore(120);
        newAccount.setCatchBallScore(1);

        assertEquals(120, newAccount.getCatchBallScore());

        newAccount.setCatchBallScore(1000);
        assertEquals(1000, newAccount.getCatchBallScore());
    }
}