package com.example.moo.dokidoggos.Classes;

import android.provider.BaseColumns;

public class Food {


    //Private variables for drink name, description and image
    private String mName;
    private String mAnswer;
    private String mExplanation;
    private int mImageResourceId;


    //Constructors

    public Food(){}


    public Food(String name, String answer, String explanation){
        mName = name;
        mAnswer = answer;
        mExplanation = explanation;
    }

    public Food(String name, String answer, String explanation, int imageResourceId){
        mName = name;
        mAnswer = answer;
        mExplanation = explanation;
        mImageResourceId = imageResourceId;
    }


    //Get method for Id
    public String getId(){
        return BaseColumns._ID;
    }

    //Get method for name
    public String getName(){
        return mName;
    }

    //Set method for name
    public void setName(String name){
        mName = name;
    }

    //Get method for description
    public String getAnswer(){
        return mAnswer;
    }

    //Set method for description
    public void setAnswer(String answer){
        mAnswer = answer;
    }


    //Get method for description
    public String getExplanation(){
        return mExplanation;
    }

    //Set method for description
    public void setExplanation(String explanation){
        mExplanation = explanation;
    }

    //Get method for image resource id
    public int getImageResourceId(){
        return mImageResourceId;
    }

    //Set method for image resource id
    public void setImageResourceId(int imageResourceId){
        mImageResourceId = imageResourceId;
    }
}
