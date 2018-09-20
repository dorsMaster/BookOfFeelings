package com.example.dors.bookoffeelings;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class History extends AppCompatActivity {


    private SharedPreferences sharedPrefs;
        private SharedPreferences.Editor sharedPrefsEditor;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_history);

            // Get the Intent that started this activity and extract the string
            Intent intent = getIntent();
            String message = intent.getStringExtra(Calendar.EXTRA_MESSAGE);

            // Capture the layout's TextView and set the string as its text
            TextView textView = findViewById(R.id.plain_text_input);
            textView.setText(message);
        }



        public void deleteData(View view, String date) {

            SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
            sharedPref.edit().remove(date).apply();
        }
//
        public void editData(View view, String date) {

            // Read Data
            EditText txt;
            txt= findViewById(R.id.plain_text_input);
            SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
            String value = sharedPref.getString(date,"empty");
            Log.d("READDATA",value);
            txt.setText(value.substring(1,value.length()-1));
            String emotion =  value.substring(0);

            //TODO how to change the text

            //Save Data
            String input =  String.valueOf(emotion)+ txt.getText().toString();
            String key = date;
            sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key),Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(key, input);
            editor.apply();
            Log.d("SAVEACTIONKEY",key);
//        Button save = findViewById(R.id.saveButton);
            startActivities(new Intent[]{new Intent(History.this, MainActivity.class)});
//
        }



}

