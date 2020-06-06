package com.example.premierleagueapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.premierleagueapp.R;
import com.google.android.material.tabs.TabLayout;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String CURRENT_POSITION_KEY = "Position";
    private static final String CURRENT_POSITION2_KEY = "PositionTab";
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private FixturesTab fixturesTab;
    private TeamsTab teamsTab;
    private TableTab tableTab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamsTab = new TeamsTab();
        tableTab = new TableTab();
        fixturesTab = new FixturesTab();

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);

        if (savedInstanceState != null) {
            int currentPos = savedInstanceState.getInt(CURRENT_POSITION_KEY);
            int currentTabPos = savedInstanceState.getInt(CURRENT_POSITION2_KEY);
            tabLayout.getTabAt(currentTabPos).select();
            viewPager.setCurrentItem(currentPos);
        } else {
            setFragment(teamsTab);
        }


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0) {
                    setFragment(teamsTab);
                } else if(tab.getPosition() == 1) {
                    setFragment(tableTab);
                } else if(tab.getPosition() == 2) {
                    setFragment(fixturesTab);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        int position = tabLayout.getSelectedTabPosition();
        savedInstanceState.putInt(CURRENT_POSITION_KEY, viewPager.getCurrentItem());
        savedInstanceState.putInt(CURRENT_POSITION2_KEY, position);

        super.onSaveInstanceState(savedInstanceState);
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

}
