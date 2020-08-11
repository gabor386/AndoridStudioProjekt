package com.example.rma;


import com.example.rma.model.Example;
import com.example.rma.model.FixturesMatchModel;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {



   @GET("fixtures/date/{date}/?rapidapi-key=52fadf2b11msh43a535a973b5879p16d181jsn26a345a89254")
    Call<Example>getApi(@Path("date")String date);

   @GET("fixtures/id/{fixtures_id}/?rapidapi-key=52fadf2b11msh43a535a973b5879p16d181jsn26a345a89254")
    Call<FixturesMatchModel>getTeamApi(@Path("fixtures_id") String fixtures_id);

}
