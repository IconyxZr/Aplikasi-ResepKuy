package com.gilang.resepmakananminuman;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class DetailResepMakanan extends AppCompatActivity {
    ImageView imMakanan;
    TextView resepMakanan;
    int teksResep, posisi;
    String judulMakanan;
    WebView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep_makanan);

        imMakanan = (ImageView) findViewById(R.id.imageView);
        resepMakanan = (TextView) findViewById(R.id.textView);
        AdapterMakanan adapterMasakan = new AdapterMakanan(this);
        video = (WebView)findViewById(R.id.video);

        Intent i = getIntent();
        posisi = i.getIntExtra("posisi", 0);

        switch (posisi){
            case  0:
                judulMakanan = "Bakso Solo";
                teksResep = R.string.bakso;
                video.loadUrl("file:///android_asset/videobaksosolo.html");
                video.getSettings().setJavaScriptEnabled(true);
            break;
            case  1:
                judulMakanan = "Mie Goreng Jawa";
                teksResep = R.string.mie;
                video.loadUrl("file:///android_asset/videomiegorengjawa.html");
                video.getSettings().setJavaScriptEnabled(true);
            break;
            case  2:
                judulMakanan = "Sop Buntut Surabaya";
                teksResep = R.string.sop;
                video.loadUrl("file:///android_asset/videosopbuntutsurabaya.html");
                video.getSettings().setJavaScriptEnabled(true);
            break;
            case  3:
                judulMakanan = "Selat Solo";
                teksResep = R.string.selat;
                video.loadUrl("file:///android_asset/videoselatsolo.html");
                video.getSettings().setJavaScriptEnabled(true);
            break;
            case  4:
                judulMakanan = "Opor Ayam Kecombrang";
                teksResep = R.string.opor;
                video.loadUrl("file:///android_asset/videooporayamkecombrang.html");
                video.getSettings().setJavaScriptEnabled(true);
            break;
            case  5:
                judulMakanan = "Soto Betawi";
                teksResep = R.string.soto;
                video.loadUrl("file:///android_asset/videosotobetawi.html");
                video.getSettings().setJavaScriptEnabled(true);
            break;
        }

        getSupportActionBar().setTitle(judulMakanan);
        imMakanan.setImageResource(adapterMasakan.makanan
                [posisi]);
        resepMakanan.setText(teksResep);
    }
    public void Cetak (View view) {

    }
    public void displayToast (View view) {
        Toast.makeText(DetailResepMakanan.this, "Resep telah di cetak", Toast.LENGTH_SHORT).show();
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
                String text = resepMakanan.getText().toString().trim();
                if (text.equals("")) {
                    Toast.makeText(DetailResepMakanan.this, "Nothing to share", Toast.LENGTH_SHORT).show();
                } else {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, resepMakanan.getText().toString().trim());
                    sendIntent.setType("Text/Plain");

                    Intent shareIntent = Intent.createChooser(sendIntent, null);
                    startActivity(shareIntent);
                }
        }
        return super.onOptionsItemSelected(item);
    }
}
