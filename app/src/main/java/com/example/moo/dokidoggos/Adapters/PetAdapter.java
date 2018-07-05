package com.example.moo.dokidoggos.Adapters;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moo.dokidoggos.Activities.EditPetActivity;
import com.example.moo.dokidoggos.DatabaseAndProvider.DatabaseContract;
import com.example.moo.dokidoggos.R;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder>{

    //TAG String
    private static final String TAG = PetAdapter.class.getSimpleName();

    //Query parameters for cursor, similar to SQL queries
    private String queryUri = DatabaseContract.petProfile.CONTENT_URI.toString();
    private static final String [] projection = new String [] {DatabaseContract.petProfile.CONTENT_PATH};
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
        public TextView petAgeTextView;
        public TextView petBreedTextView;
        public ImageView petImageView;


        //Constructor for PetViewHolder
        public PetViewHolder(View itemView) {
            super(itemView);

            petNameTextView = itemView.findViewById(R.id.name);
            petAgeTextView = itemView.findViewById(R.id.age);
            petBreedTextView = itemView.findViewById(R.id.breed);
            petImageView = itemView.findViewById(R.id.image);
        }
    }


    //PetAdapter constructor
    public PetAdapter(Context context){
        //Initialize variables
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        mCursor = mContext.getContentResolver().query(Uri.parse(queryUri), null, null, null, sortOrder);

    }


    @NonNull
    @Override
    public PetAdapter.PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Inflate pet profile card layout
        View mItemView = mInflater.inflate(R.layout.profile_card_layout, parent, false);

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
                int indexName = mCursor.getColumnIndex(DatabaseContract.petProfile.COLUMN_PET_NAME);
                holder.petNameTextView.setText(mCursor.getString(indexName));

                int indexAge = mCursor.getColumnIndex(DatabaseContract.petProfile.COLUMN_PET_DOB);
                holder.petAgeTextView.setText(mCursor.getString(indexAge));

                int indexBreed = mCursor.getColumnIndex(DatabaseContract.petProfile.COLUMN_PET_BREED);
                holder.petBreedTextView.setText(mCursor.getString(indexBreed));

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
                int id = mCursor.getInt(mCursor.getColumnIndexOrThrow(DatabaseContract.petProfile._ID));
                String name = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.petProfile.COLUMN_PET_NAME));
                String age = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.petProfile.COLUMN_PET_DOB));
                String breed = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.petProfile.COLUMN_PET_BREED));

                Intent intent = new Intent(mContext, EditPetActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString ("id", String.valueOf(id));
                bundle.putString("name", name);
                bundle.putString("age", age);
                bundle.putString("breed", breed);
                intent.putExtras(bundle);


                mContext.startActivity(intent);



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
