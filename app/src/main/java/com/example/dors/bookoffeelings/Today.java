package com.example.dors.bookoffeelings;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Today extends AppCompatActivity {
//    int angry, fear, surprised, love, joy, sad = 0;
//    int perc_angry ,perc_fear ,perc_surprised ,perc_love ,perc_joy ,perc_sad = 0;
    EditText txt;
    int emotion;
    Button saveButton;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        context = this;
        txt= findViewById(R.id.plain_text_input);
        saveButton = findViewById(R.id.saveButton);
        saveButton.setClickable(false);

                /*
        emotion 1: Sad
        emotion 2: Angry
        emotion 3: Joy
        emotion 4: Surprised
        emotion 5: Love
        emotion 6: Fear
        assertTrue("empty days list ", days.size()==0);
*/
    }



    public void saveData (View v){


        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd", Locale.CANADA);
        Date date = Calendar.getInstance().getTime();
        Log.d("MYTEST",dateFormat.format(date));
        int emotion = this.emotion;
        String input =  String.valueOf(emotion)+ txt.getText().toString();
        String key = dateFormat.format(date);
        SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key),Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, input);
        editor.apply();
        Log.d("SAVEACTIONKEY",key);
//        Button save = findViewById(R.id.saveButton);
        startActivities(new Intent[]{new Intent(Today.this, MainActivity.class)});


//        FileHelper.saveToFile(dateFormat.format(date) + emotion + input );
    }



    public void setSurprised(View view) {
        emotion = 4;
        saveButton.setClickable(true);
    }

    public void setAngry(View view) {
        emotion = 2;
        saveButton.setClickable(true);
    }

    public void setFear(View view) {
        emotion = 6;
        saveButton.setClickable(true);
    }

    public void setLove(View view) {
        emotion = 5;
        saveButton.setClickable(true);
    }

    public void setSad(View view) {
        emotion = 1;
        saveButton.setClickable(true);
    }

    public void setJoy(View view) {
        emotion = 3;
        saveButton.setClickable(true);
    }

//    public void calcaulte_Stas(){
////                switch (emotion){
////            case 1: sad+=1;
////            case 2: angry+=1;
////            case 3: joy+=1;
////            case 4: surprised+=1;
////            case 5: love+=1;
////            case 6: fear+=1;
////        }
//        int total = angry + fear + surprised + love + joy + sad;
//        perc_angry = (fear/total)*100;
//        perc_fear = (surprised/total)*100;
//        perc_surprised = (love/total)*100;
//        perc_love = (joy/total)*100;
//        perc_joy = (sad/total)*100;
//        perc_sad = (angry/total)*100;
//
//    }





}
