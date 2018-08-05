package com.deepaksharma.webaddicted.fragmentback;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.deepaksharma.webaddicted.fragmentbackhandler.BackFragmentAppCompatActivity;

public class ViewPagerActivity extends BackFragmentAppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_viewpager);

        viewPager = (ViewPager) findViewById(R.id.view_pager);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return FirstFragment.newInstance();
                    case 1:
                        return SecondFragment.newInstance();
                    default:
                        throw new RuntimeException("Invalid item index.");
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        });
    }
}
