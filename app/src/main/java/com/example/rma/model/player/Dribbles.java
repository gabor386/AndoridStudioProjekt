package com.example.rma.model.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dribbles {

    @SerializedName("attempts")
    @Expose
    private Long attempts;
    @SerializedName("success")
    @Expose
    private Long success;
    @SerializedName("past")
    @Expose
    private Long past;

    public Long getAttempts() {
        return attempts;
    }

    public void setAttempts(Long attempts) {
        this.attempts = attempts;
    }

    public Long getSuccess() {
        return success;
    }

    public void setSuccess(Long success) {
        this.success = success;
    }

    public Long getPast() {
        return past;
    }

    public void setPast(Long past) {
        this.past = past;
    }

}