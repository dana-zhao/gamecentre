package project.csc207.lightsOutGame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

import project.csc207.R;
import project.csc207.slidingtiles.CustomAdapter;

public class LightsOutGameActivity extends AppCompatActivity {

    /**
     * Board manager of Lights Out.
     */
    private LightOutBoardManager boardManager;

    /**
     * Buttons of Lights Out.
     */
    private ArrayList<Button> lightsButtons = new ArrayList<>();

    /**
     * GridView of Lights Out.
     */
    private GridView lightsGrid;
    private static int columnWidth, columnHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights_out_game);
        createLights(this);
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
        LightsOutBoard lightsBoard = boardManager.getLightsOutBoard();
        lightsGrid = findViewById(R.id.LightsGrid);
        lightsGrid.setNumColumns(LightsOutBoard.NUM_COLS);

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
        LightsOutBoard board = boardManager.getLightsOutBoard();
        int nextPos = 0;
        for (Button b : lightsButtons) {
            int row = nextPos / LightsOutBoard.NUM_ROWS;
            int col = nextPos % LightsOutBoard.NUM_COLS;
            b.setBackgroundResource(board.getLight(row, col).getBackground());
            nextPos++;
        }
    }

    /**
     * Set up background images and use adapter to set the view.
     */
    public void display() {
        updateLights();
        lightsGrid.setAdapter(new CustomAdapter(lightsButtons, columnWidth, columnHeight));
    }

}
