package com.example.rma.model.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tackles {

    @SerializedName("total")
    @Expose
    private Long total;
    @SerializedName("blocks")
    @Expose
    private Long blocks;
    @SerializedName("interceptions")
    @Expose
    private Long interceptions;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getBlocks() {
        return blocks;
    }

    public void setBlocks(Long blocks) {
        this.blocks = blocks;
    }

    public Long getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(Long interceptions) {
        this.interceptions = interceptions;
    }

}