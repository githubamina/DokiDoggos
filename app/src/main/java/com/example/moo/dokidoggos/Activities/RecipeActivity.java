package com.example.moo.dokidoggos.Activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.moo.dokidoggos.R;
import com.example.moo.dokidoggos.Classes.Recipe;
import com.example.moo.dokidoggos.Adapters.RecipeSlideAdapter;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private RecipeSlideAdapter recipeAdapter;

    private TextView[] mDots;

    private LinearLayout dotsLayout;
    private ArrayList<Recipe> recipes = new ArrayList<Recipe>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dotsLayout = (LinearLayout) findViewById(R.id.dotsLayout);


        recipes.add(new Recipe(getString(R.string.recipe1_title), getString(R.string.recipe1_ingredients), getString(R.string.recipe1_steps), R.drawable.chomp, getResources().getColor(R.color.recipe1)));
        recipes.add(new Recipe(getString(R.string.recipe2_title), getString(R.string.recipe2_ingredients), getString(R.string.recipe2_steps), R.drawable.chomp, getResources().getColor(R.color.recipe2)));
        recipes.add(new Recipe(getString(R.string.recipe3_title), getString(R.string.recipe3_ingredients), getString(R.string.recipe3_steps), R.drawable.chomp, getResources().getColor(R.color.recipe3)));
        recipes.add(new Recipe(getString(R.string.recipe4_title), getString(R.string.recipe4_ingredients), getString(R.string.recipe4_steps), R.drawable.chomp, getResources().getColor(R.color.recipe4)));
        recipes.add(new Recipe(getString(R.string.recipe5_title), getString(R.string.recipe5_ingredients), getString(R.string.recipe5_steps), R.drawable.chomp, getResources().getColor(R.color.recipe5)));
        recipes.add(new Recipe(getString(R.string.recipe6_title), getString(R.string.recipe6_ingredients), getString(R.string.recipe6_steps), R.drawable.chomp, getResources().getColor(R.color.recipe6)));
        recipes.add(new Recipe(getString(R.string.recipe7_title), getString(R.string.recipe7_ingredients), getString(R.string.recipe7_steps), R.drawable.chomp, getResources().getColor(R.color.recipe7)));
        recipes.add(new Recipe(getString(R.string.recipe8_title), getString(R.string.recipe8_ingredients), getString(R.string.recipe8_steps), R.drawable.chomp, getResources().getColor(R.color.recipe8)));
        recipes.add(new Recipe(getString(R.string.recipe9_title), getString(R.string.recipe9_ingredients), getString(R.string.recipe9_steps), R.drawable.chomp, getResources().getColor(R.color.recipe9)));
        recipes.add(new Recipe(getString(R.string.recipe10_title), getString(R.string.recipe10_ingredients), getString(R.string.recipe10_steps), R.drawable.chomp, getResources().getColor(R.color.recipe10)));


        addDotsIndicator(0);

        viewPager = findViewById(R.id.view_pager);
        recipeAdapter = new RecipeSlideAdapter(this, recipes);
        viewPager.setAdapter(recipeAdapter);

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
