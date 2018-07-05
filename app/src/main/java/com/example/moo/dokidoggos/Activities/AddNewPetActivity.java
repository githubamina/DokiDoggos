package com.example.moo.dokidoggos.Activities;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moo.dokidoggos.DatabaseAndProvider.DatabaseContract;
import com.example.moo.dokidoggos.DatabaseAndProvider.DokiDoggosDbHelper;
import com.example.moo.dokidoggos.R;

public class AddNewPetActivity extends AppCompatActivity {

    //EditText variables to store user input
    private EditText mNameEditText;
    private EditText mAgeEditText;
    private EditText mBreedEditText;

    //Button which will add the pet from user input on being pressed
    private Button mAddPetButton;

    //Handle to databasehelper
    private DokiDoggosDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_pet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialize views and button
        mNameEditText = (EditText) findViewById(R.id.userName);
        mAgeEditText = (EditText) findViewById(R.id.userAge);
        mBreedEditText = (EditText) findViewById(R.id.userOccupation);
        mAddPetButton = (Button) findViewById(R.id.addNewUserButton);

        //Set on click listener on button
        mAddPetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //On click call the savePet() method below which will save the
                //entered pet into the database
                savePet(getBaseContext());
            }
        });


    }

    //Method which creates a pet object from user input and saves it into the database
    private void savePet(Context context) {
        //Get the text from the edit text user input
        //and store in string variable
        String name = mNameEditText.getText().toString().trim();
        String age = mAgeEditText.getText().toString().trim();
        String breed = mBreedEditText.getText().toString().trim();
        //get reference to the dbhelper so we can use the savenewpet method
        dbHelper = new DokiDoggosDbHelper(this);

        //into the database
        ContentValues values = new ContentValues();
        ContentValues dietValue = new ContentValues();
        ContentValues exerciseValue = new ContentValues();
        ContentValues medicalValue = new ContentValues();
        //Add the data and where in the database we want to store it to the ContentValues
        //Photo one is currently commented out because I have yet to learn how
        //to use user gallery images with an app database
        exerciseValue.put(DatabaseContract.exercise.COLUMN_PET_NAME, name);
        dietValue.put(DatabaseContract.diet.COLUMN_PET_NAME, name);
        medicalValue.put(DatabaseContract.medical.COLUMN_PET_NAME, name);
        values.put(DatabaseContract.petProfile.COLUMN_PET_NAME, name);
        values.put(DatabaseContract.petProfile.COLUMN_PET_DOB, age);
        values.put(DatabaseContract.petProfile.COLUMN_PET_BREED, breed);
        //values.put(DatabaseContract.petProfile.COLUMN_PET_PHOTO, pet.getImage());

        //(Insert into database- this is the original code but since I'm now using a ContentProvider-
        //this is no longer necessary and this code has been commented out)
        // db.insert(DatabaseContract.petProfile.TABLE_NAME, null, values);
        // db.close();



        //if the name is empty, tell the user to enter one with a toast message
        if(name.isEmpty()){
            Toast.makeText(this, "You must enter a name", Toast.LENGTH_SHORT);
        } else {

            //ContentResolver will access the PetContentProvider
            // and insert the values into the database
            Uri newUri = context.getContentResolver().insert(DatabaseContract.petProfile.CONTENT_URI, values);
            Uri newDietUri = context.getContentResolver().insert(DatabaseContract.diet.CONTENT_URI, dietValue);
            Uri newExerciseUri = context.getContentResolver().insert(DatabaseContract.exercise.CONTENT_URI, exerciseValue);
            Uri newMedicalUri = context.getContentResolver().insert(DatabaseContract.medical.CONTENT_URI, medicalValue);
            Log.d("yay", "DONE");


            //call goBackHome method to return to mainactivity
            goBackHome();
        }
    }

    //Method which takes us back to main activity
    private void goBackHome(){
        startActivity(new Intent(AddNewPetActivity.this, MainActivity.class));

    }



}
