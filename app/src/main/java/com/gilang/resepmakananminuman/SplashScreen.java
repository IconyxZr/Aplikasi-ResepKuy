package com.gilang.resepmakananminuman;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(()->{
            Intent intent = new Intent(SplashScreen.this, Menu.class);
            startActivity(intent);
            finish();
        },3000L);
    }
}
