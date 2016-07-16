package com.thongle.dribbbleapp.data.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ThongLe on 4/28/2016.
 */
public class ShotWrapper {
    @SerializedName("shot")
    private Shot shot;

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }
}
