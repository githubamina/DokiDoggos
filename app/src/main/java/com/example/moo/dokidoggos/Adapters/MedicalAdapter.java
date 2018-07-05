package com.example.moo.dokidoggos.Adapters;

import android.app.FragmentManager;
import android.content.Context;
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

import com.example.moo.dokidoggos.DatabaseAndProvider.DatabaseContract;
import com.example.moo.dokidoggos.DietFragments.DogsPersonalDietFragment;
import com.example.moo.dokidoggos.MedicalFragments.DogsPersonalMedicalFragment;
import com.example.moo.dokidoggos.R;

public class MedicalAdapter extends RecyclerView.Adapter<MedicalAdapter.PetViewHolder>{

    private static final String TAG = MedicalAdapter.class.getSimpleName();

    public android.support.v4.app.FragmentManager fragmentManager;

    //Query parameters for cursor, similar to SQL queries
    private String queryUri = DatabaseContract.medical.CONTENT_URI.toString();
    private static final String [] projection = new String [] {DatabaseContract.medical.CONTENT_PATH};
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

            petNameTextView = itemView.findViewById(R.id.medical_prof_name);
            petImageView = itemView.findViewById(R.id.medical_prof_image);
        }
    }


    //PetAdapter constructor
    public MedicalAdapter(Context context, android.support.v4.app.FragmentManager fragmentManager){
        //Initialize variables
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.fragmentManager = fragmentManager;
        mCursor = mContext.getContentResolver().query(Uri.parse(queryUri), null, null, null, sortOrder);

    }


    @NonNull
    @Override
    public MedicalAdapter.PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //inflate pet profile card layout
        View mItemView = mInflater.inflate(R.layout.medical_card_layout, parent, false);

        return new PetViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicalAdapter.PetViewHolder holder, final int position) {

        //Initialize cursor
        mCursor = mContext.getContentResolver().query(Uri.parse(queryUri), null, null, null, sortOrder);




        //Check if cursor is empty or not,
        //if not, move to current position and populate ViewHolder views with current data
        if(mCursor != null) {
            if (mCursor.moveToPosition(holder.getAdapterPosition())) {
                int indexName = mCursor.getColumnIndex(DatabaseContract.medical.COLUMN_PET_NAME);
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
                int id = mCursor.getInt(mCursor.getColumnIndexOrThrow(DatabaseContract.medical._ID));
                String name = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_PET_NAME));
                String vetName = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_VET_NAME));
                String vetClinic = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_VET_CLINIC));
                String vetPhone = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_VET_PHONE));
                String previousVets = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_PREVIOUS_VETS));
                String nextAppt = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_NEXT_APPOINTMENT));
                String regularMeds = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_REGULAR_MEDICATION));
                String shortTermMeds = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_SHORT_TERM_MEDICATION));
                String supplements = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_SUPPLEMENTS));
                String dentalRoutine = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_DENTAL_ROUTINE));
                String healthConditions = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_HEALTH_CONDITIONS));
                String allergies = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_ALLERGIES));
                String insuranceProvider = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_INSURANCE_PROVIDER));
                String policyNumber = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_POLICY_NUMBER));
                String heartWorm = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_HEARTWORM_PREVENTION));
                String fleaTick = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_FLEA_TICK_PREVENTION));
                String cdvVac = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_VAC_CDV));
                String parvoVac = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_VAC_PARVO));
                String adenoVac = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_VAC_ADENO));
                String paraVac = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_VAC_PARAINFLUENZA));
                String bronchVac = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_VAC_BBRONCHISPETICA));
                String lintVac = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_VAC_LINTERROGANS));
                String desexed = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.medical.COLUMN_DESEXED));

                Bundle bundle = new Bundle();
                bundle.putString ("id", String.valueOf(id));
                bundle.putString("name", name);
                bundle.putString("vetName", vetName);
                bundle.putString("vetClinic", vetClinic);
                bundle.putString("vetPhone", vetPhone);
                bundle.putString("previousVets", previousVets);
                bundle.putString("nextAppt", nextAppt);
                bundle.putString("regularMeds", regularMeds);
                bundle.putString("shortTermMeds", shortTermMeds);
                bundle.putString("supplements", supplements);
                bundle.putString("dentalRoutine", dentalRoutine);
                bundle.putString("healthConditions", healthConditions);
                bundle.putString("allergies", allergies);
                bundle.putString("insurance", insuranceProvider);
                bundle.putString("policyNumber", policyNumber);
                bundle.putString("heartWorm", heartWorm);
                bundle.putString("fleaTick", fleaTick);
                bundle.putString("cdvVac", cdvVac);
                bundle.putString("parvoVac", parvoVac);
                bundle.putString("adenoVac", adenoVac);
                bundle.putString("paraVac", paraVac);
                bundle.putString("bronchVac", bronchVac);
                bundle.putString("lintVac", lintVac);
                bundle.putString("desexed", desexed);



                //Create instance of MainFragment
                DogsPersonalMedicalFragment dogsPersonalMedicalFragment = new DogsPersonalMedicalFragment();

                dogsPersonalMedicalFragment.setArguments(bundle);

                fragmentManager.beginTransaction()
                        .replace(R.id.container_fragment, dogsPersonalMedicalFragment)
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
