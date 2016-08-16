package uno.weichen.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by weichen on 8/14/16.
 */
public class CategoryFragmentPageAdapter extends FragmentPagerAdapter {
    /**
     * {@link CategoryFragmentPageAdapter} is a {@link FragmentManager} that can provide layout for
     * each list item based on a data source which is {Site} objects
     *
     * @param context
     * @param fragmentManager
     */
    private String[] tabTitles;

    public CategoryFragmentPageAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;
        tabTitles = new String[]{mContext.getString(R.string.tab_title1), mContext.getString(R
            .string.tab_title2), mContext.getString(R.string.tab_title3), mContext.getString(R
            .string.tab_title4)};

    }

    private Context mContext;


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ThingsToDoFragment();
        } else if (position == 1) {
            return new HotelFrament();
        } else if (position == 2) {
            return new RestaurantFragment();
        } else {
            return new NearbyCityFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }


}
