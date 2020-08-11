package com.example.rma.model.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Penalty {

    @SerializedName("won")
    @Expose
    private Long won;
    @SerializedName("commited")
    @Expose
    private Long commited;
    @SerializedName("success")
    @Expose
    private Long success;
    @SerializedName("missed")
    @Expose
    private Long missed;
    @SerializedName("saved")
    @Expose
    private Long saved;

    public Long getWon() {
        return won;
    }

    public void setWon(Long won) {
        this.won = won;
    }

    public Long getCommited() {
        return commited;
    }

    public void setCommited(Long commited) {
        this.commited = commited;
    }

    public Long getSuccess() {
        return success;
    }

    public void setSuccess(Long success) {
        this.success = success;
    }

    public Long getMissed() {
        return missed;
    }

    public void setMissed(Long missed) {
        this.missed = missed;
    }

    public Long getSaved() {
        return saved;
    }

    public void setSaved(Long saved) {
        this.saved = saved;
    }

}