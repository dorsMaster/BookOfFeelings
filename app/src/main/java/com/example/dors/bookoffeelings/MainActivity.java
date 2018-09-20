package com.example.dors.bookoffeelings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeToTodayActivity(View view) {
            Button today = findViewById(R.id.today_main_page);
            startActivities(new Intent[]{new Intent(MainActivity.this, Today.class)});

        }


    public void changeToHistoryActivity(View view) {
        Button history = findViewById(R.id.history_main_page);
        startActivities(new Intent[]{new Intent(MainActivity.this, Calendar.class)});
    }

    public void changeToStatsActivity(View view) {
        Button stas = findViewById(R.id.main_page_stats);
        startActivities(new Intent[]{new Intent(MainActivity.this, Stats.class)});
    }


}
