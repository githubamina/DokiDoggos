package com.example.moo.dokidoggos.DatabaseAndProvider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import static com.example.moo.dokidoggos.DatabaseAndProvider.DatabaseContract.petProfile.MULTIPLE_RECORDS_MIME_TYPE;
import static com.example.moo.dokidoggos.DatabaseAndProvider.DatabaseContract.petProfile.SINGLE_RECORD_MIME_TYPE;

public class PetContentProvider extends ContentProvider {

    //String TAG
    public static final String TAG = PetContentProvider.class.getSimpleName();

    //Final integer constants for all pets and a single pet
    //Convention to use 100, 200, 300, etc for directories,
    //and related ints (101, 102..) for items in that directory.
    public static final int PETS = 100;
    public static final int PETS_WITH_ID = 101;

    public static final int FOOD = 200;
    public static final int FOOD_WITH_NAME = 201;


    public static final int PET_DIET = 300;
    public static final int PET_DIET_WITH_NAME = 301;


    public static final int PET_EXERCISE = 400;
    public static final int PET_EXERCISE_WITH_NAME = 401;

    public static final int MEDICAL = 500;
    public static final int MEDICAL_WITH_NAME = 501;

    //Static variable for the Uri matcher that we will construct
    private static final UriMatcher sUriMatcher = buildUriMatcher();


    //A static buildUriMatcher method that associates URI's with their int match
    public static UriMatcher buildUriMatcher(){

     UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

     //Add URI matches with addUri(String authority, String path, int code)
     uriMatcher.addURI(DatabaseContract.petProfile.AUTHORITY, DatabaseContract.petProfile.CONTENT_PATH, PETS);

     uriMatcher.addURI(DatabaseContract.petProfile.AUTHORITY, DatabaseContract.petProfile.CONTENT_PATH + "/#", PETS_WITH_ID);

     uriMatcher.addURI(DatabaseContract.foodInfo.AUTHORITY, DatabaseContract.foodInfo.CONTENT_PATH, FOOD);

     uriMatcher.addURI(DatabaseContract.foodInfo.AUTHORITY, DatabaseContract.foodInfo.CONTENT_PATH +  "/" + DatabaseContract.foodInfo.COLUMN_FOOD_NAME, FOOD_WITH_NAME);

     uriMatcher.addURI(DatabaseContract.diet.AUTHORITY, DatabaseContract.diet.CONTENT_PATH, PET_DIET);
     uriMatcher.addURI(DatabaseContract.diet.AUTHORITY, DatabaseContract.diet.CONTENT_PATH + "/#", PET_DIET_WITH_NAME);


     uriMatcher.addURI(DatabaseContract.exercise.AUTHORITY, DatabaseContract.exercise.CONTENT_PATH, PET_EXERCISE);
     uriMatcher.addURI(DatabaseContract.exercise.AUTHORITY, DatabaseContract.exercise.CONTENT_PATH + "/#", PET_EXERCISE_WITH_NAME);

     uriMatcher.addURI(DatabaseContract.medical.AUTHORITY, DatabaseContract.medical.CONTENT_PATH, MEDICAL);
     uriMatcher.addURI(DatabaseContract.medical.AUTHORITY, DatabaseContract.medical.CONTENT_PATH + "/#", MEDICAL_WITH_NAME);

     return uriMatcher;
    }



    //Handle to database helper
    private DokiDoggosDbHelper dbHelper;

    //Handle to database
    private SQLiteDatabase db;



    @Override
    public boolean onCreate() {
        //Instantiate dbhelper
        dbHelper = new DokiDoggosDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        //Get access to underlying database (read-only for query)
        db = dbHelper.getReadableDatabase();

        //Uri match code
        int matchedUriType = sUriMatcher.match(uri);

        //Cursor object to store retrieved data
        Cursor retCursor;

        //Switch statement to return appropriate cursor depending on the matchedUriType passed in
        switch(matchedUriType){
            case PETS:
                //Cursor returned for query for all pets directory
                retCursor = db.query(DatabaseContract.petProfile.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case FOOD_WITH_NAME:
                retCursor = db.query(DatabaseContract.foodInfo.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case PET_DIET:
                retCursor = db.query(DatabaseContract.diet.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case PET_DIET_WITH_NAME:
                retCursor = db.query(DatabaseContract.diet.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case PET_EXERCISE:
                retCursor = db.query(DatabaseContract.exercise.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case PET_EXERCISE_WITH_NAME:
                retCursor = db.query(DatabaseContract.exercise.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case MEDICAL:
                retCursor = db.query(DatabaseContract.medical.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case MEDICAL_WITH_NAME:
                retCursor = db.query(DatabaseContract.medical.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI" + uri);

        }

        //Set a notification URI on the Cursor to watch the URI and see if source data changes
        retCursor.setNotificationUri(getContext().getContentResolver(), uri);

        //return the cursor with the retrieved data
        return retCursor;
    }


    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch(sUriMatcher.match(uri)){
            case PETS:
                return MULTIPLE_RECORDS_MIME_TYPE;
            case PETS_WITH_ID:
                return SINGLE_RECORD_MIME_TYPE;
            case PET_DIET:
                return MULTIPLE_RECORDS_MIME_TYPE;
            case PET_DIET_WITH_NAME:
                return SINGLE_RECORD_MIME_TYPE;
            case PET_EXERCISE:
                return MULTIPLE_RECORDS_MIME_TYPE;
            case PET_EXERCISE_WITH_NAME:
                return SINGLE_RECORD_MIME_TYPE;
            case MEDICAL:
                return MULTIPLE_RECORDS_MIME_TYPE;
            case MEDICAL_WITH_NAME:
                return SINGLE_RECORD_MIME_TYPE;
            default:
                return null;
        }
    }


    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {

        //Access to database (to write new data to)
        db = dbHelper.getWritableDatabase();

        //URI matching code to identify the match for the pet directory
        int matchedUriType = sUriMatcher.match(uri);

        //Uri object to be returned
        Uri returnUri;

        //Switch statement to insert new values into the database
        // based on matchedUriType passed in
        switch(matchedUriType) {
            //In case PETS (the whole table)
            case PETS:
                //Inserting values into pet table
                long id = db.insert(DatabaseContract.petProfile.TABLE_NAME, null, contentValues);

                if(id > 0) {
                    //Success. returnUri = new id of inserted values.
                    returnUri = ContentUris.withAppendedId(DatabaseContract.petProfile.CONTENT_URI, id);

                } else {
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                }
                break;
            case FOOD:
                long foodId = db.insert(DatabaseContract.foodInfo.TABLE_NAME, null, contentValues);

                if(foodId > 0) {
                    returnUri = ContentUris.withAppendedId(DatabaseContract.foodInfo.CONTENT_URI, foodId);
                } else {
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                }
                break;
            case PET_DIET:
                long dietId = db.insert(DatabaseContract.diet.TABLE_NAME, null, contentValues);

                if(dietId > 0) {
                    returnUri = ContentUris.withAppendedId(DatabaseContract.diet.CONTENT_URI, dietId);
                } else {
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                }
                break;
            case PET_EXERCISE:
                long exerciseId = db.insert(DatabaseContract.exercise.TABLE_NAME, null, contentValues);

                if(exerciseId > 0) {
                    returnUri = ContentUris.withAppendedId(DatabaseContract.exercise.CONTENT_URI, exerciseId);
                } else {
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                }
                break;
            case MEDICAL:
                long medicalId = db.insert(DatabaseContract.medical.TABLE_NAME, null, contentValues);

                if(medicalId > 0) {
                    returnUri = ContentUris.withAppendedId(DatabaseContract.medical.CONTENT_URI, medicalId);
                } else {
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: + uri");
        }

        //Notify the resolver if the passed in uri has been changed (i.e. has the data been updated)
        getContext().getContentResolver().notifyChange(uri, null);

        //return the new uri
        return returnUri;
    }



    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {

        //get handle to database
        final SQLiteDatabase db = dbHelper.getWritableDatabase();

        //int variable to store the matched uri
        final int match = sUriMatcher.match(uri);

        switch (match){
            case PETS:
                break;
            case PETS_WITH_ID:
                //get the id of the pet
                String id = DatabaseContract.petProfile.getPetId(uri);

                //String to store query criteria
                String selectionCriteria = BaseColumns._ID + "=" + id + (!TextUtils.isEmpty(selection) ? " AND (" + selection + ")" : "");
                return db.delete("basicPetInfo", selectionCriteria, selectionArgs);
            case PET_DIET_WITH_NAME:
                //get the id of the pet
                String dietId = DatabaseContract.diet.getDietId(uri);

                //String to store query criteria
                String selectionCrit = BaseColumns._ID + "=" + dietId + (!TextUtils.isEmpty(selection) ? " AND (" + selection + ")" : "");
                return db.delete(DatabaseContract.diet.TABLE_NAME, selectionCrit, selectionArgs);
            case PET_EXERCISE_WITH_NAME:
                String exerciseId = DatabaseContract.exercise.getExerciseId(uri);

                String slctnCriteria = BaseColumns._ID + "=" + exerciseId + (!TextUtils.isEmpty(selection) ? " AND (" + selection + ")" : "");
                return db.delete(DatabaseContract.exercise.TABLE_NAME, slctnCriteria, selectionArgs);
            case MEDICAL_WITH_NAME:
                String medicalId = DatabaseContract.medical.getMedicalId(uri);

                String sCriteria = BaseColumns._ID + "=" + medicalId + (!TextUtils.isEmpty(selection) ? " AND (" + selection + ")" : "");
                return db.delete(DatabaseContract.medical.TABLE_NAME, sCriteria, selectionArgs);
            default:
                throw new IllegalArgumentException("Unknown URI : " + uri);

        }

        return 0;

    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {

        //handle to database
        final SQLiteDatabase db = dbHelper.getWritableDatabase();

        //int to store urimatch
        final int match = sUriMatcher.match(uri);

        //string var to store the selection criteria to use in update query
        String selectionCriteria = selection;
        String selectionCrit = selection;
        int updateCount = 0;

        switch (match){
            case PETS:
                // Do nothing
                break;
            case PETS_WITH_ID:
                String id = DatabaseContract.petProfile.getPetId(uri);
                selectionCriteria = BaseColumns._ID + "=" + id
                        + (!TextUtils.isEmpty(selection) ? " AND (" + selection + ")" : "");
                //update table and store int in updatecount
                 updateCount = db.update("basicPetInfo", values, selectionCriteria, selectionArgs);

                 break;
            case PET_DIET_WITH_NAME:
                String dietId = DatabaseContract.diet.getDietId(uri);
                selectionCrit = BaseColumns._ID + "=" + dietId
                        + (!TextUtils.isEmpty(selection) ? " AND (" + selection + ")" : "");

                updateCount = db.update(DatabaseContract.diet.TABLE_NAME, values, selectionCrit, selectionArgs);

               break;

            case PET_EXERCISE_WITH_NAME:
                String exerciseId = DatabaseContract.exercise.getExerciseId(uri);

                selectionCrit = BaseColumns._ID + "=" + exerciseId
                        + (!TextUtils.isEmpty(selection) ? " AND (" + selection + ")" : "");

                updateCount = db.update(DatabaseContract.exercise.TABLE_NAME, values, selectionCrit, selectionArgs);

                break;
            case MEDICAL_WITH_NAME:
                String medicalId = DatabaseContract.medical.getMedicalId(uri);

                selectionCrit = BaseColumns._ID + "=" + medicalId
                        + (!TextUtils.isEmpty(selection) ? " AND (" + selection + ")" : "");

                updateCount = db.update(DatabaseContract.medical.TABLE_NAME, values, selectionCrit, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI : "+ uri);

        }

        return updateCount;
    }
}
