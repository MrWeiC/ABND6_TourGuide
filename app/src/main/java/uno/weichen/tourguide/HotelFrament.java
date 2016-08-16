package uno.weichen.tourguide;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelFrament extends Fragment {


    public HotelFrament() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.site_listview, container, false);

        final ArrayList<Site> sites = new ArrayList<>();

        sites.add(new Site("Hampton Inn & Suites Raleigh Downtown","600 Glenwood Ave, Raleigh",R.drawable.taj_mahal,R.drawable.c4));
        sites.add(new Site("Hilton Garden Inn Raleigh","3912 Arrow Dr, Raleigh, NC 27612-4657",R.drawable.museum,R.drawable.c7));
        sites.add(new Site("Hyatt House Raleigh North Hills","160 Park At North Hills St, Raleigh, NC 27609-5766",R.drawable.tent,R.drawable.c6));
        sites.add(new Site("Fairfield Inn & Suites Raleigh-Durham Airport","10040 Sellona St, Raleigh, NC 27617-8231",R.drawable.equestrian_statue,R.drawable.c8));

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
