package com.example.rma.model.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fouls {

    @SerializedName("drawn")
    @Expose
    private Long drawn;
    @SerializedName("committed")
    @Expose
    private Long committed;

    public Long getDrawn() {
        return drawn;
    }

    public void setDrawn(Long drawn) {
        this.drawn = drawn;
    }

    public Long getCommitted() {
        return committed;
    }

    public void setCommitted(Long committed) {
        this.committed = committed;
    }

}