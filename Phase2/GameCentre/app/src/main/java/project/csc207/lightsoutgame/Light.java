package project.csc207.lightsoutgame;

import java.io.Serializable;
import java.util.Observable;

import project.csc207.R;

/**
 *  A light in LightsOut Board
 */
public class Light extends Observable implements Serializable {

    /**
     * the background id to set the light to be white or black
     */
    private int background;

    /**
     * the status of light, if On, then the light is white, otherwise is black.
     */
    private boolean isOn = true;

    /**
     *  the unique id for each light
     */
    private int id;


    public int getId() {
        return id;
    }

    public int getBackground() {
        return background;
    }

    boolean getState() {
        return isOn;
    }

    /**
     * switch the light, change the background of light and the getState state.
     */
     void switchLight(){
        if(this.isOn){
            setLight(false);
        }
        else{
            setLight(true);
        }
    }

    Light(int id){
        this.id = id;
        setLight(isOn);
    }

    /**
     * set the state and the background of the light based on the given statement of light
     * default statement is true for isOn
     * @param state the statement of light
     */
    void setLight(Boolean state){
        this.isOn = state;
        if (state){
            background = R.drawable.lightson;
        }
        else {
            background = R.drawable.lightsoff;
        }
    }

}