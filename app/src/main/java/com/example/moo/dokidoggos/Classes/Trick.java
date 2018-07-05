package com.example.moo.dokidoggos.Classes;

public class Trick {

    private String mName;
    private String[] mSteps;
    private int mImageResourceId;
    private int mColor;

    public Trick(String name, String[] steps, int imageResourceId, int color){
        mName = name;
        mSteps = steps;
        mImageResourceId = imageResourceId;
        mColor = color;
    }


    public String getTrickName(){
        return mName;
    }

    public String[] getTrickSteps(){
        return mSteps;
    }

    public int getTrickImage(){
        return mImageResourceId;
    }

    public int getTrickColor(){
        return mColor;
    }
}
