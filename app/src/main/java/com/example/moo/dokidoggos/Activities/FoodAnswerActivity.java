package com.example.moo.dokidoggos.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.moo.dokidoggos.R;

import java.util.Locale;

public class FoodAnswerActivity extends AppCompatActivity {


    TextView foodName;

    TextView answer;

    TextView explanation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_answer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        foodName = findViewById(R.id.food);

        answer = findViewById(R.id.answer);

        explanation = findViewById(R.id.explanation);


        Bundle extras = getIntent().getExtras();

        String foodValue = "";

        String answerValue = "";

        String explanationValue = "";

        String idValue;

        if (extras != null) {
            foodValue = extras.getString("food");
            answerValue = extras.getString("answer");
            explanationValue = extras.getString("explanation");
            idValue = extras.getString("id");

            foodName.setText(foodValue.toUpperCase(Locale.ENGLISH));
            answer.setText(answerValue);
            explanation.setText(explanationValue);
        } else {
            explanation.setText("Food not found. Please try again or search here: for more information.");
        }




    }

}
