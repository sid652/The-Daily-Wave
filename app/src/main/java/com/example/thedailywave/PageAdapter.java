package com.example.thedailywave;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PageAdapter extends FragmentStateAdapter {


    public PageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new homeFragment();

            case 1:
                return new sportsFragment();

            case 2:
                return new healthFragment();

            case 3:
                return new scienceFragment();

            case 4:
                return new entertainmentFragment();

            case 5:
                return new technologyFragment();

        }
        return new homeFragment();
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
