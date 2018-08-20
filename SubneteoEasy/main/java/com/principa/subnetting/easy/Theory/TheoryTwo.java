package com.principa.subnetting.easy.Theory;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.principa.subnetting.easy.R;
import com.principa.subnetting.easy.Sliders.SliderAdapterTwo;

public class TheoryTwo extends AppCompatActivity {

    private ViewPager mSlideViewPager2;
    private LinearLayout mDotLayout2;

    private TextView[] mDots2;

    private SliderAdapterTwo sliderAdapter2;

    private Button mNextBtn2;
    private Button mBackBtn2;

    private int mCurrentPage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_two);

        mSlideViewPager2 = (ViewPager) findViewById(R.id.view_pager2);
        mDotLayout2 = (LinearLayout) findViewById(R.id.layoutDots2);

        mNextBtn2 = (Button)findViewById(R.id.btn_next2);
        mBackBtn2 = (Button)findViewById(R.id.btn_skip2);

        sliderAdapter2 = new SliderAdapterTwo(this);
        mSlideViewPager2.setAdapter(sliderAdapter2);

        addDotsIndicator(0);

        mSlideViewPager2.addOnPageChangeListener(viewListener2);

        //onClickListener

        mNextBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager2.setCurrentItem(mCurrentPage2 + 1);
            }
        });

        mBackBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager2.setCurrentItem(mCurrentPage2 - 1);
            }
        });
    }

    public void addDotsIndicator(int position){
        mDots2 = new TextView[3];
        mDotLayout2.removeAllViews();

        for (int i = 0; i < mDots2.length; i++){
            mDots2[i] = new TextView(this);
            mDots2[i].setText(Html.fromHtml("&#8226;"));
            mDots2[i].setTextSize(35);
            mDots2[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout2.addView(mDots2[i]);
        }

        if(mDots2.length > 0){
            mDots2[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener2 = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);

            mCurrentPage2 = i;

            if(i == 0){
                mNextBtn2.setEnabled(true);
                mBackBtn2.setEnabled(false);
                mBackBtn2.setVisibility(View.INVISIBLE);

                mNextBtn2.setText("Siguiente");
                mBackBtn2.setText("");


            }else if (i == mDots2.length - 1){
                mNextBtn2.setEnabled(true);
                mBackBtn2.setEnabled(true);
                mBackBtn2.setVisibility(View.VISIBLE);

                mNextBtn2.setText("");
                mBackBtn2.setText("Regresar");
            }else{
                mNextBtn2.setEnabled(true);
                mBackBtn2.setEnabled(true);
                mBackBtn2.setVisibility(View.VISIBLE);

                mNextBtn2.setText("Siguiente");
                mBackBtn2.setText("Regresar");
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
