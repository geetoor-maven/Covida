package com.shegi.gson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shegi.gson.Fragment_.About_frag;
import com.shegi.gson.Fragment_.Covid_frag;
import com.shegi.gson.Fragment_.Wilayah_frag;

public class DashboardActivity extends AppCompatActivity {

    Covid_frag covid_frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        covid_frag = new Covid_frag();


        BottomNavigationView bottomnavigation = findViewById(R.id.bottom_navigation);
        bottomnavigation.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new Covid_frag()).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment selectfrag = null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            selectfrag = new Covid_frag();
                            break;
                        case R.id.nav_wilayah:
                            selectfrag = new Wilayah_frag();
                            break;
                        case R.id.nav_about:
                            selectfrag = new About_frag();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,selectfrag).commit();
                    return true;
                }
            };
}
