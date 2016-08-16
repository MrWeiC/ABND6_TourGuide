package uno.weichen.tourguide;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThingsToDo extends Fragment {


    public ThingsToDo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.site_listview, container, false);

        final ArrayList<Site> sites = new ArrayList<>();

        sites.add(new Site("North Carolina Museum of Natural Sciences","11 W Jones St",R.drawable.beach,R.drawable.c2));
        sites.add(new Site("North Carolina Museum of Art","2110 Blue Ridge Rd, Raleigh",R.drawable.beach_ball,R.drawable.c1));
        sites.add(new Site("Pullen Park","520 Ashe Ave",R.drawable.beach_umbrella,R.drawable.c3));
        sites.add(new Site("Marbles Kids Museum Park","201 E Hargett St",R.drawable.big_ben,R.drawable.c4));
        sites.add(new Site("North Carolina Museum of History","5 E Edenton St",R.drawable.bust,R.drawable.c5));
        sites.add(new Site("PNC Arena","1400 Edwards Mill Rd",R.drawable.cave,R.drawable.c6));
        sites.add(new Site("Neuse River Trail","Neuse River Trail",R.drawable.coconut_cocktail,R.drawable.c7));
        sites.add(new Site("JC Raulston Arboretum","4415 Beryl Rd",R.drawable.colosseum,R.drawable.c8));
        //set the adapter the site list
        SitesItemAdapter itemAdapter = new SitesItemAdapter(getActivity(),sites);
        //bundle this adapter to the list view
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        //set the list view with the itemAdpater
        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getContext();

                Intent intent = new Intent(context, SitesDetailActivity.class);
                intent.putExtra(SitesDetailActivity.EXTRA_NAME, sites.get(position).getmName());
                intent.putExtra(SitesDetailActivity.EXTRA_ADDRESS, sites.get(position).getmAddress());
                intent.putExtra(SitesDetailActivity.EXTRA_PICID, sites.get(position).getmPicId());
                context.startActivity(intent);
            }
        });

        return rootView;
    }

}
