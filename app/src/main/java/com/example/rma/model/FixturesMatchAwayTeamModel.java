package com.example.rma.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FixturesMatchAwayTeamModel {
    @SerializedName("team_id")
    @Expose
    private Long teamId;
    @SerializedName("team_name")
    @Expose
    private String teamName;
    @SerializedName("logo")
    @Expose
    private String logo;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
