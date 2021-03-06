package com.example.moo.dokidoggos.FunFragments;


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

import com.example.moo.dokidoggos.DatabaseAndProvider.DatabaseContract;
import com.example.moo.dokidoggos.MainFragments.ExercisePetAdapter;
import com.example.moo.dokidoggos.R;

import static com.example.moo.dokidoggos.DatabaseAndProvider.PetContentProvider.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyDogsExercise extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ExercisePetAdapter adapter;
    private FragmentManager fragManager;



    public MyDogsExercise() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getLoaderManager().initLoader(0, null, this);

        View rootView = inflater.inflate(R.layout.fragment_my_dogs_exercise, container, false);

        fragManager = getActivity().getSupportFragmentManager();

        mRecyclerView = rootView.findViewById(R.id.exerciseRecyclerView);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        adapter = new ExercisePetAdapter(getContext(), fragManager);

        mRecyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return rootView;
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {

        try {
            return new CursorLoader(getContext(), DatabaseContract.exercise.CONTENT_URI, null, null, null, null);
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
