package project.csc207.lightsoutgame;

public class LightsOutTestHelpMethods {

    static void getLightsAllOn(LightsOutBoard board){
        for (Light l: board) {
            l.setLight(true);
        }
    }
}
