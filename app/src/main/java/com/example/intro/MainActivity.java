package com.example.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.example.intro.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private SliderAdapter adapter;
    private TextView[] mDots;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setTitle("Intro Activity");
        init();


        binding.viewPager.setAdapter(adapter);

        addDotsIndicator(0);

        binding.viewPager.addOnPageChangeListener(viewListener);



        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.viewPager.setCurrentItem(mCurrentPage+1);
            }
        });
        binding.prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.viewPager.setCurrentItem(mCurrentPage-1);
            }
        });





    }

    private void init() {

        adapter = new SliderAdapter(this);
    }

    public void addDotsIndicator(int position){

        mDots = new TextView[3];
        binding.dotLayout.removeAllViews();
        for (int i =0; i<mDots.length;i++){


            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.grey));
            binding.dotLayout.addView(mDots[i]);

        }

        if (mDots.length>0){

            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimary));

        }

    }

    ViewPager.OnPageChangeListener viewListener  = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrentPage = position;

            if (position==0){

                binding.next.setEnabled(true);
                binding.prev.setEnabled(false);
                binding.prev.setVisibility(View.GONE);
                binding.finish.setVisibility(View.GONE);
                binding.next.setVisibility(View.VISIBLE);

            }else if (position == mDots.length-1){

                binding.next.setEnabled(false);
                binding.prev.setEnabled(true);
                binding.prev.setVisibility(View.VISIBLE);
                binding.next.setVisibility(View.GONE);
                binding.finish.setVisibility(View.VISIBLE);
                //binding.next.setText("Finish");
            }else {
                binding.next.setEnabled(true);
                binding.prev.setEnabled(true);
                binding.prev.setVisibility(View.VISIBLE);
                binding.finish.setVisibility(View.GONE);
                binding.next.setVisibility(View.VISIBLE);
                binding.next.setText("next");
                binding.prev.setText("back");

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
