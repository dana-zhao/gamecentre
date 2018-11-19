package project.csc207;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import project.csc207.catchingball.catchballstart;
import project.csc207.slidingtiles.StartingActivity;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        addSlidingTilesListener();
        TextView accountNameTextView = findViewById(R.id.AccountName);
        String username = Account.getCurrentAccount().getUserName();
        accountNameTextView.setText(username);

    }

    /*
    Activate the game sliding tiles.
     */
    private void addSlidingTilesListener() {
        Button slidingTilesButton = findViewById(R.id.SlidingTilesButton);
        slidingTilesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent slidingTilesIntent = new Intent(AccountActivity.this,
                        StartingActivity.class);
                startActivity(slidingTilesIntent);
            }
        });
    }

    /*
    Activate the game catch the ball.
     */
    private void addCatchTheBallListener() {
        Button catchballButton = findViewById(R.id.CatchBallButton);
        catchballButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent catchballIntent = new Intent(AccountActivity.this,
                        catchballstart.class);
                startActivity(catchballIntent);
            }
        });
    }

}
