package com.example.rma.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.rma.R;
import com.example.rma.model.FixturesByDateModel;
import com.example.rma.model.FixturesMatchFixturesModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FavoriteAdapter extends BaseAdapter {
    private Activity context;
    private ArrayList<FixturesMatchFixturesModel>fixtures;
    private static LayoutInflater inflater=null;

    public FavoriteAdapter(Activity context,ArrayList<FixturesMatchFixturesModel>fixtures){
        this.context=context;
        this.fixtures=fixtures;
        inflater=(LayoutInflater)context.
                getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return fixtures.size();
    }

    @Override
    public FixturesMatchFixturesModel getItem(int position) {
        return fixtures.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView=convertView;
        itemView=(itemView==null)?inflater.inflate(R.layout.layout_favortite,null):itemView;
        TextView textViewName=itemView.findViewById(R.id.textViewNameIdFavorite);
        TextView timeTextView=itemView.findViewById(R.id.textViewDateIdFavorite);
        TextView goalHomeTeam=itemView.findViewById(R.id.goalHomeTeamIdFavorite);
        TextView goalAwayTeam=itemView.findViewById(R.id.goalAwayTeamFavorite);
        TextView time=itemView.findViewById(R.id.elapsedID);
        TextView dateText=itemView.findViewById(R.id.dateFavourite);
        time.setTextColor(Color.parseColor("#ff2052"));


        FixturesMatchFixturesModel selectedFixture=fixtures.get(position);
        textViewName.setText(selectedFixture.getHomeTeam().getTeamName()+"\n"+"   vs    "+"\n"+selectedFixture.getAwayTeam().getTeamName());

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm");
        Date date = null;
        try {
            date = inputFormat.parse(selectedFixture.getEventDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDate = outputFormat.format(date);
        timeTextView.setText(formattedDate);



        SimpleDateFormat outputFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = null;
        try {
            date2 = inputFormat.parse(selectedFixture.getEventDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDate2 = outputFormat2.format(date2);
        dateText.setText(formattedDate2);



        String goalHome="";
        String goalAway="";
        if(selectedFixture.getGoalsHomeTeam()!=null) {
             goalHome = Long.toString(selectedFixture.getGoalsHomeTeam());
        }
        if(selectedFixture.getGoalsAwayTeam()!=null) {
            goalAway = Long.toString(selectedFixture.getGoalsAwayTeam());
        }


        goalHomeTeam.setText(goalHome);
        goalAwayTeam.setText(goalAway);


        time.setText(selectedFixture.getStatus()+"  '" + selectedFixture.getElapsed().toString());


        //rezultat.setText(selectedFixture.getGoalsAwayTeam().toString());

        return itemView;
    }


}
