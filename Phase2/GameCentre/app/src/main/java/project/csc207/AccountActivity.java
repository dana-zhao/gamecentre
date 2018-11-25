package project.csc207;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;


import project.csc207.catchingball.CatchBallStart;
import project.csc207.lightsoutgame.LightsOutStartingActivity;
import project.csc207.slidingtiles.StartingActivity;

public class AccountActivity extends AppCompatActivity {


    /**
     * The account manager.
     */
    private AccountManager accountManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadFromFile(LauncherActivity.SAVE_FILENAME);
        setContentView(R.layout.activity_account);
        addSlidingTilesListener();
        addLightsOutListener();
        addCatchingTheBallListener();
        displayAccountName();
    }

    /**
     * Change text to account name.
     */
    private void displayAccountName() {
        TextView accountNameTextView = findViewById(R.id.AccountName);
        String username = accountManager.getCurrentAccount().getUserName();
        accountNameTextView.setText(username);
    }

    /**
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

    /**
     Activate the game catching the ball.
     */
    private void addCatchingTheBallListener() {
        Button catchBallButton = findViewById(R.id.CatchingBallButton);
        catchBallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent catchBallIntent = new Intent(AccountActivity.this,
                        CatchBallStart.class);
                startActivity(catchBallIntent);
            }
        });
    }

    /**
     * Activate Lights Out game.
     */
        private void addLightsOutListener() {
        Button lightsOutButton = findViewById(R.id.LightsOutButton);
        lightsOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lightsOutIntent = new Intent(AccountActivity.this, LightsOutStartingActivity.class);
                startActivity(lightsOutIntent);
            }
        });
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
