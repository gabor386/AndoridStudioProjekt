package com.example.rma.model.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Passes {

    @SerializedName("total")
    @Expose
    private Long total;
    @SerializedName("key")
    @Expose
    private Long key;
    @SerializedName("accuracy")
    @Expose
    private Long accuracy;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public Long getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Long accuracy) {
        this.accuracy = accuracy;
    }

}