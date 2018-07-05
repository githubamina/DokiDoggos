package com.example.moo.dokidoggos.DietFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.moo.dokidoggos.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HowMuchToFeedFragment extends Fragment {

    ScrollView scrollView;

    TextView sectionAge;

    TextView age;



    public HowMuchToFeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_how_much_to_feed, container, false);


        scrollView = rootView.findViewById(R.id.scrollView);

        sectionAge = rootView.findViewById(R.id.section_age);


        age = rootView.findViewById(R.id.age_view);

        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollView.smoothScrollTo(0, sectionAge.getTop());
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }


}
