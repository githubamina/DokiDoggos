package com.example.moo.dokidoggos.Activities;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.moo.dokidoggos.DatabaseAndProvider.DatabaseContract;
import com.example.moo.dokidoggos.R;

public class EditDietInfoActivity extends AppCompatActivity {


    public EditText nameEdit;
    public EditText dailyFoodEdit;
    public EditText dailyTreatsEdit;
    public EditText feedingScheduleEdit;
    public EditText foodAllergiesEdit;
    public EditText feedingMethodEdit;
    public EditText occasionalTreatsEdit;
    public EditText notesEdit;


    String nameValue = "";
    String dailyFoodValue = "";
    String dailyTreatsValue = "";
    String feedingScheduleValue = "";
    String foodAllergiesValue = "";
    String feedingMethodsValue = "";
    String occasionalTreatsValue = "";
    String notesValue = "";
    String idValue = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_diet_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameEdit = findViewById(R.id.name_edit);
        dailyFoodEdit = findViewById(R.id.daily_diet_edit);
        dailyTreatsEdit = findViewById(R.id.daily_treats_edit);
        feedingScheduleEdit = findViewById(R.id.feeding_schedule_edit);
        foodAllergiesEdit = findViewById(R.id.food_allergies_edit);
        feedingMethodEdit = findViewById(R.id.feeding_method_edit);
        occasionalTreatsEdit = findViewById(R.id.occasional_treats_edit);
        notesEdit = findViewById(R.id.other_diet_notes_edit);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            idValue = extras.getString("id");
            nameValue = extras.getString("name");
            dailyFoodValue = extras.getString("dailyFoods");
            dailyTreatsValue = extras.getString("dailyTreats");
            feedingScheduleValue = extras.getString("feedingSchedule");
            foodAllergiesValue = extras.getString("foodAllergies");
            feedingMethodsValue = extras.getString("feedingMethods");
            occasionalTreatsValue = extras.getString("occasionalTreats");
            notesValue = extras.getString("notes");

        }

        nameEdit.setText(nameValue);
        dailyFoodEdit.setText(dailyFoodValue);
        dailyTreatsEdit.setText(dailyTreatsValue);
        feedingScheduleEdit.setText(feedingScheduleValue);
        foodAllergiesEdit.setText(foodAllergiesValue);
        feedingMethodEdit.setText(feedingMethodsValue);
        occasionalTreatsEdit.setText(occasionalTreatsValue);
        notesEdit.setText(notesValue);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContentValues values = new ContentValues();
                ContentValues profValues = new ContentValues();

                profValues.put(DatabaseContract.petProfile.COLUMN_PET_NAME, nameEdit.getText().toString());

                values.put(DatabaseContract.diet.COLUMN_PET_NAME, nameEdit.getText().toString());
                values.put(DatabaseContract.diet.COLUMN_DAILY_FOODS, dailyFoodEdit.getText().toString());
                values.put(DatabaseContract.diet.COLUMN_DAILY_TREATS, dailyTreatsEdit.getText().toString());
                values.put(DatabaseContract.diet.COLUMN_FEEDING_SCHEDULE, feedingScheduleEdit.getText().toString());
                values.put(DatabaseContract.diet.COLUMN_FOOD_ALLERGIES, foodAllergiesEdit.getText().toString());
                values.put(DatabaseContract.diet.COLUMN_FEEDING_METHODS, feedingMethodEdit.getText().toString());
                values.put(DatabaseContract.diet.COLUMN_OCCASIONAL_TREATS, occasionalTreatsEdit.getText().toString());
                values.put(DatabaseContract.diet.COLUMN_NOTES, notesEdit.getText().toString());

                Uri profUri = DatabaseContract.petProfile.buildPetUri(idValue);
                Uri uri = DatabaseContract.diet.buildPetDietUri(idValue);
                getContentResolver().update(uri, values, null, null);
                getContentResolver().update(profUri, profValues, null, null);

                goBackHome();

            }
        });
    }


    //Method which takes us back to main activity
    private void goBackHome(){
        startActivity(new Intent(EditDietInfoActivity.this, MainActivity.class));

    }

}
