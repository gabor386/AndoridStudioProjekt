package com.example.rma.model.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cards {

    @SerializedName("yellow")
    @Expose
    private Long yellow;
    @SerializedName("red")
    @Expose
    private Long red;

    public Long getYellow() {
        return yellow;
    }

    public void setYellow(Long yellow) {
        this.yellow = yellow;
    }

    public Long getRed() {
        return red;
    }

    public void setRed(Long red) {
        this.red = red;
    }

}