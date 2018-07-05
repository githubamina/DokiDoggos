package com.example.moo.dokidoggos.Activities;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.moo.dokidoggos.DatabaseAndProvider.DatabaseContract;
import com.example.moo.dokidoggos.R;

public class EditPetActivity extends AppCompatActivity {


    public EditText nameEdit;
    public EditText ageEdit;
    public EditText breedEdit;

    public Button updateButton;
    public Button deleteButton;

    String nameValue = "";
    String ageValue = "";
    String breedValue = "";
    String idValue = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameEdit = findViewById(R.id.edit_name);
        ageEdit = findViewById(R.id.edit_age);
        breedEdit = findViewById(R.id.edit_breed);


        Bundle extras = getIntent().getExtras();


        if (extras != null) {
            nameValue = extras.getString("name");
            ageValue = extras.getString("age");
            breedValue = extras.getString("breed");
            idValue = extras.getString("id");
        }

        nameEdit.setText(nameValue);
        ageEdit.setText(ageValue);
        breedEdit.setText(breedValue);

       updateButton = findViewById(R.id.update_button);

        deleteButton = findViewById(R.id.delete_button);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                ContentValues values = new ContentValues();
                ContentValues dietValue = new ContentValues();
                ContentValues exerciseValue = new ContentValues();


                exerciseValue.put(DatabaseContract.exercise.COLUMN_PET_NAME, nameEdit.getText().toString());
                dietValue.put(DatabaseContract.diet.COLUMN_PET_NAME, nameEdit.getText().toString());
                values.put(DatabaseContract.petProfile.COLUMN_PET_NAME, nameEdit.getText().toString());
                values.put(DatabaseContract.petProfile.COLUMN_PET_DOB, ageEdit.getText().toString());
                values.put(DatabaseContract.petProfile.COLUMN_PET_BREED, breedEdit.getText().toString());

                Uri uri = DatabaseContract.petProfile.buildPetUri(idValue);
                Uri dietUri = DatabaseContract.diet.buildPetDietUri(idValue);
                Uri exerciseUri = DatabaseContract.exercise.buildPetExerciseUri(idValue);
                getContentResolver().update(uri, values, null, null);
                getContentResolver().update(dietUri, dietValue, null, null);
                getContentResolver().update(exerciseUri, exerciseValue, null, null);

                goBackHome();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // 1. Instantiate an AlertDialog.Builder with its constructor
                AlertDialog.Builder builder = new AlertDialog.Builder(EditPetActivity.this);

                // 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage("Are you sure you would like to delete this pet's profile?")
                        .setTitle("Delete Profile");

                // Add the buttons
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        Uri uri = DatabaseContract.petProfile.buildPetUri(idValue);
                        Uri dietUri = DatabaseContract.diet.buildPetDietUri(idValue);
                        Uri exerciseUri = DatabaseContract.exercise.buildPetExerciseUri(idValue);

                        getContentResolver().delete(uri, null, null);
                        getContentResolver().delete(dietUri, null, null);
                        getContentResolver().delete(exerciseUri, null, null);

                        goBackHome();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.cancel();
                    }
                });

               // 3. Get the AlertDialog from create()
                AlertDialog dialog = builder.create();



                dialog.show();

            }
        });


    }


    //Method which takes us back to main activity
    private void goBackHome(){
        startActivity(new Intent(EditPetActivity.this, MainActivity.class));

    }

}
