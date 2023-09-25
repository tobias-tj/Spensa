package com.tj.spensa.Presentations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tj.spensa.R;
import com.tj.spensa.RegisterPage;

public class PresentationPage extends AppCompatActivity {

    ViewPager mSliderViewPage;
    LinearLayout mViewLayout;
    Button atrasBtn, siguienteBtn, saltarBtn;

    TextView[] dots;
    ViewPresentationAdapter viewPresentationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation_page);

        atrasBtn = findViewById(R.id.btn_atras);
        siguienteBtn = findViewById(R.id.btn_siguiente);
        saltarBtn = findViewById(R.id.btn_saltar);


        atrasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getItem(0) > 0){
                    mSliderViewPage.setCurrentItem(getItem(-1),true);
                }
            }
        });

        siguienteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getItem(0) < 2){
                    mSliderViewPage.setCurrentItem(getItem(1),true);
                }else{
                    Intent intent = new Intent(PresentationPage.this, RegisterPage.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        saltarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PresentationPage.this, RegisterPage.class);
                startActivity(intent);
                finish();
            }
        });

        mSliderViewPage = (ViewPager) findViewById(R.id.viewPager);
        mViewLayout = (LinearLayout) findViewById(R.id.indicator_layout);

        viewPresentationAdapter = new ViewPresentationAdapter(this);

        mSliderViewPage.setAdapter(viewPresentationAdapter);

        setUpIndicator(0);
        mSliderViewPage.addOnPageChangeListener(viewListener);
    }

    public void setUpIndicator(int position){
        dots = new TextView[3];
        mViewLayout.removeAllViews();

        for(int i = 0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive, getApplicationContext().getTheme()));
            mViewLayout.addView(dots[i]);
        }

        dots[position].setTextColor(getResources().getColor(R.color.active, getApplicationContext().getTheme()));
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setUpIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int getItem(int i){
        return mSliderViewPage.getCurrentItem() + i;
    }
}