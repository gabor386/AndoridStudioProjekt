package com.example.rma;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.rma.adapter.FavoriteAdapter;
import com.example.rma.model.FixturesByDateModel;
import com.example.rma.model.FixturesMatchFixturesModel;
import com.example.rma.model.FixturesMatchModel;
import com.example.rma.model.StartXI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FavoriteActivity extends AppCompatActivity {
    private TextView hometeam,rezultat,vreme;
    private ListView listViewLayout;
    private FavoriteAdapter adapter;
    ArrayList<FixturesMatchFixturesModel>listAdapter=new ArrayList<>();
    DatabaseHelper myDB;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);


        listViewLayout=findViewById(R.id.favoriteId);
        //ListView listView=findViewById(R.id.favoriteId);
        myDB=new DatabaseHelper(this);

        //System.out.println("fixtures objekat is passing by: "+stringFixtures);



        getListViewItems();
    }



    private void getListViewItems() {
        ArrayList<String> theList=new ArrayList<>();
        Cursor data=myDB.getListContents();

        if(data.getCount()==0){
            Toast.makeText(FavoriteActivity.this,"The DataBase was empty",Toast.LENGTH_SHORT).show();
        }
        else {
            while (data.moveToNext()){
                theList.add(data.getString(1));
                final Gson gson = new GsonBuilder()
                        .excludeFieldsWithoutExposeAnnotation()
                        .create();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api-football-v1.p.rapidapi.com/v2/")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
                ApiInterface jsonPlaceHolderApi = retrofit.create(ApiInterface.class);
                Call<FixturesMatchModel> call = jsonPlaceHolderApi.getTeamApi(data.getString(1));
                call.enqueue(new Callback<FixturesMatchModel>() {
                    @Override
                    public void onResponse(Call<FixturesMatchModel> call, Response<FixturesMatchModel> response) {
                        if(!response.isSuccessful()){
                            Log.d("greska","greska je u TeamAcitvity");
                        }
                        FixturesMatchModel get=response.body();
                        List<FixturesMatchFixturesModel> list;
                        try {
                             list = get.getApi().getFixtures();
                        } catch (Exception e) {

                                 e.printStackTrace();
                                return;
                        }

                        listAdapter.addAll(list);
                        Log.d("Proslo ", "onResponse: Proslo je");
                        for(FixturesMatchFixturesModel f: list){
                            FixturesMatchFixturesModel object;
                            System.out.println(f.getFixtureId());
                            String home=f.getHomeTeam().getLogo();
                            String away=f.getAwayTeam().getLogo();

                            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
                            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm");
                            Date date = null;
                            try {
                                date = inputFormat.parse(f.getEventDate());
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            String formattedDate = outputFormat.format(date);

                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            listAdapter.sort(new Comparator<FixturesMatchFixturesModel>() {
                                @Override
                                public int compare(FixturesMatchFixturesModel o1, FixturesMatchFixturesModel o2) {
                                    return o1.getEventDate().compareTo(o2.getEventDate());
                                }
                            });
                        }
                        for(FixturesMatchFixturesModel l:listAdapter){

                            System.out.println("Lista adapter Nije praznva : "+l.getFixtureId());
                            System.out.println("asdasda"+l.getHomeTeam().getTeamName()+" vs "+l.getAwayTeam().getTeamName());
                        }
                        adapter=new FavoriteAdapter(FavoriteActivity.this,listAdapter);
                        if(adapter==null)
                            System.out.println("greska je");
                        else
                            System.out.println("nije greska");
                        listViewLayout.setAdapter(adapter);



                    }
                    @Override
                    public void onFailure(Call<FixturesMatchModel> call, Throwable t) {
                        Log.d("TeamActivy", "TEAMACtivity greska : Greska");

                    }
                });
                listViewLayout.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        //Toast.makeText(FavoriteActivity.this,"GOOOOODDD",Toast.LENGTH_SHORT).show();
                        FixturesMatchFixturesModel c=(FixturesMatchFixturesModel) parent.getItemAtPosition(position);
                        String name= String.valueOf(c.getFixtureId());
                        Cursor data=myDB.getItemID(name);
                        int itemID=-1;
                        while(data.moveToNext()){
                            itemID=data.getInt(0);
                        }
                        if(itemID>-1){
                            Log.d("itemid>-1 ", "onItemLongClick: The ID is"+itemID);
                            myDB.deleteName(itemID,name);
                            listAdapter.remove(position);

                            Toast.makeText(FavoriteActivity.this,"Successfully Deleted",Toast.LENGTH_LONG).show();
                        }else
                            Toast.makeText(FavoriteActivity.this,"Can not delete, something went wrong",Toast.LENGTH_SHORT).show();


                        adapter.notifyDataSetChanged();
                        return true;

                    }
                });

                listViewLayout.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(FavoriteActivity.this,TeamActivity.class);

                        FixturesMatchFixturesModel d =listAdapter.get(position);
                        FixturesByDateModel toTeamActivty=new FixturesByDateModel();
                        toTeamActivty.setAwayTeam(d.getAwayTeam().getTeamName());
                        toTeamActivty.setAwayTeam(d.getAwayTeam().getTeamId().toString());
                        toTeamActivty.setElapsed(d.getEventDate());
                        toTeamActivty.setEventDate(d.getEventDate());
                        toTeamActivty.setFinalScore("");
                        toTeamActivty.setFixtureId(d.getFixtureId().toString());
                        if(d.getGoalsHomeTeam()!=null) {
                            toTeamActivty.setGoalsAwayTeam(d.getGoalsAwayTeam().toString());
                            toTeamActivty.setGoalsHomeTeam(d.getGoalsHomeTeam().toString());
                        }else{
                            toTeamActivty.setGoalsAwayTeam("");
                            toTeamActivty.setGoalsHomeTeam("");
                        }
                        toTeamActivty.setHalftimeScore("");
                        toTeamActivty.setHomeTeam(d.getHomeTeam().getTeamName());
                        toTeamActivty.setHomeTeamId(d.getHomeTeam().getTeamId().toString());
                        toTeamActivty.setLeagueId(d.getLeagueId().toString());
                        toTeamActivty.setStatus(d.getStatus());
                        Intent intent2=getIntent();


                        final String stringFixtures=intent2.getStringExtra("Fixture");
                        final FixturesByDateModel fixture=new Gson().fromJson(stringFixtures, FixturesByDateModel.class);

                        intent.putExtra("Fixture",(new Gson().toJson(toTeamActivty)));
                        startActivity(intent);
                    }
                });



            }
        }
    }
    private Handler handler=new Handler();
    private Runnable runnable;

    @Override
    protected void onPostResume() {

        super.onPostResume();
        proba();
    }
    private  void proba(){
        handler.postDelayed(runnable=new Runnable() {
            @Override
            public void run() {
                listAdapter.removeAll(listAdapter);
                getListViewItems();
                System.out.println("Runs Again");
                handler.postDelayed(runnable,60000);
            }
        },60000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void stop(){
        handler.removeCallbacks(runnable);
    }
}