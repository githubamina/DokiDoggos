package com.example.moo.dokidoggos.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moo.dokidoggos.Activities.SelectedRecipeActivity;
import com.example.moo.dokidoggos.Classes.Recipe;
import com.example.moo.dokidoggos.R;

import java.util.ArrayList;

public class RecipeSlideAdapter extends PagerAdapter {




    Context context;

    LayoutInflater inflater;

    ArrayList<Recipe> recipes;




    public FragmentManager fragmentManager;


    public RecipeSlideAdapter(Context context, ArrayList<Recipe> recipesArrayList) {
    this.context = context;
    this.recipes = recipesArrayList;

    }


    @Override
    public int getCount() {
        return recipes.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.diet_slide, container, false);
        LinearLayout layoutslide = view.findViewById(R.id.sliderlinearlayout);
        ImageView imageSlide = view.findViewById(R.id.recipe_image);
        final TextView recipeTitle = view.findViewById(R.id.recipe_title);

        Glide.with(context).load(recipes.get(position).getRecipeImage()).into(imageSlide);
        recipeTitle.setText(recipes.get(position).getRecipeTitle());
        view.setBackgroundColor(recipes.get(position).getColor());

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String title = recipes.get(position).getRecipeTitle();
                String ingredients = recipes.get(position).getIngredients();
                String steps = recipes.get(position).getRecipeSteps();
                int imageID = recipes.get(position).getRecipeImage();
                int color = recipes.get(position).getColor();

                Bundle bundle = new Bundle();
                bundle.putString("title", title);
                bundle.putString("ingredients", ingredients);
                bundle.putString("steps", steps);
                bundle.putInt("imageID", imageID);
                bundle.putInt("color", color);

                Intent intent = new Intent(context.getApplicationContext(), SelectedRecipeActivity.class);

                intent.putExtras(bundle);

                context.startActivity(intent);



            }
        });

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
