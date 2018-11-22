package project.csc207.catchingball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import project.csc207.R;

/** 
 * A class that build the starting page of the game named catching the ball
 * This was adapted from a video from codingwithsara on Youtube
 * link here:
  * https://www.youtube.com/watch?v=ojD6ZDi2ep8&list=PLRdMAPi4QUfbIg6dRXf56cbMfeYtTdNSA
  */

public class CatchBallStart extends AppCompatActivity {

    /*
    build the outline of the background
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catchballstart);

    }

    /*
    start the game
     */
    public void startGame(View view) {
        startActivity(new Intent(getApplicationContext(), CatchBall.class));
    }

    /*
    Disable Return Button
     */

    /*

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
    */

}
