package com.gilang.resepmakananminuman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class BahanUtamaMinuman extends AppCompatActivity {
    TextView bahanMinuman;
    String judul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bahan_utama_minuman);

        bahanMinuman = (TextView) findViewById(R.id.textBahan2);
        judul = "Bahan Utama Minuman";
        getSupportActionBar().setTitle(judul);
    }
}