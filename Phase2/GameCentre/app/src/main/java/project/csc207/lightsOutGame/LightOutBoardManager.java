package project.csc207.lightsOutGame;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleBiFunction;

import project.csc207.slidingtiles.Board;

/**
 * manage the LightOutBoard, including switch light, check for a win, and managing taps
 */
public class LightOutBoardManager implements Serializable {

    /**
     *  the LightsOut Board to be managed
     */
     private  LightsOutBoard lightsOutBoard;

    public LightsOutBoard getLightsOutBoard() {
        return lightsOutBoard;
    }

    public LightOutBoardManager(){
        List<Light> lights = new ArrayList<>();
        final int numLights = LightsOutBoard.NUM_COLS*LightsOutBoard.NUM_ROWS;
        for (int lightsNum = 0; lightsNum != numLights; lightsNum++){
            lights.add(new Light(lightsNum));
        }
        // Need to add a function or code to randomly set the Lights Board
        // with some part is white and other parts are black.

        this.lightsOutBoard = new LightsOutBoard(lights);
    }

    /**
     * Return whether all lights in Light Out Board are On
     *
     * @return whether all lights in Light Out Board are On
     */
    boolean allLightsOn(){
        boolean allLightsOn = true;
        for (int i =0; i < lightsOutBoard.numLights()-1; i++){
            int row = i / LightsOutBoard.NUM_ROWS;
            int col = 1 % LightsOutBoard.NUM_COLS;
            Light lightToCheck = lightsOutBoard.getLight(row, col);
            if (!lightToCheck.isOn()){
                allLightsOn = false;
                break;
            }
        }
        return allLightsOn;
    }


}
