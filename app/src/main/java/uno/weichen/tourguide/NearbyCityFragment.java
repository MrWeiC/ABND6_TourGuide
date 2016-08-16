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
public class NearbyCityFragment extends Fragment {


    public NearbyCityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.site_listview, container, false);

        final ArrayList<Site> sites = new ArrayList<>();

        sites.add(new Site("Garner","N/A",R.drawable.walking_bridge,R.drawable.c9));
        sites.add(new Site("Chapel Hill","N/A",R.drawable.us_capitol,R.drawable.c4));
        sites.add(new Site("Cary","N/A",R.drawable.summer,R.drawable.c8));
        sites.add(new Site("Morrisville","N/A",R.drawable.obelisk,R.drawable.c7));
        sites.add(new Site("Durhamr","N/A",R.drawable.sea_waves,R.drawable.c4));

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
