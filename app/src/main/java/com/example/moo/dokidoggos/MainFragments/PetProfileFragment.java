package com.example.moo.dokidoggos.MainFragments;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moo.dokidoggos.Activities.AddNewPetActivity;
import com.example.moo.dokidoggos.DatabaseAndProvider.DatabaseContract;
import com.example.moo.dokidoggos.Adapters.PetAdapter;
import com.example.moo.dokidoggos.R;

import static com.example.moo.dokidoggos.DatabaseAndProvider.PetContentProvider.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class PetProfileFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {


    //Variables for recyclerview, layout manager and adapter
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private PetAdapter adapter;



    // Required empty public constructor
    public PetProfileFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //Initialize LoaderManager
        getLoaderManager().initLoader(0, null, this);

        //Inflate fragment_pet_profiles layout- i.e. the layout with the recyclerview
        View rootView = inflater.inflate(R.layout.fragment_pet_profiles, container, false);

        //Initialize variables
        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getContext());

        //Set layoutmanager on recyclerview
        mRecyclerView.setLayoutManager(mLayoutManager);



        adapter = new PetAdapter(getContext());
        //Set adapter on RecyclerView
        mRecyclerView.setAdapter(adapter);






        //Set on click listener on Floating Action Button
        FloatingActionButton fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //When FAB is clicked, call goToAddUserActivity() which
                //will take us to the AddNewPetActivity class
                goToAddUserActivity();
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



    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {

        //When loader is created, start loading a cursor from the database
        //with specified query parameters
        try {
            return new CursorLoader(getContext(), DatabaseContract.petProfile.CONTENT_URI, null, null, null, null);
        }
        catch (Exception e) {
            Log.e(TAG, "Failed to load data");
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        //When the cursor has finished loading, notify the adapter that the cursor data has changed so the UI can be updated
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        //If the loader is reset, reset the adapter's cursor data
        adapter.setData(null);

    }
}
