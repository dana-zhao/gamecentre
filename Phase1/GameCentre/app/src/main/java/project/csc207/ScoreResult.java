package project.csc207;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import project.csc207.slidingtiles.ScoreBoardSliding;
import project.csc207.slidingtiles.StartingActivity;

public class ScoreResult extends AppCompatActivity {

    /**
     * The ScoreBoardSliding scoreBoard.
     */
    private ScoreBoardSliding scoreBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_result);

        SharedPreferences preferences = getSharedPreferences("SCORES", MODE_PRIVATE);
        String user = Account.getCurrentAccount().getUserName();
        int score = preferences.getInt(user, 0);

        TextView userScore = findViewById(R.id.score);
        userScore.setText(Integer.toString(score));


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

}
