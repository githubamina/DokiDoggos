package com.example.moo.dokidoggos.MainFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.moo.dokidoggos.Activities.GamesActivity;
import com.example.moo.dokidoggos.FunFragments.Exercise;
import com.example.moo.dokidoggos.FunFragments.MyDogsExercise;
import com.example.moo.dokidoggos.FunFragments.Tricks;
import com.example.moo.dokidoggos.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FunFragment extends Fragment {


    public FunFragment() {
        // Required empty public constructor
    }


    ImageView myDogsExercise;
    ImageView tricks;
    ImageView games;
    ImageView exercise;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fun, container, false);

        myDogsExercise = rootView.findViewById(R.id.myDogsExercise);
        tricks = rootView.findViewById(R.id.tricks);
        games = rootView.findViewById(R.id.games);
        exercise = rootView.findViewById(R.id.exercise);


        Glide.with(getContext()).load(R.drawable.mydogs).into(myDogsExercise);
        Glide.with(getContext()).load(R.drawable.tricks).into(tricks);
        Glide.with(getContext()).load(R.drawable.gaames).into(games);
        Glide.with(getContext()).load(R.drawable.exercise).into(exercise);


        myDogsExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDogsExercise myDogsExercise = new MyDogsExercise();

                FragmentManager manager = getActivity().getSupportFragmentManager();

                manager.beginTransaction()
                        .replace(R.id.container_fragment, myDogsExercise)
                        .commit();

            }
        });


        tricks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tricks tricks = new Tricks();

                FragmentManager manager = getActivity().getSupportFragmentManager();

                manager.beginTransaction()
                        .replace(R.id.container_fragment, tricks)
                        .commit();

            }
        });


        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), GamesActivity.class);
                startActivity(intent);
            }
        });

        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exercise exercise = new Exercise();

                FragmentManager manager = getActivity().getSupportFragmentManager();

                manager.beginTransaction()
                        .replace(R.id.container_fragment, exercise)
                        .commit();
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

}
