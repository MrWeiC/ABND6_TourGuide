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

        sites.add(new Site(getString(R.string.h1),getString(R.string.addr_h1),R.drawable.taj_mahal,R.drawable.c4));
        sites.add(new Site(getString(R.string.h2),getString(R.string.addr_h2),R.drawable.museum,R.drawable.c7));
        sites.add(new Site(getString(R.string.h3),getString(R.string.addr_h3),R.drawable.tent,R.drawable.c6));
        sites.add(new Site(getString(R.string.h4),getString(R.string.addr_h4),R.drawable.equestrian_statue,R.drawable.c8));

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
