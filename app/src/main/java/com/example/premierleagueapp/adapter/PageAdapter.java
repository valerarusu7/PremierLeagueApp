package com.example.premierleagueapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.premierleagueapp.view.FixturesTab;
import com.example.premierleagueapp.view.TableTab;
import com.example.premierleagueapp.view.TeamsTab;

public class PageAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;

    public PageAdapter(@NonNull FragmentManager fm, int numberOfTabs) {
        //Avoiding deprecated method by having BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.numberOfTabs = numberOfTabs;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 :
                return new TeamsTab();
            case 1 :
                return new TableTab();
            case 2 :
                return new FixturesTab();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
