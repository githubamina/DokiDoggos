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

import com.example.moo.dokidoggos.Adapters.TrickSlideAdapter;
import com.example.moo.dokidoggos.R;

import java.util.ArrayList;

public class TrickActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private TrickSlideAdapter trickAdapter;

    private TextView[] mDots;

    private LinearLayout dotsLayout;


    public String trickName;

    public String[] trickSteps;

    public int imageResource;

    public int colorResource;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trick);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            trickName = extras.getString("name");
            trickSteps = extras.getStringArray("steps");
            imageResource = extras.getInt("image");
            colorResource = extras.getInt("color", getResources().getColor(R.color.recipe2));

        }

        getSupportActionBar().setTitle(trickName);


        dotsLayout = (LinearLayout) findViewById(R.id.trick_dotsLayout);

        addDotsIndicator(0);

        viewPager = findViewById(R.id.trick_view_pager);
        trickAdapter = new TrickSlideAdapter(this, trickSteps,trickName, imageResource, colorResource);
        viewPager.setAdapter(trickAdapter);

        viewPager.addOnPageChangeListener(viewListener);

    }



    public void addDotsIndicator(int position){

        mDots = new TextView[trickSteps.length];
        dotsLayout.removeAllViews();

        for(int i = 0; i < mDots.length; i ++){
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
