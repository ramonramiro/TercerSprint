package com.principa.subnetting.easy.Sliders;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.principa.subnetting.easy.R;


public class SliderAdapterTwo extends PagerAdapter{

    Context context2;
    LayoutInflater layoutInflater2;


    public SliderAdapterTwo(Context context){
        this.context2 = context;    }

    //Arrays
    public int[] slide_images2 = {
            R.drawable.pag1_unidad2,
            R.drawable.pag2_unidad2,
            R.drawable.pag3_unidad2
    };



    public String[] slide_headings = {
            "",
            "",
            ""
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (LinearLayout) o;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater2 = (LayoutInflater) context2.getSystemService(context2.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater2.inflate(R.layout.slide_layout_two, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slideimg2);
        // TextView slideHeading = (TextView) view.findViewById(R.id.slide_title);
        //TextView slideDescription = (TextView) view.findViewById(R.id.slide_description);

        slideImageView.setImageResource(slide_images2[position]);
        //slideHeading.setText(slide_headings[position]);
        //slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position,Object object) {
        container.removeView((LinearLayout)object);
    }
}

