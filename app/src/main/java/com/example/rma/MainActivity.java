package com.example.rma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rma.adapter.FixturesDateAdapter;
import com.example.rma.model.FixturesByDateModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
//import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private MainActivity s=this;

    private TextView textViewResult,TextViewResult2;
    private Button mBtn;

    private Calendar c;
    private DatePickerDialog dpd;

    String datumString="";

    Date date = new Date();

    FixturesByDate f;
    ArrayList<FixturesByDateModel>listOfFixutres=new ArrayList<>();

    FixturesDateAdapter adapter;
    ListView listViewFixtures;
    EditText theFilter;

    private static MainActivity instance;

    public static MainActivity getInstance() {
        return instance;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if(item.getItemId()==R.id.item1){

            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    c=Calendar.getInstance();
                    int year=c.get(Calendar.YEAR);
                    int month=c.get(Calendar.MONTH);
                    int day=c.get(Calendar.DAY_OF_MONTH);

                    dpd=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            month+=1;

                            datumString=year+"-"+month+"-"+dayOfMonth;
                            Log.d("Datum",""+datumString);
                            new FixturesByDate(textViewResult,listViewFixtures,s).invoke(datumString);
                            //TextViewResult2=(TextView) findViewById(R.id.datetxtview);
                            //TextViewResult2.setText(datumString);
                        }
                    },year,month,day);


                    dpd.show();
                    return true;
                }
            });



        }

        if(item.getItemId()==R.id.favoriteMenuId){
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Intent intentstar=new Intent(MainActivity.this,FavoriteActivity.class);
                    FixturesByDate fixtures=new FixturesByDate(listOfFixutres);

                    startActivity(intentstar);
                    return true;
                }
            });

        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);



        datumString= new SimpleDateFormat("yyyy-MM-dd").format(date);
        //TextViewResult2=(TextView) findViewById(R.id.datetxtview);
       // TextViewResult2.setText(datumString);

       textViewResult=(TextView) findViewById(R.id.text_viewe_result);
       listViewFixtures=(ListView) findViewById(R.id.listView);

       setTitle(datumString);











        new FixturesByDate(textViewResult,listViewFixtures,s).invoke(datumString);
        //System.out.println(datumString);



        //FixturesByDate fixtureList=new FixturesByDate(listOfFixutres);
        //listOfFixutres=fixtureList.getListOfFixutres();
        //listOfFixutres.add(new FixturesByDateModel("a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"));

//        for(FixturesByDateModel f: listOfFixutres){
//            System.out.println(" HomeTeam : "+f.getAwayTeamId());
//        }
//            listViewFixtures= (ListView) findViewById(R.id.listView);
//         adapter = new FixturesDateAdapter(this, listOfFixutres);
//         listViewFixtures.s2etAdapter(adapter);
//         listViewFixtures.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//             @Override
//             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                 TextView v=(TextView)view.findViewById(R.id.textViewNameId);
//                 Toast.makeText(getApplicationContext(),"HERE : "+position,Toast.LENGTH_SHORT).show();
//             }
//         });
    }

    ///////////////////////////////////////////////////////////////
//    private Handler handler=new Handler();
//    private Runnable runnable;
//
//    @Override
//    protected void onPostResume() {
//
//        super.onPostResume();
//        proba();
//    }
//    private  void proba(){
//        handler.postDelayed(runnable=new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Runs Again");
//                handler.postDelayed(runnable,3000);
//            }
//        },3000);
//
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        stop();
//    }
//
//    public void stop(){
//        handler.removeCallbacks(runnable);
//    }
}
