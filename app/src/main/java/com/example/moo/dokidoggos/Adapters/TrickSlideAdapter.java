package com.example.moo.dokidoggos.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moo.dokidoggos.R;

public class TrickSlideAdapter extends PagerAdapter {


    Context context;

    LayoutInflater inflater;

    String[] steps;

    String name;

    int imgResource;

    int colorResource;


    public TrickSlideAdapter(Context context, String[] steps, String name, int imgResource, int colorResource) {
        this.context = context;
        this.steps = steps;
        this.imgResource = imgResource;
        this.name = name;
        this.colorResource = colorResource;
    }


    @Override
    public int getCount() {
        return steps.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position){
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.trick_slide, container, false);

        view.setBackgroundColor(colorResource);

        LinearLayout layoutslide = view.findViewById(R.id.trick_slider_layout);
        ImageView imageSlide = view.findViewById(R.id.trick_image);

        TextView trickStep = view.findViewById(R.id.current_trick_step);

        Glide.with(context).load(imgResource).into(imageSlide);

        trickStep.setText(steps[position]);



        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
