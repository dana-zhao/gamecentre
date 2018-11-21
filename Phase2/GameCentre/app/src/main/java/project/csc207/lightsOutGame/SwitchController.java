package project.csc207.lightsOutGame;

import android.content.Context;
import android.widget.Toast;

import project.csc207.slidingtiles.BoardManager;

class SwitchController {

    private LightsOutBoardManager lightsOutBoardManager;

    SwitchController() {
    }

    void setLightsOutBoardManager(LightsOutBoardManager lightsOutBoardManager) {
        this.lightsOutBoardManager = lightsOutBoardManager;
    }

    void processTapSwtich(Context context, int position) {
            lightsOutBoardManager.touchToSwitch(position);
            if (lightsOutBoardManager.allLightsOut()) {
                Toast.makeText(context, "YOU WIN!", Toast.LENGTH_SHORT).show();
            }
        }

}
