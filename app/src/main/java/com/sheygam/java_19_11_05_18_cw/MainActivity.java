package com.sheygam.java_19_11_05_18_cw;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ViewPager myPager;
    private MyAdapter adapter;
    private Button prevBtn, nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPager = findViewById(R.id.my_view_pager);
        prevBtn = findViewById(R.id.prev_btn);
        nextBtn = findViewById(R.id.next_btn);
        adapter = new MyAdapter(getSupportFragmentManager());
        myPager.setAdapter(adapter);
        prevBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
        myPager.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.prev_btn) {
//            int currentPos = myPager.getCurrentItem();
//            if(currentPos > 0){
            myPager.setCurrentItem(0, false);
//            }
        } else if (v.getId() == R.id.next_btn) {
//            myPager.setCurrentItem(9);
            int currentPos = myPager.getCurrentItem();
            if (currentPos < adapter.getCount() - 1) {
                myPager.setCurrentItem(currentPos + 1);
            }
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d("SCROLLED", "onPageScrolled() called with: position = [" + position + "], positionOffset = [" + positionOffset + "], positionOffsetPixels = [" + positionOffsetPixels + "]");
    }

    @Override
    public void onPageSelected(int position) {
        Log.d("SELECTED", "onPageSelected() called with: position = [" + position + "]");
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state) {
            case ViewPager.SCROLL_STATE_IDLE:
                Log.d("SELECTED", "onPageScrollStateChanged: IDLE");
                break;
            case ViewPager.SCROLL_STATE_DRAGGING:
                Log.d("SELECTED", "onPageScrollStateChanged: DRAGGING");
                break;
            case ViewPager.SCROLL_STATE_SETTLING:
                Log.d("SELECTED", "onPageScrollStateChanged: SETTLING");
                break;
        }
    }


    class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Random rnd = new Random();
            int color = Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            return MyPageFragment.newInstance(color, "Page " + position);
        }

        @Override
        public int getCount() {
            return 10;
        }
    }
}
