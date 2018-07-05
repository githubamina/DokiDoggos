package com.example.moo.dokidoggos.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.moo.dokidoggos.R;

public class GamesActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private GamesSlideAdapter gamesAdapter;

    private TextView[] mDots;

    private LinearLayout dotsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dotsLayout = (LinearLayout) findViewById(R.id.dotsLayout);




        addDotsIndicator(0);

        viewPager = findViewById(R.id.view_pager);
        gamesAdapter = new GamesSlideAdapter(GamesActivity.this);
        viewPager.setAdapter(gamesAdapter);

        viewPager.addOnPageChangeListener(viewListener);



    }

    public void addDotsIndicator(int position){

        mDots = new TextView[10];
        dotsLayout.removeAllViews();

        for(int i = 0; i < mDots.length; i ++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.dot1));

            dotsLayout.addView(mDots[i]);

        }

        if(mDots.length > 0){

            mDots[position].setTextColor(getResources().getColor(R.color.dot2));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
