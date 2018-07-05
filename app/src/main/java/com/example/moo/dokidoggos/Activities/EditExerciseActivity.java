package com.example.moo.dokidoggos.Activities;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.moo.dokidoggos.DatabaseAndProvider.DatabaseContract;
import com.example.moo.dokidoggos.R;

public class EditExerciseActivity extends AppCompatActivity {



    public TextView nameView;
    public EditText walkEdit;
    public EditText gamesEdit;
    public EditText toysEdit;
    public EditText rollEdit;
    public EditText bangEdit;
    public EditText spinEdit;
    public EditText shakeEdit;
    public EditText kissEdit;
    public EditText danceEdit;
    public EditText speakEdit;
    public EditText hfiveEdit;
    public EditText crawlEdit;
    public EditText waveEdit;
    public EditText bowEdit;
    public EditText begEdit;
    public EditText notesEdit;


    public RatingBar rollBar;
    public RatingBar bangBar;
    public RatingBar spinBar;
    public RatingBar shakeBar;
    public RatingBar kissBar;
    public RatingBar danceBar;
    public RatingBar speakBar;
    public RatingBar hfiveBar;
    public RatingBar crawlBar;
    public RatingBar waveBar;
    public RatingBar bowBar;
    public RatingBar begBar;


    String id;
    String name = "";
    String walkingSchedule = "";
    String favGames = "";
    String favToys = "";
    String rollOver = "";
    String bang = "";
    String spin = "";
    String shake = "";
    String kiss = "";
    String dance = "";
    String speak = "";
    String highFive = "";
    String crawl = "";
    String wave = "";
    String bow = "";
    String beg = "";
    String notes = "";



    float rollRating;
    float bangRating;
    float spinRating;
    float shakeRating;
    float kissRating;
    float danceRating;
    float speakRating;
    float highFiveRating;
    float crawlRating;
    float waveRating;
    float bowRating;
    float begRating;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_exercise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameView = findViewById(R.id.name_exercise_edit);
        walkEdit = findViewById(R.id.walk_edit);
        gamesEdit = findViewById(R.id.fav_games_edit);
        toysEdit = findViewById(R.id.fav_toys_edit);
        rollEdit = findViewById(R.id.roll_edit);
        bangEdit = findViewById(R.id.bang_edit);
        spinEdit = findViewById(R.id.spin_edit);
        shakeEdit = findViewById(R.id.shake_edit);
        kissEdit = findViewById(R.id.kiss_edit);
        danceEdit = findViewById(R.id.dance_edit);
        speakEdit = findViewById(R.id.speak_edit);
        hfiveEdit = findViewById(R.id.high_five_edit);
        crawlEdit = findViewById(R.id.crawl_edit);
        waveEdit = findViewById(R.id.wave_edit);
        bowEdit = findViewById(R.id.bow_edit);
        begEdit = findViewById(R.id.beg_edit);
        notesEdit = findViewById(R.id.exercise_notes_edit);


        rollBar = findViewById(R.id.roll_rating_edit);
        bangBar = findViewById(R.id.bang_rating_edit);
        spinBar = findViewById(R.id.spin_rating_edit);
        shakeBar = findViewById(R.id.shake_rating_edit);
        kissBar = findViewById(R.id.kiss_rating_edit);
        danceBar = findViewById(R.id.dance_rating_edit);
        speakBar = findViewById(R.id.speak_rating_edit);
        hfiveBar = findViewById(R.id.high_five_rating_edit);
        crawlBar = findViewById(R.id.crawl_rating_edit);
        waveBar = findViewById(R.id.wave_rating_edit);
        bowBar = findViewById(R.id.bow_rating_edit);
        begBar = findViewById(R.id.beg_rating_edit);



        Bundle bundle = getIntent().getExtras();

        if (bundle!= null) {
            id = bundle.getString("id", null);
            name = bundle.getString("name", null);
            walkingSchedule = bundle.getString("walkies", null);
            favGames = bundle.getString("games", null);
            favToys = bundle.getString("toys", null);
            rollRating = bundle.getFloat("rollOver", 0);
            bangRating = bundle.getFloat("bang", 0);
            spinRating = bundle.getFloat("spin", 0);
            shakeRating = bundle.getFloat("shake", 0);
            kissRating = bundle.getFloat("kiss", 0);
            danceRating = bundle.getFloat("dance", 0);
            speakRating = bundle.getFloat("speak", 0);
            highFiveRating = bundle.getFloat("highFive", 0);
            crawlRating = bundle.getFloat("crawl", 0);
            waveRating = bundle.getFloat("wave", 0);
            bowRating = bundle.getFloat("bow", 0);
            begRating = bundle.getFloat("beg", 0);
            rollOver = bundle.getString("rollOverNotes", null);
            bang = bundle.getString("bangNotes", null);
            spin = bundle.getString("spinNotes", null);
            shake = bundle.getString("shakeNotes", null);
            kiss = bundle.getString("kissNotes", null);
            dance = bundle.getString("danceNotes", null);
            speak = bundle.getString("speakNotes",null);
            highFive = bundle.getString("highFiveNotes", null);
            crawl = bundle.getString("crawlNotes", null);
            wave = bundle.getString("waveNotes", null);
            bow = bundle.getString("bowNotes", null);
            beg = bundle.getString("begNotes", null);
            notes = bundle.getString("notes", null);

        }


        nameView.setText(name);
        walkEdit.setText(walkingSchedule);
        gamesEdit.setText(favGames);
        toysEdit.setText(favToys);
        rollEdit.setText(rollOver);
        bangEdit.setText(bang);
        shakeEdit.setText(shake);
        kissEdit.setText(kiss);
        danceEdit.setText(dance);
        speakEdit.setText(speak);
        hfiveEdit.setText(highFive);
        crawlEdit.setText(crawl);
        waveEdit.setText(wave);
        bowEdit.setText(bow);
        begEdit.setText(beg);
        notesEdit.setText(notes);


        rollBar.setRating(rollRating);
        bangBar.setRating(bangRating);
        spinBar.setRating(spinRating);
        shakeBar.setRating(shakeRating);
        kissBar.setRating(kissRating);
        danceBar.setRating(danceRating);
        speakBar.setRating(speakRating);
        hfiveBar.setRating(highFiveRating);
        crawlBar.setRating(crawlRating);
        waveBar.setRating(waveRating);
        bowBar.setRating(bowRating);
        begBar.setRating(begRating);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_exercise);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContentValues values = new ContentValues();
                ContentValues profValues = new ContentValues();

                values.put(DatabaseContract.exercise.COLUMN_WALKIES_SCHEDULE, walkEdit.getText().toString());
                values.put(DatabaseContract.exercise.COLUMN_GAMES, gamesEdit.getText().toString());
                values.put(DatabaseContract.exercise.COLUMN_TOYS, toysEdit.getText().toString());
                values.put(DatabaseContract.exercise.COLUMN_ROLL_OVER_NOTES, rollEdit.getText().toString());
                values.put(DatabaseContract.exercise.COLUMN_ROLL_OVER, rollBar.getRating());
                values.put(DatabaseContract.exercise.COLUMN_BANG_NOTES, bangEdit.getText().toString());
                values.put(DatabaseContract.exercise.COLUMN_BANG, bangBar.getRating());
                values.put(DatabaseContract.exercise.COLUMN_SPIN_NOTES, spinEdit.getText().toString());
                values.put(DatabaseContract.exercise.COLUMN_SPIN, spinBar.getRating());
                values.put(DatabaseContract.exercise.COLUMN_SHAKE_NOTES, shakeEdit.getText().toString());
                values.put(DatabaseContract.exercise.COLUMN_SHAKE, shakeBar.getRating());
                values.put(DatabaseContract.exercise.COLUMN_KISS_NOTES, kissEdit.getText().toString());
                values.put(DatabaseContract.exercise.COLUMN_KISS, kissBar.getRating());
                values.put(DatabaseContract.exercise.COLUMN_DANCE_NOTES, danceEdit.getText().toString());
                values.put(DatabaseContract.exercise.COLUMN_DANCE, danceBar.getRating());
                values.put(DatabaseContract.exercise.COLUMN_SPEAK_NOTES, speakEdit.getText().toString());
                values.put(DatabaseContract.exercise.COLUMN_SPEAK, speakBar.getRating());
                values.put(DatabaseContract.exercise.COLUMN_HIGH_FIVE_NOTES, hfiveEdit.getText().toString());
                values.put(DatabaseContract.exercise.COLUMN_HIGH_FIVE, hfiveBar.getRating());
                values.put(DatabaseContract.exercise.COLUMN_CRAWL_NOTES, crawlEdit.getText().toString());
                values.put(DatabaseContract.exercise.COLUMN_CRAWL, crawlBar.getRating());
                values.put(DatabaseContract.exercise.COLUMN_WAVE_NOTES, waveEdit.getText().toString());
                values.put(DatabaseContract.exercise.COLUMN_WAVE, waveBar.getRating());
                values.put(DatabaseContract.exercise.COLUMN_BOW_NOTES, bowEdit.getText().toString());
                values.put(DatabaseContract.exercise.COLUMN_BOW, bowBar.getRating());
                values.put(DatabaseContract.exercise.COLUMN_BEG_NOTES, begEdit.getText().toString());
                values.put(DatabaseContract.exercise.COLUMN_BEG, begBar.getRating());
                values.put(DatabaseContract.exercise.COLUMN_NOTES, notesEdit.getText().toString());

                Uri uri = DatabaseContract.exercise.buildPetExerciseUri(id);
                getContentResolver().update(uri, values, null, null);

                goBackHome();

            }
        });


    }



    //Method which takes us back to main activity
    private void goBackHome(){
        startActivity(new Intent(EditExerciseActivity.this, MainActivity.class));

    }


}
