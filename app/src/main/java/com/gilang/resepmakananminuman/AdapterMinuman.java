package com.gilang.resepmakananminuman;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class AdapterMinuman extends BaseAdapter {
    Context context;

    public AdapterMinuman (Context c) {
        context = c;
    }

    public int[] minuman = {
            R.drawable.bajigur, R.drawable .ronde, R.drawable.sekoteng,
            R.drawable.rempah, R.drawable.jahe, R.drawable.dawet
    };

    @Override
    public int getCount() { return minuman.length; }

    @Override
    public Object getItem(int position) { return minuman[position]; }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        ImageView im = new ImageView(context);
        im.setImageResource(minuman[position]);
        im.setScaleType(ImageView.ScaleType.CENTER_CROP);
        im.setLayoutParams(new ViewGroup.LayoutParams(250, 250));
        return im;
    }
}
