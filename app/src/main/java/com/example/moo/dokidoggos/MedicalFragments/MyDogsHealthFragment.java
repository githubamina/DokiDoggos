package com.example.moo.dokidoggos.MedicalFragments;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moo.dokidoggos.Adapters.DietPetAdapter;
import com.example.moo.dokidoggos.Adapters.MedicalAdapter;
import com.example.moo.dokidoggos.DatabaseAndProvider.DatabaseContract;
import com.example.moo.dokidoggos.R;

import static com.example.moo.dokidoggos.DatabaseAndProvider.PetContentProvider.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyDogsHealthFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private RecyclerView mRecyclerview;
    private RecyclerView.LayoutManager mLayoutManager;
    private MedicalAdapter adapter;
    private FragmentManager fragManager;


    public MyDogsHealthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        fragManager = getActivity().getSupportFragmentManager();
        //Init LoaderManager
        getLoaderManager().initLoader(0, null, this);

        View rootView = inflater.inflate(R.layout.fragment_my_dogs_health, container, false);


        mRecyclerview = rootView.findViewById(R.id.medicalRecyclerView);
        mLayoutManager = new LinearLayoutManager(getContext());

        mRecyclerview.setLayoutManager(mLayoutManager);

        adapter = new MedicalAdapter(getContext(), fragManager);

        mRecyclerview.setAdapter(adapter);
        // Inflate the layout for this fragment
        return rootView;
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        //When loader is created, start loading a cursor from the database
        //with specified query parameters
        try {
            return new CursorLoader(getContext(), DatabaseContract.medical.CONTENT_URI, null, null, null, null);

        }
        catch (Exception e) {
            Log.e(TAG, "Failed to load data");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

        adapter.setData(null);
    }
}
