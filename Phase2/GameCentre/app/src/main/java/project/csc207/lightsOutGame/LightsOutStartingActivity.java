package project.csc207.lightsOutGame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

import project.csc207.Account;
import project.csc207.R;

public class LightsOutStartingActivity extends AppCompatActivity {

    private LightOutBoardManager boardManager = new LightOutBoardManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights_out_starting);
        displayAccountName();
        addStartButtonListener();
    }

    /**
     * Change text to the account name.
     */
    private void displayAccountName() {
        TextView accountNameLightsTextView = findViewById(R.id.AccountNameLights);
        String username = Account.getCurrentAccount().getUserName();
        accountNameLightsTextView.setText(username);
    }

    /**
     * Activate the start button.
     */
    private void addStartButtonListener() {
        Button startButton = findViewById(R.id.StartButtonLights);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToGame();
            }
        });
    }

    /**
     * Switch to the LightsOutGameActivity view to play the game.
     */
    private void switchToGame() {
        Intent gameActivityIntent = new Intent(LightsOutStartingActivity.this,
                LightsOutGameActivity.class);
        startActivity(gameActivityIntent);
    }

}
