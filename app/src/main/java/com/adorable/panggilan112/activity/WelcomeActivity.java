package com.adorable.panggilan112.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.adorable.panggilan112.R;
import com.adorable.panggilan112.adapter.ViewPagerAdapter;

import java.util.Timer;

public class WelcomeActivity extends AppCompatActivity {

    ViewPager mSlideViewPager;
//    LinearLayout mDotLayout;
    LinearLayout mDotLayout;
    Button btn_mulai, skip;

    private int dotscount;
    ImageView[] dots;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btn_mulai = findViewById(R.id.btn_mulai);
        skip = findViewById(R.id.skip);

        btn_mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (getitem(0) > 0) {

                    mSlideViewPager.setCurrentItem(getitem(-1), true);
                    Intent i = new Intent(WelcomeActivity.this, RegisterActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        Intent i = new Intent(WelcomeActivity.this, RegisterActivity.class);
                        startActivity(i);
                        finish();
                    }
        });

            mSlideViewPager =(ViewPager)findViewById(R.id.SlideViewPager);
            mDotLayout =(LinearLayout)findViewById(R.id.indicator_layout);

            viewPagerAdapter =new ViewPagerAdapter(this);

            mSlideViewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0 ; i < dots.length ; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.unselected));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);
            mDotLayout.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.selected));

        mSlideViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i< dotscount ; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.unselected));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.selected));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);
    }
//    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
//        @Override
//        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//        }
//
//        @RequiresApi(api = Build.VERSION_CODES.M)
//        @Override
//        public void onPageSelected(int position) {
//
//            for (int i = 0; i mDotLayout; i++){
//
//            }
//            setUpindicator(position);
//
//            if (position > 0){
//
//                btn_mulai.setVisibility(View.VISIBLE);
//
//            }else {
//
//                btn_mulai.setVisibility(View.INVISIBLE);
//
//            }
//
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int state) {
//
//        }
//    };

    private int getitem(int i){

        return mSlideViewPager.getCurrentItem() + i;
    }

}