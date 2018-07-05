package com.example.moo.dokidoggos.Classes;

import android.provider.BaseColumns;

public class Recipe {

    private String mTitle;
    private String mIngredients;
    private String mSteps;
    private int mImageResourceID;
    private int mColor;

    public Recipe(String title, String ingredients, String steps, int imageResourceID, int color) {
        mTitle = title;
        mIngredients = ingredients;
        mSteps = steps;
        mImageResourceID = imageResourceID;
        mColor = color;

    }


    //Get method for name
    public String getRecipeTitle(){
        return mTitle;
    }

    public String getIngredients() {
        return mIngredients;
    }


    //Get method for description
    public String getRecipeSteps(){
        return mSteps;
    }

    public int getColor() {
        return mColor;
    }



    //Get method for description
    public int getRecipeImage(){
        return mImageResourceID;
    }


}
