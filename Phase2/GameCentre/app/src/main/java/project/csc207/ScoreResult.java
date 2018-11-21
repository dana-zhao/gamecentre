package project.csc207;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import project.csc207.slidingtiles.ScoreBoardSliding;
import project.csc207.slidingtiles.StartingActivity;

public class ScoreResult extends AppCompatActivity {

    /**
     * The ScoreBoardSliding scoreBoard.
     */
    private ScoreBoardSliding scoreBoard;
    /**
     * The account manager.
     */
    private AccountManager accountManager;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //loadFromFile(LauncherActivity.SAVE_FILENAME);
        setContentView(R.layout.activity_score_result);

        TextView scoreLabel = (TextView) findViewById(R.id.newscore);
        TextView highScoreLabel = (TextView) findViewById(R.id.highScore);

        int score = getIntent().getIntExtra("SCORE", 0);
        scoreLabel.setText(score + "");

        SharedPreferences settings = getSharedPreferences("HIGH_SCORE_st", Context.MODE_PRIVATE);
        int highScore = settings.getInt("HIGH_SCORE", 0);

        if (score > highScore) {
            highScoreLabel.setText("High Score : " + score);

            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE", score);
            editor.commit();

        } else {
            highScoreLabel.setText("High Score : " + highScore);

        }

        /*
        SharedPreferences preferences = getSharedPreferences("SCORES", MODE_PRIVATE);
        String user = accountManager.getCurrentAccount().getUserName();
        int score = preferences.getInt(user, 0);

        TextView userScore = findViewById(R.id.score);
        userScore.setText(Integer.toString(score));
        */


        final Button playAgainButton = (Button) findViewById(R.id.playagain);
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGame();
            }
        });
    }

    /*
    Open a new game.
     */
    public void openGame() {
        Intent intent = new Intent(this, StartingActivity.class);
        startActivity(intent);
    }



    /*
    /**
     * Load the board manager from fileName.
     *
     * @param fileName the name of the file
     */
    /*
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

    /**
     * Save the board manager to fileName.
     *
     * @param fileName the name of the file
     */
    /*
    public void saveToFile(String fileName) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    this.openFileOutput(fileName, MODE_PRIVATE));
            outputStream.writeObject(accountManager);
            outputStream.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    } */
}
