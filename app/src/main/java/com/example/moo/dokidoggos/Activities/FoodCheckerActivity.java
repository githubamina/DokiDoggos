package com.example.moo.dokidoggos.Activities;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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
import com.example.moo.dokidoggos.Classes.Food;
import com.example.moo.dokidoggos.R;

import java.util.ArrayList;

public class FoodCheckerActivity extends AppCompatActivity {

    EditText searchText;

    Button searchButton;


    private DokiDoggosDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_checker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        dbHelper = new DokiDoggosDbHelper(this);


        searchText = findViewById(R.id.searchText);
        searchButton = findViewById(R.id.searchButton);



        //Create data to store in database
        //ArrayList to initially store drinks
        ArrayList<Food> foods = new ArrayList<>();
        //Creating new drink objects
        foods.add(new Food("chocolate", "NO!", "Chocolate is FATALLY poisonous to dogs."));
        foods.add(new Food("grapes", "NO!", "Grapes are FATALLY toxic to dogs"));
        foods.add(new Food("banana", "YES!", "Bananas are a good source of potassium for dogs"));
        foods.add(new Food("carrots", "YES", "Carrots are a healthy food for dogs- both cooked and raw"));
        foods.add(new Food("raisins", "NO!", "Raisins are FATALLY toxic to dogs"));
        foods.add(new Food("peanut butter", "YES", "Peanut butter is healthy for dogs in moderation"));
        foods.add(new Food("potatoes", "ONLY COOKED", "Dogs can eat cooked potatoes, however they should never eat raw ones as they are very toxic to them"));
        foods.add(new Food("celery", "YES", "Celery is safe for dogs"));
        foods.add(new Food("avocado", "NO!", "Avocado can be fatally toxic to dogs"));
        foods.add(new Food("apples", "YES", "Apples are a good snack for dogs"));
        foods.add(new Food("green beans", "YES", "Green beans are healthy for dogs"));
        foods.add(new Food("salt", "VERY LIMITED", "Salt should be kept to an absolute minimum in dog's diets as too much can cause illness and possibly be FATAL"));
        foods.add(new Food("xylitol", "NO", "Xylitol (found in many sweets, diet foods, lollies and gum) can be FATALLY toxic to dogs"));
        foods.add(new Food("alcohol", "NO", "Alcohol can be FATALLY toxic to dogs"));
        foods.add(new Food("coffee", "NO", "The caffeine in coffee can be FATAL to dogs"));
        foods.add(new Food("tea", "NO", "The caffeine in tea can be FATAL to dogs"));
        foods.add(new Food("energy drinks", "NO", "Energy drinks can be FATALLY toxic to dogs"));
        foods.add(new Food("milk", "NO", "Milk and other dairy products can cause illness and allergies in dogs"));
        foods.add(new Food("macadamia nuts", "NO", "Macadmia nuts will make dogs very ill, possibly FATALLY so"));
        foods.add(new Food("bones", "NO", "Bones should NEVER be given to dogs as they are a choling hazard and damage a dog's digestive system"));
        foods.add(new Food("fat trimmings", "NO", "Meat fat trimmings (raw and cooked) can cause pancreatitis in dogs"));
        foods.add(new Food("eggs", "ONLY COOKED", "Raw eggs should NEVER be fed to dogs as they can be fatally poisonous. Cooked eggs are okay in moderation"));
        foods.add(new Food("sugar", "LIMITED", "Too much sugar can cause obesity, dental issues and diabetes in dogs"));
        foods.add(new Food("dough", "NO", "Yeast dough can be FATAL and should NEVER be fed to dogs"));
        foods.add(new Food("watermelon", "YES", "Watermelon is a healthy snack for dogs- seeds and skin should be removed first"));
        foods.add(new Food("meat", "ONLY COOKED LEAN MEATS", "Raw meats (INCLUDING FISH) should NEVER be fed to dogs- any meat given to dogs should be lean, and thoroughly cooked with bones and skin removed"));
        foods.add(new Food("cheese", "EXTREMELY LIMITED", "Cheese and other dairy products can cause illness and allergies in dogs"));
        foods.add(new Food("blueberries", "YES", "Blueberries are safe and healthy for your dog to eat"));
        foods.add(new Food("pineapple", "Yes, in moderation", "Pineapple is safe for dogs in small amounts- too much will cause nausea and diarrhea"));
        foods.add(new Food("onions", "NO", "Onions (in ALL FORMS, e.g. powder, leaves, etc) can be FATALLY toxic to dogs"));
        foods.add(new Food("blackberries", "YES", "Blackberries are safe and healthy for dogs"));
        foods.add(new Food("bread", "Only plain white or whole grain OCCASIONALLY", "PLAIN white or whole grain bread (without ANY extra ingredients) is okay for dogs to eat on occasion"));
        foods.add(new Food("rice", "YES- COOKED", "Cooked plain white or brown rice is safe for dogs"));
        foods.add(new Food("lemons", "NO", "Lemons can be FATALLY toxic to dogs"));
        foods.add(new Food("lime", "NO", "Lime can be FATALLY toxic to dogs"));
        foods.add(new Food("strawberries", "YES", "Stawberries are safe and healthy for dogs"));
        foods.add(new Food("oranges", "Not recommended", "Although safe for most dogs in moderation, oranges can cause nausea and diarrhea in many dogs"));
        foods.add(new Food("peanuts", "LIMITED UNSALTED", "Unsalted peanuts are safe for dogs in small amounts"));
        foods.add(new Food("garlic", "NO", "Garlic can be FATALLY toxic to dogs"));
        foods.add(new Food("chives", "NO", "Chives can be FATALLY toxic to dogs"));
        foods.add(new Food("walnuts", "NO", "Walnuts can cause stomach upset and pancreatitis in dogs"));
        foods.add(new Food("pecans", "NO", "Pecans can cause stomach upset and pancreatitis in dogs"));
        foods.add(new Food("almonds", "NO", "Almonds can cause stomach upset and pancreatitis in dogs"));
        foods.add(new Food("sweet potato", "YES - COOKED", "Cooked sweet potato is safe and healthy for dogs to eat. Dogs should never eat raw sweet potato"));
        foods.add(new Food("pumpkin", "YES- COOKED", "Cooked pumpkin is safe and healthy for dogs to eat. Raw pumpkin, skin and seeds should be avoided"));
        foods.add(new Food("sultanas", "NO", "Sultanas are TOXIC and cause kidney failure in dogs"));
        foods.add(new Food("currants", "NO", "Currants can cause kidney failure in dogs"));
        foods.add(new Food("chicken", "YES - PLAIN, COOKED, BONELESS ONLY", "Cooked and boneless chicken without any added seasoning is safe for dogs"));
        foods.add(new Food("salmon", "ONLY WELL COOKED BONELESS SKINLESS", "Dogs can safely eat well cooked salmon but raw uncooked salmon can be FATALLY TOXIC."));
        foods.add(new Food("spinach", "Not recommended", "Although not harmful to most dogs in moderation, it can cause stomach upset in many"));
        foods.add(new Food("corn", "Not recommended", "Corn in small amounts is generally not harmful but can cause allergies in many and COBS should never be fed to dogs"));



        //Iterate through drinks list and store each item inside the drink table in the database
        for(int i = 0; i < foods.size(); i++) {


            ContentValues values = new ContentValues();

            Food currentFood = foods.get(i);

            String food = currentFood.getName();

            String answer = currentFood.getAnswer();

            String explanation = currentFood.getExplanation();


            values.put(DatabaseContract.foodInfo.COLUMN_FOOD_NAME, food);
            values.put(DatabaseContract.foodInfo.COLUMN_ANSWER, answer);
            values.put(DatabaseContract.foodInfo.COLUMN_EXPLANATION, explanation);

            getBaseContext().getContentResolver().insert(DatabaseContract.foodInfo.CONTENT_URI, values);


        }



        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchForFood(getBaseContext());
            }
        });





    }


    public void searchForFood(Context context) {

        String food = searchText.getText().toString().trim().toLowerCase();




        //if the name is empty, tell the user to enter one with a toast message
        if(food.isEmpty()){
            Toast.makeText(this, "You must enter a name", Toast.LENGTH_SHORT);
        } else {




            String[] args = {food};

            String selection =  DatabaseContract.foodInfo.COLUMN_FOOD_NAME + "=?";

           Cursor returnCurs = context.getContentResolver().query(Uri.parse(DatabaseContract.foodInfo.CONTENT_URI_FOOD.toString()), null, selection, args, null);

            if (returnCurs.moveToFirst()) {
                int indexID = returnCurs.getColumnIndex(DatabaseContract.foodInfo._ID);
                int itemID = (returnCurs.getInt(indexID));

                int indexFood = returnCurs.getColumnIndex(DatabaseContract.foodInfo.COLUMN_FOOD_NAME);
                String foodText = (returnCurs.getString(indexFood));

                int indexAnswer = returnCurs.getColumnIndex(DatabaseContract.foodInfo.COLUMN_ANSWER);
                String answerText = (returnCurs.getString(indexAnswer));

                int indexExplanation = returnCurs.getColumnIndex(DatabaseContract.foodInfo.COLUMN_EXPLANATION);
                String explanationText = (returnCurs.getString(indexExplanation));
                Log.d("yee", "ok so =====" + answerText);


                Intent intent = new Intent(context, FoodAnswerActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", String.valueOf(itemID));
                bundle.putString("food", foodText);
                bundle.putString("answer", answerText);
                bundle.putString("explanation", explanationText);
                intent.putExtras(bundle);


                context.startActivity(intent);
            } else {
                Log.d("yes", "it happened");

                Intent intent = new Intent(context, FoodAnswerActivity.class);

                context.startActivity(intent);

            }



        }
    }

}
