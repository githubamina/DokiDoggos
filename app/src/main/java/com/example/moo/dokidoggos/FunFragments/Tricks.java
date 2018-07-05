package com.example.moo.dokidoggos.FunFragments;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.moo.dokidoggos.Activities.AddNewPetActivity;
import com.example.moo.dokidoggos.Activities.TrickActivity;
import com.example.moo.dokidoggos.Classes.Trick;
import com.example.moo.dokidoggos.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tricks extends Fragment {


    private ArrayList<Trick> tricks = new ArrayList<Trick>();


    public Tricks() {
        // Required empty public constructor
    }

    ImageView roll_img;
    ImageView bang_img;
    ImageView spin_img;
    ImageView shake_img;
    ImageView kiss_img;
    ImageView dance_img;
    ImageView speak_img;
    ImageView high_five_img;
    ImageView crawl_img;
    ImageView bow_img;
    ImageView beg_img;



    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        tricks.add(new Trick("Roll Over", getResources().getStringArray(R.array.roll_over_steps), R.drawable.rolll, getResources().getColor(R.color.trick)));
        tricks.add(new Trick("Bang!", getResources().getStringArray(R.array.bang_steps), R.drawable.bangg, getResources().getColor(R.color.trick)));
        tricks.add(new Trick("Spin", getResources().getStringArray(R.array.spin_steps), R.drawable.spinn, getResources().getColor(R.color.trick)));
        tricks.add(new Trick("Speak", getResources().getStringArray(R.array.speak_steps), R.drawable.speakk, getResources().getColor(R.color.trick)));
        tricks.add(new Trick("Shake", getResources().getStringArray(R.array.shake_steps), R.drawable.shaake, getResources().getColor(R.color.trick)));
        tricks.add(new Trick("Kiss", getResources().getStringArray(R.array.kiss_steps), R.drawable.kisss, getResources().getColor(R.color.trick)));
        tricks.add(new Trick("Dance", getResources().getStringArray(R.array.dance_steps), R.drawable.dancee, getResources().getColor(R.color.trick)));
        tricks.add(new Trick("High Five", getResources().getStringArray(R.array.high_five_steps), R.drawable.highfivee, getResources().getColor(R.color.trick)));
        tricks.add(new Trick("Crawl", getResources().getStringArray(R.array.crawl_steps), R.drawable.crawll, getResources().getColor(R.color.trick)));
        tricks.add(new Trick("Bow", getResources().getStringArray(R.array.bow_steps), R.drawable.boww, getResources().getColor(R.color.trick)));
        tricks.add(new Trick("Beg", getResources().getStringArray(R.array.beg_steps), R.drawable.begg, getResources().getColor(R.color.trick)));




        View rootView = inflater.inflate(R.layout.fragment_tricks, container, false);

        roll_img = rootView.findViewById(R.id.roll_img);
        bang_img = rootView.findViewById(R.id.bang_img);
        spin_img = rootView.findViewById(R.id.spin_img);
        shake_img = rootView.findViewById(R.id.shake_img);
        kiss_img = rootView.findViewById(R.id.kiss_img);
        dance_img = rootView.findViewById(R.id.dance_img);
        speak_img = rootView.findViewById(R.id.speak_img);
        high_five_img = rootView.findViewById(R.id.high_five_img);
        crawl_img = rootView.findViewById(R.id.crawl_img);
        bow_img = rootView.findViewById(R.id.bow_img);
        beg_img = rootView.findViewById(R.id.beg_img);


        Glide.with(getContext()).load(R.drawable.rolll).into(roll_img);
        Glide.with(getContext()).load(R.drawable.bangg).into(bang_img);
        Glide.with(getContext()).load(R.drawable.spinn).into(spin_img);
        Glide.with(getContext()).load(R.drawable.speakk).into(speak_img);
        Glide.with(getContext()).load(R.drawable.shaake).into(shake_img);
        Glide.with(getContext()).load(R.drawable.kisss).into(kiss_img);
        Glide.with(getContext()).load(R.drawable.dancee).into(dance_img);
        Glide.with(getContext()).load(R.drawable.highfivee).into(high_five_img);
        Glide.with(getContext()).load(R.drawable.crawll).into(crawl_img);
        Glide.with(getContext()).load(R.drawable.begg).into(beg_img);
        Glide.with(getContext()).load(R.drawable.boww).into(bow_img);



        roll_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getActivity(), TrickActivity.class);

                intent.putExtra("name", tricks.get(0).getTrickName());
                intent.putExtra("steps", tricks.get(0).getTrickSteps());
                intent.putExtra("image", tricks.get(0).getTrickImage());
                intent.putExtra("color", tricks.get(0).getTrickColor());
                startActivity(intent);

            }
        });

        bang_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrickActivity.class);

                intent.putExtra("name", tricks.get(1).getTrickName());
                intent.putExtra("steps", tricks.get(1).getTrickSteps());
                intent.putExtra("image", tricks.get(1).getTrickImage());
                intent.putExtra("color", tricks.get(1).getTrickColor());
                startActivity(intent);
            }
        });

        spin_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrickActivity.class);

                intent.putExtra("name", tricks.get(2).getTrickName());
                intent.putExtra("steps", tricks.get(2).getTrickSteps());
                intent.putExtra("image", tricks.get(2).getTrickImage());
                intent.putExtra("color", tricks.get(2).getTrickColor());
                startActivity(intent);
            }
        });

        speak_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrickActivity.class);

                intent.putExtra("name", tricks.get(3).getTrickName());
                intent.putExtra("steps", tricks.get(3).getTrickSteps());
                intent.putExtra("image", tricks.get(3).getTrickImage());
                intent.putExtra("color", tricks.get(3).getTrickColor());
                startActivity(intent);
            }
        });

        shake_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrickActivity.class);

                intent.putExtra("name", tricks.get(4).getTrickName());
                intent.putExtra("steps", tricks.get(4).getTrickSteps());
                intent.putExtra("image", tricks.get(4).getTrickImage());
                intent.putExtra("color", tricks.get(4).getTrickColor());
                startActivity(intent);
            }
        });

        kiss_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrickActivity.class);

                intent.putExtra("name", tricks.get(5).getTrickName());
                intent.putExtra("steps", tricks.get(5).getTrickSteps());
                intent.putExtra("image", tricks.get(5).getTrickImage());
                intent.putExtra("color", tricks.get(5).getTrickColor());
                startActivity(intent);
            }
        });


        dance_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrickActivity.class);

                intent.putExtra("name", tricks.get(6).getTrickName());
                intent.putExtra("steps", tricks.get(6).getTrickSteps());
                intent.putExtra("image", tricks.get(6).getTrickImage());
                intent.putExtra("color", tricks.get(6).getTrickColor());
                startActivity(intent);
            }
        });

        high_five_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrickActivity.class);

                intent.putExtra("name", tricks.get(7).getTrickName());
                intent.putExtra("steps", tricks.get(7).getTrickSteps());
                intent.putExtra("image", tricks.get(7).getTrickImage());
                intent.putExtra("color", tricks.get(7).getTrickColor());
                startActivity(intent);
            }
        });

        crawl_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrickActivity.class);

                intent.putExtra("name", tricks.get(8).getTrickName());
                intent.putExtra("steps", tricks.get(8).getTrickSteps());
                intent.putExtra("image", tricks.get(8).getTrickImage());
                intent.putExtra("color", tricks.get(8).getTrickColor());
                startActivity(intent);
            }
        });

        bow_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrickActivity.class);

                intent.putExtra("name", tricks.get(9).getTrickName());
                intent.putExtra("steps", tricks.get(9).getTrickSteps());
                intent.putExtra("image", tricks.get(9).getTrickImage());
                intent.putExtra("color", tricks.get(9).getTrickColor());
                startActivity(intent);
            }
        });

        beg_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrickActivity.class);

                intent.putExtra("name", tricks.get(10).getTrickName());
                intent.putExtra("steps", tricks.get(10).getTrickSteps());
                intent.putExtra("image", tricks.get(10).getTrickImage());
                intent.putExtra("color", tricks.get(10).getTrickColor());
                startActivity(intent);
            }
        });


        return rootView;
    }

}
