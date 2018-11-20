package project.csc207.catchingball;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;


import project.csc207.R;

/** 
 * A class that build the result of the game named catching the ball
 * This was adapted from a video from codingwithsara on Youtube
 * link here:
  * https://www.youtube.com/watch?v=ojD6ZDi2ep8&list=PLRdMAPi4QUfbIg6dRXf56cbMfeYtTdNSA
  */

public class catchballresult extends AppCompatActivity {

    /*
    set up the outline for the result page with calculated scores
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catchballresult);

        TextView scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        TextView highScoreLabel = (TextView) findViewById(R.id.highScoreLabel);

        int score = getIntent().getIntExtra("SCORE", 0);
        scoreLabel.setText(score + "");

        SharedPreferences settings = getSharedPreferences("HIGH_SCORE", Context.MODE_PRIVATE);
        int highScore = settings.getInt("HIGH_SCORE", 0);

        if (score > highScore) {
            highScoreLabel.setText("High Score : " + score);

            // Update High Score
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE", score);
            editor.commit();

        } else {
            highScoreLabel.setText("High Score : " + highScore);

        }
    }

    /*
    restart the game
     */
    public void tryAgain(View view) {
        startActivity(new Intent(getApplicationContext(), catchballstart.class));
    }


    /*
    Disable Return Button
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    return true;
            }
        }

        return super.dispatchKeyEvent(event);
    }
}
