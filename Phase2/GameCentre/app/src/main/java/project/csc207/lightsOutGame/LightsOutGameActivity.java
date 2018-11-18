package project.csc207.lightsOutGame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.widget.Button;

import java.util.ArrayList;

import project.csc207.R;

public class LightsOutGameActivity extends AppCompatActivity {

    private LightOutBoardManager boardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights_out_game);
        createLights(this);
    }

    /**
     * Creates the buttons for the lights
     * @param context the context
     */
    private void createLights(Context context) {
        LightsOutBoard lightsBoard = boardManager.getLightsOutBoard();
        ArrayList<Button> lightsButtons = new ArrayList<>();
        for (int row = 0; row != LightsOutBoard.NUM_ROWS; row++) {
            for (int col = 0; col != LightsOutBoard.NUM_COLS; col++) {
                Button light = new Button(context);
                light.setBackgroundResource(lightsBoard.getLight(row, col).getBackground());
                lightsButtons.add(light);
            }
        }

    }

}
