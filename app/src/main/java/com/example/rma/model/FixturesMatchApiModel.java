package com.example.rma.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class FixturesMatchApiModel {

    @SerializedName("results")
    @Expose
    private Long results;
    @SerializedName("fixtures")
    @Expose
    private List<FixturesMatchFixturesModel> fixtures = null;

    public Long getResults() {
        return results;
    }

    public void setResults(Long results) {
        this.results = results;
    }

    public List<FixturesMatchFixturesModel> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<FixturesMatchFixturesModel> fixtures) {
        this.fixtures = fixtures;
    }

}
