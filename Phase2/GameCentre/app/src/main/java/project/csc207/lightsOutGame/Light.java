package project.csc207.lightsOutGame;

import android.support.annotation.NonNull;

import java.io.Serializable;

import project.csc207.R;

/**
 *  A light in LightsOut Board
 */
public class Light implements Comparable<Light>, Serializable {

    /**
     * the background id to set the light to be white or black
     */
    private int background;

    /**
     * the status of light, if On, then the light is white, otherwise is black.
     */
    private boolean isOn = false;

    /**
     *  the unique id for each light
     */
    private int id;


    public int getId() {
        return id;
    }

    public int getBackgroud() {
        return background;
    }

    public boolean isOn() {
        return isOn;
    }

    /**
     * switch the light, change the background of light and the isOn state.
     * @param light as a Light Object
     */
    public void stwich(Light light){
        if(light.isOn){
            light.isOn = false;
            light.background = R.drawable.black;
        }
        else{
            light.isOn = true;
            light.background = R.drawable.white;
        }
    }


    Light(int id){
        this.id = id;
        if (this.isOn){
            background = R.drawable.white;
        }
        else{
            background = R.drawable.black;
        }
    }
    @Override
    public int compareTo(@NonNull Light o) {
        return o.id - this.id;
    }


}
