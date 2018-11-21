package project.csc207.lightsOutGame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import project.csc207.AccountManager;
import project.csc207.LauncherActivity;
import project.csc207.R;

public class LightsOutStartingActivity extends AppCompatActivity {

    /**
     * The main save file.
     */
    public static final String SAVE_FILENAME = "save_file.ser";
    /**
     * A temporary save file.
     */
    public static final String TEMP_SAVE_FILENAME = "save_file_tmp.ser";

    private AccountManager accountManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadFromFile(LauncherActivity.SAVE_FILENAME);
        accountManager.getCurrentAccount().setLightsOutBoardManager(new LightsOutBoardManager());
        saveToFile(TEMP_SAVE_FILENAME);
        //upload and update LightsOutBoardManager in Account

        setContentView(R.layout.activity_lights_out_starting);
        displayAccountName();
        addStartButtonListener();
    }

    /**
     * Change text to the account name.
     */
    private void displayAccountName() {
        TextView accountNameLightsTextView = findViewById(R.id.AccountNameLights);
        String username = accountManager.getCurrentAccount().getUserName();
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
        saveToFile(LightsOutStartingActivity.TEMP_SAVE_FILENAME);
        startActivity(gameActivityIntent);
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

    public void saveToFile(String fileName) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    this.openFileOutput(fileName, MODE_PRIVATE));
            outputStream.writeObject(accountManager);
            outputStream.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
