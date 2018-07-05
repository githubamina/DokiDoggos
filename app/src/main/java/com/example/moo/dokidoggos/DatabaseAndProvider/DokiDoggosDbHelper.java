package com.example.moo.dokidoggos.DatabaseAndProvider;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.moo.dokidoggos.Classes.Pet;

import java.util.LinkedList;

public class DokiDoggosDbHelper extends SQLiteOpenHelper {


    //DokiDoggosDbHelper constructor
    public DokiDoggosDbHelper(Context context) {
        super(context, DatabaseContract.DATABASE_NAME, null, DatabaseContract.DATABASE_VERSION);
    }


    //Create tables during database creation
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseContract.petProfile.CREATE_PET_PROFILE_TABLE);
        db.execSQL(DatabaseContract.foodInfo.CREATE_FOOD_INFO_TABLE);
        db.execSQL(DatabaseContract.vetContactInfo.CREATE_VET_CONTACTS_TABLE);
        db.execSQL(DatabaseContract.petsHealthLog.CREATE_PET_HEALTH_TABLE);
        db.execSQL(DatabaseContract.groomerContactInfo.CREATE_GROOMER_CONTACTS_TABLE);
        db.execSQL(DatabaseContract.emergencyContactInfo.CREATE_EMERGENCY_CONTACTS_TABLE);
        db.execSQL(DatabaseContract.commands.CREATE_COMMANDS_TABLE);
        db.execSQL(DatabaseContract.behaviourIssues.CREATE_BEHAVIOUR_ISSUES_TABLE);
        db.execSQL(DatabaseContract.medicines.CREATE_MEDICINES_TABLE);
        db.execSQL(DatabaseContract.diet.CREATE_DIET_TABLE);
        db.execSQL(DatabaseContract.insurance.CREATE_INSURANCE_TABLE);
        db.execSQL(DatabaseContract.vaccinations.CREATE_VACCINATIONS_TABLE);
        db.execSQL(DatabaseContract.petCarer.CREATE_PET_CARER_TABLE);
        db.execSQL(DatabaseContract.exercise.CREATE_EXERCISE_TABLE);
        db.execSQL(DatabaseContract.medical.CREATE_MEDICAL_TABLE);





    }


    //When onUpgrade is called, delete the current tables and create new ones
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Delete tables
        db.execSQL(DatabaseContract.petProfile.SQL_DELETE_PET_PROFILE);
        db.execSQL(DatabaseContract.foodInfo.CREATE_FOOD_INFO_TABLE);
        db.execSQL(DatabaseContract.vetContactInfo.SQL_DELETE_VET_CONTACTS);
        db.execSQL(DatabaseContract.petsHealthLog.SQL_DELETE_HEALTH_LOGS);
        db.execSQL(DatabaseContract.groomerContactInfo.SQL_DELETE_GROOMER_CONTACTS);
        db.execSQL(DatabaseContract.emergencyContactInfo.SQL_DELETE_EMERGENCY_CONTACTS);
        db.execSQL(DatabaseContract.commands.SQL_DELETE_COMMANDS);
        db.execSQL(DatabaseContract.behaviourIssues.SQL_DELETE_BEHAVIOIUR_ISSUES);
        db.execSQL(DatabaseContract.medicines.SQL_DELETE_MEDICINES);
        db.execSQL(DatabaseContract.diet.SQL_DELETE_DIET);
        db.execSQL(DatabaseContract.insurance.SQL_DELETE_INSURANCE);
        db.execSQL(DatabaseContract.vaccinations.SQL_DELETE_VACCINATIONS);
        db.execSQL(DatabaseContract.petCarer.SQL_DELETE_PET_CARER);
        db.execSQL(DatabaseContract.exercise.SQL_DELETE_EXERCISE);

        onCreate(db);


    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);

    }



    
    //Get list of pets from petProfile table
    public LinkedList<Pet> getPets(String filter) {
        //String variable to store the query to retrieve data from the petProfile table
        String query;
        //Check if a filter has been passed in. If not, use the select all query.
        if(filter.equals("")){
            query = "SELECT * FROM '"+DatabaseContract.petProfile.TABLE_NAME+"'";
            //If a filter has been passed in, use the query with an ORDER BY statement
        } else{
            query = "SELECT * FROM " + DatabaseContract.petProfile.TABLE_NAME + " ORDER BY '" + filter + "'";
        }


        //Create new LinkedList storing Pet objects to store our retrieved data
        LinkedList<Pet> petLinkedList = new LinkedList<>();
        //New SQLiteDatabase to store our database reference
        SQLiteDatabase db = this.getWritableDatabase();
        //Query the database and store the data in a new cursor object
        Cursor cursor = db.rawQuery(query, null);
        //Pet object to store one Pet at a time, retrieved from cursor, before inserting into
        //the LinkedList we created above
        Pet pet;

        //While the cursor isn't empty, keep getting the data for a single pet from the cursor
        //and then add the single pet to the linkedlist. and keep going until all pets
        //in the cursor have been added
        if(cursor.moveToFirst()) {
            do {
                pet = new Pet();

                pet.setId(cursor.getLong(cursor.getColumnIndex(DatabaseContract.petProfile._ID)));
                pet.setName(cursor.getString(cursor.getColumnIndex(DatabaseContract.petProfile.COLUMN_PET_NAME)));
                pet.setAge(cursor.getString(cursor.getColumnIndex(DatabaseContract.petProfile.COLUMN_PET_DOB)));
                pet.setBreed(cursor.getString(cursor.getColumnIndex(DatabaseContract.petProfile.COLUMN_PET_BREED)));
                pet.setImage(cursor.getInt(cursor.getColumnIndex(DatabaseContract.petProfile.COLUMN_PET_PHOTO)));
                petLinkedList.add(pet);
            } while (cursor.moveToNext());
        }

        //And then finally, return our linkedlist with all the pets retrieved from our query to the database.
        return petLinkedList;
    }


    //Get one pet from the petProfile table
    public Pet getPet(long id){
        //Get reference to database and store in new instance of SQLite databse
        SQLiteDatabase db = this.getWritableDatabase();
        //Create new string with query to retrieve a single pet object based on the id passed into this method
        String query = "SELECT * FROM " + DatabaseContract.petProfile.TABLE_NAME + "WHERE _id= " + id;
        //Query the database and store the data in a new cursor object
        Cursor cursor = db.rawQuery(query, null);

        //New pet object to store the received pet
        Pet receivedPet = new Pet();
        //Extract all the data about the pet from the cursor and add to our new pet object
            if(cursor.getCount() > 0){
                cursor.moveToFirst();

                receivedPet.setName(cursor.getString(cursor.getColumnIndex(DatabaseContract.petProfile.COLUMN_PET_NAME)));
                receivedPet.setAge(cursor.getString(cursor.getColumnIndex(DatabaseContract.petProfile.COLUMN_PET_DOB)));
                receivedPet.setBreed(cursor.getString(cursor.getColumnIndex(DatabaseContract.petProfile.COLUMN_PET_BREED)));
                //receivedPet.setImage(cursor.getInt(cursor.getColumnIndex(DatabaseContract.petProfile.COLUMN_PET_PHOTO)));
            }
        //Return the received pet object
        return receivedPet;
    }

    //Delete pet from petProfile table
    public void deletePetProfile(long id, Context context) {
        //Get reference to database and store in new SQLiteDatabase object
        SQLiteDatabase db = this.getWritableDatabase();

        //Call the delete query on the database to delete a pet from the table based on
        //the id passed in
        db.execSQL("DELETE FROM + DatabaseContract.petProfile.TABLE_NAME +  WHERE _id='"+id+"'");

        //Create a toast message to inform the user that the pet has been removed from the
        //database
        Toast.makeText(context, "Deleted sucessfully.", Toast.LENGTH_SHORT).show();
    }


    //Update record
    public void updatePetRecord(long petId, Context context, Pet updatedPet){
        //Get reference to database and store in new SQLiteDatabase object
        SQLiteDatabase db = this.getWritableDatabase();
        //INCOMPLETE
        db.execSQL("UPDATE " + DatabaseContract.petProfile.TABLE_NAME + " SET name ='"+ updatedPet.getName() + "', age ='" + updatedPet.getAge());

    }
}
