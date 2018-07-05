package com.example.moo.dokidoggos.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moo.dokidoggos.R;

public class SelectedRecipeActivity extends AppCompatActivity {


    String titleValue = "";
    String ingredientsValue = "";
    String stepsValue = "";
    int imageValue = 0;


    TextView title;
    TextView ingredients;
    TextView steps;
    ImageView recipeImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_recipe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        title = findViewById(R.id.selected_recipe_title);
        ingredients = findViewById(R.id.recipe_ingredients);
        steps = findViewById(R.id.recipe_steps);
        recipeImage = findViewById(R.id.selected_recipe_image);

        Bundle extras = getIntent().getExtras();


        if (extras != null) {
            titleValue = extras.getString("title");
            ingredientsValue = extras.getString("ingredients");
            stepsValue = extras.getString("steps");
            imageValue = extras.getInt("imageID");
        }

        title.setText(titleValue);
        ingredients.setText(ingredientsValue);
        steps.setText(stepsValue);
        Glide.with(getApplicationContext()).load(imageValue).into(recipeImage);

    }

}
