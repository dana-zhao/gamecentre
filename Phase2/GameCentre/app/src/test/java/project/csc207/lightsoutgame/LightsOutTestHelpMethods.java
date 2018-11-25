package project.csc207.lightsoutgame;

class LightsOutTestHelpMethods {

    void getLightsAllOn(LightsOutBoard board){
        for (Light l: board) {
            l.setLight(true);
        }
    }

    void getLightsAllOff(LightsOutBoard board){
        for (Light l: board) {
            l.setLight(false);
        }
    }
}
