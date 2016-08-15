package uno.weichen.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class SitesDetailActivity extends AppCompatActivity {

     final static String EXTRA_NAME = "site_name";
     final static String EXTRA_ADDRESS = "site_address";
     final static String EXTRA_PICID = "site_pic";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sites_detail);

        Intent intent = getIntent();
        final String site_name = intent.getStringExtra(EXTRA_NAME);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
            (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(site_name);

        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);

        final TextView textview = (TextView) findViewById(R.id.detail_address);
        textview.setText("EXTRA_ADDRESS");
    }


}
