package com.example.intro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }


    public int[] slideImages = {
            R.drawable.ic_directions_walk_black_24dp,
            R.drawable.ic_directions_run_black_24dp,
            R.drawable.ic_directions_bike_black_24dp

    };

    public String[] slideHeadings = {

            "Friends",
            "Family",
            "Kids"


    };
    public String[] slideDescriptions = {

            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc pellentesque felis odio, id congue massa semper eget. Duis a diam vel tellus rutrum iaculis eget non felis. Phasellus ultrices orci nisl",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc pellentesque felis odio, id congue massa semper eget. Duis a diam vel tellus rutrum iaculis eget non felis. Phasellus ultrices orci nisl",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc pellentesque felis odio, id congue massa semper eget. Duis a diam vel tellus rutrum iaculis eget non felis. Phasellus ultrices orci nisl"


    };


    @Override
    public int getCount() {
        return slideHeadings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = view.findViewById(R.id.imageV);
        TextView slideHeading = view.findViewById(R.id.heading);
        TextView slidedes = view.findViewById(R.id.des);

        slideImageView.setImageResource(slideImages[position]);
        slideHeading.setText(slideHeadings[position]);
        slidedes.setText(slideDescriptions[position]);

        container.addView(view);




        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
