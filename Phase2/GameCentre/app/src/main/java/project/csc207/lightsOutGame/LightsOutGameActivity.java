package project.csc207.lightsOutGame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.GridView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import project.csc207.AccountManager;
import project.csc207.R;
import project.csc207.slidingtiles.CustomAdapter;

public class LightsOutGameActivity extends AppCompatActivity implements Observer {

    /**
     * Board manager of Lights Out Board.
     */
    private LightsOutBoardManager lightsOutBoardManager;

    /**
     * Buttons of Lights Out.
     */
    private ArrayList<Button> lightsButtons = new ArrayList<>();

    /**
     * the accountManager for current  Account
     */
    private AccountManager accountManager;

    /**
     * GridView of Lights Out.
     */
    private LightsOutDetectGridView lightsGrid;

    private static int columnWidth, columnHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadFromFile(LightsOutStartingActivity.TEMP_SAVE_FILENAME);
        lightsOutBoardManager = accountManager.getCurrentAccount().getLightsOutBoardManager();
        createLights(this);
        setContentView(R.layout.activity_lights_out_game);

        lightsGrid = findViewById(R.id.LightsGrid);
        lightsGrid.setNumColumns(5);
        lightsGrid.setLightsOutBoardManager(lightsOutBoardManager);
        lightsOutBoardManager.getLightsOutBoard().addObserver(this);


        lightsGrid.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        lightsGrid.getViewTreeObserver().removeOnGlobalLayoutListener(
                                this);
                        int displayWidth = lightsGrid.getMeasuredWidth();
                        int displayHeight = lightsGrid.getMeasuredHeight();

                        columnWidth = displayWidth / LightsOutBoard.NUM_COLS;
                        columnHeight = displayHeight / LightsOutBoard.NUM_ROWS;

                        display();
                    }
                });
    }

    /**
     * Creates the buttons for the lights
     * @param context the context
     */
    private void createLights(Context context) {
        LightsOutBoard lightsBoard = lightsOutBoardManager.getLightsOutBoard();
        lightsButtons = new ArrayList<>();
        for (int row = 0; row != LightsOutBoard.NUM_ROWS; row++) {
            for (int col = 0; col != LightsOutBoard.NUM_COLS; col++) {
                Button light = new Button(context);
                light.setBackgroundResource(lightsBoard.getLight(row, col).getBackground());
                lightsButtons.add(light);
            }
        }

    }

    /**
     * Update light backgrounds.
     */
    private void updateLights() {
        LightsOutBoard board = lightsOutBoardManager.getLightsOutBoard();
        int nextPos = 0;
        for (Button b : lightsButtons) {
            int row = nextPos / LightsOutBoard.NUM_ROWS;
            int col = nextPos % LightsOutBoard.NUM_COLS;
            b.setBackgroundResource(board.getLight(row, col).getBackground());
            nextPos++;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveToFile(LightsOutStartingActivity.TEMP_SAVE_FILENAME);
    }

    /**
     * Set up background images and use adapter to set the view.
     */
    public void display() {
        updateLights();
        lightsGrid.setAdapter(new CustomAdapter(lightsButtons, columnWidth, columnHeight));
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

    @Override
    public void update(Observable o, Object arg) {
        display();
    }
}
