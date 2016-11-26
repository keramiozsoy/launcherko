package com.linux.kerami.launcherko;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.dxtt.coolmenu.CoolMenuFrameLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    CoolMenuFrameLayout coolMenuFrameLayout;
    boolean open;
    List<Fragment> fragments = new ArrayList<>();
    List<String> titleList = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        coolMenuFrameLayout = (CoolMenuFrameLayout) findViewById(R.id.rl_main);

        String[] titles = {"Everything", "Favorite Apps"};


        titleList = Arrays.asList(titles);
        coolMenuFrameLayout.setTitles(titleList);
        coolMenuFrameLayout.setMenuIcon(R.drawable.menu2);


        fragments.add(new Fragment1());
        fragments.add(new Fragment2());


        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        coolMenuFrameLayout.setAdapter(adapter);
    }
}
