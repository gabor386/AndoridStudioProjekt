package com.example.rma;

import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.rma.adapter.FixturesDateAdapter;
import com.example.rma.model.Example;
import com.example.rma.model.FixturesByDateModel;
import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FixturesByDate extends MainActivity {



    private ListView listViewFixtures;
    private TextView textViewResult;
    private MainActivity mainActivity;

    private EditText editText;


    private Date date =new Date();

    private FixturesDateAdapter adapter;

    private  ArrayList<FixturesByDateModel> listOfFixutres=new ArrayList<FixturesByDateModel>();

    public ArrayList<FixturesByDateModel> getListOfFixutres() {
        return listOfFixutres;
    }

    public FixturesByDate(TextView textViewResult,ListView listViewFixtures,MainActivity mainActivity){
        this.textViewResult=textViewResult;
        this.listViewFixtures=listViewFixtures;
        this.mainActivity=mainActivity;
    }
    public FixturesByDate(ArrayList<FixturesByDateModel> listOfFixutres){
        this.listOfFixutres=listOfFixutres;
    }






    public void invoke(final String datumString) {

        textViewResult=textViewResult.findViewById(R.id.text_viewe_result);
        listViewFixtures=listViewFixtures.findViewById(R.id.listView);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-football-v1.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface jsonPlaceHolderApi = retrofit.create(ApiInterface.class);
        Call<Example> call = jsonPlaceHolderApi.getApi(datumString);
        call.enqueue(new Callback<Example>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (!response.isSuccessful()) {
                    //textViewResult.setText("Code: " + response.code());
                    return;
                }
                Example posts = response.body();
                Map<String, Map<String,String>> fixture=posts.getApi().getFixtures();

                Log.d("hello",""+posts.getApi().getResults());
                //Log.d("datum",""+posts.getApi().getFixtures().get(datumString));
                for(Map<String,String> keys: fixture.values()){
                   // Log.d("Key "," Key :" +keys);
                    FixturesByDateModel objectOfFixtures= new FixturesByDateModel();
                   for(String k: keys.keySet()){

                       if(k.equals("fixture_id")){
                           objectOfFixtures.setFixtureId(keys.get(k));
                       }
                       if(k.equals("league_id")){
                           objectOfFixtures.setLeagueId(keys.get(k));
                       }
                       if(k.equals("awayTeam_id")){
                           objectOfFixtures.setAwayTeamId(keys.get(k));
                       }
                       if(k.equals("awayTeam")){
                           objectOfFixtures.setAwayTeam(keys.get(k));
                       }

                       if(k.equals("goalsHomeTeam")){
                           if(keys.get(k)!="Not Started" || keys.get(k)!= "Match Postponed") {
                               objectOfFixtures.setGoalsHomeTeam(keys.get(k));
                           }
                       }

                       if(k.equals("goalsAwayTeam")){
                           if(keys.get(k)!="Not Started" || keys.get(k)!="Match Postponed") {
                               objectOfFixtures.setGoalsAwayTeam(keys.get(k));
                           }
                       }
                       if(k.equals("halftime_score")){
                           objectOfFixtures.setHalftimeScore(keys.get(k));
                       }
                       if(k.equals("final_score")){
                           objectOfFixtures.setFinalScore(keys.get(k));
                       }
                       if(k.equals("homeTeam")){
                           objectOfFixtures.setHomeTeam(keys.get(k));
                           //System.out.println(keys.get(k));
                           String s="\n"+keys.get(k);
                       }
                       if(k.equals("elapsed")){
                           if(!keys.get(k).equals("null") && !keys.get(k).equals("0") && keys.get(k)!=null){
                               objectOfFixtures.setElapsed("'"+keys.get(k));
                           }
                       }

                       if(k.equals("homeTeam_id")){
                           objectOfFixtures.setHomeTeamId(keys.get(k));
                       }
                       if(k.equals("status")){
                           objectOfFixtures.setStatus(keys.get(k));

                            }
                            if(k.equals("event_date")){
                                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
                                SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                Date date = null;
                                try {
                                    date = inputFormat.parse(keys.get(k));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                String formattedDate = outputFormat.format(date);

                                objectOfFixtures.setEventDate(formattedDate);
                            }
                            if(k.equals("final_score")){
                                if(keys.get(k)==null){
                                objectOfFixtures.setFinalScore("-");
                            }else {
                                objectOfFixtures.setFinalScore(keys.get(k));
                            }

                        }

                   }
                   if(objectOfFixtures.getStatus().equals("Halftime")){
                       objectOfFixtures.setElapsed("Halftime");
                   }
                   if(objectOfFixtures.getStatus().equals("Not Started") || objectOfFixtures.getStatus().equals("Match Postponed")){
                       objectOfFixtures.setGoalsHomeTeam("");
                       objectOfFixtures.setGoalsAwayTeam("");
                   }
                   if(objectOfFixtures.getStatus().equals("Match Postponed")){
                       objectOfFixtures.setElapsed("Match Postponed");
                   }

                    listOfFixutres.add(objectOfFixtures);

                }

                listOfFixutres.sort(new Comparator<FixturesByDateModel>() {
                    @Override
                    public int compare(FixturesByDateModel o1, FixturesByDateModel o2) {
                        return o1.getEventDate().compareTo(o2.getEventDate());
                    }
                });

                adapter = new FixturesDateAdapter(mainActivity, listOfFixutres);
                listViewFixtures.setAdapter(adapter);
                listViewFixtures.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(mainActivity,TeamActivity.class);
                        if(listOfFixutres.get(position).getStatus().equals("Match Finished"))
                            listOfFixutres.get(position).setElapsed("Match Finished");
                        FixturesByDateModel d =listOfFixutres.get(position);
                        intent.putExtra("Fixture",(new Gson()).toJson(d));
                        mainActivity.startActivity(intent);
                    }
                });

                mainActivity.setTitle(datumString);

            }
            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("GRESKA","GRESKA"+t.getMessage());
                textViewResult.setText(t.getMessage());
            }
        });
    }
}