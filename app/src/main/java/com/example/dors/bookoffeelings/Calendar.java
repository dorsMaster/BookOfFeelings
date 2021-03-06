package com.example.dors.bookoffeelings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import static java.lang.String.valueOf;

public class Calendar extends AppCompatActivity {
    private final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private final String MESSAGE_DATE = "com.example.myfirstapp.DATE";

    public String readData(String date) {
//        TODO inmplement a try and catch error
        SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String value = sharedPref.getString(date," ");
        Log.d("READDATA",value);
        return value;

    }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calendar);
            CalendarView calendarView=(CalendarView) findViewById(R.id.calendarView);
            calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

                @Override
                public void onSelectedDayChange(CalendarView view, int year, int month,
                                                int dayOfMonth) {
                    int myMonth = month+1;
                    int myDay = dayOfMonth;
                    String dateToInspect = valueOf(year) + String.format("%02d", myMonth) + String.format("%02d", myDay);
                    String dateToShow = valueOf(year) +"/"+ String.format("%02d", myMonth) +"/"+ String.format("%02d", myDay);
                    Intent intent = new Intent(getBaseContext(), History.class);
                    intent.putExtra(MESSAGE_DATE,dateToShow);
                    intent.putExtra(EXTRA_MESSAGE,readData(dateToInspect));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();

                }
            });


        }

}

