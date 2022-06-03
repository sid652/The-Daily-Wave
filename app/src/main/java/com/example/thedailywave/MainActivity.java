package com.example.thedailywave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mHome, mSports, mScience, mHealth, mEntertainment, mTechnology;
    String apkiKey = "15f9c8c50a764aebbcffb80bcccdd2d7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHome = findViewById(R.id.home);
        mSports = findViewById(R.id.sports);
        mScience = findViewById(R.id.science);
        mHealth = findViewById(R.id.health);
        mEntertainment = findViewById(R.id.entertainment);
        mTechnology = findViewById(R.id.technology);

        ViewPager2 viewPager = (ViewPager2) findViewById(R.id.fragment_container);
        tabLayout = findViewById(R.id.tabs);

        PageAdapter adapter = new PageAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {

            if(position == 0) {
                tab.setText("Home");
            }
            else if (position == 1) {
                tab.setText("Sports");
            }
            else if (position == 2) {
                tab.setText("Health");
            }
            else if (position == 3) {
                tab.setText("Science");
            }
            else if (position == 4) {
                tab.setText("Entertainment");
            }
            else{
                tab.setText("Technology");
            }

        }).attach();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//                if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2 ||
//                        tab.getPosition()==3 || tab.getPosition()==4 || tab.getPosition()==5){
//                    adapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}