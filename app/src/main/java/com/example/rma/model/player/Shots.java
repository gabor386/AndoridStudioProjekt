package com.example.rma.model.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shots {

    @SerializedName("total")
    @Expose
    private Long total;
    @SerializedName("on")
    @Expose
    private Long on;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getOn() {
        return on;
    }

    public void setOn(Long on) {
        this.on = on;
    }

}