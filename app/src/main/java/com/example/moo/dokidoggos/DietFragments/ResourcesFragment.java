package com.example.moo.dokidoggos.DietFragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.moo.dokidoggos.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResourcesFragment extends Fragment {


    TextView rspca;
    TextView aspca;
    TextView vetwest;
    TextView foodReviews;

    public ResourcesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_resources, container, false);

        rspca = rootView.findViewById(R.id.openRSPCA);
        aspca = rootView.findViewById(R.id.openASPCA);
        vetwest = rootView.findViewById(R.id.openVetwest);
        foodReviews = rootView.findViewById(R.id.openReviews);

        rspca.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                {
                    Uri webpage = Uri.parse("http://kb.rspca.org.au/");
                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
            }
        });

        aspca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://www.aspca.org/pet-care/dog-care");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        vetwest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://www.vetwest.com.au/pet-library/dogs");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        foodReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("http://www.petfoodreviews.com.au/");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        return rootView;
    }



}
