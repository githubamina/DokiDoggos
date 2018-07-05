package com.example.moo.dokidoggos.ProfileFragments;


import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.moo.dokidoggos.DatabaseAndProvider.DatabaseContract;
import com.example.moo.dokidoggos.R;

import static com.example.moo.dokidoggos.DatabaseAndProvider.PetContentProvider.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectedPet extends Fragment {


    public SelectedPet() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        View rootView = inflater.inflate(R.layout.fragment_selected_pet, container, false);





        // Inflate the layout for this fragment
        return rootView;
    }



}
