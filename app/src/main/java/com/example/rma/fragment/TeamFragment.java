package com.example.rma.fragment;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SyncStats;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rma.ApiInterface;
import com.example.rma.DatabaseHelper;
import com.example.rma.FavoriteActivity;
import com.example.rma.R;
import com.example.rma.adapter.StartXIAdapter;
import com.example.rma.model.FixturesByDateModel;
import com.example.rma.model.FixturesMatchFixturesModel;
import com.example.rma.model.FixturesMatchHomeTeamModel;
import com.example.rma.model.FixturesMatchModel;
import com.example.rma.model.NotificationBroadcast;
import com.example.rma.model.StartXI;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import net.danlew.android.joda.JodaTimeAndroid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TeamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeamFragment extends Fragment {
    private DatabaseHelper myDB=new DatabaseHelper(getActivity());
    private ListView listviewLayout,listView;
    private String teamId;
    private ImageView homeTeamImage,awayTeamImage;
    private TextView homeTeamName,awayTeamName,dateAndTime,rezultat,formactionHome,formationAway,status;
    private FixturesMatchHomeTeamModel homeTeam;
    private StartXIAdapter adapter,adapter2;
    private Button mapButton;
    private ImageButton notificationButton;

    Calendar notificationTime=Calendar.getInstance();
    String mapa,contry,fixtures_id;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TeamFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TeamFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeamFragment newInstance(String param1, String param2) {
        TeamFragment fragment = new TeamFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_team, container, false);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        JodaTimeAndroid.init(getActivity());


        int i=0;
        createNotificationChannel(i);

        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);

        boolean tablet;
        float yInches= metrics.heightPixels/metrics.ydpi;
        float xInches= metrics.widthPixels/metrics.xdpi;
        double diagonalInches = Math.sqrt(xInches*xInches + yInches*yInches);
        if (diagonalInches>=6.5){
            // 6.5inch t or bigger
            tablet=true;
        }else{
            tablet=false;
            // smaller device
        }

        Intent intent=getActivity().getIntent();

        final String fixturesString=intent.getStringExtra("Fixture");
        //System.out.println("FIXTURES STRING TEAMACTITY CLASS:     "+fixturesString);

        final FixturesByDateModel fixture=new Gson().fromJson(fixturesString, FixturesByDateModel.class);
        //System.out.println(fixture.toString());
        fixtures_id=fixture.getFixtureId();

        homeTeamImage =(ImageView) v.findViewById(R.id.homeTeamImage);
        awayTeamImage=(ImageView)v.findViewById(R.id.awayTeamImage);
        homeTeamName=v.findViewById(R.id.homeTeamText);
        awayTeamName=v.findViewById(R.id.awayTeamText);
        dateAndTime=v.findViewById(R.id.timeAndDate);
        mapButton=v.findViewById(R.id.buttonStadium);
        rezultat=v.findViewById(R.id.rezultat);
        rezultat.setText(fixture.getGoalsHomeTeam()+" - "+fixture.getGoalsAwayTeam());

        listviewLayout =v.findViewById(R.id.linearLayout);
        listView=v.findViewById(R.id.listViewAwayTeam);
        formactionHome=v.findViewById(R.id.formationHome);
        formationAway=v.findViewById(R.id.formationAway);
        status=v.findViewById(R.id.statusId);



        if(fixture.getStatus().equals("Match Finished")){
            status.setText(fixture.getStatus());
        }if(fixture.getStatus().equals("Not Started")) {
            status.setText(fixture.getStatus());
        }else{
            status.setText(fixture.getElapsed());
        }
        notificationButton=v.findViewById(R.id.idNotification);


        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");



        Date date = new Date();

        try {
            date = outputFormat.parse(fixture.getEventDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        notificationTime.setTime(date);
        Intent intent22 = new Intent(getActivity(), MapFragment.class);
        intent22.putExtra("map", mapa);
        intent22.putExtra("contry", contry);
//        startActivityForResult(intent,1);



        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent3=new Intent(getActivity(), NotificationBroadcast.class);
                intent3.putExtra("HomeTeam",fixture.getHomeTeam());
                intent3.putExtra("AwayTeam",fixture.getAwayTeam());

                PendingIntent pendingIntent=PendingIntent.getBroadcast(getActivity(),0,intent3,PendingIntent.FLAG_UPDATE_CURRENT);

                if(!myDB.checkIsInDBorNot(fixture.getFixtureId())) {
                    AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
                    alarmManager.set(AlarmManager.RTC_WAKEUP, notificationTime.getTimeInMillis(), pendingIntent);
                }
                AddData(fixture.getFixtureId());

                Intent intentFavorite=new Intent(getActivity(), FavoriteActivity.class);
                intentFavorite.putExtra("Fixture",(new Gson()).toJson(fixture));
                startActivity(intentFavorite);
            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tablet) {
//                    MapFragment mapFragment=new MapFragment();
//                    mapFragment.reloadMap(mapa);
                    System.out.println("ULAZZZZIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaII");

//

                    FragmentManager fragmentManager=getFragmentManager();
                    FragmentTransaction transaction=fragmentManager.beginTransaction();

                    MapFragment mapFragment=new MapFragment();
                    Bundle args=new Bundle();
                    args.putString("mapa",mapa);
                    mapFragment.setArguments(args);
                    transaction.add(R.id.map,mapFragment);

                    transaction.commit();


                }else {


                    Intent intent22 = new Intent(getActivity(), MapClass.class);
                    intent22.putExtra("map", mapa);
                    intent22.putExtra("contry", contry);
                    startActivity(intent22);
                }

            }
        });







//        mapButton.setOnClickListener(new View.OnClickListener() {
//
//            MapFragment mapFragment=new MapFragment();
//            FragmentTransaction transaction=getFragmentManager().beginTransaction();




//            @Override
//            public void onClick(View v) {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        Uri gmmIntentUri = Uri.parse("geo:0,0?q="+mapa+","+contry);
//                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//                        mapIntent.setPackage("com.google.android.apps.maps");
//                        startActivity(mapIntent);
//                        System.out.println(mapa);
//                    }
//                }, 0);
//            }
//        });

        final Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-football-v1.p.rapidapi.com/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiInterface jsonPlaceHolderApi = retrofit.create(ApiInterface.class);
        Call<FixturesMatchModel> call = jsonPlaceHolderApi.getTeamApi(fixtures_id);
        call.enqueue(new Callback<FixturesMatchModel>() {
            @Override
            public void onResponse(Call<FixturesMatchModel> call, Response<FixturesMatchModel> response) {
                if(!response.isSuccessful()){
                    Log.d("greska","greska je u TeamAcitvity");
                }

                FixturesMatchModel get=response.body();
                List<FixturesMatchFixturesModel> list=get.getApi().getFixtures();
                Log.d("Proslo ", "onResponse: Proslo je");
                for(FixturesMatchFixturesModel f: list){

                    String home=f.getHomeTeam().getLogo();
                    String away=f.getAwayTeam().getLogo();
                    mapa=f.getVenue();
                    contry=f.getLeague().getCountry();


                    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
                    SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm");
                    Date date = null;
                    try {
                        date = inputFormat.parse(f.getEventDate());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    String formattedDate = outputFormat.format(date);






                    homeTeamName.setText(f.getHomeTeam().getTeamName());
                    awayTeamName.setText(f.getAwayTeam().getTeamName());
                    dateAndTime.setText(formattedDate);



                    Map<String, Map<String, Object>> lineup=f.getLineups();

                    ArrayList<StartXI> homeTeamStart=new ArrayList<StartXI>();
                    ArrayList<StartXI> awayTeamStart=new ArrayList<StartXI>();
                    int brojac=0;
                    int tmp=0;
                    if(lineup==null){

                        break;
                    }
                    for(Map<String,Object>keys: lineup.values()){

                        for(String k: keys.keySet()){
                            if(k.equals("coach")){

                            }
                            if(k.equals("formation")&& tmp==0){
                                tmp++;
                                if(keys.get(k)!=null)
                                    formactionHome.setText(keys.get(k).toString());
                            }
                            if(  k.equals("startXI")&&brojac==0){
                                //String s=keys.get(k);


                                ArrayList<StartXI> s= (ArrayList<StartXI>) keys.get(k);
                                for(Object as: s){
                                    brojac++;
                                    StartXI start=new StartXI();
                                    Gson g=new Gson();
                                    String json=gson.toJson(as);

                                    start=g.fromJson(json,StartXI.class);
                                    homeTeamStart.add(start);
                                }


                            }
                            if(brojac!=0 && k.equals("startXI") ){
                                brojac++;
                                ArrayList<StartXI> ss= (ArrayList<StartXI>) keys.get(k);
                                for(Object ass: ss){
                                    StartXI start2=new StartXI();
                                    Gson g2=new Gson();
                                    String json2=g2.toJson(ass);

                                    start2=g2.fromJson(json2,StartXI.class);
                                    awayTeamStart.add(start2);
                                }

                            }
                            if(k.equals("formation")&& tmp!=0) {
                                tmp++;
                                if(keys.get(k)!=null)
                                    formationAway.setText(keys.get(k).toString());
                            }

                        }
                    }

//                    for(StartXI l: homeTeamStart)
//                        System.out.println( "Home"+l.getPlayer());

                    for(int i=0;i<11;i++){
                        if(!awayTeamStart.isEmpty()) {
                            awayTeamStart.remove(0);
                        }
                    }
//                    for(StartXI i : awayTeamStart){
//                        System.out.println("Away"+i.getPlayer());
//                    }

                    adapter=new StartXIAdapter(getActivity(),homeTeamStart,list);
                    listviewLayout.setAdapter(adapter);

                    adapter2=new StartXIAdapter(getActivity(),awayTeamStart,list);
                    //listView.setTextFilterEnabled(true);
                    listView.setAdapter(adapter2);

                    Picasso.get().load(home).into(homeTeamImage);
                    Picasso.get().load(away).into(awayTeamImage);
                }
            }

            @Override
            public void onFailure(Call<FixturesMatchModel> call, Throwable t) {
                Log.d("TeamActivy", "TEAMACtivity greska : Greska");

            }
        });

        return v;

    }
    private void createNotificationChannel(int i){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            i++;
            CharSequence name="LReminderChannel";
            String description="Channel for L Reminder";
            int importnace= NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel=new NotificationChannel("idChannel",name,importnace);
            channel.setDescription(description);

            NotificationManager notificationManager= getActivity().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }

    private void AddData(String newEntry){
        System.out.println("CHEEECKK"+newEntry);
        if(myDB.checkIsInDBorNot(newEntry)){
            Toast.makeText(getActivity(),"Utakmica vec postoji u Favourite",Toast.LENGTH_SHORT).show();
            return;
        }
        boolean inserData=myDB.addData(newEntry);
        if(inserData==true){
            Toast.makeText(getActivity(),"Uspeno je dodato u Favourite",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(),"SOmting bad",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myDB= new DatabaseHelper(context);
    }

}