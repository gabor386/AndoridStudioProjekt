package com.example.rma.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.rma.R;
import com.example.rma.model.FixturesByDateModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class FixturesDateAdapter  extends BaseAdapter {
    private Activity context;
   private  ArrayList<FixturesByDateModel> fixtures;
   private  ArrayList<FixturesByDateModel> listFiltered;
    private static LayoutInflater inflater=null;


    public FixturesDateAdapter(Activity context,ArrayList<FixturesByDateModel>fixtures){
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
    public FixturesByDateModel getItem(int position) {
        return fixtures.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View itemView=convertView;
        itemView=(itemView==null)?inflater.inflate(R.layout.layout_listitem,null): itemView;
        TextView textViewName=(TextView)itemView.findViewById(R.id.textViewNameId);
        TextView timeTextView=itemView.findViewById(R.id.textViewDateId);
//        TextView rezultat=itemView.findViewById(R.id.rezultat);
        TextView goalHomeTeam=itemView.findViewById(R.id.goalHomeTeamId);
        TextView goalAwayTeam=itemView.findViewById(R.id.goalAwayTeam);

        TextView elapsed=itemView.findViewById(R.id.elapsedID);
        elapsed.setTextColor(Color.parseColor("#ff2052"));




        FixturesByDateModel selectedFixture=fixtures.get(position);
        textViewName.setText(selectedFixture.getHomeTeam()+"\n"+"   vs    "+"\n"+selectedFixture.getAwayTeam());

        timeTextView.setText(selectedFixture.getEventDate().substring(11,16));
//        rezultat.setText(selectedFixture.getFinalScore());

        goalHomeTeam.setText(selectedFixture.getGoalsHomeTeam());
        goalAwayTeam.setText(selectedFixture.getGoalsAwayTeam());


        elapsed.setText(selectedFixture.getElapsed());






        return itemView;
    }

//    Filter myFilter = new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//
//            FilterResults filterResults = new FilterResults();
//            ArrayList<FixturesByDateModel> tempList=new ArrayList<FixturesByDateModel>();
//            //constraint is the result from text you want to filter against.
//            //objects is your data set you will filter from
//            if(constraint != null && fixtures!=null) {
//                int length=fixtures.size();
//                int i=0;
//                while(i<length){
//                    FixturesByDateModel item=fixtures.get(i);
//                    //do whatever you wanna do here
//                    //adding result set output array
//
//                    tempList.add(item);
//
//                    i++;
//                }
//                //following two lines is very important
//                //as publish result can only take FilterResults objects
//                filterResults.values = tempList;
//                filterResults.count = tempList.size();
//            }
//            return filterResults;
//        }
//
//        @SuppressWarnings("unchecked")
//        @Override
//        protected void publishResults(CharSequence contraint, FilterResults results) {
//            fixtures = (ArrayList<FixturesByDateModel>) results.values;
//            if (results.count > 0) {
//                notifyDataSetChanged();
//            } else {
//                notifyDataSetInvalidated();
//            }
//        }
//    };
//    @Override
//    public Filter getFilter() {
//        Filter filter = new Filter() {
//
//            @SuppressWarnings("unchecked")
//            @Override
//            protected void publishResults(CharSequence constraint,FilterResults results) {
//
//                listFiltered = (ArrayList<FixturesByDateModel>) results.values; // has the filtered values
//                notifyDataSetChanged();  // notifies the data with new filtered values
//            }
//
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
//                ArrayList<FixturesByDateModel> FilteredArrList = new ArrayList<FixturesByDateModel>();
//
//                if (fixtures == null) {
//                    fixtures = new ArrayList<FixturesByDateModel>(listFiltered); // saves the original data in mOriginalValues
//
//                }
//
//                /********
//                 *
//                 *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
//                 *  else does the Filtering and returns FilteredArrList(Filtered)
//                 *
//                 ********/
//                if (constraint == null || constraint.length() == 0) {
//
//                    // set the Original result to return
//                    results.count = fixtures.size();
//                    results.values = fixtures;
//                    System.out.println("Hellooooo");
//                } else {
//                    constraint = constraint.toString().toLowerCase();
//                    for (int i = 0; i < fixtures.size(); i++) {
//                        String data = fixtures.get(i).getHomeTeam();
//                        if (data.toLowerCase().startsWith(constraint.toString())) {
//                            FilteredArrList.add(new FixturesByDateModel(fixtures.get(i).getHomeTeam(),fixtures.get(i).getAwayTeam()));
//                        }
//                    }
//                    // set the Filtered result to return
//                    results.count = FilteredArrList.size();
//                    results.values = FilteredArrList;
//                }
//                return results;
//            }
//        };
//        return filter;
//    }
}
