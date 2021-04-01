package ua.kpi.comsys.io8313.labs1_2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


import ua.kpi.comsys.io8313.labs1_2.parts.ChartsFragment;
import ua.kpi.comsys.io8313.labs1_2.tabs.ViewPageAdapter;
import ua.kpi.comsys.io8313.labs1_2.parts.GeneralFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private GeneralFragment generalFragment;
    private ChartsFragment chartsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pageview);
        tabLayout = findViewById(R.id.layoutTab);
        tabLayout.setupWithViewPager(viewPager);

        generalFragment = new GeneralFragment();
        chartsFragment = new ChartsFragment();

        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), 0);

        viewPageAdapter.addFragment(generalFragment, "Home");
        viewPageAdapter.addFragment(chartsFragment,"Charts");

        viewPager.setAdapter(viewPageAdapter);
    }
}
