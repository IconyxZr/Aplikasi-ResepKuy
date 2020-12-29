package com.gilang.resepmakananminuman;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class  DetailResepMinuman extends AppCompatActivity {
    ImageView imMinumann;
    TextView resepMinuman;
    int teksResep1, posisi1;
    String judulMinuman;
    WebView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep_minuman);

        imMinumann = (ImageView) findViewById(R.id.imageView1);
        resepMinuman = (TextView) findViewById(R.id.textView1);
        AdapterMinuman adapterMinuman = new AdapterMinuman(this);
        video = (WebView)findViewById(R.id.video);

        Intent i = getIntent();
        posisi1 = i.getIntExtra("posisi", 0);

        switch (posisi1){
            case  0:
                judulMinuman = "Wedang Bajigur";
                teksResep1 = R.string.bajigur;
                video.loadUrl("file:///android_asset/videowedangbajigur.html");
                video.getSettings().setJavaScriptEnabled(true);
                break;
            case  1:
                judulMinuman = "Wedang Ronde";
                teksResep1 = R.string.ronde;
                video.loadUrl("file:///android_asset/videowedangronde.html");
                video.getSettings().setJavaScriptEnabled(true);
                break;
            case  2:
                judulMinuman = "Sekoteng";
                teksResep1 = R.string.sekoteng;
                video.loadUrl("file:///android_asset/videowedangsekoteng.html");
                video.getSettings().setJavaScriptEnabled(true);
                break;
            case  3:
                judulMinuman = "Wedang Rempah";
                teksResep1 = R.string.rempah;
                video.loadUrl("file:///android_asset/videowedangrempah.html");
                video.getSettings().setJavaScriptEnabled(true);
                break;
            case  4:
                judulMinuman = "Wedang Jahe";
            teksResep1 = R.string.jahe;
                video.loadUrl("file:///android_asset/videowedangjahe.html");
                video.getSettings().setJavaScriptEnabled(true);
                break;
            case  5:
                judulMinuman = "Es Dawet";
                teksResep1 = R.string.dawet;
                video.loadUrl("file:///android_asset/videoesdawet.html");
                video.getSettings().setJavaScriptEnabled(true);
                break;
        }

        getSupportActionBar().setTitle(judulMinuman);
        imMinumann.setImageResource(adapterMinuman.minuman[posisi1]);
        resepMinuman.setText(teksResep1);
    }
    public void displayToast (View view) {
        Toast.makeText(DetailResepMinuman.this, "Resep telah di cetak", Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                String text = resepMinuman.getText().toString().trim();
                if (text.equals("")) {
                    Toast.makeText(DetailResepMinuman.this, "Nothing to share", Toast.LENGTH_SHORT).show();
                } else {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, resepMinuman.getText().toString().trim());
                    sendIntent.setType("Text/Plain");

                    Intent shareIntent = Intent.createChooser(sendIntent, null);
                    startActivity(shareIntent);
                }
        }
        return super.onOptionsItemSelected(item);
    }
}
