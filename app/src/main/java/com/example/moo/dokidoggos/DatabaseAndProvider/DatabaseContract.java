package com.example.moo.dokidoggos.DatabaseAndProvider;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

import java.util.Date;

public final class DatabaseContract {

    //Empty private constructor to prevent accidental instantiation of contract class
    private DatabaseContract() {};

    //Variable to store what the current version number of the database
    public static final int DATABASE_VERSION = 1;


    //String variable to store the database Name
    public static final String DATABASE_NAME = "petInfoDatabase.db";


    //Classes for each table
    //Implement base columns to create id column

    public static abstract class petProfile implements BaseColumns {
        //String variable storing this table's name
        public static final String TABLE_NAME= "basicPetInfo";
        //String variables storing this table's column names
        public static final String COLUMN_PET_NAME = "petName";
        public static final String COLUMN_PET_DOB = "petBirthDate";
        public static final String COLUMN_PET_DOA = "petAdoptionDate";
        public static final String COLUMN_PET_BREED = "petBreed";
        public static final String COLUMN_PET_PHOTO = "petPhoto";
        public static final String COLUMN_PET_DESEXED = "isPetDesexed";
        public static final String COLUMN_PET_MICROCHIPPED = "isPetMicroChipped";
        public static final String COLUMN_PET_WEIGHT = "petWeight";

        //String variable containing SQL query to create this table
        public static final String CREATE_PET_PROFILE_TABLE =
                "CREATE TABLE " +
                        TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_PET_NAME + " TEXT, " +
                        COLUMN_PET_DOB + " INTEGER, " +
                        COLUMN_PET_DOA + " INTEGER, " +
                        COLUMN_PET_BREED + " TEXT, " +
                        COLUMN_PET_PHOTO + " INTEGER, " +
                        COLUMN_PET_DESEXED + " INTEGER, " +
                        COLUMN_PET_MICROCHIPPED + " INTEGER, " +
                        COLUMN_PET_WEIGHT + " REAL" +
                        ");";



        //String variable containing SQL query to delete this table
        public static final String SQL_DELETE_PET_PROFILE =
                "DROP TABLE IF EXISTS " + petProfile.TABLE_NAME;

        //String variable to store the row count to be used in ROW_COUNT_URI to specify a certain row
        public static final String COUNT = "count";

        //String variable storing AUTHORITY to be used in creating a URI
        public static String AUTHORITY = "com.example.moo.dokidoggos.DatabaseAndProvider.PetContentProvider";

        //String variable storing the PATH to be used in creating a URI for this table
        public static final String CONTENT_PATH = petProfile.TABLE_NAME;

        //URI variable storing the uri for this table
        public static Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH);


        //URI variable storing the uri to be used to access a specific row of this table
        public static final Uri ROW_COUNT_URI = Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH + "#" + COUNT);

        //String variable containing the MIME type for a single entry from this table
        static final String SINGLE_RECORD_MIME_TYPE = "vnd.android.cursor.item/vnd.com.example.moo.dokidoggos.DatabaseAndProvider.PetContentProvider.basicPetInfo";

        //String variable containing the MIME type for multiple entries from this table
        static final String MULTIPLE_RECORDS_MIME_TYPE = "vnd.android.cursor.dir/vnd.com.example.moo.dokidoggos.DatabaseAndProvider.PetContentProvider.basicPetInfo";

        public static Uri buildPetUri(String petId){
            return CONTENT_URI.buildUpon().appendEncodedPath(petId).build();
        }

        public static String getPetId(Uri uri){
            return uri.getPathSegments().get(1);
        }




    }





    public static abstract class foodInfo implements BaseColumns {
        //String variable storing this table's name
        public static final String TABLE_NAME = "foodInformation";
        //String variables storing this table's column names
        public static final String COLUMN_FOOD_NAME = "foodName";
        public static final String COLUMN_ANSWER = "answer";
        public static final String COLUMN_EXPLANATION = "explanation";
        public static final String COLUMN_IMAGE = "image";

        //String variable containing SQL query to create this table
        public static final String CREATE_FOOD_INFO_TABLE =
                "CREATE TABLE " +
                        TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_FOOD_NAME + " TEXT, " +
                        COLUMN_ANSWER + " TEXT, " +
                        COLUMN_EXPLANATION + " TEXT, " +
                        COLUMN_IMAGE + " INTEGER" +
                        ");";



        //String variable storing AUTHORITY to be used in creating a URI
        public static String AUTHORITY = "com.example.moo.dokidoggos.DatabaseAndProvider.PetContentProvider";

        //String variable storing the PATH to be used in creating a URI for this table
        public static final String CONTENT_PATH = foodInfo.TABLE_NAME;

        //URI variable storing the uri for this table
        public static Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH);

        public static Uri CONTENT_URI_FOOD = Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH + "/" + foodInfo.COLUMN_FOOD_NAME);


        //String variable containing the MIME type for a single entry from this table
        static final String SINGLE_RECORD_MIME_TYPE = "vnd.android.cursor.item/vnd.com.example.moo.dokidoggos.DatabaseAndProvider.PetContentProvider.foodInfo";

        //String variable containing the MIME type for multiple entries from this table
        static final String MULTIPLE_RECORDS_MIME_TYPE = "vnd.android.cursor.dir/vnd.com.example.moo.dokidoggos.DatabaseAndProvider.PetContentProvider.foodInfo";

        public static Uri buildPetUri(String petId){
            return CONTENT_URI.buildUpon().appendEncodedPath(petId).build();
        }

        public static String getFoodId(Uri uri){
            return uri.getPathSegments().get(1);
        }




    }




    public static class vetContactInfo  implements BaseColumns {

        //String variable storing this table's name
        public static final String TABLE_NAME = "vetContacts";

        //String variables storing this table's column names
        public static final String COLUMN_VET_NAME = "vetName";
        public static final String COLUMN_CLINIC_NAME = "clinicName";
        public static final String COLUMN_VET_PHONE = "vetPhoneNumber";
        public static final String COLUMN_CLINIC_PHONE = "clinicPhoneNumber";
        public static final String COLUMN_CLINIC_ADDRESS = "clinicAddress";


        //String variable containing SQL query to create this table
        public static final String CREATE_VET_CONTACTS_TABLE =
                "CREATE TABLE " +
                        TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_VET_NAME + " TEXT," +
                        COLUMN_CLINIC_NAME + " TEXT," +
                        COLUMN_VET_PHONE + " TEXT," +
                        COLUMN_CLINIC_PHONE + " TEXT," +
                        COLUMN_CLINIC_ADDRESS + " TEXT" +
                        ");";

        //String variable containing SQL query to delete this table
        public static final String SQL_DELETE_VET_CONTACTS =
                "DROP TABLE IF EXISTS " + vetContactInfo.TABLE_NAME;
    }

    public static class petsHealthLog implements  BaseColumns {
        public static final String TABLE_NAME = "petHealthLog";
        public static final String COLUMN_PET_NAME = "petName";
        public static final String COLUMN_HEALTH_ISSUE = "healthIssue";
        public static final String COLUMN_DESCRIPTION = "issueDescription";
        public static final String COLUMN_DATE = "dateOfIssueStart";
        public static final String COLUMN_END_DATE = "dateOfIssueEnd";

        public static final String CREATE_PET_HEALTH_TABLE =
                "CREATE TABLE " +
                        TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_PET_NAME + " TEXT, " +
                        COLUMN_HEALTH_ISSUE + " TEXT, " +
                        COLUMN_DESCRIPTION + " TEXT, " +
                        COLUMN_DATE + " TEXT, " +
                        COLUMN_END_DATE + " TEXT" +
                        ");";

        public static final String SQL_DELETE_HEALTH_LOGS =
                "DROP TABLE IF EXISTS " + petsHealthLog.TABLE_NAME;
    }

    public static class groomerContactInfo implements BaseColumns {
        public static final String TABLE_NAME = "groomerContacts";
        public static final String COLUMN_GROOMER_NAME = "groomerName";
        public static final String COLUMN_GROOMER_COMPANY = "groomerCompany";
        public static final String COLUMN_GROOMER_PHONE = "groomerPhoneNumber";
        public static final String COLUMN_COMPANY_PHONE = "companyPhoneNumber";
        public static final String COLUMN_COMPANY_ADDRESS = "companyAddress";
        public static final String COLUMN_COMPANY_WEBSITE = "companyWebsite";

        public static final String CREATE_GROOMER_CONTACTS_TABLE =
                "CREATE TABLE " +
                        TABLE_NAME + "( " +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_GROOMER_NAME + " TEXT, " +
                        COLUMN_GROOMER_COMPANY + " TEXT, " +
                        COLUMN_GROOMER_PHONE + " TEXT, " +
                        COLUMN_COMPANY_PHONE + " TEXT, " +
                        COLUMN_COMPANY_ADDRESS + " TEXT, " +
                        COLUMN_COMPANY_WEBSITE + " TEXT" +
                        ");";

        public static final String SQL_DELETE_GROOMER_CONTACTS =
                "DROP TABLE IF EXISTS " + groomerContactInfo.TABLE_NAME;

    }

    public static class emergencyContactInfo implements BaseColumns {
        public static final String TABLE_NAME = "emergencyContacts";
        public static final String COLUMN_EMERGENCY_CONTACT_NAME = "emergencyContactName";
        public static final String COLUMN_EMERGENCY_CONTACT_NUMBER = "emergencyContactPhoneNumber";
        public static final String COLUMN_EMERGENCY_CONTACT_RELATION = "emergencyContactRelation";
        public static final String COLUMN_EMERGENCY_CONTACT_ACCESS = "emergencyContactAccess";
        public static final String COLUMN_CONTACT_PRIORITY = "emergencyContactPriority";

        public static final String CREATE_EMERGENCY_CONTACTS_TABLE =
                "CREATE TABLE " +
                        TABLE_NAME + "( " +
                        _ID + "INTEGER PRIMARY KEY, " +
                        COLUMN_EMERGENCY_CONTACT_NAME + " TEXT, " +
                        COLUMN_EMERGENCY_CONTACT_NUMBER + " TEXT, " +
                        COLUMN_EMERGENCY_CONTACT_RELATION + " TEXT, " +
                        COLUMN_EMERGENCY_CONTACT_ACCESS + " TEXT, " +
                        COLUMN_CONTACT_PRIORITY + " TEXT" +
                        ");";

        public static final String SQL_DELETE_EMERGENCY_CONTACTS =
                "DROP TABLE IF EXISTS " + emergencyContactInfo.TABLE_NAME;

    }


    public static class commands implements BaseColumns {
        public static final String TABLE_NAME = "commands";
        public static final String COLUMN_COMMAND_NAME = "commandName";
        public static final String COLUMN_COMMAND_PROGRESS = "commandProgress";

        public static final String CREATE_COMMANDS_TABLE =
                "CREATE TABLE " +
                        TABLE_NAME + "( " +
                        _ID + "INTEGER PRIMARY KEY, " +
                        COLUMN_COMMAND_NAME + " TEXT, " +
                        COLUMN_COMMAND_PROGRESS + " INTEGER" +
                        ");";


        public static final String SQL_DELETE_COMMANDS =
                "DROP TABLE IF EXISTS " + commands.TABLE_NAME;
    }

    public static class behaviourIssues implements BaseColumns {
        public static final String TABLE_NAME = "behaviourIssues";
        public static final String COLUMN_BEHAVIOUR_ISSUE = "behaviourIssue";
        public static final String COLUMN_ISSUE_PROGRESS = "behaviourIssueProgress";
        public static final String COLUMN_ISSUE_DESCRIPTION = "issueDescription";

        public static final String CREATE_BEHAVIOUR_ISSUES_TABLE =
                "CREATE TABLE " +
                        TABLE_NAME + "( " +
                        _ID + "INTEGER PRIMARY KEY, " +
                        COLUMN_BEHAVIOUR_ISSUE + " TEXT, " +
                        COLUMN_ISSUE_PROGRESS+ " INTEGER, " +
                        COLUMN_ISSUE_DESCRIPTION + " TEXT" +
                        ");";

        public static final String SQL_DELETE_BEHAVIOIUR_ISSUES =
                "DROP TABLE IF EXISTS " + behaviourIssues.TABLE_NAME;

    }


    public static class medicines implements BaseColumns {
        public static final String TABLE_NAME = "medicines";
        public static final String COLUMN_MEDICINE_NAME = "medicineName";
        public static final String COLUMN_MEDICINE_DOSAGE = "medicineDosage";
        public static final String COLUMN_MEDICINE_DESCRIPTION = "medicineDescription";

        public static final String CREATE_MEDICINES_TABLE =
                "CREATE TABLE " +
                        TABLE_NAME + "( " +
                        _ID + "INTEGER PRIMARY KEY, " +
                        COLUMN_MEDICINE_NAME + " TEXT, " +
                        COLUMN_MEDICINE_DOSAGE + " TEXT, " +
                        COLUMN_MEDICINE_DESCRIPTION + " TEXT" +
                        ");";

        public static final String SQL_DELETE_MEDICINES =
                "DROP TABLE IF EXISTS " + medicines.TABLE_NAME;

    }

    public static class diet implements BaseColumns {
        public static final String TABLE_NAME = "diet";
        public static final String COLUMN_PET_NAME = "petName";
        public static final String COLUMN_DAILY_FOODS = "dailyFoods";
        public static final String COLUMN_DAILY_TREATS = "dailyTreats";
        public static final String COLUMN_FEEDING_SCHEDULE = "feedingSchedule";
        public static final String COLUMN_FOOD_ALLERGIES = "foodAllergies";
        public static final String COLUMN_FEEDING_METHODS = "feedingMethods";
        public static final String COLUMN_OCCASIONAL_TREATS = "occasionalTreats";
        public static final String COLUMN_NOTES = "notesOnFood";

        public static final String CREATE_DIET_TABLE =
                "CREATE TABLE " +
                        TABLE_NAME + "( " +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_PET_NAME + " TEXT, " +
                        COLUMN_DAILY_FOODS + " TEXT, " +
                        COLUMN_DAILY_TREATS + " TEXT, " +
                        COLUMN_FEEDING_SCHEDULE + " TEXT, " +
                        COLUMN_FOOD_ALLERGIES + " TEXT, " +
                        COLUMN_FEEDING_METHODS + " TEXT, " +
                        COLUMN_OCCASIONAL_TREATS + " TEXT, " +
                        COLUMN_NOTES + " TEXT" +
                        ");";

        public static final String SQL_DELETE_DIET =
                "DROP TABLE IF EXISTS " + diet.TABLE_NAME;


        //String variable storing AUTHORITY to be used in creating a URI
        public static String AUTHORITY = "com.example.moo.dokidoggos.DatabaseAndProvider.PetContentProvider";

        //String variable storing the PATH to be used in creating a URI for this table
        public static final String CONTENT_PATH = diet.TABLE_NAME;

        //URI variable storing the uri for this table
        public static Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH);

        public static Uri CONTENT_URI_PET = Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH + "/" + diet.COLUMN_PET_NAME);


        //String variable containing the MIME type for a single entry from this table
        static final String SINGLE_RECORD_MIME_TYPE = "vnd.android.cursor.item/vnd.com.example.moo.dokidoggos.DatabaseAndProvider.PetContentProvider.diet";

        //String variable containing the MIME type for multiple entries from this table
        static final String MULTIPLE_RECORDS_MIME_TYPE = "vnd.android.cursor.dir/vnd.com.example.moo.dokidoggos.DatabaseAndProvider.PetContentProvider.diet";

        public static Uri buildPetDietUri(String petId){
            return CONTENT_URI.buildUpon().appendEncodedPath(petId).build();
        }

        public static String getDietId(Uri uri){
            return uri.getPathSegments().get(1);
        }


    }


    public static class insurance implements BaseColumns {
        public static final String TABLE_NAME = "insurance";
        public static final String COLUMN_COMPANY_NAME= "companyName";
        public static final String COLUMN_POLICY_TYPE = "policyType";
        public static final String COLUMN_POLICY_NUMBER = "policyNumber";
        public static final String COLUMN_POLICY_COST = "policyCost";
        public static final String COLUMN_POLICY_DESCRIPTION = "policyDescription";

        public static final String CREATE_INSURANCE_TABLE =
                "CREATE TABLE " +
                        TABLE_NAME + "( " +
                        _ID + "INTEGER PRIMARY KEY, " +
                        COLUMN_COMPANY_NAME + " TEXT, " +
                        COLUMN_POLICY_TYPE + " TEXT, " +
                        COLUMN_POLICY_NUMBER + " TEXT, " +
                        COLUMN_POLICY_COST + " TEXT, " +
                        COLUMN_POLICY_DESCRIPTION + " TEXT" +
                        ");";

        public static final String SQL_DELETE_INSURANCE =
                "DROP TABLE IF EXISTS " + insurance.TABLE_NAME;

    }


    public static class vaccinations implements BaseColumns {
        public static final String TABLE_NAME = "vaccinations";
        public static final String COLUMN_PET_NAME = "petName";
        public static final String COLUMN_VACCINE = "vaccine";
        public static final String COLUMN_DATE = "dateOfVaccine";
        public static final String COLUMN_PERIOD = "periodOfVaccineEfficacy";
        public static final String COLUMN_RENEWAL_DATE = "newVaccineDate";

        public static final String CREATE_VACCINATIONS_TABLE =
                "CREATE TABLE " +
                        TABLE_NAME + "( " +
                        _ID + "INTEGER PRIMARY KEY, " +
                        COLUMN_PET_NAME+ " TEXT, " +
                        COLUMN_VACCINE+ " TEXT, " +
                        COLUMN_DATE + " TEXT, " +
                        COLUMN_PERIOD + " TEXT, " +
                        COLUMN_RENEWAL_DATE + " TEXT" +
                        ");";


        public static final String SQL_DELETE_VACCINATIONS =
                "DROP TABLE IF EXISTS " + vaccinations.TABLE_NAME;

    }


    public static class exercise implements BaseColumns {
        public static final String TABLE_NAME = "exercise";
        public static final String COLUMN_PET_NAME = "petName";
        public static final String COLUMN_GAMES = "games";
        public static final String COLUMN_WALKIES_SCHEDULE = "walkiesSchedule";
        public static final String COLUMN_TOYS = "toys";
        public static final String COLUMN_ROLL_OVER = "rollOver";
        public static final String COLUMN_BANG = "bang";
        public static final String COLUMN_SPIN = "spin";
        public static final String COLUMN_SHAKE = "shake";
        public static final String COLUMN_KISS = "kiss";
        public static final String COLUMN_DANCE = "dance";
        public static final String COLUMN_SPEAK = "speak";
        public static final String COLUMN_HIGH_FIVE = "highFive";
        public static final String COLUMN_CRAWL = "crawl";
        public static final String COLUMN_WAVE = "wave";
        public static final String COLUMN_BOW = "bow";
        public static final String COLUMN_BEG = "beg";
        public static final String COLUMN_ROLL_OVER_NOTES = "rollOverNotes";
        public static final String COLUMN_BANG_NOTES = "bangNotes";
        public static final String COLUMN_SPIN_NOTES = "spinNotes";
        public static final String COLUMN_SHAKE_NOTES = "shakeNotes";
        public static final String COLUMN_KISS_NOTES = "kissNotes";
        public static final String COLUMN_DANCE_NOTES = "danceNotes";
        public static final String COLUMN_SPEAK_NOTES = "speakNotes";
        public static final String COLUMN_HIGH_FIVE_NOTES = "highFiveNotes";
        public static final String COLUMN_CRAWL_NOTES = "crawlNotes";
        public static final String COLUMN_WAVE_NOTES = "waveNotes";
        public static final String COLUMN_BOW_NOTES = "bowNotes";
        public static final String COLUMN_BEG_NOTES = "begNotes";
        public static final String COLUMN_NOTES = "notes";

        public static final String CREATE_EXERCISE_TABLE =
                "CREATE TABLE " +
                        TABLE_NAME + "( " +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_PET_NAME + " TEXT, " +
                        COLUMN_GAMES + " TEXT, " +
                        COLUMN_WALKIES_SCHEDULE + " TEXT, " +
                        COLUMN_TOYS + " TEXT, " +
                        COLUMN_ROLL_OVER + " REAL, " +
                        COLUMN_BANG + " REAL, " +
                        COLUMN_SPIN + " REAL, " +
                        COLUMN_SHAKE + " REAL, " +
                        COLUMN_KISS + " REAL, " +
                        COLUMN_DANCE + " REAL, " +
                        COLUMN_SPEAK + " REAL, " +
                        COLUMN_HIGH_FIVE+ " REAL, " +
                        COLUMN_CRAWL + " REAL, " +
                        COLUMN_WAVE + " REAL, " +
                        COLUMN_BOW + " REAL, " +
                        COLUMN_BEG + " REAL, " +
                        COLUMN_ROLL_OVER_NOTES + " TEXT, " +
                        COLUMN_BANG_NOTES + " TEXT, " +
                        COLUMN_SPIN_NOTES + " TEXT, " +
                        COLUMN_SHAKE_NOTES + " TEXT, " +
                        COLUMN_KISS_NOTES + " TEXT, " +
                        COLUMN_DANCE_NOTES + " TEXT, " +
                        COLUMN_SPEAK_NOTES + " TEXT, " +
                        COLUMN_HIGH_FIVE_NOTES+ " TEXT, " +
                        COLUMN_CRAWL_NOTES + " TEXT, " +
                        COLUMN_WAVE_NOTES + " TEXT, " +
                        COLUMN_BOW_NOTES + " TEXT, " +
                        COLUMN_BEG_NOTES + " TEXT, " +
                        COLUMN_NOTES + " TEXT" +
                        ");";

        public static final String SQL_DELETE_EXERCISE =
                "DROP TABLE IF EXISTS " + exercise.TABLE_NAME;

        public static String AUTHORITY = "com.example.moo.dokidoggos.DatabaseAndProvider.PetContentProvider";

        public static final String CONTENT_PATH = exercise.TABLE_NAME;

        public static Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH);

        public static Uri CONTENT_URI_PET = Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH + "/" + exercise.COLUMN_PET_NAME);

        public static Uri buildPetExerciseUri(String petId){
            return CONTENT_URI.buildUpon().appendEncodedPath(petId).build();
        }

        public static String getExerciseId(Uri uri){
            return uri.getPathSegments().get(1);
        }

    }




    public static class petCarer implements BaseColumns {
        public static final String TABLE_NAME = "petCarerDetails";
        public static final String COLUMN_PET_NAME = "petName";
        public static final String COLUMN_CARER_NAME = "carerName";
        public static final String COLUMN_CARER_COMPANY = "carerCompany";
        public static final String COLUMN_CARER_NUMBER = "carerNumber";
        public static final String COLUMN_COMPANY_NUMBER = "companyNumber";
        public static final String COLUMN_CARER_TYPE = "carerType";
        public static final String COLUMN_ADDRESS = "carerAddress";

        public static final String CREATE_PET_CARER_TABLE =
                "CREATE TABLE " +
                        TABLE_NAME + "( " +
                        _ID + "INTEGER PRIMARY KEY, " +
                        COLUMN_PET_NAME + " TEXT, " +
                        COLUMN_CARER_NAME + " TEXT, " +
                        COLUMN_CARER_COMPANY + " TEXT, " +
                        COLUMN_CARER_NUMBER + " TEXT, " +
                        COLUMN_COMPANY_NUMBER + " TEXT, " +
                        COLUMN_CARER_TYPE + " TEXT, " +
                        COLUMN_ADDRESS + " TEXT" +
                        ");";

        public static final String SQL_DELETE_PET_CARER =
                "DROP TABLE IF EXISTS " + petCarer.TABLE_NAME;

    }


    public static class medical implements BaseColumns {
        public static final String TABLE_NAME = "medicalDetails";
        public static final String COLUMN_PET_NAME = "petName";
        public static final String COLUMN_VET_NAME = "vetName";
        public static final String COLUMN_VET_CLINIC = "vetClinic";
        public static final String COLUMN_VET_PHONE = "vetPhone";
        public static final String COLUMN_PREVIOUS_VETS = "previousVets";
        public static final String COLUMN_NEXT_APPOINTMENT ="nextAppointment";
        public static final String COLUMN_REGULAR_MEDICATION = "regularMedication";
        public static final String COLUMN_SHORT_TERM_MEDICATION = "shortTermMedication";
        public static final String COLUMN_SUPPLEMENTS = "supplements";
        public static final String COLUMN_DENTAL_ROUTINE = "dentalRoutine";
        public static final String COLUMN_HEALTH_CONDITIONS = "healthConditions";
        public static final String COLUMN_ALLERGIES = "allergies";
        public static final String COLUMN_INSURANCE_PROVIDER = "insuranceProvider";
        public static final String COLUMN_POLICY_NUMBER = "policyNumber";
        public static final String COLUMN_HEARTWORM_PREVENTION = "heartWormPrevention";
        public static final String COLUMN_FLEA_TICK_PREVENTION = "fleaTickPrevention";
        public static final String COLUMN_VAC_CDV = "CDVVaccine";
        public static final String COLUMN_VAC_PARVO = "CParvoVaccine";
        public static final String COLUMN_VAC_ADENO = "CAdenoVaccine";
        public static final String COLUMN_VAC_PARAINFLUENZA = "ParainfluenzaVaccine";
        public static final String COLUMN_VAC_BBRONCHISPETICA = "BBronchVaccine";
        public static final String COLUMN_VAC_LINTERROGANS = "LInterrogansVaccine";
        public static final String COLUMN_DESEXED = "desexed";


        public static final String CREATE_MEDICAL_TABLE =
                "CREATE TABLE " +
                        TABLE_NAME + "( " +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_PET_NAME + " TEXT, " +
                        COLUMN_VET_NAME + " TEXT, " +
                        COLUMN_VET_CLINIC + " TEXT, " +
                        COLUMN_VET_PHONE + " TEXT, " +
                        COLUMN_PREVIOUS_VETS + " TEXT, " +
                        COLUMN_NEXT_APPOINTMENT + " TEXT, " +
                        COLUMN_REGULAR_MEDICATION + " TEXT" +
                        COLUMN_SHORT_TERM_MEDICATION + " TEXT" +
                        COLUMN_SUPPLEMENTS + " TEXT" +
                        COLUMN_DENTAL_ROUTINE + " TEXT" +
                        COLUMN_HEALTH_CONDITIONS + " TEXT" +
                        COLUMN_ALLERGIES + " TEXT" +
                        COLUMN_INSURANCE_PROVIDER + " TEXT" +
                        COLUMN_POLICY_NUMBER + " TEXT" +
                        COLUMN_HEARTWORM_PREVENTION + " TEXT" +
                        COLUMN_FLEA_TICK_PREVENTION + " TEXT" +
                        COLUMN_VAC_CDV + " TEXT" +
                        COLUMN_VAC_PARVO + " TEXT" +
                        COLUMN_VAC_ADENO + " TEXT" +
                        COLUMN_VAC_PARAINFLUENZA + " TEXT" +
                        COLUMN_VAC_BBRONCHISPETICA + " TEXT" +
                        COLUMN_VAC_LINTERROGANS + " TEXT" +
                        COLUMN_DESEXED + " TEXT" +
                        ");";


        public static final String SQL_DELETE_MEDICAL =
                "DROP TABLE IF EXISTS " + medical.TABLE_NAME;

        public static String AUTHORITY = "com.example.moo.dokidoggos.DatabaseAndProvider.PetContentProvider";

        public static final String CONTENT_PATH = medical.TABLE_NAME;

        public static Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH);

        public static Uri CONTENT_URI_PET = Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH + "/" + medical.COLUMN_PET_NAME);

        public static Uri buildMedicalUri(String petId){
            return CONTENT_URI.buildUpon().appendEncodedPath(petId).build();
        }

        public static String getMedicalId(Uri uri){
            return uri.getPathSegments().get(1);
        }
    }




}
