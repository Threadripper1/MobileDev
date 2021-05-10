package ua.kpi.comsys.io8313.mobiledev;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


import ua.kpi.comsys.io8313.mobiledev.parts.BooksFragment;
import ua.kpi.comsys.io8313.mobiledev.parts.PieAndGraphFragment;
import ua.kpi.comsys.io8313.mobiledev.tabs.ViewPageAdapter;
import ua.kpi.comsys.io8313.mobiledev.parts.GeneralFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private GeneralFragment generalFragment;
    private PieAndGraphFragment pieAndGraphFragment;
    private BooksFragment booksFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.pageview);
        tabLayout = findViewById(R.id.layoutTab);
        tabLayout.setupWithViewPager(viewPager);

        generalFragment = new GeneralFragment();
        pieAndGraphFragment = new PieAndGraphFragment();
        booksFragment = new BooksFragment();

        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), 0);

        viewPageAdapter.addFragment(generalFragment, "Home");
        viewPageAdapter.addFragment(pieAndGraphFragment,"Pie and graph");
        viewPageAdapter.addFragment(booksFragment, "Books");

        viewPager.setAdapter(viewPageAdapter);
    }
}
