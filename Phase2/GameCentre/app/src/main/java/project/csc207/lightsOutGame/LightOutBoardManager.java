package project.csc207.lightsOutGame;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * manage the LightOutBoard, including switch light, check for a win, and managing taps
 */
class LightOutBoardManager implements Serializable {

    /**
     *  the LightsOut Board to be managed
     */
    private  LightsOutBoard lightsOutBoard;

    LightsOutBoard getLightsOutBoard() {
        return lightsOutBoard;
    }

    LightOutBoardManager(){
        List<Light> lights = new ArrayList<>();
        final int numLights = LightsOutBoard.NUM_COLS * LightsOutBoard.NUM_ROWS;
        for (int lightsNum = 0; lightsNum != numLights; lightsNum++){
            Light nextLight = new Light(lightsNum);
            //Assign light a random on or off state
            Random randomBool = new Random();
            nextLight.setLight(randomBool.nextBoolean());
            lights.add(new Light(lightsNum));
        }
        this.lightsOutBoard = new LightsOutBoard(lights);
    }

    /**
     * Return whether all lights in Light Out Board are On
     *
     * @return whether all lights in Light Out Board are On
     */
    boolean allLightsOn(){
        for (int i =0; i < lightsOutBoard.numLights()-1; i++){
            int row = i / LightsOutBoard.NUM_ROWS;
            int col = 1 % LightsOutBoard.NUM_COLS;
            Light lightToCheck = lightsOutBoard.getLight(row, col);
            if (!lightToCheck.getState()){
                return false;
            }
        }
        return true;
    }


}
