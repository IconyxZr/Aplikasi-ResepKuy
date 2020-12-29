package com.gilang.resepmakananminuman;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ResepMinuman extends AppCompatActivity {
    GridView gridMinuman;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resep_minuman);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener((view) -> {
            Intent i = new Intent(ResepMinuman.this, ResepMakanan.class);
            startActivity(i);
        });

        gridMinuman = (GridView) findViewById(R.id.gridminuman);
        gridMinuman.setAdapter(new AdapterMinuman(this));

        gridMinuman.setOnItemClickListener((parent, view, position, id) -> {
            Intent in = new Intent(ResepMinuman.this, DetailResepMinuman.class);
            startActivity(in);
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.opsi, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id== R.id.bahanUtama) {
            Intent intent = new Intent(ResepMinuman.this, BahanUtamaMinuman.class);
            startActivity(intent);
            return true;
        }else
            if (id== R.id.aboutApp) {
                Intent intent = new Intent(ResepMinuman.this, AboutApps.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
