package com.example.rma.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Api {



    @SerializedName("results")
    @Expose
    private Integer results;
    @SerializedName("fixtures")
    @Expose
    private  Map<String,Map<String,String>> fixtures;

    public Integer getResults() {
        return results;
    }

    public Map<String, Map<String, String>> getFixtures() {
        return fixtures;
    }

    public Api(Integer results, Map<String, Map<String, String>> fixtures) {
        this.results = results;
        this.fixtures = fixtures;
    }
}
