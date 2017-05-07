package it.wowstoreapp.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

/**
 * Created by user01 on 19/05/2016.
 */
public class NegoziActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puntivendita_activity);

        ScrollView sv = (ScrollView) findViewById(R.id.scrollViewNeg);

        sv.setOverScrollMode(ScrollView.OVER_SCROLL_IF_CONTENT_SCROLLS);

    }

}
