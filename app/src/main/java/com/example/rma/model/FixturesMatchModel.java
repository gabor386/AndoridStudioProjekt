package com.example.rma.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FixturesMatchModel {
    @SerializedName("api")
    @Expose
    private FixturesMatchApiModel api;

    public FixturesMatchApiModel getApi() {
        return api;
    }

    public void setApi(FixturesMatchApiModel api) {
        this.api = api;
    }

}
