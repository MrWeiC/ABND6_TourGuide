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
public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.site_listview, container, false);

        final ArrayList<Site> sites = new ArrayList<>();

        sites.add(new Site("Bida Manda","222 S Blount St, Raleigh, NC 27601-1408",R.drawable.flip_flops,R.drawable.c7));
        sites.add(new Site("Neomonde Raleigh Cafe & Market","3817 Beryl Rd, Raleigh, NC 27607-5244",R.drawable.lion_statue,R.drawable.c3));
        sites.add(new Site("Gonza Tacos y Tequila","7713 Lead Mine Rd Ste 39, Raleigh, NC 27615-4805",R.drawable.cave,R.drawable.c8));
        sites.add(new Site("Marbles Kids Museum Park","201 E Hargett St",R.drawable.monument,R.drawable.c1));
        sites.add(new Site("Bad Daddy's Burger Bar","111 Seaboard Ave, Raleigh, NC 27604-1151",R.drawable.eiffel_tower,R.drawable.c6));

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
