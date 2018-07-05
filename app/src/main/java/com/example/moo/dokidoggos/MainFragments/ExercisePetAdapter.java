package com.example.moo.dokidoggos.MainFragments;

import android.app.FragmentManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moo.dokidoggos.DatabaseAndProvider.DatabaseContract;
import com.example.moo.dokidoggos.FunFragments.DogsPersonalExerciseFragment;
import com.example.moo.dokidoggos.R;

public class ExercisePetAdapter extends RecyclerView.Adapter<ExercisePetAdapter.PetViewHolder> {

    private static final String TAG = ExercisePetAdapter.class.getSimpleName();

    public android.support.v4.app.FragmentManager fragmentManager;

    private String queryUri = DatabaseContract.exercise.CONTENT_URI.toString();
    private static final String [] projection = new String [] {DatabaseContract.exercise.CONTENT_PATH};
    private String selectionClause = null;
    private String selectionArgs[] = null;
    private String sortOrder = null;

    private final LayoutInflater mInflater;
    private Context mContext;
    private Cursor mCursor;


    public class PetViewHolder extends RecyclerView.ViewHolder {

        public TextView petNameTextView;
        public ImageView petImageView;

        public PetViewHolder(View itemView) {
            super(itemView);

            petNameTextView = itemView.findViewById(R.id.exercise_prof_name);
            petImageView = itemView.findViewById(R.id.exercise_prof_image);

        }
    }

    //Adapter constructor
    public ExercisePetAdapter(Context context, android.support.v4.app.FragmentManager fragmentManager) {
        //initialize variables
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.fragmentManager = fragmentManager;
        mCursor = mContext.getContentResolver().query(Uri.parse(queryUri), null, null, null, sortOrder);
    }

    @NonNull
    @Override
    public ExercisePetAdapter.PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mItemView = mInflater.inflate(R.layout.cardlayout_exercise_profile, parent, false);


        return new PetViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolder holder, final int position) {

        mCursor = mContext.getContentResolver().query(Uri.parse(queryUri), null, null, null, sortOrder);


        if(mCursor != null){
            if(mCursor.moveToPosition(holder.getAdapterPosition())) {
                int indexName = mCursor.getColumnIndex(DatabaseContract.exercise.COLUMN_PET_NAME);
                holder.petNameTextView.setText(mCursor.getString(indexName));
            } else {
                //Set invisible because something is wonky with the number of ViewHolders being displayed...
                //holder.itemView.setVisibility(View.INVISIBLE);
            }
        } else {
            Log.e(TAG, "OnBindViewHolder: Cursor is null");
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCursor.moveToPosition(position);
                int id = mCursor.getInt(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise._ID));
                String name = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_PET_NAME));
                String games = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_GAMES));
                String walkies = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_WALKIES_SCHEDULE));
                String toys = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_TOYS));
                float rollOver = mCursor.getFloat(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_ROLL_OVER));
                float bang = mCursor.getFloat(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_BANG));
                float spin = mCursor.getFloat(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_SPIN));
                float shake = mCursor.getFloat(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_SHAKE));
                float kiss = mCursor.getFloat(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_KISS));
                float dance = mCursor.getFloat(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_DANCE));
                float speak = mCursor.getFloat(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_SPEAK));
                float highFive = mCursor.getFloat(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_HIGH_FIVE));
                float crawl = mCursor.getFloat(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_CRAWL));
                float wave = mCursor.getFloat(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_WAVE));
                float bow = mCursor.getFloat(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_BOW));
                float beg = mCursor.getFloat(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_BEG));
                String rollOverNotes = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_ROLL_OVER_NOTES));
                String bangNotes = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_BANG_NOTES));
                String spinNotes = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_SPIN_NOTES));
                String shakeNotes = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_SHAKE_NOTES));
                String kissNotes = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_KISS_NOTES));
                String danceNotes = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_DANCE_NOTES));
                String speakNotes = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_SPEAK_NOTES));
                String highFiveNotes = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_HIGH_FIVE_NOTES));
                String crawlNotes = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_CRAWL_NOTES));
                String waveNotes = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_WAVE_NOTES));
                String bowNotes = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_BOW_NOTES));
                String begNotes = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_BEG_NOTES));
                String notes = mCursor.getString(mCursor.getColumnIndexOrThrow(DatabaseContract.exercise.COLUMN_NOTES));


                Bundle bundle = new Bundle();
                bundle.putString("id", String.valueOf(id));
                bundle.putString("name", name);
                bundle.putString("games", games);
                bundle.putString("walkies", walkies);
                bundle.putString("toys", toys);
                bundle.putFloat("rollOver", rollOver);
                bundle.putFloat("bang", bang);
                bundle.putFloat("spin", spin);
                bundle.putFloat("shake", shake);
                bundle.putFloat("kiss", kiss);
                bundle.putFloat("dance", dance);
                bundle.putFloat("speak", speak);
                bundle.putFloat("highFive", highFive);
                bundle.putFloat("crawl", crawl);
                bundle.putFloat("wave", wave);
                bundle.putFloat("bow", bow);
                bundle.putFloat("beg", beg);
                bundle.putString("rollOverNotes", rollOverNotes);
                bundle.putString("bangNotes", bangNotes);
                bundle.putString("spinNotes", spinNotes);
                bundle.putString("shakeNotes", shakeNotes);
                bundle.putString("kissNotes", kissNotes);
                bundle.putString("danceNotes", danceNotes);
                bundle.putString("speakNotes", speakNotes);
                bundle.putString("highFiveNotes", highFiveNotes);
                bundle.putString("crawlNotes", crawlNotes);
                bundle.putString("waveNotes", waveNotes);
                bundle.putString("bowNotes", bowNotes);
                bundle.putString("begNotes", begNotes);
                bundle.putString("notes", notes);


                DogsPersonalExerciseFragment dogsPersonalExerciseFragment = new DogsPersonalExerciseFragment();

                dogsPersonalExerciseFragment.setArguments(bundle);

                fragmentManager.beginTransaction()
                        .replace(R.id.container_fragment, dogsPersonalExerciseFragment)
                        .commit();



            }
        });

    }

    @Override
    public int getItemCount() {

        mCursor = mContext.getContentResolver().query(Uri.parse(queryUri), null, null, null, sortOrder);

        if (mCursor.getCount() > 0){
            return mCursor.getCount();
        } else {
            return 0;
        }
    }

    public void setData(Cursor cursor){
        mCursor = cursor;
        notifyDataSetChanged();
    }


}
