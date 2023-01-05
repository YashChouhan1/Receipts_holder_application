package com.example.Receipts.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.Receipts.R;
import com.example.Receipts.controller.ViewPagerAdapter;
import com.example.Receipts.fragments.Fragment_1;
import com.example.Receipts.fragments.Fragment_2;
import com.example.Receipts.fragments.Fragment_3;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(getString(R.string.app_name));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Tabbed Activity
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_page);
        Button Submit =  findViewById(R.id.submit_button);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //ViewPagerAdapter
        viewPagerAdapter.addFragment(new Fragment_1(), "Fragment_1");
        viewPagerAdapter.addFragment(new Fragment_3(), "Fragment_2");
        viewPagerAdapter.addFragment(new Fragment_2(), "Fragment_3");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);



        tabLayout.getTabAt(0).setText("All Receipts");
        tabLayout.getTabAt(1).setText("Paid        Receipts");
        tabLayout.getTabAt(2).setText("Pending Receipts");

        Submit.setOnClickListener(View -> {
            Toast.makeText(MainActivity.this, "Receipts Submitted", Toast.LENGTH_LONG).show();
        });

    }
}