package project.csc207.catchingball;

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
import java.util.List;

import project.csc207.Account;
import project.csc207.AccountManager;
import project.csc207.LauncherActivity;
import project.csc207.R;

public class ScoreBoardForCatchingBall extends AppCompatActivity {

    private AccountManager accountManager;
    private ArrayList<Account> topPlayers;
    private ArrayList<String> textForView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board_for_catching_ball);
        loadFromFile(LauncherActivity.SAVE_FILENAME);

        setTopPlayers();
        setTextViewForTopPlayers();
        setTextViewForAccount();

    }

    private void setTextViewForAccount() {
        TextView titleText = findViewById(R.id.Title);
        TextView accountScoreText = findViewById(R.id.UserScore);
        String title = "ScoreBoard For Catching Ball Game";
        String accountsAndScore = "Your Score is: " +
                accountManager.getCurrentAccount().getCatchBallScore();

        titleText.setText(title);
        accountScoreText.setText(accountsAndScore);
    }

    /**
     * set the textView for top players
     */
    private void setTextViewForTopPlayers() {
        TextView num1Player = findViewById(R.id.num1Player);
        TextView num2Player = findViewById(R.id.num2Player);
        TextView num3Player = findViewById(R.id.num3Player);
        textForView = new ArrayList<>();

        for (Account account : topPlayers) {
            String str = "User: " + account.getUserName() + " Score : " + account.getCatchBallScore();
            textForView.add(str);
        }

        while (textForView.size() < 3) {
            textForView.add("User: " + " Score :");
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
            int catchBallScore = account.getCatchBallScore();
            System.out.println("current Account" + account.getUserName());
            System.out.println("Score" + catchBallScore);
            topPlayers = checkTopPlayers(account, catchBallScore, topPlayers);
            System.out.println(topPlayers.size());
        }
    }

    /**
     * return an list contains the top 3 players of this game, update the list if the given player
     * has higher score than the original top players
     *
     * @param player     the account to check
     * @param score      the score of CatchingBall game of the check account
     * @param topPlayers the lists contains top 3 players
     * @return the list contains top 3 players,could be less than 3 if less than 3 people sign in
     */
    private ArrayList<Account> checkTopPlayers(Account player, int score,
                                               ArrayList<Account> topPlayers) {

        for (int i = 0; i < 3; i++) {
            if (i == topPlayers.size()) {
                topPlayers.add(i, player);
                break;
            } else {
                Account topPlayer = topPlayers.get(i);
                int recordOfTopPlayer = topPlayer.getCatchBallScore();
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
