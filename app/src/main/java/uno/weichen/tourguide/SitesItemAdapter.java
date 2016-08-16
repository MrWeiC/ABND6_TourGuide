package uno.weichen.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by weichen on 8/14/16.
 */
public class SitesItemAdapter extends ArrayAdapter<Site> {
    public SitesItemAdapter(Context context, ArrayList<Site> site) {
        super(context, 0, site);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                R.layout.list_item, parent, false);
        }


        Site currentWord = getItem(position);

        TextView siteName = (TextView) listItemView.findViewById(R.id.site_name);
        siteName.setText(currentWord.getmName());

        TextView siteAddress = (TextView) listItemView.findViewById(R.id.site_address);
        if (currentWord.getmAddress().equals(("N/A"))) {
            siteAddress.setVisibility(View.GONE);
        } else {
            siteAddress.setText(currentWord.getmAddress());
        }
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.site_image);

        imageView.setImageResource(currentWord.getmResourceId());

        return listItemView;
    }


}
