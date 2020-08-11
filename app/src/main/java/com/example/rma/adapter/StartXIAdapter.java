package com.example.rma.adapter;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.rma.R;
import com.example.rma.TeamActivity;
import com.example.rma.model.FixturesMatchFixturesModel;
import com.example.rma.model.StartXI;
import com.example.rma.model.player.Players;

import java.util.ArrayList;
import java.util.List;

public class StartXIAdapter extends BaseAdapter {
    private Activity context;
    private ArrayList<StartXI> fixtures;
    private List<FixturesMatchFixturesModel>list;


    private static LayoutInflater inflater=null;


    public StartXIAdapter(Activity context, ArrayList<StartXI>fixtures, List<FixturesMatchFixturesModel>list){
        this.context=context;
        this.fixtures=fixtures;
        this.list=list;

        inflater=(LayoutInflater)context.
                getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return fixtures.size();
    }

    @Override
    public StartXI getItem(int position) {
        return fixtures.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView=convertView;
        itemView=(itemView==null)?inflater.inflate(R.layout.layout_listofstart,null): itemView;

        TextView textViewName=(TextView)itemView.findViewById(R.id.honeTeamStartXI);
        ImageView imageView=itemView.findViewById(R.id.goalIconImageView);

        //TextView timeTextView=itemView.findViewById(R.id.textViewDateId);

        StartXI selectedFixture=fixtures.get(position);
        System.out.println("FIXTURES +"+selectedFixture.getPlayer());
        textViewName.setGravity(Gravity.CENTER);
        textViewName.setText(selectedFixture.getPlayer()+"  ("+selectedFixture.getPos()+")");

//        FixturesMatchFixturesModel nw=list.get(position);
//        List<Players> playersss=nw.getPlayers();
//        for(Players p:playersss){
//            if(p.getGoals().getTotal()>0) {
//                imageView.setImageResource(R.drawable.ic_favorite);
//            }
//        }

//        for(FixturesMatchFixturesModel f: list){
//            List<Players> player=f.getPlayers();
//            if(player!=null) {
//                for (Players p : player) {
//                    if (selectedFixture.getPlayer().equals(p.getPlayerName())) {
//                        for (long i = 0; i < p.getGoals().getTotal(); i++) {
//                           // imageView.setImageResource(R.drawable.ball);
//
//                            ImageView v=new ImageView(teamActivity);
//                            v.requestLayout();
//                            v.setMaxHeight(1);
//                            v.setMaxWidth(1);
//                            v.setScaleType(ImageView.ScaleType.FIT_XY);
//                            v.setImageResource(R.drawable.bbbb);
//
//                            RelativeLayout rl=new RelativeLayout(teamActivity);
//                            rl=itemView.findViewById(R.id.layoutStartXi);
//                            rl.addView(v);

                            //rl.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));


//                        }
//                    }
//                }
//            }
//        }


//        FixturesMatchFixturesModel p=  list.get(0);
//        if(p.getPlayers().get(position)!=null) {
//
//            Players play = p.getPlayers().get(position);
//            System.out.println("GET TOTAL : "+play.getGoals().getTotal());
//            if (play.getGoals().getTotal() > 0)
//                imageView.setImageResource(R.drawable.ic_favorite);
//        int golas=0;
//        for(Players pa:play){
//            if(pa.getGoals().getTotal()>0)
//                imageView.setImageResource(R.drawable.ic_favorite);
//            golas++;
//        }








//        timeTextView.setText(selectedFixture.getEventDate());
        return itemView;
    }

}
