package com.example.moo.dokidoggos.DietFragments;


import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.moo.dokidoggos.Activities.EditDietInfoActivity;
import com.example.moo.dokidoggos.Activities.EditPetActivity;
import com.example.moo.dokidoggos.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class DogsPersonalDietFragment extends Fragment {


    public DogsPersonalDietFragment() {
        // Required empty public constructor
    }

    TextView nameView;
    TextView dailyFoodsView;
    TextView dailyTreatsView;
    TextView feedingScheduleView;
    TextView foodAllergiesView;
    TextView feedingMethodsView;
    TextView occasionalTreatsView;
    TextView notesView;
    Button editButton;
    Button reminderButton;


    String id;
    String name = "";
    String dailyFoods = "";
    String dailyTreats = "";
    String feedingSchedule = "";
    String foodAllergies = "";
    String feedingMethods = "";
    String occasionalTreats = "";
    String notes = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.fragment_dog_diet, container, false);

        nameView = rootView.findViewById(R.id.name_diet_prof);
        dailyFoodsView = rootView.findViewById(R.id.daily_foods);
        dailyTreatsView = rootView.findViewById(R.id.daily_treats);
        feedingScheduleView = rootView.findViewById(R.id.feeding_schedule);
        foodAllergiesView = rootView.findViewById(R.id.food_allergies);
        feedingMethodsView = rootView.findViewById(R.id.feeding_methods);
        occasionalTreatsView = rootView.findViewById(R.id.occasional_treats);
        notesView = rootView.findViewById(R.id.notes);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            id = bundle.getString("id", null);
            name = bundle.getString("name", null);
            dailyFoods = bundle.getString("dailyFoods", null);
            dailyTreats = bundle.getString("dailyTreats", null);
            feedingSchedule = bundle.getString("feedingSchedule", null);
            foodAllergies = bundle.getString("foodAllergies", null);
            feedingMethods = bundle.getString("feedingMethods", null);
            occasionalTreats = bundle.getString("occasionalTreats", null);
            notes = bundle.getString("notes", null);
        }

        nameView.setText(name);
        dailyFoodsView.setText(dailyFoods);
        dailyTreatsView.setText(dailyTreats);
        feedingScheduleView.setText(feedingSchedule);
        foodAllergiesView.setText(foodAllergies);
        feedingMethodsView.setText(feedingMethods);
        occasionalTreatsView.setText(occasionalTreats);
        notesView.setText(notes);


        editButton = rootView.findViewById(R.id.edit_button);
        reminderButton = rootView.findViewById(R.id.reminder_button);



        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditDietInfoActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString ("id", id);
                bundle.putString("name", name);
                bundle.putString("dailyFoods", dailyFoods);
                bundle.putString("dailyTreats", dailyTreats);
                bundle.putString("feedingSchedule", feedingSchedule);
                bundle.putString("foodAllergies", foodAllergies);
                bundle.putString("feedingMethods", feedingMethods);
                bundle.putString("occasionalTreats", occasionalTreats);
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
