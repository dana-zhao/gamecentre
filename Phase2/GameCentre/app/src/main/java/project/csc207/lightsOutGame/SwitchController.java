package project.csc207.lightsOutGame;

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
        System.out.println("Switch Controller Called");
            lightsOutBoardManager.touchToSwitch(position);
            if (lightsOutBoardManager.allLightsOut()) {
                Toast.makeText(context, "YOU WIN!", Toast.LENGTH_SHORT).show();
            }
        }

}
