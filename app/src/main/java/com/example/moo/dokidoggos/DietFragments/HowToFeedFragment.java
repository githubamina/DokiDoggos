package com.example.moo.dokidoggos.DietFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moo.dokidoggos.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HowToFeedFragment extends Fragment {


    public HowToFeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_how_to_feed, container, false);
    }

}
