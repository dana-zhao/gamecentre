package project.csc207.lightsoutgame;

import android.content.Context;
import android.widget.Toast;


class SwitchController {

    private LightsOutBoardManager lightsOutBoardManager;

    SwitchController() {
    }

    void setLightsOutBoardManager(LightsOutBoardManager lightsOutBoardManager) {
        this.lightsOutBoardManager = lightsOutBoardManager;
    }

    void processTapSwitch(Context context, int position) {
            lightsOutBoardManager.touchToSwitch(position);
            if (lightsOutBoardManager.isGameOver()) {
                Toast.makeText(context, "YOU WIN!", Toast.LENGTH_SHORT).show();
            }
        }
}
