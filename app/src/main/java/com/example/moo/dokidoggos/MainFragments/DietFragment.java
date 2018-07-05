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
import com.example.moo.dokidoggos.Activities.AddNewPetActivity;
import com.example.moo.dokidoggos.Activities.FoodCheckerActivity;
import com.example.moo.dokidoggos.Activities.RecipeActivity;
import com.example.moo.dokidoggos.DietFragments.HowMuchToFeedFragment;
import com.example.moo.dokidoggos.DietFragments.HowToFeedFragment;
import com.example.moo.dokidoggos.DietFragments.MyDogsDiets;
import com.example.moo.dokidoggos.R;
import com.example.moo.dokidoggos.DietFragments.ResourcesFragment;
import com.example.moo.dokidoggos.DietFragments.TreatsFragment;
import com.example.moo.dokidoggos.DietFragments.WhatToFeedFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class DietFragment extends Fragment {


    public DietFragment() {
        // Required empty public constructor
    }

    ImageView myDogsDiets;
    ImageView amountToFeed;
    ImageView whatToFeed;
    ImageView howToFeed;
    ImageView treatsImage;
    ImageView whatNotToFeed;
    ImageView recipes;
    ImageView resources;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Reference to fragment_diet
        View rootView = inflater.inflate(R.layout.fragment_diet, container, false);


        myDogsDiets = rootView.findViewById(R.id.myDogs);
        amountToFeed = rootView.findViewById(R.id.howMuchToFeed);
        whatToFeed = rootView.findViewById(R.id.whatToFeed);
        howToFeed = rootView.findViewById(R.id.howToFeed);
        treatsImage = rootView.findViewById(R.id.treats);
        whatNotToFeed = rootView.findViewById(R.id.whatNotToFeed);
        recipes = rootView.findViewById(R.id.recipes);
        resources = rootView.findViewById(R.id.resources);

        //Use glide to load image
        Glide.with(getContext()).load(R.drawable.donotfeed).into(whatNotToFeed);
        Glide.with(getContext()).load(R.drawable.howtofeeddog).into(howToFeed);
        Glide.with(getContext()).load(R.drawable.treatsimg).into(treatsImage);
        Glide.with(getContext()).load(R.drawable.howmuch).into(amountToFeed);
        Glide.with(getContext()).load(R.drawable.mydiets).into(myDogsDiets);
        Glide.with(getContext()).load(R.drawable.recipes).into(recipes);
        Glide.with(getContext()).load(R.drawable.resources).into(resources);
        Glide.with(getContext()).load(R.drawable.whattofeed).into(whatToFeed);


        myDogsDiets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create instance of MainFragment
                MyDogsDiets myDogsDiets = new MyDogsDiets();

                FragmentManager manager = getActivity().getSupportFragmentManager();
                //Replace current fragment in location_fragment with mainFragment
                manager.beginTransaction()
                        .replace(R.id.container_fragment, myDogsDiets)
                        .commit();

            }
        });

        whatToFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Create instance of MainFragment
                WhatToFeedFragment whatToFeedFragment = new WhatToFeedFragment();

                FragmentManager manager = getActivity().getSupportFragmentManager();
                //Replace current fragment in location_fragment with mainFragment
                manager.beginTransaction()
                        .replace(R.id.container_fragment, whatToFeedFragment)
                        .commit();
            }
        });

        amountToFeed.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Create instance of MainFragment
                HowMuchToFeedFragment howMuchToFeedFragment = new HowMuchToFeedFragment();

                FragmentManager manager = getActivity().getSupportFragmentManager();
                //Replace current fragment in location_fragment with mainFragment
                manager.beginTransaction()
                        .replace(R.id.container_fragment, howMuchToFeedFragment)
                        .commit();
            }
        });


        howToFeed.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Create instance of MainFragment
                HowToFeedFragment howToFeedFragment = new HowToFeedFragment();

                FragmentManager manager = getActivity().getSupportFragmentManager();
                //Replace current fragment in location_fragment with mainFragment
                manager.beginTransaction()
                        .replace(R.id.container_fragment, howToFeedFragment)
                        .commit();
            }
        });

        treatsImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Create instance of MainFragment
                TreatsFragment treatsFragment = new TreatsFragment();

                FragmentManager manager = getActivity().getSupportFragmentManager();
                //Replace current fragment in location_fragment with mainFragment
                manager.beginTransaction()
                        .replace(R.id.container_fragment, treatsFragment)
                        .commit();
            }
        });

        recipes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /**
                //Create instance of MainFragment
                RecipesFragment recipesFragment = new RecipesFragment();

                FragmentManager manager = getActivity().getSupportFragmentManager();
                //Replace current fragment in location_fragment with mainFragment
                manager.beginTransaction()
                        .replace(R.id.container_fragment, recipesFragment)
                        .commit();
                 **/

                Intent intent = new Intent(getActivity(), RecipeActivity.class);
                startActivity(intent);

            }
        });

        resources.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Create instance of MainFragment
                ResourcesFragment resourcesFragment = new ResourcesFragment();

                FragmentManager manager = getActivity().getSupportFragmentManager();
                //Replace current fragment in location_fragment with mainFragment
                manager.beginTransaction()
                        .replace(R.id.container_fragment, resourcesFragment)
                        .commit();
            }
        });



        whatNotToFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FoodCheckerActivity.class);
                startActivity(intent);
            }
        });



        // Inflate the layout for this fragment
        return rootView;
    }


    //Helper method- starts intent to go to AddNewPetActivity class
    private void goToAddUserActivity(){
        Intent intent = new Intent(getActivity(), AddNewPetActivity.class);
        startActivity(intent);
    }

}
