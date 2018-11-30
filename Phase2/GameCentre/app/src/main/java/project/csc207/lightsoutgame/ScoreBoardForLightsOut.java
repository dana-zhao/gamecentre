package project.csc207.lightsoutgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import project.csc207.Account;
import project.csc207.AccountManager;
import project.csc207.LauncherActivity;
import project.csc207.R;

public class ScoreBoardForLightsOut extends AppCompatActivity {
    private AccountManager accountManager;
    private ArrayList<Account> topPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board_for_lights_out);
        loadFromFile(LauncherActivity.SAVE_FILENAME);

        setTopPlayers();
        setTextViewForTopPlayers();
        setTextViewForAccount();

    }

    /**
     * Set text view for the account.
     */
    private void setTextViewForAccount() {
        TextView titleText = findViewById(R.id.LightsOutTitle);
        TextView accountScoreText = findViewById(R.id.userScoreLightsOut);
        String title = "ScoreBoard For Lights Out Game";
        String accountsAndScore = "Your Score is: " +
                accountManager.getCurrentAccount().getLightOutScores();

        titleText.setText(title);
        accountScoreText.setText(accountsAndScore);
    }

    /**
     * set the textView for top players, if not enough player, it will leave blank space
     */
    private void setTextViewForTopPlayers() {
        TextView num1Player = findViewById(R.id.num1LightsOut);
        TextView num2Player = findViewById(R.id.num2LightsOut);
        TextView num3Player = findViewById(R.id.num3LightsOut);
        ArrayList<String> textForView = new ArrayList<>();

        for (Account account : topPlayers) {
            String str = "User: " + account.getUserName() + " Score : " + account.getLightOutScores();
            textForView.add(str);
        }
        while (textForView.size() < 3) {
            textForView.add(" ");
        }
        num1Player.setText(textForView.get(0));
        num2Player.setText(textForView.get(1));
        num3Player.setText(textForView.get(2));
    }


    /**
     * get top 3 Players
     */
    private void setTopPlayers() {
        topPlayers = new ArrayList<>();
        HashMap<String, Account> allaccounts = accountManager.getAllAccount();
        Collection<Account> accounts = allaccounts.values();
        System.out.println(accounts.size());
        for (Account account : accounts) {
            int lightsOutScore = account.getLightOutScores();
            topPlayers = checkTopPlayers(account, lightsOutScore, topPlayers);
        }
    }

    /**
     * return an list contains the top players of this game, update the list if the given player
     * has higher score than the original top players, the list length might
     *
     * @param player     the account to check
     * @param score      the score of CatchingBall game of the check account
     * @param topPlayers the lists contains top 3 players
     * @return the list contains top 3 players,could be less than 3 if less than 3 people register
     */
    private ArrayList<Account> checkTopPlayers(Account player, int score,
                                               ArrayList<Account> topPlayers) {

        for (int i = 0; i < 3; i++) {
            if (i == topPlayers.size()) {
                topPlayers.add(i, player);
                break;
            } else {
                Account topPlayer = topPlayers.get(i);
                int recordOfTopPlayer = topPlayer.getLightOutScores();
                if (score > recordOfTopPlayer) {
                    topPlayers.add(i, player);
                    break;
                }
            }
        }
        if (topPlayers.size() > 3) {
            topPlayers.remove(3);
        }
        return topPlayers;
    }

    /**
     * Load from the save file
     *
     * @param fileName save file name
     */
    private void loadFromFile(String fileName) {

        try {
            InputStream inputStream = this.openFileInput(fileName);
            if (inputStream != null) {
                ObjectInputStream input = new ObjectInputStream(inputStream);
                accountManager = (AccountManager) input.readObject();
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("login activity", "File contained unexpected data type: " + e.toString());
        }
    }

}
