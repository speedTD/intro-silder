package com.developer.dinhduy.sliderproejct;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.nio.InvalidMarkException;
import java.util.List;

public class PagerAdapter extends android.support.v4.view.PagerAdapter{
    private List<IconX> list;
    private Context context;

    @Override
    public int getCount() {
        return list.size();
    }

    public PagerAdapter() {
        super();
    }

    public PagerAdapter(List<IconX> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.custom_item_layout,container,false);
        TextView textView=(TextView) view.findViewById(R.id.txt);
        ImageView imageView=(ImageView) view.findViewById(R.id.pic);

        IconX iconX=list.get(position);

        textView.setText(iconX.getText());
        imageView.setImageResource(iconX.getPicture());
        container.addView(view);

        return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((RelativeLayout) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout)object;
    }
}