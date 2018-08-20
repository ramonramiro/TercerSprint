package com.principa.subnetting.easy.Sliders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.principa.subnetting.easy.R;

public class SliderAdapterThree extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;




    public SliderAdapterThree(Context context){
        this.context = context;    }

    //Arrays
    public int[] slide_images= {
            R.drawable.pag1_unidad3,
            R.drawable.pag2_unidad3,
            R.drawable.pag3_unidad3
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
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout_three, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slideimg);
        // TextView slideHeading = (TextView) view.findViewById(R.id.slide_title);
        //TextView slideDescription = (TextView) view.findViewById(R.id.slide_description);

        slideImageView.setImageResource(slide_images[position]);
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

