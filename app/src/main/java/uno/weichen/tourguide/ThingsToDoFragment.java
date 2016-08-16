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
public class ThingsToDoFragment extends Fragment {


    public ThingsToDoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.site_listview, container, false);

        final ArrayList<Site> sites = new ArrayList<>();

        sites.add(new Site(getString(R.string.todo1),getString(R.string.todo_addr1),R.drawable.beach,R.drawable.c2));
        sites.add(new Site(getString(R.string.todo2),getString(R.string.todo_addr2),R.drawable.beach_ball,R.drawable.c1));
        sites.add(new Site(getString(R.string.todo3),getString(R.string.todo_addr3),R.drawable.beach_umbrella,R.drawable.c3));
        sites.add(new Site(getString(R.string.todo4),getString(R.string.todo_addr4),R.drawable.big_ben,R.drawable.c4));
        sites.add(new Site(getString(R.string.todo5),getString(R.string.todo_addr5),R.drawable.bust,R.drawable.c5));
        sites.add(new Site(getString(R.string.todo6),getString(R.string.todo_addr6),R.drawable.cave,R.drawable.c6));
        sites.add(new Site(getString(R.string.todo7),getString(R.string.todo_addr7),R.drawable.coconut_cocktail,R.drawable.c7));
        sites.add(new Site(getString(R.string.todo8),getString(R.string.todo_addr8),R.drawable.colosseum,R.drawable.c8));
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
