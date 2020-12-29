package com.gilang.resepmakananminuman;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterMakanan extends BaseAdapter{
    Context context;

    public AdapterMakanan (Context c) { context = c; }

    public int[] makanan = {
            R.drawable.bakso, R.drawable.miejawa, R.drawable.sop,
            R.drawable.selat, R.drawable.opor, R.drawable.sotobtw
    };

    @Override
    public int getCount() { return makanan.length; }

    @Override
    public Object getItem(int position) { return makanan[position]; }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        ImageView im = new ImageView(context);
        im.setImageResource(makanan[position]);
        im.setScaleType(ImageView.ScaleType.CENTER_CROP);
        im.setLayoutParams(new ViewGroup.LayoutParams(250, 250));
        return im;
    }
}
