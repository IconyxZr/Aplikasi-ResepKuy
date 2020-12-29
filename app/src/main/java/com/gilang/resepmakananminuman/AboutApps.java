package com.gilang.resepmakananminuman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutApps extends AppCompatActivity {
    TextView about;
    String judul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_apps);

        about = (TextView) findViewById(R.id.about);
        judul = "About Apps";
        getSupportActionBar().setTitle(judul);
    }
}