package project.csc207.lightsOutGame;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class Light implements Comparable<Light>, Serializable {

    private int backgroud;

    private boolean isOn = false;

    private int id;

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(@NonNull Light o) {
        return o.id - this.id;
    }


}
