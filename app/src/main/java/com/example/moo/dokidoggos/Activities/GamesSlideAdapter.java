package com.example.moo.dokidoggos.Activities;

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
import com.example.moo.dokidoggos.R;

import java.util.List;


public class GamesSlideAdapter extends PagerAdapter {


    Context context;

    LayoutInflater inflater;

    int[] images = {
            R.drawable.fetch,
            R.drawable.frisbee,
            R.drawable.tug,
            R.drawable.hide,
            R.drawable.find,
            R.drawable.water,
            R.drawable.obstacles,
            R.drawable.bubbles,
            R.drawable.treattoy,
            R.drawable.chase



    };

    public String[] names = {
            "Fetch",
            "Frisbee",
            "Tug of war",
            "Hide and Treat",
            "Treat/toy hunt",
            "Water fun",
            "Obstacle course",
            "Bubbles",
            "Treat Puzzles/Dispensers",
            "Chasies"

    };

    public String[] descriptions = {
            "All dogs love to chase things, but if your\'s has trouble coming back, keep a long lead on them as you play to reel them in",
            "Make sure you throw the frisbee low enough for your dog to catch!",
            "Tugging games are always a favourite and can be played with lots of different toys, not just ropes!",
            "Grab some treats, tell your dog to stay as you hide, then call them to find you!",
            "Hide your dog\'s favourite toy or treats under a blanket/behind a sofa, and encourage them to sniff them out",
            "Go splash around with your dog in the pool (get a small inflatable one if you don\'t have one) or the beach",
            "Use items lying around your house to make an obstacle course to lead your dog through",
            "Blow some bubbles and see if your dog will chase them",
            "Get a treat puzzle/dispenser toy for your dog - be sure you buy one which is safe for your dog and only let them use it under your supervision",
            "When all else fails, think like your dog and just run around madly with them- chase them and let them chase you back!"
    };







    public FragmentManager fragmentManager;


    public GamesSlideAdapter(Context context) {
        this.context = context;

    }


    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.game_slide, container, false);
        LinearLayout layoutslide = view.findViewById(R.id.game_slide_layout);
        ImageView imageSlide = view.findViewById(R.id.game_image);
        final TextView gameTitle = view.findViewById(R.id.game_title);
        TextView gameDescription = view.findViewById(R.id.game_description);

        Glide.with(context).load(images[position]).into(imageSlide);
        gameTitle.setText(names[position]);
        gameDescription.setText(descriptions[position]);



        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
