package com.example.viewpagerwithbottomindicator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private LinearLayout bottomIndicatorContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        bottomIndicatorContainer = findViewById(R.id.bottomIndicatorContainer);

        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        bottomIndicatorContainer.removeAllViews();
        final BottomIndicatorView[] bottomIndicators = new BottomIndicatorView[adapter.getItemCount()];
        for (int i = 0; i < adapter.getItemCount(); i++) {
            bottomIndicators[i] = new BottomIndicatorView(this);
            bottomIndicators[i].setCount(adapter.getItemCount());
            bottomIndicators[i].setIndicatorColor(Color.RED);
            bottomIndicators[i].setCurrentPosition(i);
            final int position = i;
            bottomIndicators[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(position);
                }
            });
            bottomIndicatorContainer.addView(bottomIndicators[i]);
        }


        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < adapter.getItemCount(); i++) {
                    if (i == position) {
                        bottomIndicators[i].setCurrentPosition(i);
                    } else {
                        bottomIndicators[i].setCurrentPosition(-1);
                    }
                }
            }
        });
    }
}
