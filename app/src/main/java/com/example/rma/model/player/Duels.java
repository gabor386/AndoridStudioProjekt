package com.example.rma.model.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Duels {

    @SerializedName("total")
    @Expose
    private Long total;
    @SerializedName("won")
    @Expose
    private Long won;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getWon() {
        return won;
    }

    public void setWon(Long won) {
        this.won = won;
    }

}