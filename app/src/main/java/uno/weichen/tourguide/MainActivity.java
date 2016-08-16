package uno.weichen.tourguide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Find the View pager
        ViewPager viewPager = (ViewPager)findViewById(R.id.category_viewpager);
        //Create an adapter that is know which fragment should be shown on each page
        CategoryFragmentPageAdapter adapter = new CategoryFragmentPageAdapter(this,getSupportFragmentManager());
        //Set the Adapter for the viewPager
        viewPager.setAdapter(adapter);

        //Find the TabLayout
        TabLayout tabLayout =(TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
