package com.gilang.resepmakananminuman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class BahanUtamaMakanan extends AppCompatActivity {
    TextView bahanMakanan;
    String judul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bahan_utama_makanan);

        bahanMakanan = (TextView) findViewById(R.id.textbahan1);
        judul = "Bahan Utama Makanan";
        getSupportActionBar().setTitle(judul);
    }
}