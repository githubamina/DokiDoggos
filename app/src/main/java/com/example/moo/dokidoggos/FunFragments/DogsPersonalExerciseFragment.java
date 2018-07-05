package com.example.moo.dokidoggos.FunFragments;


import android.content.Intent;
import android.os.Bundle;

import android.provider.CalendarContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.moo.dokidoggos.Activities.EditExerciseActivity;
import com.example.moo.dokidoggos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DogsPersonalExerciseFragment extends Fragment {

    Button editButton;
    Button reminderButton;

    TextView nameView;
    TextView walkiesScheduleTV;
    TextView favGamesTV;
    TextView favToysTV;
    TextView rollOverNotesTV;
    TextView bangNotesTV;
    TextView spinNotesTV;
    TextView shakeNotesTV;
    TextView kissNotesTV;
    TextView danceNotesTV;
    TextView speakNotesTV;
    TextView highFiveNotesTV;
    TextView crawlNotesTV;
    TextView waveNotesTV;
    TextView bowNotesTV;
    TextView begNotesTV;
    TextView notesTV;


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


    RatingBar rollRatingBar;
    RatingBar bangRatingBar;
    RatingBar spinRatingBar;
    RatingBar shakeRatingBar;
    RatingBar kissRatingBar;
    RatingBar danceRatingBar;
    RatingBar speakRatingBar;
    RatingBar highFiveRatingBar;
    RatingBar crawlRatingBar;
    RatingBar waveRatingBar;
    RatingBar bowRatingBar;
    RatingBar begRatingBar;

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


    public DogsPersonalExerciseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_dogs_personal_exercise, container, false);

        nameView = rootView.findViewById(R.id.name_exercise_prof);
        walkiesScheduleTV = rootView.findViewById(R.id.walkies_profile);
        favGamesTV = rootView.findViewById(R.id.games_profile);
        favToysTV = rootView.findViewById(R.id.toys_profile);
        rollOverNotesTV = rootView.findViewById(R.id.roll_over);
        bangNotesTV = rootView.findViewById(R.id.bang);
        spinNotesTV = rootView.findViewById(R.id.spin);
        shakeNotesTV = rootView.findViewById(R.id.shake);
        kissNotesTV = rootView.findViewById(R.id.kiss);
        danceNotesTV = rootView.findViewById(R.id.dance);
        speakNotesTV = rootView.findViewById(R.id.speak);
        highFiveNotesTV = rootView.findViewById(R.id.high_five);
        crawlNotesTV = rootView.findViewById(R.id.crawl);
        waveNotesTV = rootView.findViewById(R.id.wave);
        bowNotesTV = rootView.findViewById(R.id.bow);
        begNotesTV = rootView.findViewById(R.id.beg);
        notesTV = rootView.findViewById(R.id.notes);


        rollRatingBar = rootView.findViewById(R.id.roll_rating);
        bangRatingBar = rootView.findViewById(R.id.bang_rating);
        spinRatingBar = rootView.findViewById(R.id.spin_rating);
        shakeRatingBar = rootView.findViewById(R.id.shake_rating);
        kissRatingBar = rootView.findViewById(R.id.kiss_rating);
        danceRatingBar = rootView.findViewById(R.id.dance_rating);
        speakRatingBar = rootView.findViewById(R.id.speak_rating);
        highFiveRatingBar = rootView.findViewById(R.id.high_five_rating);
        crawlRatingBar = rootView.findViewById(R.id.crawl_rating);
        waveRatingBar = rootView.findViewById(R.id.wave_rating);
        bowRatingBar = rootView.findViewById(R.id.bow_rating);
        begRatingBar = rootView.findViewById(R.id.beg_rating);

        editButton = rootView.findViewById(R.id.exercise_edit_button);
        reminderButton = rootView.findViewById(R.id.exercise_reminder_button);


        Bundle bundle = this.getArguments();
        if (bundle != null) {
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
        walkiesScheduleTV.setText(walkingSchedule);
        favGamesTV.setText(favGames);
        favToysTV.setText(favToys);
        rollOverNotesTV.setText(rollOver);
        bangNotesTV.setText(bang);
        shakeNotesTV.setText(shake);
        kissNotesTV.setText(kiss);
        danceNotesTV.setText(dance);
        speakNotesTV.setText(speak);
        highFiveNotesTV.setText(highFive);
        crawlNotesTV.setText(crawl);
        waveNotesTV.setText(wave);
        bowNotesTV.setText(bow);
        begNotesTV.setText(beg);
        notesTV.setText(notes);


        rollRatingBar.setRating(rollRating);
        bangRatingBar.setRating(bangRating);
        shakeRatingBar.setRating(shakeRating);
        kissRatingBar.setRating(kissRating);
        danceRatingBar.setRating(danceRating);
        speakRatingBar.setRating(speakRating);
        highFiveRatingBar.setRating(highFiveRating);
        crawlRatingBar.setRating(crawlRating);
        waveRatingBar.setRating(waveRating);
        bowRatingBar.setRating(bowRating);
        begRatingBar.setRating(begRating);


        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditExerciseActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString ("id", id);
                bundle.putString("name", name);
                bundle.putString("games", favGames);
                bundle.putString("walkies", walkingSchedule);
                bundle.putString("toys", favToys);
                bundle.putFloat("rollOver", rollRating);
                bundle.putFloat("bang", bangRating);
                bundle.putFloat("spin", spinRating);
                bundle.putFloat("shake", shakeRating);
                bundle.putFloat("kiss", kissRating);
                bundle.putFloat("dance", danceRating);
                bundle.putFloat("speak", speakRating);
                bundle.putFloat("highFive", highFiveRating);
                bundle.putFloat("crawl", crawlRating);
                bundle.putFloat("wave", waveRating);
                bundle.putFloat("bow", bowRating);
                bundle.putFloat("beg", begRating);
                bundle.putString("rollOverNotes", rollOver);
                bundle.putString("bangNotes", bang);
                bundle.putString("spinNotes", spin);
                bundle.putString("shakeNotes", shake);
                bundle.putString("kissNotes", kiss);
                bundle.putString("danceNotes", dance);
                bundle.putString("speakNotes", speak);
                bundle.putString("highFiveNotes", highFive);
                bundle.putString("crawlNotes", crawl);
                bundle.putString("waveNotes", wave);
                bundle.putString("bowNotes", bow);
                bundle.putString("begNotes", beg);
                bundle.putString("notes", notes);

                intent.putExtras(bundle);


                startActivity(intent);
            }
        });


        reminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI);
                startActivity(intent);
            }
        });









        // Inflate the layout for this fragment
        return rootView;
    }

}
