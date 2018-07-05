package com.example.moo.dokidoggos.MainFragments;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.moo.dokidoggos.FunFragments.Exercise;
import com.example.moo.dokidoggos.MedicalFragments.MyDogsHealthFragment;
import com.example.moo.dokidoggos.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MedicalFragment extends Fragment {

    ImageView myDogs;
    ImageView vetsNearMe;
    ImageView symptomChecker;
    ImageView supplements;
    ImageView medResources;



    public MedicalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_medical, container, false);

        myDogs = rootView.findViewById(R.id.myDogsMedical);
        vetsNearMe = rootView.findViewById(R.id.vetsNearMe);
        symptomChecker = rootView.findViewById(R.id.symptomCheck);
        supplements = rootView.findViewById(R.id.supplements);
        medResources = rootView.findViewById(R.id.resources);


        Glide.with(getContext()).load(R.drawable.mydoghealth).into(myDogs);
        Glide.with(getContext()).load(R.drawable.vets).into(vetsNearMe);
        Glide.with(getContext()).load(R.drawable.symptoms).into(symptomChecker);
        Glide.with(getContext()).load(R.drawable.sup).into(supplements);
        Glide.with(getContext()).load(R.drawable.resourcesmed).into(medResources);


        myDogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDogsHealthFragment myDogsHealthFragment = new MyDogsHealthFragment();

                FragmentManager manager = getActivity().getSupportFragmentManager();

                manager.beginTransaction()
                        .replace(R.id.container_fragment, myDogsHealthFragment)
                        .commit();
            }

        });

        vetsNearMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        symptomChecker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        supplements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        medResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return rootView;



    }

}
