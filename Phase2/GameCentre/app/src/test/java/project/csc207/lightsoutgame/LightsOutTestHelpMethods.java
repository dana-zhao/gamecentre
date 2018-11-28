package project.csc207.lightsoutgame;

class LightsOutTestHelpMethods {

    static void getLightsAllOn(LightsOutBoard board){
        for (Light l: board) {
            l.setLight(true);
        }
    }

    static void getLightsAllOff(LightsOutBoard board){
        for (Light l: board) {
            l.setLight(false);
        }
    }
}
