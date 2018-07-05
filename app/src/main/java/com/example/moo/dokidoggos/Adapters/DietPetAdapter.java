package com.example.moo.dokidoggos.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moo.dokidoggos.DatabaseAndProvider.DatabaseContract;
import com.example.moo.dokidoggos.DietFragments.DogsPersonalDietFragment;
import com.example.moo.dokidoggos.R;

public class DietPetAdapter extends RecyclerView.Adapter<DietPetAdapter.PetViewHolder>{

    //TAG String
    private static final String TAG = DietPetAdapter.class.getSimpleName();

    public FragmentManager fragmentManager;

    //Query parameters for cursor, similar to SQL queries
    private String queryUri = DatabaseContract.diet.CONTENT_URI.toString();
    private static final String [] projection = new String [] {DatabaseContract.diet.CONTENT_PATH};
    private String selectionClause = null;
    private String selectionArgs[] = null;
    private String sortOrder = null;

    //Variables
    private final LayoutInflater mInflater;
    private Context mContext;
    public Cursor mCursor;



    //ViewHolder class
    public class PetViewHolder extends RecyclerView.ViewHolder {

        //Variables to store the ViewHolder views
        public TextView petNameTextView;
        public ImageView petImageView;


        //Constructor for PetViewHolder
        public PetViewHolder(View itemView) {
            super(itemView);

            petNameTextView = itemView.findViewById(R.id.diet_prof_name);
            petImageView = itemView.findViewById(R.id.diet_prof_image);
        }
    }


    //PetAdapter constructor
    public DietPetAdapter(Context context, FragmentManager fragmentManager){
        //Initialize variables
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.fragmentManager = fragmentManager;
        mCursor = mContext.getContentResolver().query(Uri.parse(queryUri), null, null, null, sortOrder);

    }


    @NonNull
    @Override
    public DietPetAdapter.PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Inflate pet profile card layout
        View mItemView = mInflater.inflate(R.layout.diet_prof_card_layout, parent, false);

        //return PetViewHolder object
        return new PetViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolder holder, final int position) {

        //Initialize cursor
        mCursor = mContext.getContentResolver().query(Uri.parse(queryUri), null, null, null, sortOrder);




        //Check if cursor is empty or not,
        //if not, move to current position and populate ViewHolder views with current data
        if(mCursor != null) {
            if (mCursor.moveToPosition(holder.getAdapterPosition())) {
                int indexName = mCursor.getColumnIndex(DatabaseContract.diet.COLUMN_PET_NAME);
                holder.petNameTextView.setText(mCursor.getString(indexName));


            } else {
                //Set invisible because something is wonky with the number of ViewHolders being displayed...
                //holder.itemView.setVisibility(View.INVISIBLE);
            }
        } else {
            //If cursor is empty, log error
            Log.e(TAG, "onBindViewHolder: Cursor is null");
        }

        //listen to single view layout click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to full pet profile fragment
                mCursor.moveToPosition(position);
                int id = mCursor.getInt(mCursor.getColumnIndexOrThrow(DatabaseContract.diet._ID));
                String name = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.diet.COLUMN_PET_NAME));
                String dailyFoods = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.diet.COLUMN_DAILY_FOODS));
                String dailyTreats = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.diet.COLUMN_DAILY_TREATS));
                String feedingSchedule = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.diet.COLUMN_FEEDING_SCHEDULE));
                String foodAllergies = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.diet.COLUMN_FOOD_ALLERGIES));
                String feedingMethods = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.diet.COLUMN_FEEDING_METHODS));
                String occasionalTreats = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.diet.COLUMN_OCCASIONAL_TREATS));
                String notes = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.diet.COLUMN_NOTES));


                Bundle bundle = new Bundle();
                bundle.putString ("id", String.valueOf(id));
                bundle.putString("name", name);
                bundle.putString("dailyFoods", dailyFoods);
                bundle.putString("dailyTreats", dailyTreats);
                bundle.putString("feedingSchedule", feedingSchedule);
                bundle.putString("foodAllergies", foodAllergies);
                bundle.putString("feedingMethods", feedingMethods);
                bundle.putString("occasionalTreats", occasionalTreats);
                bundle.putString("notes", notes);



                //Create instance of MainFragment
               DogsPersonalDietFragment dogsPersonalDietFragment = new DogsPersonalDietFragment();

                dogsPersonalDietFragment.setArguments(bundle);

                fragmentManager.beginTransaction()
                        .replace(R.id.container_fragment, dogsPersonalDietFragment)
                        .commit();




            }
        });

    }



    //Return count of columns in the cursor
    @Override
    public int getItemCount() {

        mCursor = mContext.getContentResolver().query(Uri.parse(queryUri), null, null, null, sortOrder);

        if (mCursor.getCount() > 0){
            return  mCursor.getCount();
        } else {
            return 0;
        }


    }



    //Refresh data
    public void setData(Cursor cursor) {
        mCursor = cursor;
        notifyDataSetChanged();
    }



}
